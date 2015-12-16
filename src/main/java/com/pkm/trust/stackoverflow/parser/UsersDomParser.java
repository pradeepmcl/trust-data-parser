package com.pkm.trust.stackoverflow.parser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * One run of this program on a 1GB Users.xml file took quite long and I decided
 * to use StAX instead. This program is not full fledged.
 * 
 * @author mpradeep
 *
 */
@Deprecated
public class UsersDomParser {

  public static void main(String[] args) throws SAXException, IOException,
      ParserConfigurationException {
    
    String usersFilename = args[0];

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    try (InputStream stream = new FileInputStream(usersFilename)) {
    Document document = builder.parse(stream);
    
    NodeList nodeList = document.getDocumentElement().getChildNodes();
    System.out.println(nodeList.getLength());
    
    for (int i = 0; i < nodeList.getLength(); i++) {
      Node node = nodeList.item(i);
      if (node instanceof Element) {
        System.out.println(node.getNodeName());
      }
    }
    }
  }
}
