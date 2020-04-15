package com.matthenry87.restclients.privateresttemplate;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Setter
@Configuration
@ConfigurationProperties(prefix = "googleclient")
class GoogleClientConfig {

    private String url;

    @Bean
    public GoogleClient googleClient(RestTemplateBuilder restTemplateBuilder) {

        RestTemplate restTemplate = restTemplateBuilder.rootUri(url)
                .build();

        return new GoogleClientImpl(restTemplate);
    }

}
