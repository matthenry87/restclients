package com.matthenry87.restclients.webclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient googleWebClient() {

        return WebClient.builder()
                .baseUrl("https://www.google.com")
                .build();
    }

}
