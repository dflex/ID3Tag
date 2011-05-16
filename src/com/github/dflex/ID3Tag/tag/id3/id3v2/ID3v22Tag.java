/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.dflex.ID3Tag.tag.id3.id3v2;

import com.github.dflex.ID3Tag.tag.Genre;
import com.github.dflex.ID3Tag.tag.id3.id3v2.frame.ID3v2Frame;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author dominik
 */
public class ID3v22Tag extends ID3v2Tag {

    public ID3v22Tag(ID3v2Header header, LinkedList<ID3v2Frame> frames) {
        super(header, frames);
    }

    public ID3v22Tag(ID3v2Header header, ID3v2ExtendedHeader extendedHeader, ID3v2Footer footer) {
        super(header, extendedHeader, footer);
    }

    public ID3v22Tag(ID3v2Header header, ID3v2ExtendedHeader extendedHeader) {
        super(header, extendedHeader);
    }

    public ID3v22Tag(ID3v2Header header, ID3v2Footer footer) {
        super(header, footer);
    }

    public ID3v22Tag(ID3v2Header header) {
        super(header);
    }
    
    @Override
    public String getIdentifier() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getAlbum() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getArtist() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getComment() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public byte[] getData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Date getDate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Genre getGenre() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getTitle() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setAlbum(String album) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setArtist(String artist) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setComment(String comment) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setDate(Date date) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setGenre(Genre genre) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setTitle(String title) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
