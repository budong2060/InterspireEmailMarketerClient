package com.tomogle.iemclient.requests;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xmlrequest")
public class CheckTokenDTO extends BaseRequestDTO {

  private String details;

  public CheckTokenDTO() {
  }

  public CheckTokenDTO(final String username, final String usertoken) {
    super(username, usertoken, RequestType.authentication, RequestMethod.xmlapitest);
    setDetails(" ");
  }

  @XmlElement(required = true)
  public String getDetails() {
    return details;
  }

  public void setDetails(final String details) {
    this.details = details;
  }
}
