package servlet.data;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import org.xml.sax.SAXException;

import java.io.File;

/**
 * Created by Olga on 21.11.2016.
 */
public class XMLvalidation {

    private String pathXml;
    private String pathXsd;

    public XMLvalidation(){
        pathXml = "src\\main\\resources\\data.xml";
        pathXsd = "src\\main\\resources\\schema.xsd";
    }

    static {
       new DOMConfigurator().doConfigure("src\\main\\resources\\log4j.xml", LogManager.getLoggerRepository());
    }
    static Logger log = Logger.getLogger("log");

    public String getXMLFilePath(){
        return pathXml;
    }

    public File getXMLFile(){
        return new File(pathXml);
    }

    public boolean isFileExist(String path){
        return new File(path).exists();
    }

    public boolean checkXMLforXSD()
            throws Exception {

        try {
            if (!isFileExist(pathXml)) {
               log.info("Do not found XML " + pathXml);
            }

            if (!isFileExist(pathXsd)) {
                log.info("Do not found XSD " + pathXsd);
            }

            if (!isFileExist(pathXml) || !isFileExist(pathXsd)) {
                return false;
            }

            SchemaFactory factory = SchemaFactory
                    .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(pathXsd));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(pathXml));
            return true;
        } catch (SAXException e) {
            log.error(e.getMessage());
            return false;
        }

    }
}
