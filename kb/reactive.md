This two-way connection between a publisher and a subscriber is called a subscription. 

Reactive Streams are made up of four main entities: (1) publishers, (2) subscribers, (3) subscriptions, and (4) processors. 

 a subscriber has four main interactions: (1) notification of being subscribed, (2) accepting pushed items, (3) accepting errors that occur in a subscribed publisher, and (4) notification when a publisher is complete. 
 subscription - 1) accepting requests for items and (2) being canceled. 
  a processor as a combination of the publisher and subscriber interfaces, with an important quirk: A processor may produce items of a different type than the type of the items it consumes.