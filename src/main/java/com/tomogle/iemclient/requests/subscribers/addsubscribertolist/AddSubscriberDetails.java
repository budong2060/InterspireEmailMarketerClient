package com.tomogle.iemclient.requests.subscribers.addsubscribertolist;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "details")
public class AddSubscriberDetails {

  private String emailaddress;
  private String mailinglist;
  private Format format;
  private Confirmed confirmed;
  private String ipaddress;
  private List<CustomFields> customfields;

  public AddSubscriberDetails() {
    super();
  }

  public AddSubscriberDetails(final String emailaddress, final String mailinglist, final Format format,
      final Confirmed confirmed, final List<CustomFields> customfields) {
    this.emailaddress = emailaddress;
    this.mailinglist = mailinglist;
    this.format = format;
    this.confirmed = confirmed;
    this.customfields = customfields;
  }


  @XmlElement(required = true)
  public String getEmailaddress() {
    return emailaddress;
  }

  public void setEmailaddress(final String emailaddress) {
    this.emailaddress = emailaddress;
  }

  @XmlElement(required = true)
  public String getMailinglist() {
    return mailinglist;
  }

  public void setMailinglist(final String mailinglist) {
    this.mailinglist = mailinglist;
  }

  @XmlElement(required = true)
  public Format getFormat() {
    return format;
  }

  public void setFormat(final Format format) {
    this.format = format;
  }

  @XmlElement(required = true)
  public Confirmed getConfirmed() {
    return confirmed;
  }

  public void setConfirmed(final Confirmed confirmed) {
    this.confirmed = confirmed;
  }

  @XmlElement(required = false)
  public String getIpaddress() {
    return ipaddress;
  }

  public void setIpaddress(final String ipaddress) {
    this.ipaddress = ipaddress;
  }

  @XmlElement(name = "customfields")
  public List<CustomFields> getCustomfields() {
    return customfields;
  }

  public void setCustomfields(final List<CustomFields> customfields) {
    this.customfields = customfields;
  }
}