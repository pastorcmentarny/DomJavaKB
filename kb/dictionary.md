## **HONEST WARNING**
**Content in this KB is for me ONLY.**
It contains definitions that explain things in the way that is easiest for me to understand.
_I am not the author of these definitions so check resources section for the origin of definitions._ 


# H
## HTTP 
stands for Hypertext Transfer Protocol. It's a stateless, application-layer protocol for communicating between distributed systems to allow two systems to communicate via remote calls.

# I
## IaaS
Infrastructure as a Service. Cloud providers only provide the hardware needed to run applications.

# M
## Microservices Architecture?
A microservices architecture is a software development technique that structures an application as a collection of loosely coupled services
The services are fine-grained and the protocols lightweight, thus improving application modularity, making it easier to understand, develop, and test. It parallelizes development by enabling small autonomous teams to develop, deploy, and scale their respective services independently. 

# P
## PaaS
Platform as a Service. The cloud provider provides you a platform - an operating system or managed software (databases, programming languages, web application platforms) - on top of the hardware.

# R
## Reactive Streams 
It is a specification. For Java programmers, Reactive Streams is an API. Reactive Streams gives us a common API for Reactive Programming in Java.

The Reactive Streams API consists of just 4 interfaces.
* **A publisher** is a provider of a potentially unbounded number of sequenced elements, publishing them according to the demand received from its Subscribers.
* **A subscriber** will receive call to Subscriber.onSubscribe(Subscription) once after passing an instance of Subscriber to Publisher.subscribe(Subscriber).
* **A subscription** represents a one-to-one lifecycle of a Subscriber subscribing to a Publisher.
* **A processor** represents a processing stage—which is both a Subscriber and a Publisher and obeys the contracts of both.


**Reactive Systems** are **_Responsive_**, **_Resilient_**, **_Elastic_** and **_Message Driven_**. As result, Reactive Systems are more flexible, loosely-coupled and scalable. This makes them easier to develop and amenable to change. 
* **_Responsive_** The system responds in a timely manner if at all possible. 
* **_Responsiveness_** is the cornerstone of usability and utility, but more than that, responsiveness means that problems may be detected quickly and dealt with effectively. The system stays responsive in the face of failure. 
* **_Resilience_** is achieved by replication, containment, isolation and delegation. The system stays responsive under varying workload.
* **_Elastic_**: The system stays responsive under varying workload.   Reactive Systems can react to changes in the input rate by increasing or decreasing the resources allocated to service these inputs. 
* **_Message Driven_**: Reactive Systems rely on asynchronous message-passing to establish a boundary between components that ensures loose coupling, isolation and location transparency.

Sources: 
* https://www.reactivemanifesto.org/
* https://springframework.guru/reactive-streams-in-java/

## REST
REST stands for Representational state transfer. It is an  architectural style for distributed hypermedia systems (for example HTTP). REST is not a "standard". 

### CRUD operations using HTTP verbs
####HTTP Verb (CRUD verb)


#### POST (Create)

POST is used for creating an entity. When resource is successfully created, an id of the newly created entity is returned as part of the response to this HTTP request.

```POST on /song/1001 will create a new song with employee id 1001```

####GET (Read)
GET retrieves data from the server (nothing else).

GET request on /song/1001, you can retrieve details of that song.


####PUT (Update)
PUT is Similar to POST, but used to update an existing entity and requires the id of existing resource.

PUT request type on /song/1001 can be used to update details of song with id 1001

####DELETE (Delete)
DELETE removes the resource from the server. You need to pass the id of the resource to be deleted.

DELETE method on /song/1001 can be used to remove data for that id.


###OTHERS

####TRACE
TRACE provides a means to test what a machine along the network path receives when a request is made. As such, it simply returns what was sent.

####HEAD
HEAD is same as the GET method for a resource, but returns only the response headers without body.


OPTIONS
[TODO improve it]
OPTIONS allows a client to request information about the request methods supported by a service.
CONNECT
CONNECT primarily used to establish a network connection to a resource (usually via some proxy that can be requested to forward an HTTP request as TCP and maintain the connection). Once established, the response sends a 200 status code and a “Connection Established” message.


 RESTful design FEATURES 
 

Representations
The focus of a RESTful service is on resources and how to provide access to these resources. 
REST does not put a restriction on the format of a representation, so you can chose JSON , XML and so on.


Messages


The client and service talk to each other via messages. Clients send a request to the server, and the server replies with a response.

HTTP REQUEST:


<VERB>
is one of the HTTP methods like GET and so on.
<URI>
It is the URI of the resource on which the operation is going to be performed
<HTTP Version>
the version of HTTP
<Request Header> 
It contains the metadata as a collection of key-value pairs of headers and their values. These settings contain information about the message and its sender like client type, the formats client supports, format type of the message body, cache settings for the response, and a lot more information.
<Request Body>
the actual message content. 


HTTP RESPONSE:

<response code>
This response code is generally the 3-digit code., which contains the status of the request. 
<Response Header> 
It contains the metadata and settings about the response message.
<Response Body> 
It contains the representation if the request was successful.

# S
## SL4J
SLF4J is a façade for various logging frameworks

## Statelessness
A RESTful service is stateless and does not maintain the application state for any client


Links Between Resources
A resource representation can contain links to other resources like an HTML page contains links to other pages. The representations returned by the service should drive the process flow as in case of a website.

Caching is the concept of storing the generated results and using the stored results instead of generating them repeatedly if the same request arrives in the near future. This can be done on the client, the server, or on any other component between them, such as a proxy server. Caching is a great way of enhancing the service performance, 

Caching can be controlled using these HTTP headers:
Header
Application
Date
Date and time when this representation was generated.
Last Modified
Date and time when the server last modified this representation.
Cache-Control
The HTTP 1.1 header used to control caching.
Expires
Expiration date and time for this representation. To support HTTP 1.0 clients.
Age
Duration passed in seconds since this was fetched from the server. Can be inserted by an intermediary component.


UI
REST requires each resource to have at least one URI. 
The actual operation is determined by an HTTP verb. The URI should not say anything about the operation or action.

This URL has following format: Protocol://ServiceName/ResourceType/ResourceID

This is typical convention:
Use plural nouns for naming your resources.
Avoid using spaces as they create confusion. Use an _ (underscore) or – (hyphen) instead.
A URI is case insensitive. I use camel case in my URIs for better clarity. You can use all lower-case URIs.
You can have your own conventions, but stay consistent throughout the service. 


Query Parameters in URI
The preceding URI is constructed with the help of a query parameter:

http://MyService/Persons?id=1


The basic purpose of query parameters is to provide parameters to an operation that needs the data items.

ttp://MyService/Persons/1?format=xml&encoding=UTF8

TIPS and Tricks:
The query parameter approach works just fine and REST does not stop you from using query parameters. However, this approach has a few disadvantages.
Increased complexity and reduced readability, which will increase if you have more parameters
Search-engine crawlers and indexers like Google ignore URIs with query parameters. 
Documenting a RESTful Service RESTful services do not necessarily require a document to help clients discover them. Due to URIs, links, and a uniform interface, it is extremely simple to discover RESTful services at runtime. The method OPTION can be used effectively in the process of discovering a service. This does not mean that RESTful services require no documentation at all. There is no excuse for not documenting your service. You should document every resource and URI for client developers. 


Source:
http://www.drdobbs.com/web-development/restful-web-services-a-tutorial/240169069
http://javarevisited.blogspot.com/2016/04/what-is-purpose-of-http-request-types-in-RESTful-web-service.html

# S
## SaaS
Software as a Service. The cloud provider offers a software product on the cloud - like Google Docs.

# T
## (Database) Transaction 
A "_unit of work_" that need be performed **together** or **not at all**. 


2019.1 - Quick cleanup
2018.1 - First Version
