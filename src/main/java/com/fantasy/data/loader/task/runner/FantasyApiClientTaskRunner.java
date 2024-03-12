package com.fantasy.data.loader.task.runner;

import com.fantasy.data.loader.task.client.FantasyPremierLeagueApiClient;
import com.fantasy.data.loader.task.model.ApiClientResponseDTO;
import com.fantasy.data.loader.task.service.LeagueTeamService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MarkerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.fantasy.data.loader.task.utils.ServiceConstants.BOOTSTRAP_CALL_LOG_MARKER;

@Slf4j
@Component
public class FantasyApiClientTaskRunner implements ApplicationRunner {

    private final FantasyPremierLeagueApiClient fantasyPremierLeagueApiClient;
    private final LeagueTeamService leagueTeamService;

    public FantasyApiClientTaskRunner (FantasyPremierLeagueApiClient fantasyPremierLeagueApiClient, LeagueTeamService leagueTeamService) {
        this.fantasyPremierLeagueApiClient = fantasyPremierLeagueApiClient;
        this.leagueTeamService = leagueTeamService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ResponseEntity<ApiClientResponseDTO.BootstrapApiResponseDTO> response = fantasyPremierLeagueApiClient.getBootstrapData();
        log.atInfo().addMarker(MarkerFactory.getMarker(BOOTSTRAP_CALL_LOG_MARKER)).log("Bootstrap call successful");
        leagueTeamService.convertAndWriteLeagueTeamRecords(Optional.ofNullable(response.getBody()).orElseThrow().teams());
    }
}