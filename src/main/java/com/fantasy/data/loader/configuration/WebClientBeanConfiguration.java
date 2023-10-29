package com.fantasy.data.loader.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientBeanConfiguration {

    private final String FANTASY_API_URL = "https://fantasy.premierleague.com/api/bootstrap-static/";

    @Bean
    public WebClient fantasyApiClient () {
        return WebClient.builder()
                .baseUrl(FANTASY_API_URL)
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(2 * 1024 * 1024))
                .build();
    }
}