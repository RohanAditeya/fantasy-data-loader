package com.fantasy.data.loader.task.runner;

import com.fantasy.data.loader.task.client.FantasyPremierLeagueApiClient;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MarkerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FantasyApiClientTaskRunner implements ApplicationRunner {

    private final FantasyPremierLeagueApiClient fantasyPremierLeagueApiClient;

    public FantasyApiClientTaskRunner (FantasyPremierLeagueApiClient fantasyPremierLeagueApiClient) {
        this.fantasyPremierLeagueApiClient = fantasyPremierLeagueApiClient;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.atInfo().addMarker(MarkerFactory.getMarker("bootstrap-api-call")).log("Making bootstrap call");
        ResponseEntity<?> response = fantasyPremierLeagueApiClient.getBootstrapData();
        log.atInfo().addMarker(MarkerFactory.getMarker("bootstrap-api-call")).log("Bootstrap call successful");
    }
}