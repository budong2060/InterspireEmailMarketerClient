package com.tomogle.iemclient.requests;

import javax.xml.bind.annotation.XmlElement;

public class CheckTokenDTO extends BaseRequestDTO {
  @XmlElement(required = true)
  private final String details = "";

}
