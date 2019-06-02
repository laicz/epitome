/**
 * Date:     2019/5/921:14
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.elastic;

import com.alibaba.fastjson.JSON;
import com.zhou.epitome.EpitomeApplication;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.delete.DeleteRequestBuilder;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequestBuilder;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetItemResponse;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.recycler.Recycler;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryAction;
import org.elasticsearch.index.reindex.DeleteByQueryRequestBuilder;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * 2019/5/9  21:14
 * created by zhoumb
 */
@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EpitomeApplication.class)
public class ElasticSearchTest {

    @Autowired
    private TransportClient transportClient;

    @Test
    public void init() {
        System.out.println(transportClient);
        IndicesExistsResponse indicesExistsResponse = transportClient.admin().indices()
                .exists(new IndicesExistsRequest("javaapi")).actionGet();
        System.out.println(indicesExistsResponse.isExists());
    }

    @Test
    public void addMap() {
        Calendar instance = Calendar.getInstance();
        for (int i = 0; i < 100000; i++) {
            instance.add(Calendar.MINUTE, i);
            Map<String, Object> maps = new HashMap<>();
            maps.put("insertType", "java api" + i);
            maps.put("ctime", instance.getTime());
            maps.put("fields", 3);
            //准备数据进行写入
            IndexRequestBuilder indexRequestBuilder = transportClient.prepareIndex("javaapi", "java").setSource(maps);
            IndexResponse indexResponse = indexRequestBuilder.get();
            RestStatus status = indexResponse.status();
            System.out.println(status.getStatus());
            System.out.println(indexResponse.getId());
        }

    }

    @Test
    public void addString() {
        Map<String, Object> maps = new HashMap<>();
        maps.put("insertType", "java api1");
        maps.put("ctime", new Date());
        maps.put("fields", 3);
        String json = JSON.toJSONString(maps);
        IndexRequestBuilder indexRequestBuilder = transportClient.prepareIndex("javaapi", "java");
        indexRequestBuilder.setSource(json, XContentType.JSON);
        //使用方法get将结果进行提交
        IndexResponse indexResponse = indexRequestBuilder.get();
        RestStatus status = indexResponse.status();
        System.out.println(status.getStatus());
    }

    @Test
    public void deleteTest() {
        DeleteRequestBuilder deleteRequestBuilder = transportClient.prepareDelete("javaapi", "java", "tZAbnWoBkaAYOGhy-Hp2");
        DeleteResponse deleteResponse = deleteRequestBuilder.get();
        System.out.println(deleteResponse.status());
    }

    /**
     * 先获取，在删除
     */
    @Test
    public void deleteUpdateTest() {
        DeleteByQueryRequestBuilder deleteByQueryRequestBuilder = new DeleteByQueryRequestBuilder(transportClient, DeleteByQueryAction.INSTANCE);
        BulkByScrollResponse response = deleteByQueryRequestBuilder.filter(QueryBuilders.matchQuery("insertType", "java api"))
                .source("javaapi")  //指定 index
                .get();
        long deleted = response.getDeleted();
        System.out.println(deleted);
    }

    @Test
    public void updateTest() throws ExecutionException, InterruptedException {
        String index = "javaapi";
        String type = "java";
        String id = "n5AqnWoBkaAYOGhyFXs1";
        Map<String, Object> source = transportClient.prepareGet(index, type, id).get().getSource();
        System.out.println(source);

        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.index(index);
        updateRequest.type(type);
        updateRequest.id(id);
        Date date = (Date) source.get("ctime");
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.HOUR, 10);
        Map<String, Date> update = new HashMap<>();
        update.put("ctime", instance.getTime());
        updateRequest.doc(update);
        UpdateResponse updateResponse = transportClient.update(updateRequest).get();
        System.out.println(updateResponse.getGetResult().getSource());
    }

    private static final String index = "haizhi_test";
    private static final String type = "haizhi_type";

    @Test
    public void multiGetApi() {
        MultiGetResponse response = transportClient.prepareMultiGet()
                .add(index, type, "eZB2tWoBkaAYOGhyOdmI")
                .add(index, type, "this is set source id ", "fpCHtWoBkaAYOGhyiNms", "fJB_tWoBkaAYOGhyptnY")
                .add("books", "book", "BDYFmGoBcbRZfGek3bM8")
                .get();
        for (MultiGetItemResponse multiGetItemResponse : response) {
            System.out.println("--------------------------------");
            GetResponse itemResponse = multiGetItemResponse.getResponse();
            if (itemResponse.isExists()) {
                Map<String, Object> sourceAsMap = itemResponse.getSourceAsMap();
                for (Map.Entry entry : sourceAsMap.entrySet()) {
                    System.out.println(entry.getKey() + " : " + entry.getValue());
                }
            }
        }
    }
}
