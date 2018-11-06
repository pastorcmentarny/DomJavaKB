KAFKA
It is a tool to manage data movement at scale.

? TODO ?
Subscribing to topic,  assigning partitions?


TOPIC
* A topic is a category or feed name to which records are published. 
* Topics in Kafka are always multi-subscriber; that is, a topic can have 0, 1, many consumers that subscribe to the data written to it.
* Topic stores a time-ordered sequence of messages that share the same category.
* Each topic has to have a single partition. 

PARTITION
* Partition is a physical representation of the topic as commit log stored on one or more brokers.  
* Each partition must fit entirely on one machine.
* Each partition is an ordered, immutable sequence of records that is continually appended to—a structured commit log. 
* Each partition is replicated across a configurable number of servers for fault tolerance.
* Each partition has one server which acts as the "leader" and zero or more servers which act as "followers". 

RECORDS (known as MESSAGE)
* Records in the partitions are each assigned a sequential id number called the offset that uniquely identifies each record within the partition.
* Each message in Kafka contains Timestamp, ID,  Data content using a key-value pairs .
* The message offset is like placeholder. (It is like bookmark, last read place, in case of a Kafka topic, it is the last read message). 
* value - the message content .
* key is additional information in the message and can determine what partitions the message will be written to .
* topic to which the Producer record will be sent.

CONSUMER
* Consumer is responsible for read and process. it is a response for know what it read and not.
* If consumer didn't read, consumer establishing that its message offset is 0. as it read sequence it moves offset .
* This offset is controlled by the consumer.
* Consumer will advance its offset linearly as it reads records, but, in fact, since the position is controlled by the consumer it can consume records in any order it likes.
* The group.id is a string that uniquely identifies the group of consumer processes to which this consumer belongs.
* Each record published to a topic is delivered to one consumer instance within each subscribing consumer group. 
* Consumer instances can be in separate processes or on separate machines.
* The way consumption is implemented in Kafka is by dividing up the partitions in the log over the consumer instances so that each instance is the exclusive consumer of a "fair share" of partitions at any point in time. 


PRODUCER
* KafkaProducer instances can only send Producer records that match the key and value serializers types it is configured with.
* The producer is responsible for choosing which record to assign to which partition within the topic.
* It writes to leader of the partition
* Best practice to catch send() method to surround with try/catch block  and use structured exception handling.
* Kafka producer portioning strategy : 
    * 1. Direct
    * 2. Round-robin
    * 3. Key mod-hash 
    * 4. Custom

CLUSTER
* Kafka is run as a cluster on one or more servers.
* Message Retention Policy. all published messages are retained by a Kafka cluster regardless is any consumer has consumed.
* The Kafka cluster retains all published records—whether or not they have been consumed—using a configurable retention period. 
* Each record consists of a key, a value, and a timestamp.
* Kafka has four core APIs:
    * The Producer API allows an application to publish a stream of records to one or more Kafka topics.
    * The Consumer API allows an application to subscribe to one or more topics and process the stream of records produced to them.
    * The Streams API allows an application to act as a stream processor, consuming an input stream from one or more topics and producing an output stream to one or more output topics, effectively transforming the input streams to output streams.
    * The Connector API allows building and running reusable producers or consumers that connect Kafka topics to existing applications or data systems. For example, a connector to a relational database might capture every change to a table.
* For sending messages we will be using the KafkaTemplate which wraps a Producer and provides convenience methods to send data to Kafka topics. 
* The cluster is a grouping of multiple  Kafka  Broker.  This where zookeeper come in. 

THE COMMIT LOG
* the Commit log it primary record of what happened . it continually appends events in the order in which they are received.
topic stores a time-ordered sequence of messages that share the same category.
* The commit log is useful of point of recovery (so you can redo all things that happened in the order in which they happened. It helps with replication and distribution that is useful for redundancy.

GENERAL:
* Apache Kafka is a publish-subscribe messaging as a distributed commit log.
* How Partitions enable work to be reliably distributed. What about fault-tolerance? broker failure , network issue storage failure . (Create a facility enabled through a configuration property to ensure redundancy)
* Replication level set on topic level
* ISR = in sync replicas 
* Kafka do not automatically go out and search for replace peer. 
* if more message producer is needed, the solution is to add more and more producers.  if we need more message retention and redundancy, we add more and more brokers. if we need more metadata management facilities, we add more Zookeeper members. if we need more consumer then we use consumer groups that is collection of individual independent consumer working together.
* Event sourcing is an architectural style to maintaining an application’s state by capturing all changes as a sequence of time-ordered, immutable events.
* offset behaviour, read != committed
* his is nothing more than publish-subscribe semantics where the subscriber is a cluster of consumers instead of a single process.

BROKER
* Broker is a place where Kafka keeps and maintain topics
* The broker is a node in the cluster.
* The topic is a logical name for 1 or more partition.
* Messages and Topics are kept in Broker
* 

KAFKA-SPRNG BOOT AND EMBEDDED KAFKA
* @EnableKafka annotation which enables the detection of the @KafkaListener annotation (and other annotation
* For sending messages we will be using the KafkaTemplate which wraps a Producer and provides convenience methods to send data to Kafka topics. 
* ‘BOOTSTRAP_SERVERS_CONFIG' property that specifies a list of host:port pairs used for establishing the initial connections to the Kafka cluster. 
* The Consumer is nothing more than a simple POJO that defines a method for receiving messages.
* The creation and configuration of the different Spring Beans needed for the Receiver POJO are grouped in the ReceiverConfig class.
* The kafkaListenerContainerFactory() is used by the @KafkaListenerannotation from the Receiver in order to configure a MessageListenerContainer. In order to create it, a ConsumerFactory and accompanying configuration Map is needed.
* GROUP_ID_CONFIG' which allows to identify the group this consumer belongs to.
* Consumers label themselves with a consumer group name, and each record published to a topic is delivered to one consumer instance within each subscribing consumer group.


OTHER
* Messaging traditionally has two models: queuing and publish-subscribe.  In a queue, a pool of consumers may read from a server and each record goes to one of them; in publish-subscribe the record is broadcast to all consumers. Each of these two models has a strength and a weakness. The strength of queuing is that it allows you to divide up the processing of data over multiple consumer instances, which lets you scale your processing. Unfortunately, queues aren't multi-subscriber—once one process reads the data it's gone. Publish-subscribe allows you broadcast data to multiple processes, but has no way of scaling processing since every message goes to every subscriber. The consumer group concept in Kafka generalizes these two concepts. As with a queue the consumer group allows you to divide up processing over a collection of processes (the members of the consumer group). As with publish-subscribe, Kafka allows you to broadcast messages to multiple consumer groups.
*  Kafka as a kind of special purpose distributed filesystem dedicated to high-performance, low-latency commit log storage, replication, and propagation.
* Event Sourcing: An architecture style to maintain application’s state by capturing all changes as a sequence of time-ordereded immutable events.
* High throughput means how system distributes its load and efficiency  process  in parallel 
* 

Source:
* https://www.codenotfound.com/spring-kafka-consumer-producer-example.html



Other:
* @Configurationwhich indicates that the class can be used by the Spring IoC container as a source of bean definitions.
* acks - The number of acknowledgments the producer requires the leader to have received before considering a request complete. 
    * acks=0  producer will not wait for any acknowledgment from the server a
    * acks=1 the leader will write the record to its local log but will respond without awaiting full acknowledgement from all followers.
    * acks=-1 or acks=all his means the leader will wait for the full set of in-sync replicas to acknowledge the record. 
