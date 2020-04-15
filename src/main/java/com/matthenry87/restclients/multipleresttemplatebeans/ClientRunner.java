package com.matthenry87.restclients.multipleresttemplatebeans;

import com.matthenry87.restclients.WebServiceException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Component
public class ClientRunner {

    private final RestTemplate googleClient2;
    private final RestTemplate githubClient;

    public ClientRunner(RestTemplate googleClient2, RestTemplate githubClient) {

        this.googleClient2 = googleClient2;
        this.githubClient = githubClient;
    }

    String getGoogleHelp() {

        try {

            return googleClient2.getForObject("/health", String.class);

        } catch (HttpStatusCodeException e) {

            throw new WebServiceException(e.getMessage(), e.getRawStatusCode());
        }
    }

    String getGithubHelp() {

        try {

            return githubClient.getForObject("/health", String.class);

        } catch (HttpStatusCodeException e) {

            throw new WebServiceException(e.getMessage(), e.getRawStatusCode());
        }
    }

}
