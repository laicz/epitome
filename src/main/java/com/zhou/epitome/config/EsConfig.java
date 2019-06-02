/**
 * Date:     2019/5/921:42
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 2019/5/9  21:42
 * created by zhoumb
 */
@Configuration
public class EsConfig {

    @Bean
    public TransportClient transportClient() throws UnknownHostException {
        Settings settings = Settings.builder()
                .put("cluster.name", "my-application")
                .put("thread_pool.search.size", 5)
                .build();
        TransportClient transportClient = new PreBuiltTransportClient(settings);
        TransportAddress transportAddress = new TransportAddress(InetAddress.getByName("60.205.176.135"), 9300);
        transportClient.addTransportAddress(transportAddress);
        return transportClient;
    }
}
