package com.matthenry87.restclients.webclient;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class WebClientRunner {

    private final WebClient googleWebClient;

    public WebClientRunner(WebClient googleWebClient) {

        this.googleWebClient = googleWebClient;
    }

    Mono<String> getGoogleMaps() {

        return googleWebClient.get()
                .uri("/maps")
                .exchange()
                .block()
                .bodyToMono(String.class);
    }

}
