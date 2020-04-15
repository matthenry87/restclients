package com.matthenry87.restclients.privateresttemplate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static reactor.core.publisher.Mono.when;

@SpringBootTest
class GoogleClientTest {

    @Autowired
    private GoogleClient googleClient;

    @Test
    void getGoogleHealth_works() {

        // Act
        String response = googleClient.getGoogleHealth();

        // Assert
        assertNotNull(response);
    }

    @Test
    void getGoogleMaps_works() {

        // Act
        String response = googleClient.getGoogleMaps();

        // Assert
        assertNotNull(response);
    }

}
