package top.inson.springboot.core;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import top.inson.springboot.web.interceptor.LogRestTemplateInterceptor;

import java.util.Collections;

@Configuration
public class RestTemplateConfiguration {
    @Autowired
    private LogRestTemplateInterceptor logRestTemplateInterceptor;


    @Bean
    @ConditionalOnMissingBean({RestOperations.class, RestTemplate.class})
    public RestOperations restOperations(){
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setReadTimeout(5000);
        requestFactory.setConnectTimeout(5000);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        restTemplate.setInterceptors(Collections.singletonList(logRestTemplateInterceptor));
        return restTemplate;
    }

}
