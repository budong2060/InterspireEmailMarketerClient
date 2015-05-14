package com.tomogle.iemclient.requests.subscribers.changesubscriberconfirm;

import com.tomogle.iemclient.requests.BaseRequest;
import com.tomogle.iemclient.requests.RequestMethod;
import com.tomogle.iemclient.requests.RequestType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xmlrequest")
public class ChangeSubscriberConfirmRequest extends BaseRequest {

  private Details details;

  public ChangeSubscriberConfirmRequest() {
  }

  public ChangeSubscriberConfirmRequest(final String username, final String usertoken,
      final Details details) {
    super(username, usertoken, RequestType.subscribers, RequestMethod.ChangeSubscriberConfirm);
    this.details = details;
  }

  @XmlElement(name = "details")
  public Details getDetails() {
    return details;
  }

  public void setDetails(final Details details) {
    this.details = details;
  }
}
