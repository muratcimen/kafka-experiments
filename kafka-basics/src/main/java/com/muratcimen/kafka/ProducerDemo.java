package com.muratcimen.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ProducerDemo {

    private static final Logger log = LoggerFactory.getLogger(ProducerDemo.class.getSimpleName());

    public static void main(String[] args) {
        System.out.println("Hello world");

        // create Producer Properties
        Properties properties = new Properties();
        // connect to Localhost
        properties.setProperty("bootstrap.servers", "localhost:9092");
        //connect to Remote Server
//      properties.setProperty("security.protocol","SASL_SSL");
//      properties.setProperty("sasl.jaas.config","");
//      properties.setProperty("sasl.mechanism","PLAIN");

        //set producer properties
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());

        //create the Producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        //create a Producer Record
        ProducerRecord<String, String> producerRecord =
                new ProducerRecord<>("demo_java", "hello world");

        //send data
        producer.send(producerRecord);

        //tell the producer to send all data and block until done -- synchronous
        producer.flush();

        //flush  and close the producer
        producer.close();
    }
}

