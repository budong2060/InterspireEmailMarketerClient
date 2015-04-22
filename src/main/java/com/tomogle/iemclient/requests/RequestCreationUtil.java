package com.tomogle.iemclient.requests;


import com.tomogle.iemclient.requests.authentication.checktoken.CheckTokenDTO;
import com.tomogle.iemclient.requests.stats.FetchStatsDTO;
import com.tomogle.iemclient.requests.stats.FetchStatsDetailsDTO;
import com.tomogle.iemclient.requests.subscribers.addsubscriber.AddSubscriberDTO;
import com.tomogle.iemclient.requests.subscribers.addsubscriber.AddSubscriberDetailsDTO;
import com.tomogle.iemclient.requests.subscribers.addsubscriber.Confirmed;
import com.tomogle.iemclient.requests.subscribers.addsubscriber.Format;
import com.tomogle.iemclient.requests.subscribers.addsubscriber.ItemDTO;
import com.tomogle.iemclient.requests.subscribers.deletesubscriber.DeleteSubscriberDTO;

import java.util.List;

public class RequestCreationUtil {

  public static CheckTokenDTO checkTokenDTO(final String apiUsername, final String apiToken) {
    return new CheckTokenDTO(apiUsername, apiToken);
  }

  public static AddSubscriberDTO addSubscriberDTO(final String apiUsername, final String apiToken, final String emailAddress,
      final String mailingListId, final Format format, final Confirmed confirmed, final List<ItemDTO> customFields) {
    return new AddSubscriberDTO(apiUsername, apiToken, new AddSubscriberDetailsDTO(emailAddress, mailingListId, format, confirmed, customFields));
  }

  public static DeleteSubscriberDTO deleteSubscriberDTO(final String apiUsername, final String apiToken, final String listId,
      final String emailAddress) {
    return new DeleteSubscriberDTO(apiUsername, apiToken, listId, emailAddress);
  }

  public static FetchStatsDTO fetchStatsDTO(final String apiUsername, final String apiToken, final String statId, final String statsType) {
    return new FetchStatsDTO(apiUsername, apiToken, new FetchStatsDetailsDTO(statId, statsType));
  }
}
