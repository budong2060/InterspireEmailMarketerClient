package com.tomogle.iemclient.requests.authentication.checktoken;

import com.tomogle.iemclient.requests.BaseRequest;
import com.tomogle.iemclient.requests.RequestMethod;
import com.tomogle.iemclient.requests.RequestType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xmlrequest")
public class CheckTokenRequest extends BaseRequest {

  private String details;

  public CheckTokenRequest() {
  }

  public CheckTokenRequest(final String username, final String usertoken) {
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
