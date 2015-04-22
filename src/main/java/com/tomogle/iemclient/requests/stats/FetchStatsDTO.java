package com.tomogle.iemclient.requests.stats;

import com.tomogle.iemclient.requests.BaseRequestDTO;
import com.tomogle.iemclient.requests.RequestMethod;
import com.tomogle.iemclient.requests.RequestType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xmlrequest")
public class FetchStatsDTO extends BaseRequestDTO {

  private FetchStatsDetailsDTO details;

  public FetchStatsDTO() {
  }

  public FetchStatsDTO(final String username, final String usertoken, final FetchStatsDetailsDTO details) {
    super(username, usertoken, RequestType.stats, RequestMethod.FetchStats);
    this.details = details;
  }

  @XmlElement(required = true)
  public FetchStatsDetailsDTO getDetails() {
    return details;
  }

  public void setDetails(final FetchStatsDetailsDTO details) {
    this.details = details;
  }
}
