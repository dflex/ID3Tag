/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
// TODO: Längenüberprüfung von getData in Setter verschieben!!!
package com.github.dflex.ID3Tag.tag.id3;

import com.github.dflex.ID3Tag.exceptions.InvalidInputData;
import java.util.Calendar;
import java.util.Date;
import com.github.dflex.ID3Tag.helper.StringHelper;
import com.github.dflex.ID3Tag.tag.Genre;
import com.github.dflex.ID3Tag.tag.Tag;


/**
 *
 * @author Dominik
 */
public class ID3v1 implements ID3 {
    private String identifier;  // Sollte immer "TAG" sein
    private String artist;      // Name des Künstlers
    private String album;       // Titel des Albums
    private String title;       // Titel des Liedes
    private String comment;     // Kommentar
    private Date date;          // Hier: Das Releasejahr
    private Genre genre;        // Das Genre
    
    
    /**
     * Generiert einen ID3v1-Tag aus einem schon gegebenen Tag
     * @param tag 
     */
    public ID3v1(Tag tag) {
        this.identifier = "TAG";
        this.artist = StringHelper.getInstance().trimString(tag.getArtist(),30);
        this.album = StringHelper.getInstance().trimString(tag.getAlbum(),30);
        this.title = StringHelper.getInstance().trimString(tag.getTitle(),30);
        this.comment = StringHelper.getInstance().trimString(tag.getComment(),30);
        this.date = tag.getDate();
        this.genre = tag.getGenre();
    }

    /**
     * Generiert einen ID3v1-Tag mithilfe der übergebenen Daten
     * @param artist
     * @param album
     * @param title
     * @param comment
     * @param year
     * @param genre
     */
    public ID3v1(String artist, String album, String title, String comment, Date year, Genre genre) {
        // TODO: länge der Strings auf 30chars begrenzen und trimmen
        this.identifier = "TAG";
        this.artist = StringHelper.getInstance().trimString(artist,30);
        this.album = StringHelper.getInstance().trimString(album,30);
        this.title = StringHelper.getInstance().trimString(title,30);
        this.comment = StringHelper.getInstance().trimString(comment,30);
        this.date = year;
        this.genre = genre;
    }

    /**
     * Generiert einen ID3v1-Tag aus einem Byte-Array
     * @param data
     * @throws InvalidInputData Wenn das Byte-Array zu klein ist, oder nicht die Daten für einen ID3v1-Tag enthält
     */
    public ID3v1(byte[] data) throws InvalidInputData {
        if(data.length == 127) {
            identifier = new String(data,0,3);
            // Überprüfung, ob die das Array den richtigen Tagtyp enthält
            if(!identifier.equalsIgnoreCase("TAG")) {
                throw new InvalidInputData("ID3v1");
            }
            // Jedes Feld ist 30 Chars lang, Leerzeichen sollten entfernt werden
            title = new String(data, 3, 30).trim();
            artist = new String(data,33,30).trim();
            album = new String(data,63,30).trim();
            // Kalender auf das richtige Datum setzen (Uhrzeit auf 00:00:00 setzen)
            Calendar cal = Calendar.getInstance();
            cal.set(new Integer(new String(data,93,4)), 0, 1, 0, 0, 0);
            date = cal.getTime();
            comment = new String(data,97,30).trim();
            // Das Genre setzen
            if(Genre.values().length < data[127]) {
                this.genre = Genre.values()[data[127]];
            }
        } else {
            throw new InvalidInputData(128, data.length);
        }
    }

    /**
     * Returns the identifier, here TAG
     * @return
     */
    @Override
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Returns the artist
     * @return
     */
    @Override
    public String getArtist() {
        return artist;
    }

    /**
     * Returns the albumname
     * @return
     */
    @Override
    public String getAlbum() {
        return album;
    }

    /**
     * returns the songtitle
     * @return
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     * returns the comment
     * @return
     */
    @Override
    public String getComment() {
        return comment;
    }

    /**
     * returns the date, here the year only
     * @return
     */
    @Override
    public Date getDate() {
        return date;
    }

    /**
     * returns the genre
     * @return
     */
    @Override
    public Genre getGenre() {
        return genre;
    }

    /**
     * Sets the albumname with a max length of 30 chars. Strings bigger than 30 chars will be cropped.
     * @param album
     */
    @Override
    public void setAlbum(String album) {
        this.album = StringHelper.getInstance().trimString(album,30);
    }

    /**
     * Sets the artistname with a max length of 30 chars. Strings bigger than 30 chars will be cropped.
     * @param artist
     */
    @Override
    public void setArtist(String artist) {
        this.artist = StringHelper.getInstance().trimString(artist,30);
    }

    /**
     * Sets the comment with a max length of 30 chars. Strings bigger than 30 chars will be cropped.
     * @param comment
     */
    @Override
    public void setComment(String comment) {
        this.comment = StringHelper.getInstance().trimString(comment,30);
    }

    /**
     *
     * @param date
     */
    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     * @param genre
     */
    @Override
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    /**
     *
     * @param title
     */
    @Override
    public void setTitle(String title) {
        this.title = StringHelper.getInstance().trimString(title,30);
    }

    /**
     * Generiert ein Byte-Array
     * @return
     */
    @Override
    public byte[] getData() {
        byte[] result = new byte[128];

        System.arraycopy(identifier.getBytes(), 0, result, 0, 3);

        int length = (title.length() > 30)? 30 : title.length();
        System.arraycopy(title.getBytes(), 0, result, 3, length);

        length = (artist.length() > 30)? 30 : artist.length();
        System.arraycopy(artist.getBytes(), 0, result, 33, length);

        length = (album.length() > 30)? 30 : album.length();
        System.arraycopy(album.getBytes(), 0, result, 63, length);

        Calendar cal = Calendar.getInstance();

        cal.setTime(date);

        System.arraycopy(Integer.toString(cal.get(Calendar.YEAR)).getBytes(), 0, result, 93, 4);
        
        length = (comment.length() > 30)? 30 : comment.length();
        System.arraycopy(comment.getBytes(), 0, result, 97, length);

        result[127] = (byte) genre.getValue();

        return result;
    }

    @Override
    public String toString() {
        return "ID3v1{" + "identifier=" + identifier + " artist=" + artist + " album=" + album + " title=" + title + " comment=" + comment + " date=" + date + " genre=" + genre + '}';
    } 
}