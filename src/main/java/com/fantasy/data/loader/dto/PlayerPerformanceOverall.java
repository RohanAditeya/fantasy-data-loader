package com.fantasy.data.loader.dto;

import lombok.Data;

@Data
public class PlayerPerformanceOverall {
    private int dreamTeamCount;
    private int totalPoints;
    private float valueSeason;
    private float valueForm;
    private float form;
    private float pointsPerGame;
    private int goalsScored;
    private int assists;
    private int cleanSheets;
    private int goalsConceded;
    private int ownGoals;
    private int penaltiesSaved;
    private int penaltiesMissed;
    private int yellowCards;
    private int redCards;
    private int bonus;
    private int bps;
    private float influence;
    private float creativity;
    private float threat;
    private float ictIndex;
    private int starts;
    private float expectedGoals;
    private float expectedAssists;
    private float expectedGoalInvolvements;
    private float expectedGoalsConceded;
    private float epNext;
    private float epThis;
}