/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.github.dflex.exceptions;

/**
 *
 * @author Dominik
 */
public class InvalidInputData extends Exception {

    public InvalidInputData(String type) {
        super("The given array doesn't contain valid "+type+" data.");
    }

    /**
     * Constructs an instance of <code>InvalidInputData</code> with the specified detail message.
     * @param msg the detail message.
     */
    public InvalidInputData(int validSize, int givenSize) {
        super("The given array should contain "+validSize+". Actually it contains "+givenSize);
    }
}
