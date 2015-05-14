package com.tomogle.iemclient.requests;

/**
 * Represents the method we want to call in the IEM API.
 * According to the IEM API docs, it represents the 'name of the function being called'.
 *
 * We ignore the Java uppercase enum naming convention for ease of use.
 */
public enum RequestMethod {
  AddSubscriberToList,
  DeleteSubscriber,
  xmlapitest,
  GetLists,
  FetchStats,
  GetSubscribers,
  IsSubscriberOnList,
  AddBannedSubscriber,
  ChangeSubscriberConfirm,
  SaveSubscriberCustomField
}
