package com.tomogle.iemclient.requests.stats;

import com.tomogle.iemclient.requests.BaseRequest;
import com.tomogle.iemclient.requests.RequestMethod;
import com.tomogle.iemclient.requests.RequestType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xmlrequest")
public class FetchStatsRequest extends BaseRequest {

  private FetchStatsDetails details;

  public FetchStatsRequest() {
  }

  public FetchStatsRequest(final String username, final String usertoken, final FetchStatsDetails details) {
    super(username, usertoken, RequestType.stats, RequestMethod.FetchStats);
    this.details = details;
  }

  @XmlElement(required = true)
  public FetchStatsDetails getDetails() {
    return details;
  }

  public void setDetails(final FetchStatsDetails details) {
    this.details = details;
  }
}
