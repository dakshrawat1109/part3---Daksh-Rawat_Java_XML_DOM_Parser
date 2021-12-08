import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Document;

public class domParserSchema {
 public static void main(String[] args) {

  String schemaName = "Parents.xsd";
  String xmlName = "Parents.xml";
  Schema schema = loadSchema(schemaName);
  Document document = parseXmlDom(xmlName);
  validateXml(schema, document);
 }
 public static void validateXml(Schema schema, Document document) {
  try {

   Validator validator = schema.newValidator();


   validator.validate(new DOMSource(document));
   System.out.println("Validation true.");
  } catch (Exception e) {
   
   System.out.println(e.toString());
  }
 }
 public static Schema loadSchema(String schemaFileName) {
  Schema schema = null;
  try {
  
   String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
   SchemaFactory factory = SchemaFactory.newInstance(language);

   schema = factory.newSchema(new File(schemaFileName));
  } catch (Exception e) {
   System.out.println(e.toString());
  }
  return schema;
 }
 public static Document parseXmlDom(String xmlName) {
  Document document = null;
  try {
   DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
   DocumentBuilder builder = factory.newDocumentBuilder();
   document = builder.parse(new File(xmlName));
  } catch (Exception e) {
   System.out.println(e.toString());
  }
  return document;
 }
 
}