/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.parsers;

import java.util.ArrayList;
import javax.xml.stream.XMLStreamException;
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
public class MyStaxParserTest {
    

    /**
     * Test of getResult method, of class MyStaxParser.
     */
    @Test
    public void testGetResult() throws XMLStreamException {
        System.out.println("getResult");
        MyStaxParser myStaxParser = new MyStaxParser();
        MyStaxParser instance = new MyStaxParser();
        ArrayList<String> result = instance.getResult();
        assertNotNull(result);
    }
}
