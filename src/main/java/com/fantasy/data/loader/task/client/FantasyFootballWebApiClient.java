package com.fantasy.data.loader.task.client;

import com.fantasy.football.model.LeagueTeam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;

public interface FantasyFootballWebApiClient {

    @PostExchange(url = "/fantasy/football/v1/league-team/create")
    ResponseEntity<Void> createLeagueTeamPlayer(@RequestBody LeagueTeam leagueTeam);
}