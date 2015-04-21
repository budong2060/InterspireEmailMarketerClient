package com.tomogle.iemclient.requests;

import com.tomogle.iemclient.requests.addsubscriber.AddSubscriberDTO;
import com.tomogle.iemclient.requests.addsubscriber.AddSubscriberDetailsDTO;
import com.tomogle.iemclient.requests.addsubscriber.Confirmed;
import com.tomogle.iemclient.requests.addsubscriber.Format;
import com.tomogle.iemclient.requests.addsubscriber.ItemDTO;

import java.util.List;

public class RequestCreationUtil {

  public static CheckTokenDTO checkTokenDTO(final String apiUsername, final String apiToken) {
    return new CheckTokenDTO(apiUsername, apiToken);
  }

  public static AddSubscriberDTO addSubscriberDTO(final String apiUsername, final String apiToken, final String emailAddress,
      final String mailingListId, final Format format, final Confirmed confirmed, final List<ItemDTO> customFields) {
    return new AddSubscriberDTO(apiUsername, apiToken, new AddSubscriberDetailsDTO(emailAddress, mailingListId, format, confirmed, customFields));
  }
}
