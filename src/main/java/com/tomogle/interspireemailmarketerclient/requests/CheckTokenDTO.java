package com.tomogle.interspireemailmarketerclient.requests;

import javax.xml.bind.annotation.XmlElement;

public class CheckTokenDTO extends BaseRequestDTO {
  @XmlElement(required = true)
  private final String details = "";

}
