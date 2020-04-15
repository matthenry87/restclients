package com.matthenry87.restclients.privateresttemplate;

import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestOperations;

class GoogleClientImpl implements GoogleClient {

    private final RestOperations restOperations;

    public GoogleClientImpl(RestOperations restOperations) {

        this.restOperations = restOperations;
    }

    @Override
    public String getGoogleHealth() {

        String response;

        try {

            response = restOperations.getForObject("/health", String.class);

        } catch (HttpStatusCodeException e) {

            throw new GoogleClientException(e.getMessage(), e.getRawStatusCode());
        }

        return response;
    }

    @Override
    public String getGoogleMaps() {

        return restOperations.getForObject("/maps", String.class);
    }

}
