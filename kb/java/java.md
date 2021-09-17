## **HONEST WARNING**

**Content in this KB is for me ONLY.**
It contains definitions that explain things in the way that is easiest for me to understand.
_I am not the author of these definitions so check resources section for the origin of definitions._

# THE JAVA REVISION BOOK BASICS

# DICTIONARY

## ::

    :: keyword is a way pass references of methods or constructors. Default methods cannot be accessed from within lambda
    expressions. Predicates are boolean-valued functions of one argument.

## Java

    Java is a general-purpose, object-oriented computer programming language. main principle was to  "write once, run anywhere". It means Java applications are typically compiled to bytecode that can run on any Java virtual machine (JVM) regardless of computer architecture.
    Object-oriented programming based on abstract concept of real-world object where each object has state and behaviour. It contains 4 significant features, such as encapsulation, inheritance, polymorphism and abstraction.

## Annotation

    Annotation is not part of the program itself. It contains information for the compiler; it helps software tools process
    and/or generate data/code.

## Abstraction

    It is the process of separating ideas and signatures. It is a commonly used component from specific implementation. Implementation is left for subclasses.  It is used to hide specific details and only show the essential features of the object.
    An interface is a way to achieve abstraction in Java. It is similar to a class with a group of methods with empty bodies without implementation, and it can contain final fields. Since Java 9 default method with implementation is allowed.

### What is Autoboxing and Unboxing? It is conversion between a primitive type and its object wrapper.

 	for example
 		Stack<Integer> x = new Stack<Integer>();
 		x.push(17); (autoboxing will swap 86 with new Integer(86) )

## Algorithm

    An algorithm is a recipe to instructs how to perform a task. It is a sequence of instructions that accomplishes a task
    in a finite time period. The algorithm receives zero or more inputs, produces at least one output, consists of clear and
    unambiguous instructions, terminates after a finite number of steps.

## BIG O NOTATION

    The Big-O notation is used for describing algorithm performance, scalability, execution and complexity factors in the
    worst case scenario as the number of elements in a data structure increases.

BIG O NOTATION from best to worst:

    O(1) 	
    Constant O(log n)
    Logarithmic O(n)
    Linear O(n log n) 	
    Linear Logarithmic O(n2) 	
    Quadratic O(n3) 	
    Cubic

List and sets:

    Structure       get     add     remove  contains
    ArrayList       O(1)    O(1)    O(n)    O(n)    
    LinkedList      O(n)    O(1)    O(1)    O(n)
    HashSet         O(1)    O(1)    O(1)    O(1)
    LinkedHashList  O(1)    O(1)    O(1)    O(1)
    TreeSet         O(logn) O(logn) O(logn) O(logn)

Maps:

    Structure       Get     Put     Remove  ContainsKey
    HashMap         O(1)    O(1)    O(1)    O(1)
    LinkedHashMap   O(1)    O(1)    O(1)    O(1)
    TreeMap         O(logn) O(logn) O(logn) O(logn)

## Class

    It is a blueprint from which objects are created.

## The Java Collections Framework (JCF)

 	The Java collections framework (JCF) is a set of classes and interfaces that implement a commonly reusable collection of data structures.

## CopyOnWriteArrayList

    A version of ArrayList that makes a cloned copy of the underlying ArrayList to implement all operations and modifications. It is fail-safe, and it will never throw ConcurrentModificationException during iteration.

## Data structure

    The data structure is a container (in java will be a class) that provides storage for data elements and 
    capabilities for manipulating data items (add, remove, swap, find and so on).

    Benefits are:

    - Reusability and better code quality as a result of the use of well-tested collections framework classes.
    - Reduced Effort for code maintenance by using collection classes shipped with JDK.

## Data Types supported by Java?

    Java has 8 types (boolean, byte, char, double, float, int, long, short).

## DATE AND TIME IN JAVA 8

    What was the design principles for date and time in Java 8?
    
    * Immutability: All the classes in the new Date-Time API are immutable and suitable for multithreaded environments.
    * Separation of Concerns: The new API clearly separates human-readable date time and machine time (UNIX timestamp).
      It defines separate classes for Date, Time, DateTime, Timestamp, Timezone etc.
    * Clarity: The methods are clearly defined and perform the same action in all the classes. For example, to get the current instance, we have now() method. There are format() and parse() methods defined in all these classes rather than having a separate class for them. All the classes use Factory Pattern and Strategy Pattern for better handling. Once you have used the methods in one class, working with other classes won’t be hard.
    * Utility operations: All the new Date-Time API classes comes with methods to perform common tasks, such as plus,      minus, format, parsing, getting a separate part in date/time etc.
    * Extendable: The new Date Time API works on the ISO-8601 calendar system, but we can use it with other non-ISO calendars as well.

    Worth to know:

    * The new Java 8 java.time.
      Instant is the equivalent class to the classic java.util.Date Date in Pre-Java 8 does not represent… date. 
      Seriously, officially, date is “[…] the day of the month or year as specified by a number […]” 
      whereas in Java it represents a point in time without any specific calendar (day/month/year). 
      Many methods in Date are deprecated for a reason because they lead you to believe. 
      Date represents, you know, date.
      Timestamp (long value) or as ISO 8601, which is basically what Instant.toString() is.
    * Why Java 8 introduced new data and time classes. What was wrong with time and date?
        * Java Date Time classes are not defined consistently; we have Date Class in both java.util as well asjava.sql packages. Again formatting and parsing classes are defined in java.text package. java.util.Date contains both date and time, whereas java.sql.Date contains the only date. Having this in java.sql package doesn’t make sense. Also, both the classes have the same name, which is a very bad design itself.
        * There are no clearly defined classes for time, timestamp, formatting and parsing. We have java.text.DateFormat abstract class for parsing and formatting need. Usually, SimpleDateFormat class is used for parsing and formatting.
        * All the Date classes are mutable, so they are not thread-safe. It’s one of the biggest problems with Java Date and Calendar classes. ⦁ Date class doesn’t provide internationalization; there is no timezone support. So java.util.Calendar and java.util.TimeZone classes were introduced, but they also have all the problems listed above.

## DEADLOCK

    Deadlock is a situation when two or more threads waiting for each other to release the lock and get stuck for infinite
    time. It will only happen in the case of multithreading. How to fix deadlock? or How to avoid deadlock in Java? Real
    reason for the deadlock is not multiple threads but the way they access lock. If you provide ordered access, then the
    problem will be resolved.

## Encapsulation

    Encapsulation (data hiding) is a technique that gives the ability to control access to their internal characteristics and behaviour. It is accomplished by Java access modifiers: public, private, default(no modifier)  and protected.
    * It increases usability. 
    * It improves the maintenance of code.
    * It helps object to interact with each other correctly.

## GARBAGE COLLECTORS

    Garbage Collection is a process that manages the allocation and release of memory of the application. For example, It frees memory allocated to objects that are not being used by the program any more.

### Garbage First (G1).

    It a newish collector that’s recently become more stable and is in slowly increasing usage.  

### The Z Garbage Collector

    ZGC is a low-latency GC designed to work well with huge amounts of memory. The Oracle documentation refers to multi-terabyte heaps in its description of Z. Oracle introduced ZGC in Java 11. In Java 12, Oracle added performance fixes and class unloading even though Z is still in experimental status. It's only available on 64-bit Linux.

### What Is Shenandoah?

    Shenandoah GC is a garbage collector with low pause times. These times are short and predictable, regardless of the size of the heap.
    How Does Shenandoah Work? Shenandoah's design trades concurrent CPU cycles and space for pause time improvements. The forwarding pointer makes it easy to move objects, but the aggressive moves mean Shenandoah uses more memory and requires more parallel work than other GCs. But it does the extra work with very brief stop-the-world pauses.https://dzone.com/articles/java-garbage-collection-3?edition=479246&utm_source=Zone%20Newsletter&utm_medium=email&utm_campaign=java%202019-05-07

## Generics

    Generics allow us to specify the type of Object that a collection can contain, so if you try to add any element of other
    types, it throws a compile-time error. This avoids ClassCastException at Runtime because you will get the error at
    compilation.

## What is a hashcode()?

    A hashcode() is a method that returns an integer number. It is used some data structures (like theHashMap): because it
    is one of the fastest solutions around for random-access key-value storage, which means it allows objects to be
    stored/retrieved quickly in a HashMap. Objects that are equal must have the same hash code within a running process.
    Note: An alternative: SHA1. Objects with the same hash code NOT MUST be equal hashCode does not guarantee the same
    result in different executions. You may know that cryptographic hash codes such as SHA1 are sometimes used to identify
    objects (Git does this, for example).

## Immutable objects

    In Java, Immutable objects offer a number of advantages for building reliable applications. We don’t need to write
    defensive or protective code to keep the application state consistent; our code can be simpler, more concise, and less
    error-prone than defining mutable objects.

    Some of the key benefits of immutable objects are:

      - Thread safety
      - Atomicity of failure
      - Absence of hidden side-effects
      - Protection against null reference errors
      - Ease of caching
      - Prevention of identity mutation
      - Protection from instantiating logically invalid objects
      - Protection from unintentional corruption of existing objects

## Inheritance

    Inheritance gives an object the ability to use the fields and methods of the parent class. It is helpful technique because
    it allows you to re-use code and can be used to add additional features to an existing class without modifying it.

### Does Java support multiple inheritance?

    No. Java does not support multiple inheritances. Each class can extend only one class, BUT It can implement more than one
    interface. Why? It is a design decision. Different experts have different opinions on that. I guess they didn't have a usable and error-proof solution for the C++ diamond problem.

## Java Bean (POJO)

    JavaBean is a normal Java class with with set of coding conventions rules to make a reusable software component. Implements java.io.Serializable interface Provides no argument constructor Provides getter and setter methods for accessing its properties.

## What is JDBC?

    JDBC is a Java database connectivity technology. This technology is an API for the Java programming language that
    defines how a client may access a database, query and manipulate data. It allows the programmer to interact with the
    database without concern about what database is used.

## JSP

    Ancient technology.Ask Software archeologies for details.

## Lambda

    Lambda expression are cute little anonymous method.
    Lambda expression is a more compact way of writing an anonymous function or implementing a functional interface.

## Marshalling and Demarshalling?

    When an application wants to pass its memory objects across a network to another host or persist it to storage, the
    in-memory representation must be converted to a suitable format. This process is called marshalling, and the revert
    operation is called demarshalling.

## method

    The method is a collection of statements that are grouped together, which is referred to by name and can be called.

## A method reference

    A method reference is a more compact and easy-to-read construct that replaces a lambda expression that does nothing more
    than invoking an existing method.

    Types of Method References:

    - Type Syntax Method Reference Lambda expression Reference to a static method Class::staticMethod String::valueOf s -> String.valueOf(s)
    - Reference to an instance method of a particular object instance::instanceMethod s:toString () -> “string”.toString()
    - Reference to an instance method of an arbitrary object of a particular type Class:instanceMethod String::toString s -> s.toString()
    - Reference to a constructor Class::new String::new () -> new String()

## Method Overloading

    Method overloading in Java occurs when two or more methods in the same class have the exact same name but different parameters.

## Method Overriding

    Method overriding in Java occurs when a subclass has the same method as a parent class. Overridden methods must have the same name, argument list, and return type.

## Object

    It is a particular instance of a class (with its own variables, methods, and data structures).

## Package

    It is a namespace for organizing classes, interfaces and so on in a logical structure.

## PATH environment variable

    - It is a way for the system to run the executables (javac.exe, java.exe, javadoc.exe, and so on) from any directory
      without having to type the full path of the command
    - The CLASSPATH variable is one way to tell applications, including the JDK tools, where to look for user classes. If a
      class is not found in CLASSPATH then Java throws ClassNotFoundException.

## Polymorphism

    Polymorphism (the State of having many shapes) is the ability for method to perform tasks in different ways. Subclasses of a class can define their own unique behaviours and/or re-use one of the parent class's same functionality. In Java, it is done, for example, in method overriding.

## Remote Method Invocation (RMI)

    The Java Remote Method Invocation (RMI) system allows an object running in one Java virtual machine to invoke methods on
    an object running in another Java virtual machine. RMI provides for remote communication between programs written in the
    Java programming language. It is an object-oriented equivalent of remote procedure calls (RPC), with support for the
    direct transfer of serialized Java classes and distributed garbage collection.

## SerialVersionUID

    You should always define SerialVersionUID for a serializable class and you should always define it. If you don't define
    then JVM will calculate it for you but if you modify anything you will get a different SerialVersionUID which means you
    won't be able to restore object saved by previous version of your program.

## JAVA SERVLET

    The javax.servlet.Servlet interface defines the three methods known as the life-cycle method.

    1.  init()      - the servlet is constructed, then initialized with the init() method.
    2.  service()   - Any request from the client are handled initially by the service() method before delegating to the doXxx() methods in the
    case of HttpServlet.
    3.  destroy()   - The servlet is removed from service, destroyed with the destroy() method, then garbaged collected and finalized.

## Static keyword

 	It indicates that field, method or class has a single instance for the whole class that defines it and A static variable in Java belongs to its class and its value remains the same for all its instances.

## Static Classes

    Do not allow instantiation of a static class. Always create a private constructor. Static classes should be stateless, immutable, not allow subclassing, and thread-safe. Static classes should be side-effect free and provided as utilities, such as filtering a list.

## Volatile keyword

    Voltile variable in Java is a special variable which is used to signal threads, compiler that this particular variables values is going to be updated by multiple thread inside Java application. By making a variable volatile using volatile keyword in Java, application programmer ensures that its value should always been read from main memory and thread should not use cached value of that variable from there own stack. Volatile keyword can only be applied to variable, it can not be applied to class or method. using volatile keyword along with class and method is compiler error. Any variable which is shared between multiple threads should be made variable, in order to ensure that all thread must see latest value of volatile variable.

Differences between Abstraction and Interface

Abstract Class Interface It can have method implementation It can implement default method only All non-default methods
in an interface are implicitly abstract. Abstract class can have constructor Interface can not have a constructor An
abstract class may contain non-final variables. Variables declared in a Java interface is by default final. It is faster
than interface It is slower than abstract class You can not extend more than one abstract class. You can implement more
than on ethan interface Abstract classes can have a main method so we can run it. Interface can not not have main method
so we can not run it.

⦁ If you have a lot of methods and want default implementation for some of them or If your base contract keeps on
changing, then you should use abstract class. ⦁ If you want to implement multiple inheritance then you have to use
interface. As Java does not support multiple inheritance, subclass can not extend more than one class but you can
implement multiple interface so you can use interface for that. ⦁ If your base contract keeps on changing, then you
should use abstract class, as if you keep changing your base contract and use interface, then you have to change all the
classes which implements that interface. ⦁ In Java8 Oracle has tried to bridge gap between abstract class and interface
by introducing concept of default and static methods in interface.
(In Java8 things changed as The addition of default methods removes many of the reasons to use abstract classes. The
differences are the accessibility of data members and methods: abstract classes allow non-static and non-final fields
and allow methods to be public, private, or protected while interfaces’ fields are inherently public, static, and final,
and all interface methods are inherently public. How does Java handle a class that implements two interfaces, both of
which describe a default method with the same signature? this is a compilation error.

What is a Constructor? A constructor gets invoked when a new object is created. Every class has a constructor. (You
don't need provide default constructor. It will be done by compiler).

What is a Constructor Overloading? The constructor overloading is similar to method overloading in Java. Different
constructors can be created for a single class.

Difference between Abstraction and Encapsulation? Abstraction and encapsulation are complementary concepts. Abstraction
focuses on the behaviour of an object. Encapsulation focuses on the implementation of an object’s behaviour.

If you had to change Java, what would you do? I think Java is getting better but it misses some synthetic sugar from
Groovy, Scala and Apache Commons. It is not a big deal, but nice to have I feel that Java Remove deprecated methods and
get rid off all stuff

- Clonable (redesign)
- merge groovy goodness into Java. (- File handling)
- merge Apache commons goodness into Java Many changes was done in Java7 and Java Date/Time was changed in Java8. Thank
  you.

Question 1: What is Framework in Java?

Answer: A framework is a set of classes and interfaces which provide a ready-made architecture. An optimal
object-oriented design always includes a framework with a collection of classes such that all the classes perform the
same kind of task.

What are the basic interfaces of Java Collections Framework? Collection, which represents a group of objects known as
its elements. Map, which is an object that maps keys to values and cannot contain duplicate keys. List, which is an
ordered collection and can contain duplicate elements. Set, which is a collection that cannot contain duplicate
elements.

What is an Iterator? The Iterator interface has a number of methods that are able to iterate over any Collection. Each
Java Collection contains the iterator method that returns an Iterator instance.

Note: Iterators are capable of removing elements from the underlying collection during the iteration. Note: Iterator
takes the place of Enumeration in the Java Collections Framework. Note: You can iterate over list in 3 ways: using
iterator , using for-each loop or stream.

What Fail Fast Iterator Fail Safe Iterator Throw ConcurrentModification Exception YES No Clone object no YES Memory
Overhead no YES Examples ArrayList Vector HashSet

HashMap, CopyOnWriteArrayList,

Note: To avoid ConcurrentModificationException we can use concurrent collection classes to avoid
ConcurrentModificationException while iterating over a collection, for example CopyOnWriteArrayList instead of
ArrayList.

How HashMap works in Java? A HashMap is a data structure that stores key-value pairs. Key need to be unique.

Put/Get In order to put and retrieve elements to and from the collection it uses hashCode and equals methods.

When we call put method by passing key-value pair, HashMap uses Key hashCode() with hashing to find out the index to
store the key-value pair. The Entry is stored in the LinkedList (or in some cases in balanced tree ,if you use java 8) ,
so if there are already existing entry, it uses equals() method to check if the passed key already exists, if yes it
overwrites the value else it creates a new entry and store this key-value Entry.

Worth remember:
Hashmap do not implement collection interface. (Collection view of a map can be obtained using entrySet() method. To
obtain a collection-view of the keys, keySet() method can be used.)
Bucket is an array (Normally LinkedList or balanced tree)  where you store elements that has the same hashcode.
Map.Entry interface - This interface gives a map entry (key-value pair). Threshold resizing is set 0.75f by default Some
important characteristics of a HashMap are its capacity, its load factor and the threshold resizing. As we know that
HashMap also allows null, though there can only be one null key in HashMap.
(A HashSet, being a wrapper around a HashMap object, effectively provides less function than HashMap whilst being
slightly larger.)
If two objects are equal, then calling hashCode() on both objects must return the same value. When inserting an object
into a hastable you use a key. The hash code of this key is calculated, and used to determine where to store the object
internally. When you need to lookup an object in a hashtable you also use a key. The hash code of this key is calculated
and used to determine where to search for the object.

The hash code only points to a certain "area" (or list, bucket etc) internally. Since different key objects could
potentially have the same hash code, the hash code itself is no guarantee that the right key is found. The hashtable
then iterates this area (all keys with the same hash code) and uses the key's equaals() method to find the right key.

Optional Anti-Pattern #2: Collections of Optionals Optionals were not designed to be serialized.

What is the trade off between using an unordered array versus an ordered array? search times in ordered array are better
as they have complexity of O(log n), compared to that of an unordered array, which is O (n). Insertion times in
unordered array are better as they it takes constant time ofO(1),while ordered time takes O(n)

Question 10: Define EnumSet.

Answer: It is a Set implementation that can be used with enum types. All the elements must come from one enum type
specified explicitly or implicitly. It is not synchronized. NULL keys are not allowed. Note: LinkedHashSet is in some
sense intermediate between HashSet and TreeSet. Implemented as a hash table with a linked list running through it,
however it provides insertion-ordered iteration which is not same as sorted traversal guaranteed by TreeSet. Also, since
we used a LinkedHashSet, the iteration order is the same as the insertion order. If you do not need this behavior, use a
HashSet for more efficiency. Difference between TreeSet and TreeMap in Java?

TreeSet TreeMap They are sorted collections. They are not synchronized. Store values Store keys and values Duplicate
object are not allowed. Duplicate object are allowed(for value only).

How to decide between HashMap and TreeMap? TODO improve it For inserting, deleting, and locating elements in a Map, the
HashMap offers the best alternative. If however, you need to traverse the keys in a sorted order, then TreeMap is your
better alternative. Depending upon the size of your collection, it may be faster to add elements to a HashMap, then
convert the map to a TreeMap for sorted key traversal.

STREAM the map method. It takes a lambda expression as its only argument, and uses it to change every individual element
in the stream.

A reduction operation is one which allows you to compute a result using all the elements present in a stream. also
called terminal operations

 	Perm space is a part of Java Heap where JVM stores Meta data that are related to the Java language itself. (About classes and methods, String pool and Class level details.)

What is a Java Heap? Java Virtual Machine gets some memory from Operating System. JVM uses this memory for all its need
and part of this memory is call Java heap memory.

How is Heap organised? EDEN Young Generation S0 /S1 Young Generation Tenured Old Generation Permanent
PermanentGeneration Perm space of Java Heap is where JVM stores Meta data about classes and methods, String pool and
Class level details.

Difference between OutOfMemoryError for Java Heap Space and PermGen space.
"java.lang.OutOfMemoryError: Java heap space"
error messages denotes that Java heap does not have sufficient space and cannot be expanded further
"java.lang.OutOfMemoryError: PermGen space"
error message comes when the permanent generation of Java Heap is full, the application will fail to load a class or to
allocate an interned string.

Exception Handling

What is an exception? Exception is an error event that can happen during the execution of a program and disrupts its
normal flow. When an error occurs while executing a statement, creates an exception object and then the normal flow of
the program halts and JVM tries to find someone that can handle the raised exception.

Is Java Exception framework handles compile time errors? No. It is used to handle runtime errors only.

Exception Handling Keywords ⦁ Throw – is used when we want to generate an exception explicitly in our code. throw new
SomethingWentWrongException(); ⦁ Throws – is used when we throwing an exception in the method and not handle it. public
void aMethod() throws FileNotFoundException{ ... } ⦁ Try-catch – is a block for exception handling in our code. Catch
block requires a parameters of Exception type (for example FileNotFoundException). ⦁ Finally is an optional block that
will be executed whenever exception occurred or not.(It is used to close open connection, stream and so on)

Exception Hierarchy

Errors Errors are exceptional cases that are out of scope of the application and that is impossible to anticipate and
recover from them (JVM crashes, HW failure).

Checked Exceptions

Checked exceptions are checked at compile-time. It means if a method is throwing a checked exception then it should
handle the exception using try-catch block or it should declare the exception using throws keyword.

Here are the few other Checked Exceptions – ⦁ SQLException ⦁ IOException ⦁ DataAccessException ⦁ ClassNotFoundException
⦁ InvocationTargetException Checked exceptions are exceptions that we can anticipate and we should be able to recover
from them.

When to use them? TODO improve it

1) All Operation where chances of failure is more e.g. IO Operation, Database Access or Networking operation can be
   handled with Checked Exception.
2) Checked Exception is a reminder by compiler to programmer to handle failure scenario.

Unchecked (Runtime) Exceptions Runtime Exceptions are exceptions caused by mistakes in programming. There called a bug.
it’s not required to specify them in the method signature throws clause. It usually caused by input of bad data during
user/software-program interaction. Here are the few most frequently seen unchecked exceptions – ⦁ NullPointerException ⦁
ArrayIndexOutOfBoundsException ⦁ ArithmeticException ⦁ IllegalArgumentException

“Runtime exceptions represent problems that are the result of a programming problem, and as such, the API client code
cannot reasonably be expected to recover from them or to handle them in any way. Such problems include arithmetic
exceptions, such as dividing by zero; pointer exceptions, such as trying to access an object through a null reference;
and indexing exceptions, such as attempting to access an array element through an index that is too large or too small.
“

What are the two types of Exceptions in Java? Which are the differences between them? TODO improve it Java has two types
of exceptions: checked exceptions and unchecked exceptions. Unchecked exceptions do not need to be declared in a method
or a constructor’s throws clause, if they can be thrown by the execution of the method or the constructor, and propagate
outside the method or constructor boundary. On the other hand, checked exceptions must be declared in a method or a
constructor’s throws clause.

When you should throw checked exception and when you should throw unchecked exception? We should always use unchecked
exception. Checked exception was good idea,but … it breaks Open/Closed Principle. If a client can reasonably be expected
to recover from an exception, make it a checked exception. If a client cannot do anything to recover from the exception,
make it an unchecked exception.

GOOD TO REMEMBER:
⦁ A try statement should have either catch block or finally block, it can have both blocks. ⦁ We can have multiple catch
blocks with a single try statement and only one finally block ⦁ In terms of Functionality Checked and Unchecked
Exception are same. ⦁ Java has always been criticized for having checked exception and polluting code with cluttered
exception handling code, multi-catch block in Java 7 fix this problem.

Explain Serialization and Deserialization.

 	Java provides a mechanism, called object serialization where an object can be represented as a sequence of bytes and includes the object’s data, as well as information about the object’s type, and the types of data stored in the object. Thus, serialization can be seen as a way of flattening objects, in order to be stored on disk, and later, read back and reconstituted. Deserialisation is the reverse process of converting an object from its flattened state to a live object.

Worth remember:
variables like static and transient will be initialized to their default value after de-serialization, because transient
and static fields are never get serialized. There is an interface available to validate the object and its data called '
ObjectInputValidation'. It has validateObject() method

Source:

THREAD What is a Thread? Thread in Java is an independent path of execution which is used to run two task in parallel.
The Java Virtual Machine allows an application to have multiple threads of execution running concurrently..

What is Collections Class? java.util.Collections Is a utility class consists exclusively of static methods that operate
on or return collections. It contains polymorphic algorithms that operate on collections, “wrappers”, which return a new
collection backed by a specified collection, and a few other odds and ends.This class contains methods for collection
framework algorithms, such as binary search, sorting, shuffling, reverse etc.

Difference between notify and notifyAll? (TODO improve it)
The main difference between notify and notifyAll is that notify method will only notify one Thread and notifyAll method
will notify all Threads which are waiting on that monitor or lock. When you call notify only one of waiting for the
thread will be woken and it's not guaranteed which thread will be woken, it depends on upon Thread scheduler. Is it
matter ? While if you call notifyAll method, all threads waiting on that lock will be woken up, but again all woken
thread will fight for lock before executing remaining code and that's why wait is called on loop because if multiple
threads are woken up, the thread which will get lock will first execute and it may reset waiting for condition, which
will force subsequent threads to wait. In this case, notify is optimized call over notifyAll because so calling
notifyAll method is just waste of CPU cycles.

Difference between <? super T> and <? extends T> in Java ? TODO

System Properties

The System class maintains a set of properties--key/value pairs--that define traits or attributes of the current working
environment. When the runtime system first starts up, the system properties are initialized to contain information about
the runtime environment. including information about the current user, the current version of the Java runtime, and even
the character used to separate components of a filename.

GOOD TO KNOW:
This is an example of how to use the AtomicInteger class of Java. The java.util.concurrent.atomic package provides very
useful classes that support lock-free and thread-safe programming on single variables. Among them, the AtomicInteger
class is a wrapper class for an int value that allows it to be updated atomically. The class provides useful methods,
some of which will be shown in the code snippet below. The most common use of the AtomicInteger is to handle a counter
that is accessed by different threads
simultaneously. (https://examples.javacodegeeks.com/core-java/util/concurrent/atomic/atomicinteger/java-atomicinteger-example/)

OOP concepts:
abstraction , encapsulation , inheritance and polymorphism DRY (Don't repeat yourself)

###### ###### ######

Style Guide

1 empty before 14 QUESTION 10 Answer Subject . Keyword and Important important information. Normal information. 2 empty
lines in the end

Things to add:

* Only private constructors are allowed in enum types
* Enum constants are created only once for the whole execution.
* Enum types are final by default. T
* , all enum types are Comparable and Serializable by default.
* volatile is a field modifier, while synchronized modifies code blocks and methods.
* Threads can have local copies of variables, and the data does not have to be the same as the data held in other
  threads.
* A volatile variable is not allowed to have a local copy of a variable that is different from the value currently held
  in "main" memory. Effectively, a variable declared volatile must have its data synchronized across all threads, so
  that whenever you access or update the variable in any thread, all other threads immediately see the same value.
* mory and the "main" memory, synchronized synchronizes the value of all variables between the thread memory and the "
  main" memory and locks and releases a monitor to control the ownership between multiple threads.
* String.valueOf(Object) Vs. Objects.toString(Object). Although I typically use String.valueOf(Object) instead of
  Objects.toString(Object) by default when I want the string "null" returned if the passed-in object is null, the
  alternate overloaded method Objects.toString(Object, String) has the advantage of specifying any string to be returned
  by the method if the passed-in object is null.
* Java Management Extensions (JMX) is a Java technology that supplies tools for managing and monitoring applications,
  system objects, devices (such as printers) and service-oriented networks.Those resources are represented by objects
  called MBeans (for Managed Bean)
* A managed bean - sometimes simply referred to as an MBean - is a type of JavaBean, created with dependency injection.
  The MBean represents a resource running in the Java virtual machine, such as an application or a Java EE technical
  service (transactional monitor, JDBC driver, etc.). They can be used for collecting statistics on concerns like
  performance, resources usage, or problems (pull); for getting and setting application configurations or properties (
  push/pull); and notifying events like faults or state changes (push).
* What Is the Difference Between equals() and = = ? Equals() method is used for checking the equality of two objects
  defined by business logic. == or the equality operator is used to compare primitives and objects.
* as shown below:
  Equals() method is used for checking the equality of two objects defined by business logic.

== or the equality operator is used to compare primitives and objects.

# RANDOM TIPS

0. **Finally** is _not executed_ if the** System.exit** method is called _inside_ a try block.
0. Consequently an amount of money should never ever be stored in a floating point data type (float, double).For
   calculations the class BigDecimal provides an excellent facility.
0. When using streams,use ordered collection when u use dropWhile/takeWhile to avoid sneaky bugs.
0. Objects.isNull vs object == null. Objects.isNull is intended for use within Java 8 lambda filtering. However value is
   limited to helps readability for some style preference For example some guides prefere
   this:    ```    .stream().filter(Objects::isNull)     ```    than: ```    .stream().filter(x->x==null)    ```
0. The List returned by Arrays.asList() is an immutable list. Attempting to remove (or add) items to such a list results
   in an UnsupportedOperationException

# FAQ

## When does ConcurrentModificationException occur?

    ConcurrentModificationException occurs when a data collection tries to modify while that collection is actively in use, as when something we are iterating on is modified.

## Concurrent Modification?

    When one or more thread is iterating over the collection, in between, one thread changes the structure of the
    collection (either adding the element to the collection or by deleting the element in the collection or by updating the
    value at particular position in the collection) is known as Concurrent Modification

## What peek() in the queue interface?

    Peek() returns the head of the queue. It does not remove any element. It returns null when the queue is empty.

## What is a heap dump ?

    A heap dump is a snapshot of your application’s memory in a point in time. It contains information such as what are the objects in memory, what values do they carry, what is their size, what other objects do they referenc It used for troubleshooting memory related, OutOfMemoryError problems.

## What is a Thread Dump?

    A thread dump is a snapshot of all threads running in the application at a point in time. It contains all the information about each thread in the application such as thread state, thread Id, native Id, thread name, stack trace,  and priority.
    It is used for troubleshooting production problems such as CPU spikes, unresponsiveness in the application, poor response time, hung threads, high memory consumption.

## Can you override static method in Java?

    No. It is worth nothing that you can declare and define static method of same name and signature in child class, this will hide the static method from parent class

## How do you convert bytes to character in Java?

    Bytes are converted to character or text data using character encoding. When you read binary data from a file or network endpoint, you provide a character encoding to convert those bytes to equivalent character. Incorrect choice of character encoding may alter meaning of message by interpreting it differently.

## What is Perm Gen space in Heap?

    It was removed in Java 8. The permanent generation is being removed in favour of  metaspace.

## What does stop-the-world mean?

    The term ‘stop-the-world’ is used to mean that all of the threads are paused in order to perform garbage collection.

## What is difference between ArrayList and LinkedList?

There are similar as both implement list ArrayList LinkedList.

* An ArrayList is an index based data structure. It provides random access to its elements with a performance equal to
  O(1).
* An ArrayList use less memory (LinkedList store 2 references)
* LinkedList are faster in a The Insertion, addition and removal operations of an element (no need of resizing an array
  or update index)

# What is the difference between Exception and Error in Java?

    Exception and Error classes are both subclasses of the Throwable class.
    The Exception class is used for exceptional conditions that a user’s program should catch.
    The Error class defines exceptions that are unrecovable.

## Difference between Serializable and Externalizable in Java?

- Serializable is a marker interface with no methods defined to allow serialization/deserialization.
- Externalizable extends Serializable interface and add two methods defined on it e.g. readExternal() and
  writeExternal() which allows you to control the serialization/deserialization process.
- Serializable uses default serialization process which can be very slow for some application.

## What differences exist between Iterator and ListIterator?

- An Iterator can be used to traverse the Set and List collections, ListIterator can be used to iterate only over Lists.
- Iterator can traverse a collection only in forward direction. ListIterator can traverse a List in both directions.
- The ListIterator implements the Iterator interface and contains extra functionality, such as adding an element,
  replacing an element, getting the index position for previous and next elements, etc.

## What is difference between fail-fast and fail-safe?

- Fail fast iterator while iterating through the collection, instantly throws Concurrent Modification Exception if there
  is structural modification of the collection. Oracle docs said: the fail-fast behaviour of an iterator cannot be
  guaranteed.
- Fail Safe Iterator makes copy of the internal data structure (object array) and iterates over the copied data
  structure. Any structural modification done to the iterator affects the copied data structure. So, original data
  structure remains structurally unchanged. Hence, no ConcurrentModificationException throws by the fail safe iterator.

## How HashMap, ConcurrentHashMap, and LinkedHashMap handles collisions ?

A collision occurs when a hash function returns same bucket location for two different keys. HashMap handles collision
by using linked list to store map entries ended up in same array location or bucket location. However, if worst case
scenario when there are many collisions, performance drop from O(1) to O(n),to address this HashMap has a threshold when
they reach they switch to balanced tree from linked list to handle frequently hash collisions.
(Default is TREEIFY_THRESHOLD = 8) . This will improve the worst case performance from O(n) to O(log n).

## What is the importance of hashCode() and equals() methods?

HashMap uses Key object hashCode() and equals() method to determine the index to put the key-value pair. These methods
are also used when we try to get value from HashMap. If these methods are not implemented correctly, two different keys
might produce same hashCode() and equals() output and in that case rather than storing it at different location, HashMap
will consider them same and overwrite them.

## What is the difference between HashSet and TreeSet?

HashSet TreeSet Elements are not ordered. Elements are ordered. The add, remove, and contains method have constant time
of O(1). add, remove, and contains method have constant time of O(logn).

It has a few extra methods to deal with the ordered set like first(), last() and so on.

## What’s difference between Streams and collections ?

No storage. A stream is not a data structure that stores elements; instead, it conveys elements from a source such as a
the data structure, an array, a generator function, or an I/O channel through a pipeline of computational operations.
Functional in nature. An operation on a stream produces a result but does not modify its source. For example, filtering
a Stream obtained from a collection produces a new Stream without the filtered elements, rather than removing elements
from the source collection. Laziness-seeking. Many stream operations, such as filtering, mapping, or duplicate removal,
can be implemented lazily, exposing opportunities for optimization. For example, "find the first String with three
consecutive vowels" need not examine all the input strings. Stream operations are divided into intermediate (
Stream-producing) operations and terminal (value- or side-effect-producing) operations. Intermediate operations are
always lazy. Possibly unbounded. While collections have a finite size, streams need not. Short-circuiting operations
such as limit(n) or findFirst() can allow computations on infinite streams to complete in finite time. Consumable. The
elements of a stream are only visited once during the life of a stream. Like an Iterator, a new stream must be generated
to revisit the same elements of the source.

## What is Comparable and Comparator interface?

- A comparable is an interface. An object that implements this interface is capable of comparing itself with another
  object. To implement this interface class must contain a method called compareTo.
- A comparator object is capable of comparing two different objects. The class is not comparing its instances but some
  other class’s instances. This comparator class must implement the java.util.Comparator interface. The main difference
  between these two is that you could create multiple Comparator to define multiple sorting order based upon a different
  object attribute.

## How can we sort a list of Objects?

If we need to sort an array of Objects, we can use Arrays.sort(). If we need to sort a list of objects, we can use
Collections.sort(). Both these classes have overloaded sort() methods for natural sorting (using Comparable) or sorting
based on criteria (using Comparator). Collections internally uses Arrays sorting method, so both of them have same
performance except that Collections take sometime to convert list to array. Streams can sort collections

## Difference between extends Thread vs implements Runnable in Java?

The way how I choose is quite simple. If you want add new functionality ,then I will extends Thread. Otherwise, I will
use Runnable/Callable Interface. Why? In Object oriented programming extending a class generally means adding new
functionality, modifying or improving behaviours.

## Difference between Runnable and Callable interface in Java? Just like Runnable, Callable also defines a single call()

method but unlike run() it can return values and throw exceptions.

What is difference between calling start() and run() method of Thread? start() method also starts a new thread. If you
call the run method directly then it will run on same thread not on different thread, which is what original intention
would be.

What are some of the best practices relating to the Java Collection framework ? ⦁ Use immutable classes provided by the
Java Development Kit (JDK) as a key in a Map, in order to avoid the implementation of the ⦁ hashCode and equals methods
for our custom class. ⦁ Choosing the right type of the collection to use, based on the application’s needs, is very
crucial for its performance. For example if the size of the elements is fixed and know a priori, we shall use an ⦁
Array, instead of an ⦁ ArrayList. ⦁ Some collection classes allow us to specify their initial capacity. Thus, if we have
an estimation on the number of elements that will be stored, we can use it to avoid rehashing or resizing. ⦁ Always use
Generics for type-safety, readability, and robustness. Also, by using Generics you avoid the⦁ ClassCastException during
runtime. ⦁ Program in terms of interface not implementation. ⦁ Return zero-length collections or arrays as opposed to
returning a null in case the underlying collection is actually empty.

# QA:

## _Why Collection doesn't extend Cloneable and Serializable interfaces?_

    It was a design decision to leave up to the concrete implementations of Collection how they want to maintain cloning or
    serializing gives better flexibility as Collection is an abstract representation.

## _Can you access non-static variable in static context?_

    No. A static variable in Java belongs to its class, and its value remains the same for all its instances. A static
    variable is initialized when the JVM loads the class. Suppose your code tries to access a non-static variable without
    any instance. The compiler will complain because those variables are not created yet, and they are not associated with
    any instance.

## _Difference between final, finally, and finalize?_

    - Final is a keyword that indicates that variables cannot change. The method cannot be overridden, and the class cannot be subclassed.
    - Finally is a block of code that is always executed after try/catch block. (Java 7 has a try with resources statement)
    - Finalize is a method called before is an object is a garbage collected.

## _Create a map without need to resize_

```Map map = new HashMap(1 + (int) (collection.size() / 0.75));```

    HashMap implementation doesn't quite behave like this. 
    It sets its internal threshold to threshold = (int)(capacity * loadFactor). 
    So it will resize after 75% of the collection have been inserted into the map. 
    The above code will thus always cause extra garbage.

//TODO add example

## What are pass by reference and pass by value? Is Java pass by reference and pass by value?

    According to specification Java is strictly pass-by-value. Read the Java Language Specification (JLS). It's spelt out,
    and it's correct. In https://docs.oracle.com/javase/specs/jls/se17/html/jls-8.html#jls-8.4.1
    
    However, based on my experience correct answer for many reviews accept only this answer: By value = changes doesn't
    affect original By reference = changes are reflected where original value is used.
    
    The object is passed by value – this means that a copy of the object is passed. If changes are made to that object, it
    doesn't affect the original value. The object is passed by reference; this means that the actual object is not passed;
    rather, a reference of the object is passed. Any changes made by the external method are also reflected in all places.

## Why Is the String Object Immutable in Java?

    It is a design choice for a few security, multithreading, memory optimisation reasons like:

    1. Since String is immutable, it makes them thread-safe for multithreading, and it avoids the usage of synchronisation
       for thread safety. It makes a good performance because a single String instance can be shared across different
       threads.
    2. Since String is immutable, its hashcode is cached at the creation time, and it doesn't need to be calculated again.
       This makes it a great candidate for a key in a map, and its processing is fast than other HashMap key objects. This
       is why String is the most-used object of HashMap keys.
    3. String pool is possible. Different String variables can refer to the same string variable in the pool. If String were
       not immutable, then if any variable have changed the value, it would have been reflected in other variables. String
       pool allows Java Runtime saves a lot of Java heap space.
    4. It prevents many security issues like Since String is immutable, it's value can't be changed. Otherwise, any hacker
       could change the referenced value to cause security issues in the application. As it used in the Java classloader,
       and immutability provides security that the correct class is getting loaded by the Classloader (connections to the
       database)

## Why wait, notify and notifyAll is defined in Object Class and not on Thread class in Java?

    It is a language design decision, and I am a software developer. I am not knowledgeable enough about language
    architecture design to comment on it. My guess is based on usage of these methods like Both wait and notifies methods
    are used for inter-thread communication.

# RESOURCES:

0. http://en.wikipedia.org/wiki/Anti-pattern#Programming_anti-patterns
1. http://www.antipatterns.com/antipatt.htm
2. https://glenndejaeger.wordpress.com/2010/04/05/programming-antipatterns/
3. http://www.javacodegeeks.com/2011/10/programming-antipatterns.html
4. http://stackoverflow.com/questions/4343202/difference-between-super-t-and-extends-t-in-java
5. http://javarevisited.blogspot.co.uk/2012/02/why-wait-notify-and-notifyall-is.html
6. http://javarevisited.blogspot.com/2012/10/difference-between-notify-and-notifyall-java-example.html
7. http://javarevisited.blogspot.sg/2011/04/synchronization-in-java-synchronized.html
8. www.javacodegeeks.com/2014/04/java-interview-questions-and-answers.html
9. http://javarevisited.blogspot.com/2016/09/how-to-serialize-object-in-java-serialization-example.html
10. https://dzone.com/articles/what-you-need-to-know-about-serialization
11. http://www.javacodegeeks.com/2013/07/java-exception-handling-tutorial-with-examples-and-best-practices.html
12. http://docs.oracle.com/javase/tutorial/essential/exceptions/runtime.html
13. http://javarevisited.blogspot.co.uk/2011/04/garbage-collection-in-java.html
14. http://www.odi.ch/prog/design/newbies.php
15. https://dzone.com/articles/single-responsibility
16. http://examples.javacodegeeks.com/java-basics/encapsulation-in-java/
17. http://java67.blogspot.co.uk/2015/03/top-40-core-java-interview-questions-answers-telephonic-round.html
18. http://javahungry.blogspot.com/2014/04/fail-fast-iterator-vs-fail-safe-iterator-difference-with-example-in-java.html
19. http://www.javacodegeeks.com/2013/02/40-java-collections-interview-questions-and-answers.html
20. https://www.quora.com/How-is-Hashmap-in-Java-implemented-internally-What-are-the-pros-and-cons-to-use-it-What-are-the-complexities-it-provides-for-insert-delete-and-lookup
21. http://javarevisited.blogspot.co.uk/2016/01/how-does-java-hashmap-or-linkedhahsmap-handles.html
22. http://netjs.blogspot.co.uk/2015/05/how-hashmap-internally-works-in-java.html
23. http://javarevisited.blogspot.com/2016/01/how-does-java-hashmap-or-linkedhahsmap-handles.html#ixzz4YenTvj7S
24. http://eclipsesource.com/blogs/2012/09/04/the-3-things-you-should-know-about-hashcode/
25. http://www.javacodegeeks.com/2014/03/how-hashmap-works-in-java.html
26. http://docs.oracle.com/javase/tutorial/essential/exceptions/runtime.html)
27. http://www.wellho.net/mouth/1062_Java-sorting-comparable-v-comparator.html
28. http://www.javacodegeeks.com/2013/07/java-exception-handling-tutorial-with-examples-and-best-practices.html
29. http://beginnersbook.com/2013/04/java-checked-unchecked-exceptions-with-examples/
30. http://beginnersbook.com/2013/04/java-checked-unchecked-exceptions-with-examples/
31. http://bigocheatsheet.com
32. http://www.javacodegeeks.com/2011/04/simple-big-o-notation-post.html
33. http://javarevisited.blogspot.co.uk/2012/02/why-wait-notify-and-notifyall-is.html
34. http://javarevisited.blogspot.com/2012/03/10-object-oriented-design-principles.html#ixzz3EjBs0YFQ
35. http://docs.oracle.com/javase/tutorial/java/concepts/class.html)
36. http://java67.blogspot.sg/2012/08/difference-between-treemap-and-treeset-java.html
37. http://docs.oracle.com/javase/tutorial/java/javaOO/methods.html
38. http://www.javadude.com/articles/passbyvalue.htm

TODO:
https://dzone.com/articles/composition-vs-inheritance

6. Ponder Over the Choice of Data Structures Java collections provide ArrayList, LinkedList, Vector, Stack, HashSet,
   HashMap, Hashtable. It’s important to understand the pros and cons of each to use them in the correct context. A few
   hints to help you make the right choice:

Map: Useful if you have unordered items in the form of key, value pairs and require efficient retrieval, insertion, and
deletion operations. HashMap, Hashtable, LinkedHashMap are all implementations of the Map interface.

List: Very commonly used to create an ordered list of items. This list may contain duplicates. ArrayList is an
implementation of the List interface. A list can be made thread-safe using Collections.synchronizedList thus removing
the need for using Vector. Here’s some more info on why Vector is essentially obsolete.

Set: Similar to list but does not allow duplicates. HashSet implements the Set interface.