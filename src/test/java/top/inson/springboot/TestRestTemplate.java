package top.inson.springboot;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestOperations;

import java.util.List;
import java.util.Map;

@Log4j2
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRestTemplate {
    @Autowired
    private RestOperations restOperations;




    private String signKey = "a6cad2ecae3357e7ad90980eae75cf73";
    private String baseUrl = "https://restapi.amap.com";
    private String productKey = "9f56c704bd6c5a10c0378bc93dd06303";

    @Test
    public void testOperaGet(){
        String reqUrl = baseUrl + "/v3/weather/weatherInfo?key={key}&city={adcode}&extensions={extensions}&output={output}";
        Map<String, Object> reqParams = Maps.newHashMap();
        reqParams.put("key", productKey);
        reqParams.put("adcode", "440000");
        reqParams.put("extensions", "all");
        reqParams.put("output", "JSON");

        ResponseEntity<String> resEntity = restOperations.getForEntity(reqUrl, String.class, reqParams);
        log.info("resJson:{}", resEntity.getBody());
        //{"status":"1","count":"1","info":"OK","infocode":"10000","forecasts":[{"city":"东莞市","adcode":"441900","province":"广东","reporttime":"2020-05-22 11:22:39","casts":[{"date":"2020-05-22","week":"5","dayweather":"暴雨","nightweather":"阴","daytemp":"29","nighttemp":"24","daywind":"无风向","nightwind":"无风向","daypower":"≤3","nightpower":"≤3"},{"date":"2020-05-23","week":"6","dayweather":"阴","nightweather":"阴","daytemp":"28","nighttemp":"23","daywind":"无风向","nightwind":"无风向","daypower":"≤3","nightpower":"≤3"},{"date":"2020-05-24","week":"7","dayweather":"中雨","nightweather":"雷阵雨","daytemp":"30","nighttemp":"24","daywind":"无风向","nightwind":"无风向","daypower":"≤3","nightpower":"≤3"},{"date":"2020-05-25","week":"1","dayweather":"雷阵雨","nightweather":"雷阵雨","daytemp":"30","nighttemp":"24","daywind":"无风向","nightwind":"无风向","daypower":"≤3","nightpower":"≤3"}]}]}
        String resObj = restOperations.getForObject(reqUrl, String.class, reqParams);
        log.info("resObj:{}", resObj);
    }

    @Test
    public void getRest(){
        //ip定位查询
        String reqUrl = baseUrl + "/v3/ip?key={key}&ip={ip}&output={output}";
        Map<String, Object> reqParams = Maps.newHashMap();
        reqParams.put("key", productKey);
        //reqParams.put("ip", "14.221.237.27");
        reqParams.put("ip", "14.30.24.246");
        reqParams.put("output", "JSON");

        /*ResponseEntity<Object> resEntity = restOperations.getForEntity(reqUrl, Object.class, reqParams);
        log.info("res:{}", resEntity);
        HttpHeaders headers = resEntity.getHeaders();
        log.info("headers:{}", headers);
        log.info("contentType:" + headers.getContentType());
        log.info("resBody:{}", JSON.toJSONString(resEntity.getBody()));*/
        //{"status":"1","info":"OK","infocode":"10000","province":"广东省","city":"东莞市","adcode":"441900","rectangle":"113.6608279,22.94255637;113.837328,23.09629277"}
        String resObj = restOperations.getForObject(reqUrl, String.class, reqParams);
        log.info("resObj:{}", resObj);
        //{"status":"1","info":"OK","infocode":"10000","province":"广东省","city":"广州市","adcode":"440000","rectangle":"113.1017375,22.93212254;113.6770499,23.3809537"}
    }

    @Test
    public void postNews(){
        String reqUrl = "http://139.159.217.58:7777/tgjf-report-web-report/v3/uploadRecord/addData";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Map<String, Object> reqMap = Maps.newHashMap();
        reqMap.put("beginDate", "2020-04-1");
        reqMap.put("endDate", "2020-04-7");
        List<String> repChannelIds = Lists.newArrayList();
        repChannelIds.add("WFT-WYF-ZFB_287550057025");
        reqMap.put("repChannelIds", repChannelIds);
        reqMap.put("isAll", "0");

        String reqJson = JSON.toJSONString(reqMap);
        HttpEntity<String> entity = new HttpEntity<>(reqJson, headers);

        ResponseEntity<String> resObj = restOperations.exchange(reqUrl, HttpMethod.POST, entity, String.class);
        log.info("响应结果resObj：{}", resObj.getBody());
        String resObj2 = restOperations.postForObject(reqUrl, entity, String.class, reqJson);
        log.info("resObj2:{}", resObj2);
    }


}
