* Spring Boot 2.3
.Graceful shutdown is used to continue pending requests for a certain time period after stopping the application.

The following snippet shows how to enable the graceful shutdown and configure the timeout value to 30 seconds:

server.shutdown=graceful

spring.lifecycle.timeout-per-shutdown-phase=30s


* Spring Boot 2.1
* It uses In 1.18, Lombok will no longer generate a private, no-args constructor by default. It can be enabled by setting lombok.noArgsConstructor.extraPrivate=true in a lombok.config configuration file.
* Java 11 supported
* Profile matching has been improved to support an expression format. For instance production & (us-east | eu-central) indicates a match if the production profile is active and either the us-east or eu-central profiles are active.
* Logging Groups
    * define the group
    * logging.group.tomcat=org.apache.catalina, org.apache.coyote, org.apache.tomcat
* Auto-configuration is now provided for Kafa Streams when a org.apache.kafka:kafka-streams dependency is declared. 
* Micrometer
    * Common Micrometer Tags
```properties
management.metrics.tags.region=us-east-1
management.metrics.tags.stack=prod
```      
* Error page shows stacktraces when Devtools is in use.
 Kafka auto-configuation now supports errorHandler transactionManager and afterRollbackProcessor beans.
* ongoDB auto-configuration will now back-off when a com.mongodb.client.MongoClient bean is defined (as well as the more usual com.mongodb.MongoClient).


Resource:
* https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.1-Release-Notes
* https://github.com/spring-projects/spring-framework/wiki/Upgrading-to-Spring-Framework-5.x#upgrading-to-version-51