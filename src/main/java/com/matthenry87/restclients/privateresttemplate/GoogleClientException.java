package com.matthenry87.restclients.privateresttemplate;

import com.matthenry87.restclients.WebServiceException;
import lombok.Getter;

/* Any exception thrown by a web service client will supply the http status code, the
 error message, and the source of the response. This way we have 1 ExceptionHandler
  for all web service client errors */
@Getter
class GoogleClientException extends WebServiceException {

    private final String source = "Google";

    public GoogleClientException(String message, int httpStatusCode) {
        super(message, httpStatusCode);
    }

}
