## **HONEST WARNING**
**Content in this KB is for me ONLY.**
It contains definitions that explain things in the way that is easiest for me to understand.
_I am not the author of these definitions so check resources section for the origin of definitions._ 

# SPRING FRAMEWORK
Spring framework is a set of projects that allow you to create a software platform using modular and flexible approach to develop your enterprise application by hiding complexity and allow you focus follow pattern that helps learn, re-learn 

# SPRING BOOT
SPRING BOOT
Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can “just run”.

Spring Boot looks at a) Frameworks available on the CLASSPATH b) Existing configurations for the application. Based on these, Spring Boot provides the basic configuration needed to configure the application with these frameworks. This is called Auto Configuration.







# A

## The actuator 
It is a feature of Spring Boot which allows seeing what's going on inside a running Spring Boot application.


## @ApplicationContext
An interface to provide configuration for an application. This is read-only while the application is running, but may be reloaded if the implementation supports this.

## @Autowired
Marks a constructor, field, setter method or config method as to be autowired by Spring's dependency injection facilities.
Only one constructor (at max) of any given bean class may carry this annotation


# B

## @Bean
A bean is an object that is instantiated, assembled, and otherwise managed by a Spring IoC container

Spring beans are just object instances that are managed by the Spring container. They are created and wired by the framework and put into a "bag of objects" (the container) from where you can get them later.

A Spring Bean definition contains all configuration metadata which is needed for the container to know how to create a bean, its lifecycle details and its dependencies.


The interface org.springframework.context.ApplicationContext the Spring IoC container and is responsible for instantiating, configuring, and assembling beans.

Scope:

There are five scoped provided by the Spring Framework. The default is Singleton.
Singleton - Spring scopes the bean definition to a single instance per Spring IoC container. Singleton in Spring means one instance for given bean  id per IoC container, unlike Java Singletons, where the Singleton hardcodes the scope of an object such that one and only one instance of a particular class will ever be created per ClassLoader.You can think of a Spring container as managing a key-value pair, where the key is the id or name of the bean and the value is the bean itself.
Prototype - a single bean definition has any number of object instances.
(web only) Request - a bean is defined to an HTTP request.
(web only) Session - a bean definition is scoped to an HTTP session.
(web only) Global-session - a bean definition is scoped to a global HTTP session.

Lifecycle: [TODO improve it]
The spring container finds the bean’s definition (annotation, xml and so on)
Spring populates all of the properties as specified in the bean definition (DI).
If the bean implements BeanNameAware interface, spring passes the bean’s id to setBeanName() method.
If Bean implements BeanFactoryAware interface, spring passes the beanfactory to setBeanFactory() method.
If there are any bean BeanPostProcessors associated with the bean, Spring calls postProcesserBeforeInitialization() method.
If the bean implements IntializingBean, its afterPropertySet() method is called. If the bean has init method declaration, the specified initialization method is called.
If there are any BeanPostProcessors associated with the bean, their postProcessAfterInitialization() methods will be called.
If the bean implements DisposableBean, it will call the destroy() method.

BEAN FACTORY

A BeanFactory is an implementation of the factory pattern that applies Inversion of Control to separate the application’s configuration and dependencies from the actual application code. the BeanFactory is a central registry of application components, and centralizes configuration of application  components (no more do individual objects need to read properties files, for example). 


# C

## @ComponentScan
It  Configures component scanning directives for use with classes that that are annotated with @Component, @Controller, @Service, @Repository and so on.

## @Component
register classes as Spring bean which is annotated using @Component annotation.
ComponentScan But, it only scans @Component and does not look for @Controller, @Service and @Repository in general. They are scanned because they themselves are annotated with @Component.

A Spring bean in the service layer should be annotated using @Service instead of @Component annotation and a spring bean in the persistence layer should be annotated with @Repository annotation.

## Spring Container

Way to configure Spring Container.
- XML based configuration file
- Annotation-based configuration
- Java-based configuration


## @Controller

For example, DispatcherServlet will look for @RequestMapping on classes which are annotated using @Controller but not with @Component.
Here is a nice summary of what does @Component, @Service, @Controller, and @Repository annotation do in Spring Framework:
@Component is a generic stereotype for any Spring-managed component or bean. 
@Repository is a stereotype for the persistence layer.
@Service is a stereotype for the service layer.
@Controller is a stereotype for the presentation layer (spring-MVC).


# D

## Spring Data
It is an umbrella that takes care of SQL and NoSQL databases and reduces the effort to use them.

DISPATCHER SERVLET
the DispatcherServlet is an actual Servlet (it inherits from the HttpServlet base class), and as such is declared in your web application.  Central dispatcher for HTTP request handlers/controllers, e.g. for web UI controllers  or HTTP-based remote service exporters. Dispatches to registered handlers for processing a web request, providing convenient mapping and exception handling facilities. The Spring DispatcherServlet uses special beans to process requests and render the appropriate views. These beans are part of Spring MVC.
The main purpose of the dispatch() method is to find an appropriate handler for the request and feed it the request/response parameters. 


# E

## @EnableAutoConfiguration
Spring Boot auto-configuration attempts to automatically configure your Spring application based on the jar dependencies that you have added. For example, If HSQLDB is on your classpath, and you have not manually configured any database connection beans, then we will auto-configure an in-memory database.


# F

## FailureAnalyzer

To create own FailureAnalyzer, you need:
1. Implement Class that implements : FailureAnalyzer
2. Register your class in a META-INF/spring.factories

FailureAnalyzer
To create own FailureAnalyzer, you need:
Implement Class that implements : FailureAnalyzer
Register your class in a META-INF/spring.factories


Example in DomSpringKB:
dms.pastor.spring.failureanalyzer;

## FAT JARs
Executable jars (sometimes called “fat jars”) are archives containing your compiled classes along with all of the jar dependencies that your code needs to run.

## Spring IoC container?
The Spring IoC is responsible for creating the objects,managing them (with dependency injection (DI)), wiring them together, configuring them, as also managing their complete lifecycle.

You can use both Constructor-based and Setter-based Dependency Injection. Spring documentation states, use constructor-based DI for mandatory dependencies and setter-based DI for optional dependencies. Spring recommends  to use constructor-based DI, because it helps with immutability and also ensures that required dependencies are met before constructing that bean.
Use setter DI when :
You want to reconfigure your bean.
You have a Circular Dependencies problem and The Spring IoC container will detect this at runtime and will throw BeanCurrentlyInCreationException. Then use setter DI on some of the beans.


## JAVA BEANS
Java Bean is just a convention that states that class must:
- All properties private (use getters/setters)
- A public no-argument constructor
- Implements Serializable interface
   
It allows libraries to programmatically do things with class instances you define in a predefined way.


## JdbcTemplate
JdbcTemplate class provides many convenience methods for doing things such as converting database data into primitives or objects, executing prepared and callable statements, and providing custom database error handling.

# M

## MVC

Model – a key-value map of data used to render the page 
View – a template of the page that is filled with data from the model
Controller


## @Qualifier
When there are more than one beans of the same type and only one is needed to be wired with a property, the @Qualifier annotation is used along with @Autowired annotation specify which exact bean should  be wired.


# R

## @Repository
This bean post processor adds an advisor to any bean that’s annotated with @Repository so that any platform-specific exceptions are caught and then rethrown as one of Spring’s unchecked data access exception

## @ResponseBody
Annotation that indicates a method return value should be bound to the web response body.

## @RequestMapping
It is a “routing” information. It maps web requests onto specific handler classes and/or handler methods.

## Spring Retry
It provides the ability to automatically re-invoke a failed operation. 


# S

## SERVLET
A servlet is a small Java program that runs within a Web server.
Servlets receive and respond to requests from Web clients, (for example HTTP)

Servlet methods in this interface describe a life-cycle and are called in the following sequence:
init()  to initialize a servlet ()
service()  to service requests and give a response
destroy() to remove a servlet from the server.

# STEREOTYPE
Annotations denoting the roles of types or methods in the overall architecture (at a conceptual, rather than implementation, level). There are few of them Component , Controller , Repository , Service

# T
The benefits of the Spring Framework’s transaction management are  a consistent programming model across different transaction APIs such as JTA, JDBC, Hibernate, JPA, and JDO
and simpler API for programmatic transaction management than a number of complex transaction APIs such as JTA.
-

# W
## Bean wiring
The "wiring" is what dependency injection is all about, what it means is that you can just say "I will need this thing" and the framework will follow some rules to get you the proper instance. Bean wiring is how beans are combined together within the Spring container. When wiring beans, the Spring container needs to know what beans are needed and how the container should use dependency injection to tie them together.

Different modes of auto wiring?
The autowiring functionality has five modes which can be used to instruct Spring container to use autowiring for dependency injection:
no: This is default setting. Explicit bean reference should be used for wiring.
byName: When autowiring byName, the Spring container looks at the properties of the beans on which autowire attribute is set to byName in the XML configuration file. It then tries to match and wire its properties with the beans defined by the same names in the configuration file.
byType: When autowiring by datatype, the Spring container looks at the properties of the beans on which autowire attribute is set to byType in the XML configuration file. If more than one such beans exist, a fatal exception is thrown.
constructor: This mode is similar to byType, but type applies to constructor arguments. If there is not exactly one bean of the constructor argument type in the container, a fatal error is raised.
autodetect: Spring first tries to wire using autowire by constructor, if it does not work, Spring tries to autowire by byType.










# Tips and tricks:
0. Logging properties are independent of the actual logging infrastructure. 
0. Logging is initialized before the ApplicationContext is created, it isn’t possible to control logging from @PropertySources
0. Use _-spring._  suffix (for example: logback-spring.xml ) ,because then spring can completely control log initialization.
0. Classes that can be used to bootstrap and launch a Spring application from a Java main method.
0. It is generally recommended that a single @Configuration class is used to bootstrap your application,
0. Note that it is generally better to rely on Dependency Injection ("push" configuration) to configure application objects through setters or constructors, rather than use any form of "pull" configuration like a BeanFactory lookup.
0. It is generally recommended that a single @Configuration class is used to bootstrap your application,
0. If your application uses component scanning, for example if you use @SpringBootApplication or @ComponentScan, you may find components or configurations created only for specific tests accidentally get picked up everywhere. To help prevent this, Spring Boot provides @TestComponent and @TestConfiguration annotations that can be used on classes in src/test/java to indicate that they should not be picked up by scanning.
0. Triggering a restart. In IntelliJ IDEA, building the project (Build → Make Project) will trigger a restart.
   You need use spring-boot-devtools.


# Sources:
- https://github.com/spring-projects/spring-boot/
- http://static.springsource.org/
- https://dzone.com/
- http://docs.oracle.com/javaee/6/api/javax/servlet/Servlet.html
- http://docs.spring.io/
- https://javarevisited.blogspot.com/
- http://stackoverflow.com/a/3295517/6449720