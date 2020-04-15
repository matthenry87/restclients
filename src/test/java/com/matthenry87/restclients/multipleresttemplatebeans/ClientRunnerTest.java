package com.matthenry87.restclients.multipleresttemplatebeans;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ClientRunnerTest {

    @Autowired
    private ClientRunner clientRunner;

    @Test
    void getGoogleHelp_works() {

        // Act
        String response = clientRunner.getGoogleHelp();

        // Assert
        assertNotNull(response);
    }

    @Test
    void getGithubHelp_works() {

        // Act
        String response = clientRunner.getGithubHelp();

        // Assert
        assertNotNull(response);
    }

}