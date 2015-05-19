# InterspireEmailMarketerClient
Java client for the Interspire Email Marketer (IEM) XML API

To instantiate a new client: `IEMClient client = new Client("http://mydomain/iem/xml.php", 60000, 60000)`

To make a request against the IEM API:

1. 
a) Build a request object for the request that you want to make.
```java
CheckTokenRequest request =  new CheckTokenRequest(apiUsername, apiToken);
```
or
b) Use the RequestCreationUtil convenience methods to create your request.
```java
CheckTokenRequest request =  RequestCreationUtil.checkTokenRequest(apiUsername, apiToken);
```
2. Make the request using the client:
```java
GenericResponse response = client.checkToken(request);
```
3. The response entity object can then be queried
```java
response.getStatus();
```

To run integration tests successfully copy test/resources/sampleiem.properties to test/resources/iem.properties.
Then provide values for each of the properties:
 
 iem.api.url = The URL of the XML API, usually http://yourdomain/xml.php
 iem.api.username = The API user name
 iem.api.token = The API token 
 iem.api.listid = An existing list ID that can be used for testing (You can find this in your iem database, email_lists table, listid column).
 
