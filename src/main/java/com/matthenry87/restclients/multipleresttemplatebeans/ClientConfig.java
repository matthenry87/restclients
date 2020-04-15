package com.matthenry87.restclients.multipleresttemplatebeans;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
class ClientConfig {

    @Bean
    RestTemplate googleClient2(RestTemplateBuilder restTemplateBuilder) {

        return restTemplateBuilder.rootUri("https://www.google.com").build();
    }

    @Bean
    RestTemplate githubClient(RestTemplateBuilder restTemplateBuilder) {

        return restTemplateBuilder.rootUri("https://www.github.com").build();
    }

}
