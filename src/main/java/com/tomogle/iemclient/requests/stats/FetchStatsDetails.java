package com.tomogle.iemclient.requests.stats;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "details")
public class FetchStatsDetails {

  private String statid;
  private StatsType statstype;

  public FetchStatsDetails() {
  }

  /**
   *
   * @param statid The statid of the entry you want to retrieve from the database.
   * @param statstype The type of statistics the entry you are retrieving should be (n = newsletter / a = autoresponder)
   */
  public FetchStatsDetails(final String statid, final StatsType statstype) {
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
  public StatsType getStatstype() {
    return statstype;
  }

  public void setStatstype(final StatsType statstype) {
    this.statstype = statstype;
  }
}
