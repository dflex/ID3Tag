/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.dflex.tag.id3;

import com.github.dflex.tag.Genre;
import java.util.Calendar;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dominik
 */
public class ID3v1Test {
    
    private ID3v1 testTag;
    
    public ID3v1Test() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        // Initialisieren der Testklasse mit Strings der Länge 32
        testTag = new ID3v1("123456789012345678901234567890!!", "123456789012345678901234567890!!", "123456789012345678901234567890!!", "123456789012345678901234567890!!", Calendar.getInstance().getTime(), Genre.Dance);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getIdentifier method, of class ID3v1.
     */
    @Test
    public void testGetIdentifier() {
        System.out.println("getIdentifier");
        ID3v1 instance = testTag;
        String expResult = "TAG";
        String result = instance.getIdentifier();
        assertEquals(expResult, result);
    }

    /**
     * Test of getArtist method, of class ID3v1.
     */
    @Test
    public void testGetArtist() {
        System.out.println("getArtist");
        ID3v1 instance = testTag;
        String expResult = "123456789012345678901234567890";
        String result = instance.getArtist();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAlbum method, of class ID3v1.
     */
    @Test
    public void testGetAlbum() {
        System.out.println("getAlbum");
        ID3v1 instance = testTag;
        String expResult = "123456789012345678901234567890";
        String result = instance.getAlbum();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTitle method, of class ID3v1.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        ID3v1 instance = testTag;
        String expResult = "123456789012345678901234567890";
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getComment method, of class ID3v1.
     */
    @Test
    public void testGetComment() {
        System.out.println("getComment");
        ID3v1 instance = testTag;
        String expResult = "123456789012345678901234567890";
        String result = instance.getComment();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDate method, of class ID3v1.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        ID3v1 instance = testTag;
        int expResult = 2011;
        Calendar.getInstance().setTime(instance.getDate());
        int result = Calendar.getInstance().get(Calendar.YEAR);
        assertEquals(expResult, result);
    }

    /**
     * Test of getGenre method, of class ID3v1.
     */
    @Test
    public void testGetGenre() {
        System.out.println("getGenre");
        ID3v1 instance = testTag;
        Genre expResult = Genre.Dance;
        Genre result = instance.getGenre();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAlbum method, of class ID3v1.
     */
    @Test
    public void testSetAlbum() {
        System.out.println("setAlbum");
        String album = null;
        ID3v1 instance = testTag;
        instance.setAlbum(album);
    }

    /**
     * Test of setArtist method, of class ID3v1.
     */
    @Test
    public void testSetArtist() {
        System.out.println("setArtist");
        String artist = "";
        ID3v1 instance = testTag;
        instance.setArtist(artist);
    }

    /**
     * Test of setComment method, of class ID3v1.
     */
    @Test
    public void testSetComment() {
        System.out.println("setComment");
        String comment = "";
        ID3v1 instance = testTag;
        instance.setComment(comment);
    }

    /**
     * Test of setDate method, of class ID3v1.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        Date date = null;
        ID3v1 instance = testTag;
        instance.setDate(date);
    }

    /**
     * Test of setGenre method, of class ID3v1.
     */
    @Test
    public void testSetGenre() {
        System.out.println("setGenre");
        Genre genre = null;
        ID3v1 instance = testTag;
        instance.setGenre(genre);
    }

    /**
     * Test of setTitle method, of class ID3v1.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "";
        ID3v1 instance = testTag;
        instance.setTitle(title);
    }

    /**
     * Test of getData method, of class ID3v1.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        ID3v1 instance = testTag;
        byte[] expResult = new byte[128];
        System.arraycopy("TAG".getBytes(), 0, expResult, 0, 3);
        System.arraycopy("123456789012345678901234567890".getBytes(), 0, expResult, 3, 30);
        System.arraycopy("123456789012345678901234567890".getBytes(), 0, expResult, 33, 30);
        System.arraycopy("123456789012345678901234567890".getBytes(), 0, expResult, 63, 30);
        System.arraycopy("2011".getBytes(), 0, expResult, 93, 4);
        System.arraycopy("123456789012345678901234567890".getBytes(), 0, expResult, 97, 30);
        expResult[127] = (byte) Genre.Dance.getValue();
        byte[] result = instance.getData();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of toString method, of class ID3v1.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ID3v1 instance = testTag;
        Calendar.getInstance().setTime(instance.getDate());
        String expResult = "ID3v1{" + "identifier=TAG artist=123456789012345678901234567890 album=123456789012345678901234567890 title=123456789012345678901234567890 comment=123456789012345678901234567890 date=" + Calendar.getInstance().getTime() + " genre=Dance}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
