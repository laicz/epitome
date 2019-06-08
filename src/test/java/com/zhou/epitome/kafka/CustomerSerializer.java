/**
 * Date:     2019/6/810:13
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.kafka;

import com.zhou.epitome.kafka.model.Customer;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

/**
 * 自定义序列化工具
 * 2019/6/8  10:13
 * created by zhoumb
 */
public class CustomerSerializer implements Serializer<Customer> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        
    }

    @Override
    public byte[] serialize(String topic, Customer data) {
        return new byte[0];
    }

    @Override
    public void close() {

    }
}
