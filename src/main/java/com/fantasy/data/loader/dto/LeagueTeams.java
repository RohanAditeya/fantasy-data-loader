package com.fantasy.data.loader.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LeagueTeams {
    private int code;
    private int draw;
    private String form;
    private int id;
    private int loss;
    private String name;
    private int played;
    private int points;
    private int position;
    @JsonProperty(value = "short_name")
    private String shortName;
    private int strength;
    @JsonProperty(value = "team_division")
    private String teamDivision;
    private boolean unavailable;
    private int win;
    @JsonProperty(value = "pulse_id")
    private int pulseId;
    @JsonProperty(value = "strength_overall_home")
    private int strengthOverallHome;
    @JsonProperty(value = "strength_overall_away")
    private int strengthOverallAway;
    @JsonProperty(value = "strength_attack_home")
    private int strengthAttackHome;
    @JsonProperty(value = "strength_attack_away")
    private int strengthAttackAway;
    @JsonProperty(value = "strength_defence_home")
    private int strengthDefenceHome;
    @JsonProperty(value = "strength_defence_away")
    private int strengthDefenceAway;
}