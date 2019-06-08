/**
 * Date:     2019/6/523:55
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.kafka;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

/**
 * 2019/6/5  23:55
 * created by zhoumb
 */
public class KafkaTest {
    private KafkaProducer<String, String> kafkaProducer;
    private KafkaConsumer<String, String> kafkaConsumer;
    private static final String TOPIC_NAME = "test1";

    @Before
    public void createClient() {
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "60.205.176.135:9092");
        kafkaProps.put("key.serializer", StringSerializer.class.getName());
        kafkaProps.put("value.serializer", StringSerializer.class.getName());
        kafkaProducer = new KafkaProducer<>(kafkaProps);
        kafkaProps.remove("key.serializer");
//        kafkaConsumer = new KafkaConsumer<>(kafkaProps);
    }

    @Test
    public void testToPosition() {
        System.out.println(toPosition(-1));
        System.out.println(Integer.MAX_VALUE);
    }

    /**
     * 发送消息至不存在的topic中
     * 会同时创建kafka的topic
     */
    @Test
    public void testSendNotExistsTopic() {
        ProducerRecord<String, String> record = new ProducerRecord<>("not_exists_topic", "test_key1", "test_value");
        kafkaProducer.send(record);
    }

    /**
     * 同步发送数据
     * 特点：
     * 低延时
     * 低吞吐率
     * 无数据丢失
     */
    @Test
    public void testSyncSendMessage() {
        ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME, "key1", "value1");

        try {
            //同步发送数据并返回回调
            //如果发生异常且
            RecordMetadata recordMetadata = kafkaProducer.send(record).get();
            System.out.println("offset:" + recordMetadata.offset() + " : hasOffset:" + recordMetadata.hasOffset());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * 异步发送消息
     */
    private CountDownLatch countDownLatch = new CountDownLatch(1);

    @Test
    public void asyncSendMessage() throws InterruptedException {
        ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME, "async_send_message_key", "async_send_message_value");
        long currentTimeMillis = System.currentTimeMillis();
        kafkaProducer.send(record, new DemoProducerCallback());
        countDownLatch.await();
        System.out.println(System.currentTimeMillis() - currentTimeMillis);
    }

    /**
     * 异步发送消息回调
     */
    class DemoProducerCallback implements Callback {

        @Override
        public void onCompletion(RecordMetadata metadata, Exception exception) {
            if (Objects.nonNull(metadata)) {
                System.out.println("offset:" + metadata.offset() + " : hasOffset:" + metadata.hasOffset());
            }
            if (Objects.nonNull(exception)) {
                exception.printStackTrace();
            }
            countDownLatch.countDown();
        }
    }

    @Test
    public void testConsumer() {
        Map<String, List<PartitionInfo>> stringListMap = kafkaConsumer.listTopics();
        stringListMap.forEach((key, partitionInfos) -> {
            System.out.println("----------------------------");
            partitionInfos.forEach(info -> {
                System.out.println("key:" + key + ",partition:" + info.partition() + ",relic " + info.replicas());
            });
        });
    }

    private int toPosition(int target) {
        return target & 0x7fffffff;
    }
}
