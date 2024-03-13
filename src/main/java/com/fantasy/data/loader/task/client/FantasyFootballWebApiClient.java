package com.fantasy.data.loader.task.client;

import com.fantasy.football.model.LeagueTeam;
import com.fantasy.football.model.PlayerBasicInformation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;

public interface FantasyFootballWebApiClient {

    @PostExchange(url = "/fantasy/football/v1/league-team/create")
    ResponseEntity<Void> createLeagueTeam(@RequestBody LeagueTeam leagueTeam);
    @PostExchange(url = "/fantasy/football/v1/league-player/create")
    ResponseEntity<Void> createLeaguePlayer(@RequestBody PlayerBasicInformation playerBasicInformation);
}