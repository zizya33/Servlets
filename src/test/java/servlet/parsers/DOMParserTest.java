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
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 *
 * @author Olga
 */
public class DOMParserTest {

    /**
     * Test of getFlowers method, of class DOMParser.
     */
    @Test
    public void testGetFlowers() throws Exception {
        System.out.println("getFlowers");
        DOMParser instance = new DOMParser();
        ArrayList<Node> result = instance.getFlowers();
        assertNotNull(result);
    }

    /**
     * Test of getAll method, of class DOMParser.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        DOMParser instance = new DOMParser();
        ArrayList<Node> result = instance.getAll(instance.getDoc());
        assertNotNull(result);
    }    
}
