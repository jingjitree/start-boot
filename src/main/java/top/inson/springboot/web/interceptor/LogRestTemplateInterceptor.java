package top.inson.springboot.web.interceptor;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Log4j2
@Component
public class LogRestTemplateInterceptor implements ClientHttpRequestInterceptor {


    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        traceRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        traceResponse(response);
        return response;
    }

    private void traceRequest(HttpRequest request, byte[] body) throws IOException{
        log.info("请求地址url:{}", request.getURI());
        log.info("请求方法method:{}", request.getMethod());
        log.info("请求头headers:{}", request.getHeaders());
        log.info("请求参数request body:{}", new String(body, "UTF-8"));
    }

    private void traceResponse(ClientHttpResponse response) throws IOException{
        StringBuilder builder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getBody(), "UTF-8"));
        String line = bufferedReader.readLine();
        while (line != null) {
            builder.append(line);
            builder.append('\n');
            line = bufferedReader.readLine();
        }
        log.info("响应状态码status code：{}", response.getStatusCode());
        log.info("响应头headers：{}", response.getHeaders());
        log.info("响应结果body：{}", builder.toString());
    }
}
