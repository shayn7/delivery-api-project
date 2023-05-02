package com.naamad.deliveryapiproject.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@PropertySource("external-rest-provider.properties")
public class WebClientConfiguration {

    @Bean
    public WebClient webClient(@Value("${base-url}") String baseUrl){
        return WebClient
                .builder()
                .baseUrl(baseUrl)
                .build();
    }
}
