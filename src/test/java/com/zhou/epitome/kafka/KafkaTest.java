/**
 * Date:     2019/6/523:55
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

/**
 * 2019/6/5  23:55
 * created by zhoumb
 */
public class KafkaTest {
    private KafkaProducer<String, String> kafkaProducer;

    @Before
    public void createClient() {
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "60.205.176.135:9092");
        kafkaProps.put("key.serializer", StringSerializer.class.getName());
        kafkaProps.put("value.serializer", StringSerializer.class.getName());
        kafkaProducer = new KafkaProducer<>(kafkaProps);
    }

    @Test
    public void testToPosition(){
        System.out.println(toPosition(-1));
        System.out.println(Integer.MAX_VALUE);
    }

    private int toPosition(int target){
        return target & 0x7fffffff;
    }
}
