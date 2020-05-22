package top.inson.springboot;

import com.google.common.collect.Maps;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestOperations;

import java.util.Map;

@Log4j2
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRestTemplate {
    @Autowired
    private RestOperations restOperations;


    @Test
    public void testOperaGet(){
        String reqUrl = "https://restapi.amap.com/v3/weather/weatherInfo?key={key}&city={adcode}&extensions={extensions}&output={output}";
        Map<String, Object> reqParams = Maps.newHashMap();
        reqParams.put("key", "9f56c704bd6c5a10c0378bc93dd06303");
        reqParams.put("adcode", "440000");
        reqParams.put("extensions", "all");
        reqParams.put("output", "JSON");

        /*ResponseEntity<Object> resEntity = restOperations.getForEntity(reqUrl, Object.class, reqParams);
        String resJson = JSON.toJSONString(resEntity.getBody());
        log.info("resJson:{}", resJson);*/
        //{"status":"1","count":"1","info":"OK","infocode":"10000","forecasts":[{"city":"东莞市","adcode":"441900","province":"广东","reporttime":"2020-05-22 11:22:39","casts":[{"date":"2020-05-22","week":"5","dayweather":"暴雨","nightweather":"阴","daytemp":"29","nighttemp":"24","daywind":"无风向","nightwind":"无风向","daypower":"≤3","nightpower":"≤3"},{"date":"2020-05-23","week":"6","dayweather":"阴","nightweather":"阴","daytemp":"28","nighttemp":"23","daywind":"无风向","nightwind":"无风向","daypower":"≤3","nightpower":"≤3"},{"date":"2020-05-24","week":"7","dayweather":"中雨","nightweather":"雷阵雨","daytemp":"30","nighttemp":"24","daywind":"无风向","nightwind":"无风向","daypower":"≤3","nightpower":"≤3"},{"date":"2020-05-25","week":"1","dayweather":"雷阵雨","nightweather":"雷阵雨","daytemp":"30","nighttemp":"24","daywind":"无风向","nightwind":"无风向","daypower":"≤3","nightpower":"≤3"}]}]}
        String resObj = restOperations.getForObject(reqUrl, String.class, reqParams);
        log.info("resObj:{}", resObj);
    }

    @Test
    public void getRest(){
        //ip定位查询
        String reqUrl = "https://restapi.amap.com/v3/ip?key={key}&ip={ip}&output={output}";
        Map<String, Object> reqParams = Maps.newHashMap();
        reqParams.put("key", "9f56c704bd6c5a10c0378bc93dd06303");
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


}
