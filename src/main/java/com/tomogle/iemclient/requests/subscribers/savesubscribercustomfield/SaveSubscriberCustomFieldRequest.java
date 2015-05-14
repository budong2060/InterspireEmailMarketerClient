package com.tomogle.iemclient.requests.subscribers.savesubscribercustomfield;

import com.tomogle.iemclient.requests.BaseRequest;
import com.tomogle.iemclient.requests.RequestMethod;
import com.tomogle.iemclient.requests.RequestType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xmlrequest")
public class SaveSubscriberCustomFieldRequest extends BaseRequest {

  private Details details;

  public SaveSubscriberCustomFieldRequest() {
  }

  public SaveSubscriberCustomFieldRequest(final String username, final String usertoken,
      final Details details) {
    super(username, usertoken, RequestType.subscribers, RequestMethod.SaveSubscriberCustomField);
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
