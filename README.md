# rest-client-demo

This project contains examples of REST Clients.

## Client w/ Private RestTemplate

In the configuration class GoogleClientConfig, you will see that a GoogleClient bean is configured with a private 
RestTemplate (created using the RestTemplateBuilder bean). This allows us to create an easy to use method for each 
operation on the target service, and also allows us to create granular tests for each of those said client operations 
specific to this GoogleClient class.

### AOP Exception Handling
Inside of GoogleClientImpl, you will notice that the first method has a try/catch inside of it, and the second one 
doesn't. The second method is surrounded by AOP defined inside of ExceptionHandlerAdvice which allows us to handle
this cross-cutting concern instead of having a try/catch in each method. This also gives us an opportunity to capture 
metrics or do some logging.

## Multiple RestTemplate Beans

In the multipleresttemplatebeans package, you will see that ClientConfig class offers up 2 beans that are both 
RestTemplate types. Note that he name of the method offering up the bean becomes the name of the bean.

This approach allows up to manipulate the beans as they are produced from the BeanFactory using a BeanPostProcessor, for 
example if you wanted to add some logging interceptor to every bean of a certain type (or manipulate/modify them).

## Web Client

The WebClient is the replacement for RestTemplate, as RestTemplate will be deprecated in the future (not in the near 
future, but all new features will be built into WebClient instead going forward). WebClient comes from the Spring 
Reactive WebFlux project, and Spring/Pivotal recommends using WebClient as a developer's first exposure to Spring
Reactive.

WebClient is non-blocking by default (in Reactive threads don't block, so you only need 4 of them), so while using
WebClient in a Spring MVC project, you need to explicitly block in order to stop program execution until the response 
comes back.

As a side note, if you have both Spring MVC(spring-starter-web) and Spring WebFlux(spring-boot-starter-webflux) on your 
classpath, Spring Boot will know that you want to use Spring MVC as your web layer and still have the ability to use 
the more modern WebClient.