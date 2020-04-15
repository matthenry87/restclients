package com.matthenry87.restclients.privateresttemplate;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;

@Aspect
@Component
public class ExceptionHandlerAdvice {

    @Around("execution(String com.matthenry87.restclients.privateresttemplate.GoogleClient.getGoogleMaps())")
    public String handleGoogleClientException(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        String string;

        try {

            string = (String) proceedingJoinPoint.proceed();

        } catch (HttpStatusCodeException e) {

            throw new GoogleClientException(e.getMessage(), e.getRawStatusCode());
        }

        return string;
    }

}
