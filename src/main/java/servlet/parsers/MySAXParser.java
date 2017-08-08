package servlet.parsers;

import org.xml.sax.SAXException;
import servlet.data.XMLvalidation;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Olga on 23.11.2016.
 */
public class MySAXParser extends DefaultHandler{

    ArrayList<String> tags;
    private ArrayList<String> result;
    private String thisElement;

    public ArrayList<String> startParse() throws ParserConfigurationException, IOException, SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLvalidation xmlFile = new XMLvalidation();
        parser.parse(xmlFile.getXMLFile(), this);
        for(int i=0; i<result.size()-1; i++) {
            if(i % 12 == 0 && !result.get(i+1).startsWith("*"))  result.add(i+1, "");
        }
        return result;
    }

    public MySAXParser() throws ParserConfigurationException, IOException, SAXException {
        result = new ArrayList<String>();
        tags = new ArrayList<String>();
        tags.add("Name");
        tags.add("Note");
        tags.add("Soil");
        tags.add("ColorOfStem");
        tags.add("ColorOfLeaf");
        tags.add("Value");
        tags.add("Type");
        tags.add("Lighting");
        tags.add("Watering");
        tags.add("Multiplying");
        tags.add("TemperatureValue");
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        thisElement = qName;
    }
    @Override
    public void endElement(String u, String m, String n) {
        thisElement="";
    }
    @Override
    public void characters(char[] ch, int start, int length) {
        if (tags.contains(thisElement)) {
            result.add(new String(new String(ch, start, length)));
        }
    }
}
