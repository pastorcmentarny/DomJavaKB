# **HONEST WARNING**
**Content in this KB is for me ONLY.**
It contains definitions that explain things in the way that is easiest for me to understand.
_I am not the author of these definitions so check resources section for the origin of definitions._ 

##Types of Design Patterns
###Creational Design Patterns

 * Factory
 * Builder
 * Prototype
 * Singleton

Structural Design Patterns

 * Adapter
 * Bridge
 * Composite
 * Decorator
 * Facade
 * Flyweight
 * Proxy

Behavioural Design Patterns

 * Chain of responsibility
 * Command
 * Interpreter
 * Iterator
 * Mediator
 * Memento
 * Observer
 * State
 * Strategy
 * Template Method
 * Visitor


# Principles
The principles, when applied together, intend to make it more likely that a programmer will create a system that is easy to maintain and extend over time.

## SOLID principles
It stands for:
* S – Single-responsibility principle
* O – Open-closed principle
* L – Liskov substitution principle
* I – Interface segregation principle
* D – Dependency Inversion Principle

SOLID are "not principles to adopt" but "frameworks to use"****

### SPR Single responsibility Principle
`A class should have one and only one reason to change, meaning that a class should have only one job.`
SINGLE RESPONSIBILITY PRINCIPLE (SRP) 
“a class should have only a single responsibility “
	
	Class should always handle single functionality. If you put more than one functionality then you introduce coupling between two functionality and even if you change one functionality there is chance you broke coupled functionality,  which require another round of testing to avoid any surprise on production environment.
This principle also helps you organize the code (like tools in box ) , makes code change, testing and debugging easier. In the context of the Single Responsibility Principle (SRP) we define a responsibility to be “a reason for change.” 
For example if you object get data from database, perform some transformation and calculate things then this class breaks SPR. Solution will be to split them into 3 independent classes.

### OPEN CLOSED DESIGN PRINCIPLE 
`software entities … should be open for extension, but closed for modification.`
Classes and methods should be Open for extension (new functionality) and Closed for modification. You should prevents someone from changing already tried and tested code. Ideally if you are adding new functionality only then your code should be tested and that's the goal of Open Closed Design principle.

### LISKOV SUBSTITUTION PRINCIPLE (LSP)
`objects in a program should be replaceable with instances of their subtypes without altering the correctness of that program.` 
It means methods that use super class type must be able to work with the object of subclass without any issue. If a class has more functionality than subclass might not support some of the functionality and does violate LSP. It is related to Single Responsibility Principle and Interface Segregation Principle.

### INTERFACE SEGREGATION PRINCIPLE (ISP) 
`many client-specific interfaces are better than one general-purpose interface.`

### DEPENDENCY INJECTION

A powerful mechanism for separating construction from use is Dependency Injection (DI), the application of Inversion of Control (IoC) to dependency management.3 Inversion of Control moves secondary responsibilities from an object to other objects that are dedicated to the purpose, thereby supporting the Single Responsibility Principle. In the context of dependency management, an object should not take responsibility for instantiating dependencies itself. Instead, it should pass this responsibility to another “authoritative” mechanism, thereby inverting the control. Because setup is a global concern, this authoritative mechanism will usually be either the “main” routine or a special-purpose container.
LAZY-INITIALIZATION  is still sometimes useful with DI. Most DI containers won’t construct an object until needed.

Dependency Inversion Principle
[TODO improve it]

Dependency Inversion Principle (DIP) states that

– High level modules should not depend upon low level modules. Both should depend upon abstractions.
– Abstractions should not depend upon details. Details should depend upon abstractions.

Dependency Injection
“one should “Depend upon Abstractions. Do not depend upon concretions.” 
	Dependency injection means giving an object its instance variables. Dependency injection is just passing in an instance variable. We could pass the variable into the constructor. That would "inject" the "dependency" into the class. Now when we use the variable (dependency), we use the object that we were given rather than the one we created. 

Example: `java/dms/pastor/examples/principles/DependencyInjectionViaConstructor.java`


Used in Framework, where Dependency injection relieves the class of the responsibility of locating or creating their dependencies. 

Advantages of Dependency Injection
DI allows a client the flexibility of being configurable. Only client's behavior is fixed.
Testing can be performed using mock objects.
Loosely couple architecture.

### KISS principle
	KISS is an acronym for "Keep it simple, stupid" as a design principle. It states that most systems work best if they are kept simple rather than made complicated.
Simplicity should be a key goal in design.

### YAGNI principle
	YAGNI stands for "You aren't gonna need it" and it states a programmer should not add functionality until it is your task to do so.
Why? It affect maintenance in terms of time and complexity without adding value to the product (in business sense).
 
### DRY (Don't repeat yourself)
Duplication is a source of troubles. All known to me the expert in programming states that this one of the most important rule. It means don't write duplicate code, instead use Abstraction to abstract common things in one place. 
Examples:
If you have a block of code in more than two places consider making it a separate method.
If you use a hard-coded value more than one time make them public final constant.

Why?	It helps maintenance.
Remember:	Don't use common code for two different functionalities as you will couple them and cause problem in future when one of the functionality changed.

### INVERSION OF CONTROL
It means now we have inverted the control of creating the object. You get control of creating an object to container/ framework instead of using own using the new operator.

###ASPECT-ORIENTED PROGRAMMING
TODO improve it 
	
It relieves business components of generic cross-cutting concerns by modularizing them into reusable aspects.

ENCAPSULATE WHAT CHANGES
 [Example code needed]
	Change is a one thing is constant in software development. Encapsulate the code you expect or suspect to be changed in future.
Why?	It's easy to test and maintain proper encapsulated code. If you are coding in Java then follow principle of making variable and methods private by default and increasing access step by step e.g. from private to protected and not public. 

### Favour Composition over Inheritance
 TODO improve it
	Always favour composition over inheritance, if possible. In many cases Composition is lot more flexible than Inheritance. Composition allows to change behaviour of a class at runtime by setting property during runtime and by using Interfaces to compose a class we use polymorphism which provides flexibility of to replace with better implementation any time.

	Interface Segregation Principle states that a client should not implement an interface if it doesn't use that. This happens mostly when one interface contains more than one functionality, and the client only needs one functionality and not other. Interface design is tricky because once you release your interface you can not change it without causing some chaos to implementation. Default method helps keep interface backward compatible but it should be used as the last solution. The interface has the disadvantage to implementing all method before any class can use it so having single functionality means less method to implement.

### PROGRAMMING FOR INTERFACE NOT IMPLEMENTATION
[Example code needed]
	Always program for an interface and not for implementation this will lead to flexible code which can work with any new implementation of the interface. So use interface type on variables, return types of method or argument type of methods in Java.

### DELEGATION PRINCIPLE 
TODO improve it , [Example code needed]
	Don't do all stuff by yourself,  delegate it to respective class. Classical example of delegation design principle is equals() and hashCode() method in Java. In order to compare two objects for equality we ask class itself to do comparison instead of Client class doing that check. The benefit of this design principle is no duplication of code and pretty easy to modify behavior.

##THE PRINCIPLE OF LEAST KNOWLEDGE (POLA, LAW OF DEMETER) 
TODO improve it , [Example code needed]
“Talk only to your immediate friends.”

	It means is a client should only have knowledge of an object's members and not have access to properties and methods of other objects via the members. In simple terms, you should only have access to the members of the object, and nothing beyond that. Think if it like this: if you use more than 1 dot you are violating the principle.



# DESIGN PATTERNS

## What is a Design Patterns?
Design patterns are best practices how to solve common known problems. This is not a framework or ready to re-use solution. It gives good practices and solutions recipe how to helps solve common known problems and it provides a common vocabulary for developers to talk about certain problems.  Patterns give you hint to solve a problem effectively.

## What are type of patters? (TODO improve it)
* Behavioural Patterns:
  * Used to manage algorithms, relationships, and responsibilities between objects.
* Creation Patterns:
  * Used to construct objects such that they can be decoupled from their implementing system.
* Structural Patterns:
  * Used to form large object structures between many disparate objects.

## **ADAPTER** {STRUCTURAL} TODO improve it
 
The Adapter Design Pattern Allows 2 incompatible interfaces to work together by creating a common object by which they may communicate and interact. Any class can work together as long as the Adapter solves the issue that all classes must implement every method defined by the shared interface.
Target
Adapter
Adaptee
Use When
⦁	A class to be used doesn't meet interface requirements.
⦁	Complex conditions tie object behaviour to its state.
⦁	Transitions between states need to be explicit.
Example
A billing application needs to interface with an HR application in order to exchange employee data, however each has its own interface and implementation for the Employee object. In addition, the SSN is stored in different formats by each system. By creating an adapter we can create a common interface between the two applications that allows them to communicate using their native objects and is able to transform the SSN format in the process.


## **BUILDER** {CREATIONAL}

Allows for the dynamic creation of objects based upon easily interchangeable algorithms. (Pattern used to create object made from a bunch of other objects)
Use When
Object creation algorithms should be decoupled from the system.
Multiple representations of creation algorithms are required.
The addition of new creation functionality without changing the core code is necessary.
Runtime control over the creation process is required.
Example
A file transfer application could possibly use many different protocols to send files and the actual transfer object that will be created will be directly dependent on the chosen protocol. Using a builder we can determine the right builder to use to instantiate the right object. If the setting is FTP then the FTP builder would be used when creating the object.


## **BRIDGE** {STRUCTURAL} TODO improve it
 TODO improve it , [Example code needed]

???? - The Bridge Design Pattern – progressively adding functionality while separating out major differences  using abstract classes.

Defines an abstract object structure independently of the implementation object structure in order to limit coupling. 
Use When
⦁	Abstractions and implementations should not be bound at compile time.
⦁	Abstractions and implementations should be independently extensible.
⦁	Changes in the implementation of an abstraction should have no impact on clients.
⦁	Implementation details should be hidden from the client.
Example
The Java Virtual Machine (JVM) has its own native set of functions that abstract the use of windowing, system logging, and byte code execution but the actual implementation of these functions is delegated to the operating system the JVM is running on. When an application instructs the JVM to render a window it delegates the rendering call to the concrete implementation of the JVM that knows how to communicate with the operating system in order to render the window.

## **CHAIN OF RESPONSIBILITY** {BEHAVIORAL}  TODO improve it
TODO improve it , [Example code needed]

The Chain of Responsibility is a Design pattern send data to an object and if that object can't use it, it sends it to any number of other objects that may be able to use it. Gives more than one object an opportunity to handle a request by linking receiving objects together.
Use When
Multiple objects may handle a request and the handler doesn't have to be a specific object.
A set of objects should be able to handle a request with the handler determined at runtime.
A request not being handled is an acceptable potential outcome.
Example
Exception handling in some languages implements this pattern. When an exception is thrown in a method the runtime checks to see if the method has a mechanism to handle the exception or if it should be passed up the call stack. When passed up the call stack the process repeats until code to handle the exception is encountered or until there are no more parent objects to hand the request to.

## **COMMAND** {BEHAVIORAL} TODO improve it
TODO improve it , [Example code needed]
 Encapsulates a request allowing it to be treated as an object. This allows the request to be handled in traditionally object based relationships such as queuing and callbacks.

The command pattern uses object to represent and encapsulate all the information needed to call a method at later time. This information includes the method name, the object that owns the method and values for the method parameters.
Use When
⦁	You need callback functionality.
⦁	Requests need to be handled at variant times or in variant orders.
⦁	A history of requests is needed.
⦁	The invoker should be decoupled from the object handling the invocation.

Bad: 
you will create a lot of small classes

Example
Job queues are widely used to facilitate the asynchronous processing of algorithms. By utilizing the command pattern the functionality to be executed can be given to a job queue for processing without any need for the queue to have knowledge of the actual implementation it is invoking. The command object that is enqueued implements its particular algorithm within the confines of the interface the queue is expecting.


## **COMPOSITE** {STRUCTURAL} TODO improve it
 TODO improve it , [Example code needed]

The Composite Design Pattern?
Allows you to treat individual objects and compositions of objects uniformly. 

It helps structure data or represent the inner working of every part of a whole object individually.
Facilitates the creation of object hierarchies where each object can be treated independently or as a set of nested objects through the same interface.
Use When
⦁	Hierarchical representations of objects are needed.
⦁	Objects and compositions of objects should be treated uniformly.
Example
Sometimes the information displayed in a shopping cart is the product of a single item while other times it is an aggregation of multiple items. By implementing items as composites we can treat the aggregates and the items in the same way, allowing us to simply iterate over the tree and invoke functionality on each item. By calling the getCost() method on any given node we would get the cost of that item plus the cost of all child items, allowing items to be uniformly treated whether they were single items or groups of items.

## The Aggregator pattern TODO stub 
The Aggregator pattern helps to address this. It talks about how we can aggregate the data from different services and then send the final response to the consumer. This can be done in two ways:
* 1. A composite microservice will make calls to all the required microservices, consolidate the data, and transform the data before sending back.
* 2. An API Gateway can also partition the request to multiple microservices and aggregate the data before sending it to the consumer.
It is recommended if any business logic is to be applied, then choose a composite microservice. Otherwise, the API Gateway is the established solution.


## **DECORATOR** {STRUCTURAL} TODO improve it
TODO improve it , [Example code needed]

The Decorator Patterns allows you to modify an object dynamically at Runtime. It more flexible than inheritance. It's useful when you want the capabilities of inheritance with subclasses ,but you need add functionality at run time. It simplify extension as rather than rewrite old code you can extend with new code.
Allows for the dynamic wrapping of objects in order to modify their existing responsibilities and behaviours.
Use When
⦁	Object responsibilities and behaviours should be dynamically modifiable.
⦁	Concrete implementations should be decoupled from responsibilities and behaviours.
⦁	Subclassing to achieve modification is impractical or impossible.
⦁	Specific functionality should not reside high in the object hierarchy.
⦁	A lot of little objects surrounding a concrete implementation is acceptable.
Example
Many businesses set up their mail systems to take advantage of decorators. When messages are sent from someone in the company to an external address the mail server decorates the original message with copyright and confidentiality information. As long as the message remains internal the information is not attached. This decoration allows the message itself to remain unchanged until a runtime decision is made to wrap the message with additional information.

The BufferedReader class is a Decorator which provides buffering functionality to FileReader or any other Reader.

The decorator pattern is used to add more functionality to an existing object without affecting other instances of the class. This means that it used composition instead of inheritance to extend functionality of an object at runtime. You can use it in different occasions:
When you want to transparently and dynamically add responsibilities to objects without affecting other objects.
When you want to add responsibilities to an object that you may want to change in future.
Extending functionality by sub-classing is no longer practical.


## **FACADE** {STRUCTURAL} TODO improve it
 TODO improve it , [Example code needed]

When you create a simplified interface that performs many other actions behind the scenes.

Supplies a single interface to a set of interfaces within a system.
Use When
⦁	A simple interface is needed to provide access to a complex system.
⦁	There are many dependencies between system implementations and clients.
⦁	Systems and subsystems should be layered.
Example
By exposing a set of functionalities through a web service the client code needs to only worry about the simple interface being exposed to them and not the complex relationships that may or may not exist behind the web service layer. A single web service call to update a system with new data may actually involve communication with a number of databases and systems, however this detail is hidden due to the implementation of the façade pattern.


## **FACTORY METHOD** {CREATIONAL}
TODO improve it , [Example code needed]
	Defines an interface for creating objects let subclasses to control the actual creation process. Refers to the newly created object through a common interface. Factory method pattern, compared to Factory pattern replace the factory with an abstract class and a set of concrete factories subclasses. The subclasses are responsible for creating concrete product objects 
Use When
A class will not know what classes it will be required to create.
Subclasses may specify what objects should be created.
Parent classes wish to defer creation to their subclasses.
Example
They are used in factories providing an xml parser. 
Many applications have some form of user and group structure for security. When the application needs to create a user it will typically delegate the creation of the user to multiple user implementations. The parent user object will handle most operations for each user but the subclasses will define the factory method that handles the distinctions in the creation of each type of user. A system may have AdminUser and StandardUser objects each of which extend the User object. The AdminUser object may perform some extra tasks to ensure access while the StandardUser may do the same to limit access.

Factory Method Pattern.Factory, as it's name suggests, is a pattern used to facilitate the creation of other objects. a creational pattern "Define an interface for creating an object, but let the subclasses decide which class to instantiate."Example:logging frameworks, 


##  **FACTORY** {CREATIONAL} 
TODO improve it , [Example code needed]
The factory pattern allows you to create objects without specifying the exact class of object that will be created at runtime.
When a method returns one of several possible classes that share a common super class
⦁	Create a new enemy in a game
⦁	Random number generator picks a number assigned to a specific enemy
⦁	The factory returns the enemy associated with that number
The class is chosen at run time.

When to use a Factory Pattern?
You don't know ahead of time what class object you need.
When all of the potential classes are in the same subsclass hierarchy
To centralize class selection code.
When you don't want the user to have to know every subclasses.
To encapsulate object creation.

Examples:
BeanFactory in Spring Framework  is an implementation of the factory pattern.
ABSTRACT FACTORY {CREATIONAL} TODO improve it

 
The Factory Pattern allows you to create objects without specifying the extract class of the object that will be created. 
Offers the interface for creating a family of related objects, without explicitly specifying their classes 
Everything in abstract factory is encapsulated.
The method that orders the object
The factories that build the object.
The final objects
The final objects contain objects that use the Strategy Patterns

Only the product interfaces are revealed, the implementations remains hidden to the clients.
 A system should be independent of how its products are created, composed and represented.
Systems should be capable of using multiple families of objects.
Families of objects must be used together.
Libraries must be published without exposing implementation details.
Concrete classes should be decoupled from clients.
Bad: it can get complicated

Example
⦁	Email editors will allow for editing in multiple formats including plain text, rich text, and HTML Depending on the format being used, different objects will need to be created.  By utilizing an abstract factory for creation we can then ensure that the appropriate object sets are created based upon the style of email that is being sent.
⦁	java.sql.Connection - an abstract factory which create Statements, PreparedStatements, CallableStatements,... for each database flavor.


## **FLY WEIGHT** {STRUCTURAL}  TODO improve it MUTED as unluckily needed
TODO improve it , [Example code needed]
It is used when you need to create a very large number of similar objects (100k or more) and use this pattern to reduce memory usage you share objects .
Facilitates the reuse of many fine grained objects, making the utilization of large numbers of objects more efficient.
Use When
⦁	Many like objects are used and storage cost is high.
⦁	The majority of each object's state can be made extrinsic.
⦁	A few shared objects can replace many unshared ones.
⦁	The identity of each object does not matter.
Example
Systems that allow users to define their own application flows and layouts often have a need to keep track of large numbers of fields, pages, and other items that are almost identical to each other. By making these items into flyweights all instances of each object can share the intrinsic state while keeping the extrinsic state separate. The intrinsic state would store the shared properties, such as how a textbox looks, how much data it can hold, and what events it exposes. The extrinsic state would store the unshared properties, such as where the item belongs, how to react to a user click, and how to handle events.


## **INTERPRETER** {BEHAVIORAL} TODO improve it. MUTED as unluckily needed
 TODO improve it , [Example code needed]
The interpreter pattern is normally ignored and hardly ever used.It is used to convert one representation of data into another.


## **ITERATOR** {BEHAVIORAL}  TODO improve it MUTED as unluckily needed
 TODO improve it , [Example code needed]


The Iterator pattern provides you with a uniform way to aces different collections of Objects. This provides a uniform way to cycle through different collections.
Allows for access to the elements of an aggregate object without allowing access to its underlying representation.
Use When
⦁	Access to elements is needed without access to the entire representation.
⦁	Multiple or concurrent traversals of the elements are needed.
⦁	A uniform interface for traversal is needed.
⦁	Subtle differences exist between the implementation details of various iterators.
Example
The Java implementation of the iterator pattern allows users to traverse various types of data sets without worrying about the underlying implementation of the collection. Since clients simply interact with the iterator interface, collections are left to define the appropriate iterator for themselves. Some will allow full access to the underlying data set while others may restrict certain functionalities, such as removing items.

## **MEDIATOR** {BEHAVIORAL}  TODO improve it MUTED as unluckily needed
TODO improve it , [Example code needed]
 It's used to handle communication between related objects (colleagues)
GOF :“Allows loose coupling by encapsulating the way disparate sets of objects interact and communicate with each other. Allows for the actions of each object set to vary independently of one another.”
Use When
⦁	Communication between sets of objects is well defined and complex.
⦁	Too many relationships exist and common point of control or communication is needed.
Example
Mailing list software keeps track of who is signed up to the mailing list and provides a single point of access through which any one person can communicate with the entire list. Without a mediator implementation a person wanting to send a message to the group would have to constantly keep track of who was signed up and who was not. By implementing the mediator pattern the system is able to receive messages from any point then determine which recipients to forward the message on to, without the sender of the message having to be concerned with the actual recipient list.


## **MEMENTO** {STRUCTURAL} TODO improve it
 TODO improve it , [Example code needed]
The memento design pattern is a way to store a previous states of an object easily. Allows for capturing and externalizing an object's internal state so that it can be restored later, all without violating encapsulation.
Use When
⦁	The internal state of an object must be saved and restored at a later time.
⦁	Internal state cannot be exposed by interfaces without exposing implementation.
⦁	Encapsulation boundaries must be preserved.
Example
Undo functionality can nicely be implemented using the memento pattern. By serializing and deserializing the state of an object before the change occurs we can preserve a snapshot of it that can later be restored should the user choose to undo the operation.

## **NULL OBJECT**{BEHAVIORAL}
Provide an object as a surrogate for the lack of an object of a given type. The Null Object Pattern provides intelligent do nothing behavior, hiding the details from its collaborators. 

Instead of putting if check for a null value, Null Object reflects a do nothing relationship. Such Null object can also be used to provide default behaviour in case data is not available.
The intent of a Null Object is to encapsulate the absence of an object by providing a substitutable alternative that offers suitable default do nothing behavior.
The key to the Null Object pattern is an abstract class that defines the interface for all objects of this type.

//TODO [Example code needed]

## **OBSERVER** {BEHAVIORAL}  TODO improve it
TODO improve it , [Example code needed]
 
The Observer pattern is a software design pattern in which an object (Subject), maintain list of its dependants , called observers, and notifies them automatically of any state  changes, usually by calling one of their methods.
Use When
⦁	State changes in object and we need trigger behaviour in other objects
⦁	Broadcasting capabilities are required.
⦁	An understanding exists that objects will be blind to the expense of notification.
Example
This pattern can be found in almost every GUI environment. When buttons, text, and other fields are placed in applications the application typically registers as a listener for those controls. When a user triggers an event, such as clicking a button, the control iterates through its registered observers and sends a notification to each.

+ Loose coupling
- send updates that doesn't matter

## **PROXY** {STRUCTURAL} TODO improve it
 TODO improve it , [Example code needed]
The Proxy Design Patterns Provide a class which will limit access to another class (due security reasons or expensive to create or accessed from remote location).
Allows for object level access control by acting as a pass through entity or a placeholder object.
Use When
⦁	The object being represented is external to the system.
⦁	Objects need to be created on demand.
⦁	Access control for the original object is required.
⦁	Added functionality is required when an object is accessed.
Example
Ledger applications often provide a way for users to reconcile their bank statements with their ledger data on demand, automating much of the process. The actual operation of communicating with a third party is a relatively expensive operation that should be limited. By using a proxy to represent the communications object we can limit the number of times or the intervals the communication is invoked. In addition, we can wrap the complex instantiation of the communication object inside the proxy class, decoupling calling code from the implementation details.

PROTOYPE {CREATIONAL}MUTED as unluckily needed
Create objects based upon a template of an existing objects through cloning. 
Create new object instances by cloning/copying other objects. Reduce need for creating subclasses
OBJECT POOL TODO improve it


## **RETRY PATTERN**
the replay pattern as remedy for.network or app hiccups for short time

## **SINGLETON** _{CREATIONAL}_

There is only one instance of a class is allowed within a system.An instance is available through all the code.

I used Singleton for Statistics and Configuration Classes in my personal projects.
At work, I use Singleton indirectly through Spring Framework and Loggers that used singleton pattern.

I am aware of 3 ways to create Singleton
Classic implementation
lazy implementation
Implementation via Enum
Examples can found in package dms.pastor.kb.patterns.singleton

Many people believes that there is no bullet prof singleton implementation in Java as they can brake it via reflection.
I disagree with this arguments as it does NOT have value in real world application (as it will indicate more serious security problem)
It is pointless argument as conclusion will be "Don't use Java because code is breakable via reflection API" which is pointless.

Examples:
* Logger Classes
* Configuration Classes
* Accessing resources in shared mode

Sources:


Avoid Interfaces that Just Force Action .Using interface just to force the creation of a method is a bad idea.

Composition Behaviour can change without side effects,because tHe Behaviour isn't tied to the Superclass or Subclasses;


## **STRANGLER PATTERN** TODO rewrite it

###Problem.
So far, the design patterns we talked about were decomposing applications for greenfield, but 80% of the work we do is with brownfield applications, which are big, monolithic applications. Applying all the above design patterns to them will be difficult because breaking them into smaller pieces at the same time it's being used live is a big task.

### Solution
The Strangler pattern comes to the rescue. The Strangler pattern is based on an analogy to a vine that strangles a tree that it’s wrapped around. This solution works well with web applications, where a call goes back and forth, and for each URI call, a service can be broken into different domains and hosted as separate services. The idea is to do it one domain at a time. This creates two separate applications that live side by side in the same URI space. Eventually, the newly refactored application “strangles” or replaces the original application until finally you can shut off the monolithic application.Strangler Pattern.


### Explanation of name of the pattern by Martin Flower
They seed in the upper branches of a fig tree and gradually work their way down the tree until they root in the soil. Over many years they grow into fantastic and beautiful shapes, meanwhile strangling and killing the tree that was their host. An alternative route is to gradually create a new system around the edges of the old, letting it grow slowly over several years until the old system is strangled. The most important reason to consider a strangler application over a cut-over rewrite is reduced risk. A strangler can give value steadily and the frequent releases allow you to monitor its progress more carefully. Many people still don't consider a strangler since they think it will cost more - I'm not convinced about that. Since you can use shorter release cycles with a stranger you can avoid a lot of the unnecessary features that cut over rewrites often generate. https://martinfowler.com/bliki/StranglerApplication.html

STATE TODO improve it
TODO improve it , [Example code needed] 

The State Design Pattern allows an object to alter its behaviour when its internal state changes. The object will appear to change its class
Ties object circumstances to its behaviour, allowing the object to behave in different ways based upon its internal state.
Use When
⦁	The behaviour of an object should be influenced by its state.
⦁	Complex conditions tie object behaviour to its state.
⦁	Transitions between states need to be explicit.
Example
An email object can have various states, all of which will change how the object handles different functions. If the state is "not sent" then the call to send() is going to send the message while a call to recallMessage() will either throw an error or do nothing. However, if the state is "sent" then the call to send() would either throw an error or do nothing while the call to recallMessage() would attempt to send a recall notification to recipients. To avoid conditional statements in most or all methods there would be multiple state objects that handle the implementation with respect to their particular state. The calls within the Email object would then be delegated down to the appropriate state object for handling.


## **STRATEGY** {BEHAVIORAL}
Define a family of algorithms, encapsulate each one and make them interchangeable. The Strategy pattern lets the algorithm vary independently of clients that use it.
### Use When:
⦁	The only difference between many related classes is their behaviour.
⦁	Multiple versions or variations of an algorithm are required.
⦁	Algorithms access or utilize data that calling code shouldn't be exposed to.
⦁	The behaviour of a class should be defined at runtime.
⦁	Conditional statements are complex and hard to maintain.
### Example
    ```Collections.sort()```  Collections.sort() method that takes Comparator parameter. Based on the different implementations of Comparator interfaces, the Objects are getting sorted in different ways.
	When importing data into a new system different validation algorithms may be run based on the data set. By configuring the import to utilize strategies the conditional logic to determine what validation set to run can be removed and the import can be decoupled from the actual validation code. This will allow us to dynamically call one or more strategies during the import.


## **TEMPLATE METHOD** {BEHAVIORAL}  TODO improve it
TODO improve it , [Example code needed]
 
The Template Method Design pattern is used to create a group of subclasses that have to execute a similar group of methods.
Identifies the framework of an algorithm, allowing implementing classes to define the actual behaviour.
Use When
⦁	A single abstract implementation of an algorithm is needed.
⦁	Common behaviour among subclasses should be localized to a common class.
⦁	Parent classes should be able to uniformly invoke behaviour in their subclasses.
⦁	Most or all subclasses need to implement the behaviour.
Example
A parent class, InstantMessage, will likely have all the methods required to handle sending a message. However, the actual serialization of the data to send may vary depending on the implementation. A video message and a plain text message will require different algorithms in order to serialize the data correctly. Subclasses of InstantMessage can provide their own implementation of the serialization method, allowing the parent class to work with them without understanding their implementation details.


## **VISITOR** {BEHAVIORAL} //TODO improve it
TODO improve it , [Example code needed]
 
Allows for one or more operations to be applied to a set of objects at runtime, decoupling the operations from the object structure.
Use When
⦁	An object structure must have many unrelated operations performed upon it.
⦁	The object structure can't change but operations performed on it can.
⦁	Operations must be performed on the concrete classes of an object structure.
⦁	Exposing internal state or operations of the object structure is acceptable.
⦁	Operations should be able to operate on multiple object structures that implement the same interface sets.
Example
Calculating taxes in different regions on sets of invoices would require many different variations of calculation logic. Implementing a visitor allows the logic to be decoupled from the invoices and line items. This allows the hierarchy of items to be visited by calculation code that can then apply the proper rates for the region. Changing regions is as simple as substituting a different visitor.


# ANTIPATTERNS

An anti-pattern is a common response to a recurring problem that is usually ineffective and risks being highly counterproductive.

## PREMATURE OPTIMIZATION 
Premature optimization refers to thinking about possible issues that could arise in the future but that are not the case at this moment. You should only think about what is asked and what is required, not about what eventually could be useful for future purposes. A frequent occurring premature optimization is the premature performance optimization. If there are no performance issues at this moment, do not try to handle them, handle them when they happen. 

## REINVENTING THE WHEEL
An antipattern of frequent occurrence is the lack of knowing the existence of some useful frameworks/libraries. Apache commons lang and commons collections are dependencies that should be present in every Java project.  A general rule is not trying to reinvent the wheel. 

## CODING BY EXCEPTION/EXCEPTION HANDLING
Instead of checking for some specific corner case values like null values, some people like to catch a NullPointerException and do some logic in the catch block. This way of coding is called exception handling because the exception is expected to happen. Exceptions are invented to inform you of the fact that something really bad happened but they’re not meant to be thrown often. That’s why they are called ‘exceptions’. If they occur, please handle them carefully but never abuse them to execute some logic that could have been implemented with a simple if-else check.

## INHERITANCE HELL
Inheritance should be handled with care. It’s very useful but you should only use it what it’s intended for. If the inheritance tree becomes to bloated, something is wrong. Do not write abstract classes for 1 specific case. Use composition instead. The strategy pattern can come in handy here.
For example if your JSF managed bean ‘EditUserManagedBean’ extends AbstractEditingManagedBean which extends AbstractSelectionManagedBean which extends AsbtractParentDetailManagedBean which extends AbstractUnitBean you should know that something is wrong and that there should be other ways to implement this behaviour ;-)

## CODING BY EXCEPTION/EXCEPTION HANDLING
Instead of checking for some specific corner case values like null values, some people like to catch a NullPointerException and do some logic in the catch block. This way of coding is called exception handling because the exception is expected to happen. Exceptions are invented to inform you of the fact that something really bad happened but they’re not meant to be thrown often. That’s why they are called ‘exceptions’. If they occur, please handle them carefully but never abuse them to execute some logic that could have been implemented with a simple if-else check.

## AVOIDING/SWALLOWING EXCEPTIONS
Referring to the previous antipattern, when an exception is thrown that means that something unexpected happened. The last thing you should do is swallow these exceptions instead of processing its useful information.


## **PATTERN** _{BEHAVIORAL}_
### Problem```Statenent```
### Solution/Explanation
### Advantages/Disadvantages
### ```Path to example code```


# USEFUL SOURCES
* https://www.owasp.org/index.php/How_to_add_a_security_log_level_in_log4j
* http://www.ericfeminella.com/blog/2008/02/02/principle-of-least-knowledge/
* http://javarevisited.blogspot.co.uk/2012/03/10-object-oriented-design-principles.html
* http://refcardz.dzone.com/refcardz/design-patterns
* http://www.oodesign.com
* http://natpryce.com/articles/000714.html
* https://dzone.com/articles/enforcing-java-singletons-is-very-hard
* http://javarevisited.blogspot.com/2016/07/10-examples-to-read-text-file-in-java.html
* https://www.journaldev.com/1754/strategy-design-pattern-in-java-example-tutorial

# CHANGELOG
2021-03-02 - v 4.1 - minor clean up
2020-11-11 - v 4.0 - clean up
2017-06-17 - v 3.0 add few things I learned recently
2017-06    - v 2.4 -> v2.6 read proof and fix problems
2017-03-28 - v2.1 add remaining items for agile
2017-03-19 - v2.0  March update
2017-02-22 - Add few things about null
2017-01-08 - v1.2 Add UX
2017-01-03 - v1.1 Correct mistakes
2017-01-01 - INIT VERSION
