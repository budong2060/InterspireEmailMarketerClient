package com.tomogle.iemclient.requests.addsubscriber;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "details")
public class AddSubscriberDetailsDTO {

  private String emailaddress;
  private String mailinglist;
  private Format format;
  private Confirmed confirmed;
  private List<ItemDTO> customfields;

  public AddSubscriberDetailsDTO() {
  }

  public AddSubscriberDetailsDTO(final String emailaddress, final String mailinglist, final Format format,
      final Confirmed confirmed, final List<ItemDTO> customfields) {
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

  @XmlElement(required = true)
  public List<ItemDTO> getCustomfields() {
    return customfields;
  }

  public void setCustomfields(final List<ItemDTO> customfields) {
    this.customfields = customfields;
  }
}