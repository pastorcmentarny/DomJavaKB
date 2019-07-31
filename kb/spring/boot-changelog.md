Spring Boot 2.1

0.  Java 11 Support
0.  JUnit 5 improvements. No need for @ExtendWith(SpringExtension.class)
0.  Logging improvements. group logging categories using logging.group.{groupName}={first},{second} (logging.group.web and logging.group.sql are already defined).
0.  Lazy JPA startup: specify spring.data.jpa.repositories.bootstrap-mode=lazy to turn it on.
