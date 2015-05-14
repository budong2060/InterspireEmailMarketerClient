package com.tomogle.iemclient.requests;


import com.tomogle.iemclient.requests.authentication.checktoken.CheckTokenRequest;
import com.tomogle.iemclient.requests.lists.GetListsRequest;
import com.tomogle.iemclient.requests.lists.GetListsDetails;
import com.tomogle.iemclient.requests.stats.FetchStatsRequest;
import com.tomogle.iemclient.requests.stats.FetchStatsDetails;
import com.tomogle.iemclient.requests.stats.StatsType;
import com.tomogle.iemclient.requests.subscribers.addbannedsubscriber.AddBannedSubscriberRequest;
import com.tomogle.iemclient.requests.subscribers.addbannedsubscriber.Details;
import com.tomogle.iemclient.requests.subscribers.addsubscribertolist.AddSubscriberRequest;
import com.tomogle.iemclient.requests.subscribers.addsubscribertolist.AddSubscriberDetails;
import com.tomogle.iemclient.requests.subscribers.addsubscribertolist.Confirmed;
import com.tomogle.iemclient.requests.subscribers.addsubscribertolist.CustomFields;
import com.tomogle.iemclient.requests.subscribers.addsubscribertolist.Format;
import com.tomogle.iemclient.requests.subscribers.changesubscriberconfirm.ChangeSubscriberConfirmRequest;
import com.tomogle.iemclient.requests.subscribers.changesubscriberconfirm.Status;
import com.tomogle.iemclient.requests.subscribers.deletesubscriber.DeleteSubscriberRequest;
import com.tomogle.iemclient.requests.subscribers.getsubscribers.GetSubscriberDetails;
import com.tomogle.iemclient.requests.subscribers.getsubscribers.GetSubscribersCountRequest;
import com.tomogle.iemclient.requests.subscribers.getsubscribers.GetSubscribersRequest;
import com.tomogle.iemclient.requests.subscribers.getsubscribers.SearchInfo;

import java.util.List;

public class RequestCreationUtil {

  public static CheckTokenRequest checkTokenRequest(final String apiUsername, final String apiToken) {
    return new CheckTokenRequest(apiUsername, apiToken);
  }

  public static AddBannedSubscriberRequest addBannedSubscriberToSingleListRequest(final String apiUsername, final String apiToken,
      final String list, final String emailAddress) {
    AddBannedSubscriberRequest request = new AddBannedSubscriberRequest(apiUsername, apiToken);
    Details details = new Details(emailAddress, list);
    request.setDetails(details);
    return request;
  }

  public static AddBannedSubscriberRequest addBannedSubscriberGloballyRequest(final String apiUsername, final String apiToken,
      final String emailAddress) {
    AddBannedSubscriberRequest request = new AddBannedSubscriberRequest(apiUsername, apiToken);
    Details details = new Details(emailAddress, "global");
    request.setDetails(details);
    return request;
  }

  public static AddSubscriberRequest addSubscriberRequest(final String apiUsername, final String apiToken, final String emailAddress,
      final String mailingListId, final Format format, final Confirmed confirmed, final List<CustomFields> customFields) {
    return new AddSubscriberRequest(apiUsername, apiToken, new AddSubscriberDetails(emailAddress, mailingListId, format, confirmed,
        customFields));
  }

  public static DeleteSubscriberRequest deleteSubscriberRequest(final String apiUsername, final String apiToken, final String listId,
      final String emailAddress) {
    return new DeleteSubscriberRequest(apiUsername, apiToken, listId, emailAddress);
  }

  public static FetchStatsRequest fetchStatsRequest(final String apiUsername, final String apiToken, final String statId,
      final StatsType statsType) {
    return new FetchStatsRequest(apiUsername, apiToken, new FetchStatsDetails(statId, statsType));
  }

  public static GetListsRequest getListsRequest(final String apiUsername, final String apiToken, final int start, final int perPage) {
    return new GetListsRequest(apiUsername, apiToken, new GetListsDetails(start, perPage));
  }

  /**
   *
   * @param apiUsername
   * @param apiToken
   * @param listId The listid, or any for any list
   * @param email
   * @return
   */
  public static GetSubscribersRequest getSubscribersRequest(final String apiUsername, final String apiToken, final String listId,
      final String email) {
    return new GetSubscribersRequest(apiUsername, apiToken, new GetSubscriberDetails(new SearchInfo(listId, email)));
  }

  public static GetSubscribersCountRequest getSubscribersCountRequest(final String apiUsername, final String apiToken, final String listId) {
    SearchInfo searchinfo = new SearchInfo();
    searchinfo.setList(listId);
    GetSubscriberDetails details = new GetSubscriberDetails(searchinfo);
    details.setCountonly(true);
    return new GetSubscribersCountRequest(apiUsername, apiToken, details);
  }

  public static GetSubscribersRequest getSubscribersRequestByEmail(final String apiUsername, final String apiToken, final String email) {
    SearchInfo searchInfo = new SearchInfo();
    searchInfo.setEmail(email);
    return new GetSubscribersRequest(apiUsername, apiToken, new GetSubscriberDetails(searchInfo));
  }

  public static GetSubscribersRequest getSubscribersRequestByListId(final String apiUsername, final String apiToken, final String listId) {
    SearchInfo searchInfo = new SearchInfo();
    searchInfo.setList(listId);
    return new GetSubscribersRequest(apiUsername, apiToken, new GetSubscriberDetails(searchInfo));
  }

  public static ChangeSubscriberConfirmRequest changeSubscriberConfirmStatusForAllLists(final String apiUsername, final String apiToken,
      final Status status, final String subscriberid) {
    return new ChangeSubscriberConfirmRequest(apiUsername, apiToken, new com.tomogle.iemclient.requests.subscribers
        .changesubscriberconfirm.Details(status, subscriberid));
  }

  public static ChangeSubscriberConfirmRequest changeSubscriberConfirmStatusForList(final String apiUsername, final String apiToken,
      final Status status, final String listid,final String subscriberid) {
    return new ChangeSubscriberConfirmRequest(apiUsername, apiToken, new com.tomogle.iemclient.requests.subscribers
        .changesubscriberconfirm.Details(status, listid, subscriberid));
  }
}
