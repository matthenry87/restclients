package com.matthenry87.restclients.privateresttemplate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
class GoogleClientConfig {

    @Bean
    public GoogleClient googleClient(RestTemplate googleRestTemplate) {

        return new GoogleClientImpl(googleRestTemplate);
    }

}
