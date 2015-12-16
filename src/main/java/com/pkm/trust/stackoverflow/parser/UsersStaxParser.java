package com.pkm.trust.stackoverflow.parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;

import com.pkm.trust.stackoverflow.jaxb.User;

public class UsersStaxParser {

  public static void main(String[] args)
      throws FileNotFoundException, IOException, XMLStreamException, JAXBException {

    String usersFilename = args[0];

    int i = 0;
    try (InputStream stream = new FileInputStream(usersFilename)) {
      XMLInputFactory factory = XMLInputFactory.newInstance();
      XMLEventReader reader = factory.createXMLEventReader(stream);

      JAXBContext jc = JAXBContext.newInstance(User.class);
      Unmarshaller unmarshaller = jc.createUnmarshaller();
      Marshaller marshaller = jc.createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

      while (reader.hasNext()) {
        if (reader.peek().isStartElement()
            && reader.peek().asStartElement().getName().getLocalPart().equals("row")) {
          User user = (User) unmarshaller.unmarshal(reader);
          System.out.println(user.getId() + ": " + user.getDisplayName());
        } else {
          reader.nextEvent();
        }

        if (i++ == 20) {
          break;
        }
      }
    }
  }
}
