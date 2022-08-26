package com.example.demo.nokia.routerhandler;

import com.example.demo.nokia.handler.HelloHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
@Configuration(proxyBeanMethods = false)
public class Routerhandler {

    @Bean
    public RouterFunction<ServerResponse> hellohandler(HelloHandler helloHandler) {
        System.out.println("called");
        return RouterFunctions.route(GET("/hello").and(accept(MediaType.APPLICATION_JSON)),helloHandler::helloTest);

    }
}
