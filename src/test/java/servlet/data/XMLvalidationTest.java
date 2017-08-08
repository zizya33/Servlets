/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.data;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Olga
 */
public class XMLvalidationTest {
    /**
     * Test of getXMLFilePath method, of class XMLvalidation.
     */
    @Test
    public void testGetXMLFilePath() {
        System.out.println("getXMLFilePath");
        XMLvalidation instance = new XMLvalidation();
        String expResult = "src\\main\\resources\\data.xml";
        String result = instance.getXMLFilePath();
        assertEquals(expResult, result);
    }

    /**
     * Test of isFileExist method, of class XMLvalidation.
     */
    @Test
    public void testIsFileExist() {
        System.out.println("isFileExist");
        String path = "src\\main\\resources\\data.xml";
        XMLvalidation instance = new XMLvalidation();
        boolean expResult = true;
        boolean result = instance.isFileExist(path);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkXMLforXSD method, of class XMLvalidation.
     */
    @Test
    public void testCheckXMLforXSD() throws Exception {
        System.out.println("checkXMLforXSD");
        XMLvalidation instance = new XMLvalidation();
        boolean expResult = true;
        boolean result = instance.checkXMLforXSD();
        assertEquals(expResult, result);
    }
    
}
