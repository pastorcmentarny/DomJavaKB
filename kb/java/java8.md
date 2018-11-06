 ## DATE and TIME
 
 What's wrong with old Date?
 * Date is mutable.
 * It has many deprecated methods as they are misleading (as they suggest to represent date, which is not truth as Java's Date represents point in time without any specific calendar (day,month or year))
 * java.sql.Date extends java.util.Date .However it violating Liskov substitution principle.
 java.util.Date.toInstant() works as expected but java.sql.Date.toInstant()fails unconditionally with UnsupportedOperationException
 
Things to remember: 
 * Converting Instant to ZonedDateTime in any way without providing explicit ZoneId is probably a bug.
 * It is important to understand Why is all of this important? When you make an agreement with your client that something is supposed to take one day vs. 24 hours this may actually make a huge difference on certain days. (https://dzone.com/articles/guide-to-time-and-date-in-java-part-2) 
 * Store and send time either as a timestamp (long value) or as an ISO 8601 which is basically what Instant.toString() does as per the documentation.
 
time and calendars. For example, some people believe that the time difference between two locations is always constant.
* First is daylight savings time

##Interface

### Functional interface
Functional interfaces provide target types for lambda expressions and method references.
 Each functional interface has a single abstract method, called the functional method for that functional interface, to which the lambda expression's parameter and return types are matched or adapted.
 FunctionalInterface. This annotation is not a requirement for the compiler to recognize an interface as a functional interface, but merely an aid to capture design intent and enlist the help of the compiler in identifying accidental violations of design intent.
 
Examples:
 The java.lang.Runnable and java.util.concurrent.Callable are two great examples of functional interfaces
 
### Default method
 They allow adding new methods to existing interfaces without breaking the binary compatibility with the code written for older versions of those interfaces.
 The difference between default methods and abstract methods is that abstract methods are required to be implemented. But default methods are not.
 
 before declaring method as default it is better to think twice if it is really needed as it may cause ambiguity and compilation errors in complex hierarchies. 
 
## Lambdas
Lambda expressions allows you treat functionality as method argument, or code as data.
The return statement is not required if the lambda body is just a one-liner.


### Method reference
Method reference allows you refer to the existing method by name (useful  a lambda expression does nothing but call an existing method). 
Method references provide the useful syntax to refer directly to exiting methods or constructors of Java classes or objects (instances)

## STREAM
A stream is a sequence of elements. 
A pipeline is a sequence of stream operations, which in this example is filter- map-forEach. I
gregate operations typically accept lambda expressions as parameters

### The map Method
Once you have a Stream object, you can use a variety of methods to transform it into another Stream object. The first such method we’re going to look at is the map method. It takes a lambda expression as its only argument, and uses it to change every individual element in the stream. Its return value is a new Stream object containing the changed elements

## OTHER
The arrow token, ->

### Function
**Interface Predicate<T>**  Represents a predicate (boolean-valued function) of one argument.
**interface Consumer<T>**  Represents an operation that accepts a single input argument and returns no result. Unlike most other functional interfaces, Consumer is expected to operate via side-effects.
**interface Function<T,R>**  Represents a function that accepts one argument and produces a result.


Sources:
https://www.javacodegeeks.com/2014/05/java-8-features-tutorial.html
https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 

 
#### **Functional Interface**

**Definition:**
A functional interface has exactly one abstract method. Since default methods have an implementation, they are not abstract. If an interface declares an abstract method overriding one of the public methods of java.lang.Object, that also does not count toward the interface's abstract method count since any implementation of the interface will have an implementation from java.lang.Object or elsewhere.
An instances of functional interfaces can be created with lambda expressions, method references, or constructor references.
**Docs:** https://docs.oracle.com/javase/8/docs/api/java/lang/FunctionalInterface.html

Add @FunctionalInterface to Your Functional Interface


#### **Method References**
 
 
#### Optionals

Please don't use it as the field of a Java-Bean.


Sources:
* http://blog.joda.org/2014/11/optional-in-java-se-8.html
