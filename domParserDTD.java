import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class domParserDTD {

  private static final String FILENAME = "Parents.xml";

  public static void main(String[] args) {

   
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

      try {

     
          dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

          DocumentBuilder db = dbf.newDocumentBuilder();

          Document doc = db.parse(new File(FILENAME));

          doc.getDocumentElement().normalize();

          System.out.println( doc.getDocumentElement().getNodeName());
          System.out.println("------");

          NodeList list =doc.getElementsByTagName("Father");

          for (int i = 0; i < list.getLength(); i++) {

            Node p=list.item(i);
			if(p.getNodeType()==Node.ELEMENT_NODE) {
//				Element element = (Element) p;
//				String id=element.getAttributes("id");
				org.w3c.dom.Element parent= (org.w3c.dom.Element) p;
				String id=parent.getAttribute("id");
				NodeList namelist =parent.getChildNodes();
				for(int j=0;j<namelist.getLength();j++) {
					Node q=namelist.item(j);
					if(q.getNodeType()==Node.ELEMENT_NODE) {
						org.w3c.dom.Element name=(org.w3c.dom.Element) q;
						System.out.println("Parent "+ id + ":" + name.getTagName()+ "   " +name.getTextContent());
					}

              }
			}
		}

      } catch (ParserConfigurationException | SAXException | IOException e) {
          e.printStackTrace();
      }

  }

}