package com.example.demo.nokia.configuration;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;

@Configuration
public class WebClientConfiguration {



    public ExchangeFilterFunction exchangeFilterFunction() {
        ExchangeFilterFunction exchangeFilterFunction=(clientRequest,nextFilter)-> {
            final HttpMethod method = clientRequest.method();
            if(method==HttpMethod.GET) {
                System.out.println("GET Called");
                System.out.println("clientRequest"+clientRequest.toString());
            } else if (method==HttpMethod.POST) {
                System.out.println("POST Called");
                System.out.println("clientRequest"+clientRequest.body());
            }
            return nextFilter.exchange(clientRequest);
        };

        return exchangeFilterFunction;
    }

    @Bean(name = "webClient")
    @Primary
    public WebClient webClient() {
        System.out.println("wih ssl called");
        final int size = 30 * 1024 * 1024;
        final ExchangeStrategies strategies = ExchangeStrategies.builder()
                .codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(size))
                .build();
        final WebClient build = WebClient.builder()
                .exchangeStrategies(strategies)
                .filter(exchangeFilterFunction())
                .build();
        return  build;
    }

    @Bean(name = "webClientDisablessl")
    public WebClient webClientDisablessl() {
        System.out.println("Disabele called");

        try {
            SslContext  sslContext = SslContextBuilder
                    .forClient()
                    .trustManager(InsecureTrustManagerFactory.INSTANCE)
                    .build();
            HttpClient httpClient = HttpClient.create().secure(t -> t.sslContext(sslContext));
            final int size = 30 * 1024 * 1024;
            final ExchangeStrategies strategies = ExchangeStrategies.builder()
                    .codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(size))
                    .build();
            final WebClient build = WebClient.builder()
                    .exchangeStrategies(strategies)
                    .filter(exchangeFilterFunction())
                    .clientConnector(new ReactorClientHttpConnector(httpClient))
                    .build();
            return build;
        }
        catch (SSLException e) {
            throw new RuntimeException(e);
        }
    }


}
