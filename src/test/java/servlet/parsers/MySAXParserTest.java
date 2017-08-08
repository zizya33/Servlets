/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.parsers;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 *
 * @author Olga
 */
public class MySAXParserTest {

    /**
     * Test of startParse method, of class MySAXParser.
     */
    @Test
    public void testStartParse() throws Exception {
        System.out.println("startParse");
        MySAXParser instance = new MySAXParser();
        ArrayList<String> result = instance.startParse();
        assertNotNull(result);
    }
}
