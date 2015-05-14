package com.tomogle.iemclient.requests.subscribers.deletesubscriber;

import com.tomogle.iemclient.requests.BaseRequest;
import com.tomogle.iemclient.requests.RequestMethod;
import com.tomogle.iemclient.requests.RequestType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xmlrequest")
public class DeleteSubscriberRequest extends BaseRequest {

  private Details details;

  public DeleteSubscriberRequest() {
    super();
  }

  public DeleteSubscriberRequest(final String username, final String usertoken, final String list, final String emailaddress) {
    super(username, usertoken, RequestType.subscribers, RequestMethod.DeleteSubscriber);
    details = new Details(list, emailaddress);
  }

  @XmlElement(required = true)
  public Details getDetails() {
    return details;
  }

  public void setDetails(final Details details) {
    this.details = details;
  }
}
