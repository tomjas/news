# Application for downloading articles from newsapi.org

This is application for demonstrating downloading articles from newsapi.org.
For demonstration purposes only 300 articles are downloaded as per setting
*NUMBER_OF_PAGES = 3* in *HttpService*. It works with hsqldb database in memory -
it means that database table is dropped on stopping the application.


### Prerequisites
Java 17

In `application.properties` one should set *x.api.key* parameter, otherwise synchronizing
document will fail on apiKeyMissing.

For server database one should configure datasource in `application.properties`
and provide driver for given database. Also flyway should be turned on by setting
*spring.flyway.enabled=true*. Example sql script for oracle db executed by flyway
is in *db/migration/oracle* folder.

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