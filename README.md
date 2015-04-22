# InterspireEmailMarketerClient
Java client for Interspire Email Marketer API

Currently a work in progress.

To run integration tests successfully copy test/resources/sampleiem.properties to test/resources/iem.properties.
Then provide values for each of the properties:
 
 iem.api.url = The URL of the XML API, usually http://yourdomain/xml.php
 iem.api.username = The API user name
 iem.api.token = The API token 
 iem.api.listid = An existing list ID that can be used for testing (You can find this in your iem database, email_lists table, listid column).
 
