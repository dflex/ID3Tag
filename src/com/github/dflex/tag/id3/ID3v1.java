/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
// TODO: Längenüberprüfung von getData in Setter verschieben!!!
package com.github.dflex.tag.id3;

import com.github.dflex.tag.Tag;
import java.util.Calendar;
import java.util.Date;
import com.github.dflex.exceptions.InvalidInputData;
import com.github.dflex.tag.Genre;

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

    public ID3v1(Tag tag) {
        this.identifier = "TAG";
        this.artist = tag.getArtist();
        this.album = tag.getAlbum();
        this.title = tag.getTitle();
        this.comment = tag.getComment();
        this.date = tag.getDate();
        this.genre = tag.getGenre();
    }

    /**
     *
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
        this.artist = artist;
        this.album = album;
        this.title = title;
        this.comment = comment;
        this.date = year;
        this.genre = genre;
    }

    /**
     *
     * @param data
     * @throws InvalidInputData
     */
    public ID3v1(byte[] data) throws InvalidInputData {
        if(data.length == 127) {
            identifier = new String(data,0,3);
            // Check wether data contains valid ID3v1 data.
            if(!identifier.equalsIgnoreCase("TAG")) {
                throw new InvalidInputData("ID3v1");
            }
            title = new String(data, 3, 30).trim();
            artist = new String(data,33,30).trim();
            album = new String(data,63,30).trim();
            // Kalender auf den 1.1. um 00:00:00 setzen
            Calendar cal = Calendar.getInstance();
            cal.set(new Integer(new String(data,93,4)), 0, 1, 0, 0, 0);
            date = cal.getTime();
            comment = new String(data,97,30).trim();
            if(Genre.values().length < data[127]) {
                this.genre = Genre.values()[data[127]];
            }
        } else {
            throw new InvalidInputData(128, data.length);
        }
    }

    /*
     *
     *
     */
    /**
     * Returns the identifier, here TAG
     * @return
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Returns the artist
     * @return
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Returns the albumname
     * @return
     */
    public String getAlbum() {
        return album;
    }

    /**
     * returns the songtitle
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * returns the comment
     * @return
     */
    public String getComment() {
        return comment;
    }

    /**
     * returns the date, here the year only
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     * returns the genre
     * @return
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * Sets the albumname with a max length of 30 chars. Strings bigger than 30 chars will be cropped.
     * @param album
     */
    public void setAlbum(String album) {
        int length = (album.length() > 30)? 30 : album.length();
        this.album = album.trim().substring(0, length);
    }

    /**
     * Sets the artistname with a max length of 30 chars. Strings bigger than 30 chars will be cropped.
     * @param artist
     */
    public void setArtist(String artist) {
        int length = (artist.length() > 30)? 30 : artist.length();
        this.artist = artist.trim().substring(0, length);
    }

    /**
     * Sets the comment with a max length of 30 chars. Strings bigger than 30 chars will be cropped.
     * @param comment
     */
    public void setComment(String comment) {
        int length = (comment.length() > 30)? 30 : comment.length();
        this.comment = comment.trim().substring(0,length);
    }

    /**
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     * @param genre
     */
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        int length = (title.length() > 30)? 30 : title.length();
        this.title = title.trim().substring(0, length);
    }

    /**
     *
     * @return
     */
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
        return "ID3v1{" + "identifier=" + identifier + "artist=" + artist + "album=" + album + "title=" + title + "comment=" + comment + "date=" + date + "genre=" + genre + '}';
    }
}