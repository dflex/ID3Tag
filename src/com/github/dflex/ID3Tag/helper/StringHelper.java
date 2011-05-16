/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.dflex.ID3Tag.helper;

/**
 *
 * @author Dominik
 */
public class StringHelper {
    
    private static StringHelper instance = null;
    
    private StringHelper() {
    }
    
    public static StringHelper getInstance() {
        if(instance == null) {
            instance = new StringHelper();
        }
        return instance;
    }
    
    public String trimString(String string, int length) {
        if(string == null) {
            string = "";
        }
        if(length < 0) {
            length = 0;
        }
        
        int stringLength = (string.length() > length) ? length : string.length();
        return string.trim().substring(0, stringLength);
    }
    
    public void encode(String string) {
        
    }
    
    public void decode(String string) {
        
    }
}