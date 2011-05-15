/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.github.dflex.tag.id3;

import com.github.dflex.StringHelper;
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
        tracknumber = comment.getBytes()[comment.length()-1];
        super.comment = comment.substring(0, comment.length()-1);
    }

    public ID3v11(byte[] data) throws InvalidInputData {
        super(data);
        tracknumber = comment.getBytes()[comment.length()-1];
        super.comment = comment.substring(0, comment.length()-1);
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
        super.comment = StringHelper.getInstance().trimString(comment, 29);
    }

    @Override
    public byte[] getData() {
        // BUG: Was ist mit der Tracknummer?
        return super.getData();
    }
}