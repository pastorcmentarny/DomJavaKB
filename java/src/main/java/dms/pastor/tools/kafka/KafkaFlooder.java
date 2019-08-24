package dms.pastor.tools.kafka;

import dms.pastor.utils.file.TextFileUtils;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaFlooder {
    private static final String TOPIC = "argos-local-notifications-email-v1";
    //private static final String KAFKA_SERVER = "localhost:9092";
    private static final String KAFKA_SERVER = "dxaa2kafbrok01:9093,dxaa2kafbrok02:9093,dxaa2kafbrok03:9093";

    public static void fire(String topic, String kafkaServer, String content) {
        Producer<String, String> kafkaProducer = new KafkaProducer<>(getProperties(kafkaServer));
        kafkaProducer.send(new ProducerRecord<>(topic, content));
        kafkaProducer.close();

    }


    private static Properties getProperties(String kafkaServer) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
        props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "PLAINTEXT");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        return props;
    }


    public static void main(String[] args) {
        final var payload = TextFileUtils.loadFileFromResourceAsString("data/json/kafka.json");
        long start = System.currentTimeMillis();

        fire(TOPIC, KAFKA_SERVER, payload);

        long end = System.currentTimeMillis();

        System.out.println("It took" + (end - start) + "ms");
    }
}
