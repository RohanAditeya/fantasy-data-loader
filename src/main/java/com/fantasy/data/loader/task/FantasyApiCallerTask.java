package com.fantasy.data.loader.task;

import com.fantasy.data.loader.dto.FantasyApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class FantasyApiCallerTask implements ApplicationRunner {

    private final WebClient fantasyWebClient;

    public FantasyApiCallerTask (WebClient fantasyWebClient) {
        this.fantasyWebClient = fantasyWebClient;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Mono<FantasyApiResponse> responseMono = fantasyWebClient.get().retrieve()
                .bodyToMono(FantasyApiResponse.class);
        FantasyApiResponse response = responseMono.block();
        log.info("Got response from Fantasy API");
    }
}