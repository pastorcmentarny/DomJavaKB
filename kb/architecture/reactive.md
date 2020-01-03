## **HONEST WARNING**
**Content in this KB is for me ONLY.**
It contains definitions that explain things in the way that is easiest for me to understand.
_I am not the author of these definitions so check resources section for the origin of definitions._ 

* Reactive Programming is a style of micro-architecture involving intelligent routing and consumption of events, all combining to change behaviour. 
* This two-way connection between a publisher and a subscriber is called a subscription. 
* Reactive Streams are made up of four main entities: (1) publishers, (2) subscribers, (3) subscriptions, and (4) processors. 
    *   (1) notification of being subscribed, 
    *   (2) accepting pushed items,
    *   (3) accepting errors that occur in a subscribed publisher,
    *   (4) notification when a publisher is complete. 
* subscription
    *   (1) accepting requests for items
    *   (2) being canceled. 
  a processor as a combination of the publisher and subscriber interfaces, with an important quirk: A processor may produce items of a different type than the type of the items it consumes.
* Reactive use cases:
    *   Highly Concurrent Message Consumers Message processing, in particular when it is highly concurrent, is a common enterprise use case.
     
  
  https://spring.io/blog/2016/06/07/notes-on-reactive-programming-part-i-the-reactive-landscape