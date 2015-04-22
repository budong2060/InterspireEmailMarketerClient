package com.tomogle.iemclient.requests.stats;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "details")
public class FetchStatsDetailsDTO {

  private String statid;
  private String statstype;

  public FetchStatsDetailsDTO() {
  }

  public FetchStatsDetailsDTO(final String statid, final String statstype) {
    this.statid = statid;
    this.statstype = statstype;
  }

  @XmlElement(required = true)
  public String getStatid() {
    return statid;
  }

  public void setStatid(final String statid) {
    this.statid = statid;
  }

  @XmlElement(required = true)
  public String getStatstype() {
    return statstype;
  }

  public void setStatstype(final String statstype) {
    this.statstype = statstype;
  }
}
