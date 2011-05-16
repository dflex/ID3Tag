/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.github.dflex.ID3Tag.tag.id3;

import com.github.dflex.ID3Tag.exceptions.InvalidInputData;
import com.github.dflex.ID3Tag.helper.StringHelper;
import com.github.dflex.ID3Tag.tag.Genre;
import com.github.dflex.ID3Tag.tag.Tag;
import java.util.Date;

/**
 *
 * @author Dominik
 */
public class ID3v11 extends ID3v1 {

    private byte tracknumber;

    public ID3v11(Tag tag) {
        super(tag);
        // Kommentar ist bei ID3v1.1 nur 28 Zeichen lang, letztes Zeichen ist die Titelnummer
        String comment = super.getComment();
        tracknumber = comment.getBytes()[comment.length()-1];
        super.setComment(comment.substring(0, comment.length()-2));
    }

    public ID3v11(byte[] data) throws InvalidInputData {
        super(data);
        String comment = super.getComment();
        tracknumber = comment.getBytes()[comment.length()-1];
        super.setComment(comment.substring(0, comment.length()-2));
    }

    public ID3v11(String artist, String album, String title, String comment, byte tracknumber, Date year, Genre genre) {
        super(artist, album, title, comment, year, genre);
        this.setComment(comment);
        this.tracknumber = tracknumber;
    }

    public short getTracknumber() {
        return tracknumber;
    }

    public void setTracknumber(byte tracknumber) {
        this.tracknumber = tracknumber;
    }

    @Override
    public void setComment(String comment) {
        super.setComment(StringHelper.getInstance().trimString(comment, 28));
    }

    @Override
    public byte[] getData() {
        byte[] data = super.getData();
        data[125] = 0;
        data[126] = tracknumber;
        
        return data;
    }
}