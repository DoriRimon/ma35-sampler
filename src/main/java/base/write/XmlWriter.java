package base.write;

import base.config.Configurations;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;


/**
 * The XmlWriter writes to XML files
 * @param <T> - the type of data to be written
 */
public class XmlWriter<T> implements Writer<T> {

    /* configurations */
    private Configurations configurations;

    /* Files writing */
    private File file;
    private Transformer transformer;

    /* DOM elements */
    private DocumentBuilder documentBuilder;
    private Document document;
    private Element root;

    /* DOM metadata */
    private String rootTagName;
    private String recordTagName;

    /* files metadata */
    private String dirPath;
    private String fileName;
    private final String type = "xml";

    /* counters */
    private int currentFileNumber;
    private int currentRecordsAmount;
    private int maxRecordsPerBatch;

    public XmlWriter(String dirPathKey, String rootTagName, String recordTagName) throws IOException {
        /* get configuration data */
        this.configurations = new Configurations();
        this.dirPath = configurations.get(dirPathKey);
        this.fileName = configurations.get("xmlFileName");
        this.maxRecordsPerBatch = Integer.parseInt(configurations.get("xmlWriterMaxRecordsPerBatch"));

        this.rootTagName = rootTagName;
        this.recordTagName = recordTagName;

        /* initialize DocumentBuilder */
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            this.documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        /* initialize transformer */
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            this.transformer = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }

        this.currentFileNumber = 0;
        initialize();
    }

    /**
     * Initializes DOM & File
     */
    private void initialize() {
        this.document = this.documentBuilder.newDocument();
        this.root = this.document.createElement(this.rootTagName);
        this.document.appendChild(root);
        this.currentRecordsAmount = 0;
        this.currentFileNumber++;
        this.file = new File(this.dirPath + "\\" + this.fileName + "_" +
                this.currentFileNumber + "." + this.type);
    }

    /**
     * Adds element to the DOM file (i.e. append to root)
     * @param object - The object to be added
     */
    private void addDomElement(T object) {
        /* Create tag for the object */
        Element element = this.document.createElement(this.recordTagName);

        /* Iterate over all objet's fields */
        Class objectClass = object.getClass();
        for (Field field : objectClass.getFields()) {
            String name = field.getName();
            Object value = null;
            try {
                value = field.get(field.getType());

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            /* Create inner element per field */
            Element fieldElement = this.document.createElement(name);
            fieldElement.appendChild(document.createTextNode(String.valueOf(value)));
            element.appendChild(fieldElement);
        }

        /* Append the object element to the root */
        this.root.appendChild(element);
    }

    /**
     * Writes current batch into current file, and re-initializes everything
     * @throws TransformerException - if transformation failed
     */
    private void batchClean() throws TransformerException {
        DOMSource domSource = new DOMSource(document);
        this.transformer.transform(domSource, new StreamResult(this.file));

        initialize();
    }

    /**
     * Add the object to DOM, and write if batch is of required size
     * @param object - The object to be written
     * @throws IOException - if writing failed
     */
    @Override
    public void write(T object) throws IOException {
        addDomElement(object);
        this.currentRecordsAmount++;

        if (this.currentRecordsAmount >= this.maxRecordsPerBatch) {
            try {
                batchClean();
            } catch (TransformerException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Writes current batch to the file
     * @throws IOException - if writing failed
     */
    @Override
    public void flush() {
        try {
            batchClean();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
