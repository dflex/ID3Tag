/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.dflex.ID3Tag.tag.id3.id3v2;

import com.github.dflex.ID3Tag.exceptions.InvalidID3v2HeaderException;

/**
 *
 * @author dominik
 */
class ID3v2Header {
    
    private String identifier;
    private byte version;
    private byte revision;
    private boolean unsynchronisation;
    private boolean extendedHeader;
    private boolean experimentalIndicator;
    private boolean footer;
    private int size;

    public ID3v2Header(byte[] data) throws InvalidID3v2HeaderException {
        // Der Header ist 10Byte groß, ist dies nicht der Fall liegen ungültige Daten vor
        if(data.length == 10) {
            // Die ersten 3 Bytes sind der Identifier (ID3)
            identifier = new String(data,0,3);
            // Danach folgt Version und Revision
            version = data[3];
            revision = data[4];
            // Überprüfen welche Flags gesetzt sind
            int mask = 1 << 7;
            unsynchronisation = (data[5] & mask) == mask;
            mask = 1 << 6;
            extendedHeader = (data[5] & mask) == mask;
            mask = 1 << 5;
            experimentalIndicator = (data[5] & mask) == mask;
            mask = 1 << 4;
            footer = (data[5] & mask) == mask;
            // Die Größe auslesen
            String tmpSize = "";
            for(int i = 6; i < 10; i++) {
                String tmpBin = Integer.toBinaryString((int) data[i]);
                while(tmpBin.length() < 7) {
                    tmpBin = "0" + tmpBin;
                }
                tmpSize += tmpBin;
            }
            size = Integer.parseInt(tmpSize,2);
        } else {
            throw new InvalidID3v2HeaderException();
        }
    }

    public ID3v2Header(String identifier, byte version, byte revision, boolean unsynchronisation, boolean extendedHeader, boolean experimentalIndicator, boolean footer, int size) {
        this.identifier = identifier;
        this.version = version;
        this.revision = revision;
        this.unsynchronisation = unsynchronisation;
        this.extendedHeader = extendedHeader;
        this.experimentalIndicator = experimentalIndicator;
        this.footer = footer;
        this.size = size;
    }
    
    public boolean isSetExtendedHeaderBit() {
        return extendedHeader;
    }

    public boolean isSetFooterBit() {
        return footer;
    }
    
    public boolean isSetExperimentalBit() {
        return experimentalIndicator;
    }
    
    public boolean isSetUnsynchronisationBit() {
        return unsynchronisation;
    }
    
    public int getTagSize() {
        return size;
    }

    public int getTotalTagSize() {
        if(footer) {
            return size + 20;
        } else {
            return size + 10;
        }
    }
    
    public byte getVersion() {
        return version;
    }
    
    public byte getRevision() {
        return revision;
    }
    
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setVersion(byte version) {
        this.version = version;
    }

    public void setRevision(byte revision) {
        this.revision = revision;
    }

    public void setExtendedHeader(boolean extendedHeader) {
        this.extendedHeader = extendedHeader;
    }

    public void setExperimentalIndicator(boolean experimentalIndicator) {
        this.experimentalIndicator = experimentalIndicator;
    }

    public void setFooter(boolean footer) {
        this.footer = footer;
    }

    public void setUnsynchronisation(boolean unsynchronisation) {
        this.unsynchronisation = unsynchronisation;
    }

    public void setSize(int size) {
        this.size = size;
    }
}