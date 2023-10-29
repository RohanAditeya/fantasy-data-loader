package com.fantasy.data.loader.dto;

import lombok.Data;

@Data
public class PlayerPerformancePerGameWeek {
    private int chanceOfPlayingNextRound;
    private int chanceOfPlayingThisRound;
    private int eventPoints;
    private boolean inDreamTeam;
    private int nowCost;
    private float selectedByPercent;
    private long transfersIn;
    private long transfersOut;
    private int expectedGoalsPer90;
    private int savesPer90;
    private int expectedAssistsPer90;
    private int expectedGoalInvolvementsPer90;
    private int expectedGoalsConcededPer90;
    private int startsPer90;
    private int cleanSheetsPer90;
    private int elementType;
    private boolean special;
    private String status;
}