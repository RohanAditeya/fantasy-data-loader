package com.fantasy.data.loader.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class FantasyApiResponse {
    private List<LeagueTeams> teams;
    @JsonProperty(value = "elements")
    private List<LeaguePlayers> players;
}