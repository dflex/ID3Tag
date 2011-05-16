/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.dflex.ID3Tag.tag.id3.id3v2;

import com.github.dflex.ID3Tag.tag.id3.id3v2.frame.ID3v2Frame;
import com.github.dflex.ID3Tag.tag.id3.ID3Tag;
import java.util.LinkedList;

/**
 *
 * @author dominik
 */
public abstract class ID3v2Tag implements ID3Tag {
    
    ID3v2Header header;
    ID3v2ExtendedHeader extendedHeader;
    ID3v2Footer footer;
    LinkedList<ID3v2Frame> frames;

    public ID3v2Tag(ID3v2Header header) {
        this.header = header;
    }

    public ID3v2Tag(ID3v2Header header, ID3v2Footer footer) {
        this.header = header;
        this.footer = footer;
        header.setFooter(true);
    }

    public ID3v2Tag(ID3v2Header header, ID3v2ExtendedHeader extendedHeader) {
        this.header = header;
        this.extendedHeader = extendedHeader;
        header.setExtendedHeader(true);
    }

    public ID3v2Tag(ID3v2Header header, ID3v2ExtendedHeader extendedHeader, ID3v2Footer footer) {
        this.header = header;
        this.extendedHeader = extendedHeader;
        this.footer = footer;
        header.setFooter(true);
        header.setExtendedHeader(true);
    }

    public ID3v2Tag(ID3v2Header header, LinkedList<ID3v2Frame> frames) {
        this.header = header;
        this.frames = frames;
    }
    
    public boolean hasExtendedHeader() {
        return header.isSetExtendedHeaderBit();
    }
    
    public boolean hasFooter() {
        return header.isSetFooterBit();
    }
    
    public boolean isUsingPadding() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    public int getTagSize() {
        return header.getTagSize();
    }
    
    public int getTotalTagSize() {
        return header.getTotalTagSize();
    }
}
