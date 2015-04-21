package com.tomogle.iemclient;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;

public class Utils {

  public static <T> String toXml(final T entity) throws JAXBException {
    JAXBContext ctx = JAXBContext.newInstance(entity.getClass());
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    Marshaller marshaller = ctx.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

    marshaller.marshal(entity, bos);
    return bos.toString();
  }
}
