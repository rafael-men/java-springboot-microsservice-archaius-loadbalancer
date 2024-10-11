package com.erudio.book_service.Controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Tag(name = "foobar endpoint")
@RestController
@RequestMapping("book-service")
public class FooBarController {

    private Logger logger = LoggerFactory.getLogger(FooBarController.class);

    @Operation(summary = "Requests a foo-bar")
    @GetMapping("/foo-bar")
    @CircuitBreaker(name = "default",fallbackMethod = "fallbackMethod")
    public String fooBar() {
        logger.info("Request foo-bar");
        var response = new RestTemplate().getForEntity("http://localhost:8080/foo-bar",String.class);
        return response.getBody();
    }

    public String fallbackMethod(Exception ex) {
        return "Fallback Foobar";
    }
}
