package com.tomogle.iemclient.requests.lists;

import com.tomogle.iemclient.requests.BaseRequest;
import com.tomogle.iemclient.requests.RequestMethod;
import com.tomogle.iemclient.requests.RequestType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xmlrequest")
public class GetListsRequest extends BaseRequest {

  private GetListsDetails details;

  public GetListsRequest() {
  }

  public GetListsRequest(final String username, final String usertoken, final GetListsDetails details) {
    super(username, usertoken, RequestType.lists, RequestMethod.GetLists);
    this.details = details;
  }

  @XmlElement(required = true)
  public GetListsDetails getDetails() {
    return details;
  }

  public void setDetails(final GetListsDetails details) {
    this.details = details;
  }
}
