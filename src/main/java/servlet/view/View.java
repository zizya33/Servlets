package servlet.view;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import servlet.parsers.DOMParser;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.ArrayList;
import servlet.parsers.MySAXParser;
import servlet.parsers.MyStaxParser;

/**
 * Created by Olga on 22.11.2016.
 */
public class View {

    ArrayList<String> tags;
    static {
        new DOMConfigurator().doConfigure("src\\main\\resources\\log4j.xml", LogManager.getLoggerRepository());
    }
    static Logger log = Logger.getLogger("log");
    public View(){
        tags = new ArrayList<String>();
        tags.add("VisualParameters");
        tags.add("AverageSize");
        tags.add("GrowingTips");
        tags.add("AverageSize");
        tags.add("Temperature");
    }

    public static ArrayList<Node> getFlowers() throws IOException, SAXException, ParserConfigurationException {
        DOMParser parser = new DOMParser();
        ArrayList<Node> array1 = parser.getFlowers();
        try{
            if(array1 == null) throw new IOException();
        } catch (IOException e) {
            log.error("Null result at getAllNodeList(Node node)");
        }
        return array1;
    }

    private ArrayList<Node> getAllNodeList(Node node) throws IOException, SAXException, ParserConfigurationException {
        DOMParser parser = new DOMParser();
        ArrayList<Node> array1 = parser.getAll(node);
        try{
            if(array1 == null) throw new IOException();
        } catch (IOException e) {
            log.error("Null result at getAllNodeList(Node node)");
        }
        return array1;
    }

    public ArrayList<String> getAll(Node node) throws IOException, SAXException, ParserConfigurationException {
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<Node> array = getAllNodeList(node);
        for (Node i: array) {
            if(tags.contains(i.getNodeName())) continue;
            NodeList nodes = i.getChildNodes();
            for (int j = 0; j < nodes.getLength(); j++) {
                if(nodes.item(j).getNodeValue()!=null) list.add(nodes.item(j).getNodeValue());
            }
        }
        if(list.size()!=12) list.add(1, "");
        try{
            if(list == null) throw new IOException();
        } catch (IOException e) {
            log.error("Null result at getAll(Node node)");
        }
        return list;
    }

    public ArrayList<String> getAllElems() throws IOException, SAXException, ParserConfigurationException {
        MySAXParser parser = new MySAXParser();
        return parser.startParse();
    }

    public ArrayList<String> getAllData() throws XMLStreamException {
        MyStaxParser parser = new MyStaxParser();
        try{
            if(parser.getResult() == null) throw new IOException();
        } catch (IOException e) {
            log.error("Null result at getAllData()");
        }
        return parser.getResult();
    }
}