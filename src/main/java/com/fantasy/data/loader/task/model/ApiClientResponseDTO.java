package com.fantasy.data.loader.task.model;

import java.time.OffsetDateTime;
import java.util.List;

public class ApiClientResponseDTO {

    public record LeagueTeamResponseDTO (int code, int draw, Integer form, int id, int loss, String name, int played, int points, int position, String shortName
            , int strength, String teamDivision, boolean unavailable, int win, int strengthOverallHome, int strengthOverallAway, int strengthAttackHome, int strengthAttackAway
            , int strengthDefenceHome, int strengthDefenceAway, int pulseId) {}

    public record LeaguePlayerResponseDTO (int code, String firstName, String secondName, Integer squadNumber, Character status, int teamCode, String webName
            , Integer chanceOfPlayingNextRound, Integer chanceOfPlayingThisRound, Integer dreamteamCount, Float epNext, Float epThis, Integer eventPoints, Boolean inDreamteam
            , Float form, Integer nowCost, Float pointsPerGame, Float selectedByPercent, Integer totalPoints, Long transfersIn, Long transfersOut, Float valueForm
            , Float valueSeason, Integer bonus, Integer bps, Float expectedGoals, Float expectedAssists, Float expectedGoalInvolvements, Float expectedGoalsConceded
            , Float expectedGoalsPer90, Float expectedAssistsPer90, Float expectedGoalInvolvementsPer90, Float expectedGoalsConcededPer90, Integer minutes, Integer goalsScored
            , Integer assists, Integer cleanSheets, Integer goalsConceded, Integer ownGoals, Integer penaltiesSaved, Integer penaltiesMissed, Integer yellowCards
            , Integer redCards, Integer saves, Float influence, Float creativity, Float threat, Integer starts, Float startsPer90, Float cleanSheetsPer90, Float savesPer90
            , Float goalsConcededPer90, String news, OffsetDateTime newsAdded, Float ictIndex, Integer influenceRank, Integer influenceRankType, Integer creativityRank
            , Integer creativityRankType, Integer threatRank, Integer threatRankType, Integer ictIndexRank, Integer ictIndexRankType, String cornersAndIndirectFreekicksOrder
            , String cornersAndIndirectFreekicksText, String directFreekicksOrder, String directFreekicksText, String penaltiesOrder, String penaltiesText, Integer nowCostRank
            , Integer nowCostRankType, Integer formRank, Integer formRankType, Integer pointsPerGameRank, Integer pointsPerGameRankType, Integer selectedRank
            , Integer selectedRankType) {}

    public record BootstrapApiResponseDTO (List<LeagueTeamResponseDTO> teams, List<LeaguePlayerResponseDTO> elements) {}
}