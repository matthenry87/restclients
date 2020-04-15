package com.matthenry87.restclients.webclient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class WebClientRunnerTest {

    @Autowired
    private WebClientRunner webClientRunner;

    @Test
    void getGoogleMaps() {

        // Act
        String response = webClientRunner.getGoogleMaps().block();

        // Assert
        assertNotNull(response);
    }

}
