WordCount
=========


To Run the project
==================

1. Build the TermIndexer
2. Build the SearchInterface
3. Run the SearchInterface


To Build the TermIndexer
========================

1. Go to the project directory
2. Run the command `mvn package install -pl TermIndexer/`


To Build the SearchInterface
============================

1. Go to the project directory
2. Run the command `mvn package -Pfatjar -pl SearchInterface/`


To Run the project
==================

1. Refer the SearchInterface/conf/httpConfig.yaml for the template of the config file.
2. Clone the above mentioned config file
3. Update the path of the folder where the text corpus files are available
4. Update the port to which the HttpServer need to listen
5. Run the command `java -cp SearchInterface/target/SearchInterface-1.0-SNAPSHOT.jar com.freecharge.interview.http.service.WordCountService server "<path-to-the-config-file>"`
6. Server is now up and running :)
7. Type http://localhost:<configured-port>/?q=<word> to find the count


