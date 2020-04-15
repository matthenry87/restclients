package com.matthenry87.restclients.multipleresttemplatebeans;

import com.matthenry87.restclients.WebServiceException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Component
public class ClientRunner {

    private final RestTemplate googleRestTemplate;
    private final RestTemplate githubRestTemplate;

    public ClientRunner(RestTemplate googleRestTemplate, RestTemplate githubRestTemplate) {

        this.googleRestTemplate = googleRestTemplate;
        this.githubRestTemplate = githubRestTemplate;
    }

    String getGoogleHelp() {

        try {

            return googleRestTemplate.getForObject("/health", String.class);

        } catch (HttpStatusCodeException e) {

            throw new WebServiceException(e.getMessage(), e.getRawStatusCode());
        }
    }

    String getGithubHelp() {

        try {

            return githubRestTemplate.getForObject("/health", String.class);

        } catch (HttpStatusCodeException e) {

            throw new WebServiceException(e.getMessage(), e.getRawStatusCode());
        }
    }

}
