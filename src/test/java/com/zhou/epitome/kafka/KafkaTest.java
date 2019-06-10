/**
 * Date:     2019/6/523:55
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.kafka;

import com.google.common.collect.ImmutableList;
import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.util.*;
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

    /**
     * 获取kafka生产者
     */
    @Before
    public void createProducer() {
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "60.205.176.135:9092");
        kafkaProps.put("key.serializer", StringSerializer.class.getName());
        kafkaProps.put("value.serializer", StringSerializer.class.getName());
        kafkaProps.put("linger.ms", 10000L);
        kafkaProducer = new KafkaProducer<>(kafkaProps);
        kafkaProps.remove("key.serializer");
    }

    /**
     * 获取kafka消费者
     */
    @Before
    public void createConsumer() {
        kafkaConsumer = getKafkaConsumer("test_group", TOPIC_NAME);
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
    public void testSendNotExistsTopic() throws InterruptedException {
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

    /**
     * Rebalance：当发生rebalance时，如果存在还有被消费的offset还没有被提交，容易发生重复读的情况，需要在rebalance之前将offset进行提交
     */
    @Test
    public void rollPollTopic() {
        kafkaConsumer.subscribe(Collections.singleton(TOPIC_NAME), new ConsumerRebalanceListener() {
            /**
             * 该方法会在消费者停止读取数据之后，broker重新分配(reloadBalance)之前调用
             * @param partitions
             */
            @Override
            public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
                kafkaConsumer.commitSync();
            }

            /**
             * 该方法会在broker重新分配之后，消费者重新读取数据之前调用
             * @param partitions
             */
            @Override
            public void onPartitionsAssigned(Collection<TopicPartition> partitions) {

            }
        });
        while (true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(100L));
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("--------------------------------------------------------------------------------------------");
                System.out.println("key[" + record.key() + "]  :  value[" + record.value() + "]   :  offset[" + record.offset() + "]   :   partition:[" + record.partition() + "]");
                kafkaConsumer.commitSync();
            }
        }
    }

    @Test
    public void syncAndAsyncCommit() {
        kafkaConsumer.subscribe(ImmutableList.of(TOPIC_NAME));
        while (true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(100L));
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("--------------------------------------------------------------------------------------------");
                System.out.println("key[" + record.key() + "]  :  value[" + record.value() + "]   :  offset[" + record.offset() + "]   :   partition:[" + record.partition() + "]");
            }
            //处理完所有的业务，同步提交offset
            try {
                kafkaConsumer.commitSync();
            } catch (Exception e) {
                //如果发生异常，则异步提交offset，异步提交不会重试
                kafkaConsumer.commitAsync();
            }
        }
    }

    private int toPosition(int target) {
        return target & 0x7fffffff;
    }

    public KafkaConsumer getKafkaConsumer(final String groupId, String... topicName) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "60.205.176.135:9092");
        properties.put("group.id", groupId);
        properties.put("key.deserializer", StringDeserializer.class.getName());
        properties.put("value.deserializer", StringDeserializer.class.getName());
        return new KafkaConsumer<>(properties);
    }
}
