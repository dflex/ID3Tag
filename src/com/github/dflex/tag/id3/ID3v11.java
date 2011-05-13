/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.github.dflex.tag.id3;

import java.util.Date;
import com.github.dflex.exceptions.InvalidInputData;
import com.github.dflex.tag.Genre;
import com.github.dflex.tag.Tag;

/**
 *
 * @author Dominik
 */
public class ID3v11 extends ID3v1 {

    private short tracknumber;

    public ID3v11(Tag tag) {
        super(tag);
    }

    public ID3v11(byte[] data) throws InvalidInputData {
        super(data);
        // TODO: comment kürzen, neu setzen
    }

    public ID3v11(String artist, String album, String title, String comment, short tracknumber, Date year, Genre genre) {
        super(artist, album, title, comment, year, genre);
        this.setComment(comment);
        this.tracknumber = tracknumber;
    }

    public short getTracknumber() {
        return tracknumber;
    }

    public void setTracknumber(short tracknumber) {
        this.tracknumber = tracknumber;
    }

    @Override
    public void setComment(String comment) {
        int length = (comment.length() > 29)? 29 : comment.length();
        comment.trim().substring(0, length);
        super.setComment(comment);
    }

    @Override
    public byte[] getData() {
        return super.getData();
    }
}