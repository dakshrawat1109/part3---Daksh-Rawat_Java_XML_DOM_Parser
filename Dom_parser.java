import java.io.IOException;

import javax.lang.model.element.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;




public class Dom_parser {

	public static void main(String[] args) throws SAXException, IOException {
	DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
	
	try {
		DocumentBuilder builder= factory.newDocumentBuilder();
		Document doc=builder.parse("Parents.xml");
		NodeList parentslist =doc.getElementsByTagName("Father");
		for(int i=0;i<parentslist.getLength();i++) {
			Node p=parentslist.item(i);
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
	} catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	

	}

}
