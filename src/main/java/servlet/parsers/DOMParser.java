package servlet.parsers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import servlet.data.XMLvalidation;

/**
 * Created by Olga on 21.11.2016.
 */
public class DOMParser {

    private Document doc;

    public Document getDoc(){
        return doc;
    }

    public DOMParser() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        f.setValidating(false);
        DocumentBuilder builder = f.newDocumentBuilder();
        XMLvalidation xmlFile = new XMLvalidation();
        doc = builder.parse(xmlFile.getXMLFile());
    }

    public ArrayList<Node> getFlowers() throws IOException, SAXException, ParserConfigurationException {
        NodeList list = doc.getChildNodes();
        NodeList childNodes = list.item(0).getChildNodes();
        ArrayList<Node> array = new ArrayList<Node>();
        for (int i = 0; i < childNodes.getLength(); i++) {
            if( childNodes.item(i).getNodeType() == Node.ELEMENT_NODE) array.add(childNodes.item(i));
        }
        return array;
    }

    public ArrayList<Node> getAll(Node node) throws IOException, SAXException, ParserConfigurationException {
        ArrayList<Node> array = new ArrayList<Node>();
        read(node, array);
        ArrayList<Node> array1 = new ArrayList<Node>();
        for (Node i: array) {
            if( i.getNodeType() == Node.ELEMENT_NODE ) array1.add(i);
        }
        return array1;
    }

    public  void read(Node node, ArrayList<Node> array) {
        NodeList list = node.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            Node childNode = list.item(i);
            if( childNode.getNodeType() == Node.ELEMENT_NODE) array.add(childNode);
            read(list.item(i), array);
        }
    }
}
