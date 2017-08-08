package servlet.parsers;

import servlet.data.XMLvalidation;

import java.util.ArrayList;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.events.StartElement;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class MyStaxParser {

    private ArrayList<String> result;
    private ArrayList<String> tags;

    public MyStaxParser() throws XMLStreamException {
        tags = new ArrayList<String>();
        result = new ArrayList<String>();
        tags.add("VisualParameters");
        tags.add("AverageSize");
        tags.add("GrowingTips");
        tags.add("AverageSize");
        tags.add("Temperature");
        tags.add("Flowers");
        tags.add("Item");
        XMLvalidation file = new XMLvalidation();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(new FileInputStream(file.getXMLFilePath()));
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(file.getXMLFilePath()));
            while (xmlEventReader.hasNext()) {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    if (!tags.contains(startElement.getName().getLocalPart())) {
                        xmlEvent = xmlEventReader.nextEvent();
                        result.add(xmlEvent.asCharacters().getData());
                    }
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (XMLStreamException e) {
            e.printStackTrace();
        }
        for(int i=0; i<result.size()-1; i++) {
            if(i % 12 == 0 && !result.get(i+1).startsWith("*"))  result.add(i+1, "");
        }
    }
        public ArrayList<String> getResult() {
        return result;
    }
}