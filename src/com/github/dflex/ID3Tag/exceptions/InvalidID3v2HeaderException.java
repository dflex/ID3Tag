/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.dflex.ID3Tag.exceptions;

/**
 *
 * @author Dominik
 */
public class InvalidID3v2HeaderException extends Exception{

    public InvalidID3v2HeaderException() {
        super("The Header is invalid");
    }
}
