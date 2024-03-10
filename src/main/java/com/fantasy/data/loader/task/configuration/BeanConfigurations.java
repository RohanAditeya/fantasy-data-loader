package com.fantasy.data.loader.task.configuration;

import com.fantasy.data.loader.task.client.FantasyPremierLeagueApiClient;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Configuration
public class BeanConfigurations {

    @Bean
    public FantasyPremierLeagueApiClient premierLeagueApiClient (Jackson2ObjectMapperBuilder objectMapperBuilder) {
        RestClient restClient = RestClient.builder().baseUrl("https://fantasy.premierleague.com")
                .messageConverters(
                        converters -> {
                            // Since premier league API sends JSON response in snake case we need to
                            // configure message converter using snake case for the client used to call
                            // premier league API.
                            objectMapperBuilder.propertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
                            converters.add(0, new MappingJackson2HttpMessageConverter(objectMapperBuilder.build()));
                        }
                ).build();
        RestClientAdapter restClientAdapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory serviceProxyFactory = HttpServiceProxyFactory.builderFor(restClientAdapter).build();
        return serviceProxyFactory.createClient(FantasyPremierLeagueApiClient.class);
    }
}