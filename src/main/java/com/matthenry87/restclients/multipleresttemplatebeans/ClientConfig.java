package com.matthenry87.restclients.multipleresttemplatebeans;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Setter
@Configuration
@ConfigurationProperties("clientconfig")
class ClientConfig {

    private String googleUrl;
    private String githubUrl;

    @Bean
    RestTemplate googleRestTemplate(RestTemplateBuilder restTemplateBuilder) {

        return restTemplateBuilder.rootUri(googleUrl).build();
    }

    @Bean
    RestTemplate githubRestTemplate(RestTemplateBuilder restTemplateBuilder) {

        return restTemplateBuilder.rootUri(githubUrl).build();
    }

}
