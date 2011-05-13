/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.github.dflex.tag;

import java.util.Date;

/**
 *
 * @author Dominik
 */
public interface Tag {

    String getAlbum();

    String getArtist();

    String getComment();

    byte[] getData();

    Date getDate();

    Genre getGenre();

    String getTitle();

    void setAlbum(String album);

    void setArtist(String artist);

    void setComment(String comment);

    void setDate(Date date);

    void setGenre(Genre genre);

    void setTitle(String title);

}
