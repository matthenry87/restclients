package com.matthenry87.restclients;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public
class WebServiceException extends RuntimeException {

    private final int httpStatusCode;

    public WebServiceException(String message, int httpStatusCode) {
        super(message);

        this.httpStatusCode = httpStatusCode;
    }

}
