package com.tomogle.iemclient.requests.subscribers.deletesubscriber;

import com.tomogle.iemclient.requests.BaseRequest;
import com.tomogle.iemclient.requests.RequestMethod;
import com.tomogle.iemclient.requests.RequestType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "details")
public class DeleteSubscriberRequest extends BaseRequest {

  private String list;
  private String emailaddress;

  public DeleteSubscriberRequest() {
    super();
  }

  public DeleteSubscriberRequest(final String username, final String usertoken, final String list, final String emailaddress) {
    super(username, usertoken, RequestType.subscribers, RequestMethod.DeleteSubscriber);
    this.list = list;
    this.emailaddress = emailaddress;
  }

  @XmlElement(required = true)
  public String getList() {
    return list;
  }

  public void setList(final String list) {
    this.list = list;
  }

  @XmlElement(required = true)
  public String getEmailaddress() {
    return emailaddress;
  }

  public void setEmailaddress(final String emailaddress) {
    this.emailaddress = emailaddress;
  }
}
