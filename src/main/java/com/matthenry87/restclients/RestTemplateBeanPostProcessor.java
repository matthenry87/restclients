package com.matthenry87.restclients;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;

@Configuration
public class RestTemplateBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {

        if (bean instanceof RestTemplate) {

            RestTemplate restTemplate = (RestTemplate) bean;

            restTemplate.setInterceptors(Collections.singletonList(new RestTemplateLoggingInterceptor()));
        }

        return bean;
    }

    @Slf4j
    static class RestTemplateLoggingInterceptor implements ClientHttpRequestInterceptor {

        @Override
        public ClientHttpResponse intercept(
                HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

            String url = request.getURI().toString();

            log.info("Attempting HTTP request to " + url);

            ClientHttpResponse response = execution.execute(request, body);

            log.info("HTTP request successful to  " + url);

            return response;
        }
    }

}
