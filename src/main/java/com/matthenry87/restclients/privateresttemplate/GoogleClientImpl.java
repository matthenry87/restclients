package com.matthenry87.restclients.privateresttemplate;

import org.springframework.web.client.RestOperations;

class GoogleClientImpl implements GoogleClient {

    private final RestOperations restOperations;

    public GoogleClientImpl(RestOperations restOperations) {

        this.restOperations = restOperations;
    }

    @Override
    public String getGoogleHealth() {

        return restOperations.getForObject("/health", String.class);
    }

    @Override
    public String getGoogleMaps() {

        return restOperations.getForObject("/maps", String.class);
    }

}
