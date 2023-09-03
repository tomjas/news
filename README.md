# Application for downloading articles from newsapi.org

This is application for demonstrating downloading articles from newsapi.org.
For demonstration purposes only 300 articles are downloaded as per setting
*NUMBER_OF_PAGES = 3* in *HttpService*. It works with hsqldb database in memory -
it means that database table is deleted on stopping the application.
For true persistence on should configure datasource and provide driver for given database.

### Prerequisites
Java 17

In `application.properties` one should set *x.api.key* parameter, otherwise synchronizing document will fail on apiKeyMissing.

### Endpoints

`GET /api/synchronize` - collects documents from newsapi and saves them to database.
Documents are narrowed to keyword `bitcoin` as set in `application.properties` in *newsapi.url*
(narrowing articles search is required by the NewsApi).

`GET /api/messages?LIMIT={number}&OFFSET={number}` - retrieve articles from database.
Parameters are optional.

### Build
mvn clean package

### Run
Application may be deployed to application server (e.g. Tomcat)