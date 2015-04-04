package com.tomogle.iemclient.requests;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xmlrequest")
public class CheckTokenDTO extends BaseRequestDTO {

  public CheckTokenDTO() {
  }

  public CheckTokenDTO(final String username, final String usertoken, final RequestType requesttype,
      final RequestMethod requestmethod) {
    super(username, usertoken, RequestType.authentication, RequestMethod.xmlapitest);
    this.setDetails(" ");
  }
}
