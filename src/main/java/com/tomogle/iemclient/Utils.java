package com.tomogle.iemclient;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;

public class Utils {

  public static <T> String toXml(final T entity) throws JAXBException {
    JAXBContext ctx = JAXBContext.newInstance(entity.getClass());
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    Marshaller marshaller = ctx.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

    marshaller.marshal(entity, bos);
    return bos.toString();
  }

  public static <T> T fromXml(final String entity, final Class<T> clazz) throws JAXBException {
    JAXBContext ctx = JAXBContext.newInstance(clazz);

    Unmarshaller unmarshaller = ctx.createUnmarshaller();

    StringReader reader = new StringReader(entity);
    return (T) unmarshaller.unmarshal(reader);
  }
}
