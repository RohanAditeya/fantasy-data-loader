package com.fantasy.data.loader.task.service.impl;

import com.fantasy.data.loader.task.client.FantasyFootballWebApiClient;
import com.fantasy.data.loader.task.model.ApiClientResponseDTO;
import com.fantasy.data.loader.task.service.LeaguePlayerService;
import com.fantasy.football.model.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MarkerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.fantasy.data.loader.task.utils.ServiceConstants.BOOTSTRAP_CALL_LOG_MARKER;

@Slf4j
@Service
public class LeaguePlayerServiceImpl implements LeaguePlayerService {

    private final FantasyFootballWebApiClient fantasyFootballWebApiClient;

    public LeaguePlayerServiceImpl (FantasyFootballWebApiClient fantasyFootballWebApiClient) {
        this.fantasyFootballWebApiClient = fantasyFootballWebApiClient;
    }

    @Override
    public void convertAndWriteLeaguePlayerRecords(List<ApiClientResponseDTO.LeaguePlayerResponseDTO> leaguePlayerResponseDTOS) {
        leaguePlayerResponseDTOS.stream().map(this::convertToEntity).forEach(fantasyFootballWebApiClient::createLeaguePlayer);
        log.atInfo().addMarker(MarkerFactory.getMarker(BOOTSTRAP_CALL_LOG_MARKER)).log("Finished calling create league player API for {} players", leaguePlayerResponseDTOS.size());
    }

    private PlayerBasicInformation convertToEntity (ApiClientResponseDTO.LeaguePlayerResponseDTO leaguePlayerResponseDTO) {
        return new PlayerBasicInformation.Builder()
                .compositeKey(new PlayerBasicInformationPrimaryKey(leaguePlayerResponseDTO.code(), leaguePlayerResponseDTO.firstName(), leaguePlayerResponseDTO.secondName()))
                .squadNumber(leaguePlayerResponseDTO.squadNumber())
                .status(leaguePlayerResponseDTO.status())
                .team(new LeagueTeam.Builder().compositeKey(new LeagueTeamPrimaryKey(null, leaguePlayerResponseDTO.teamCode())).build())
                .webName(leaguePlayerResponseDTO.webName())
                .playerFantasyStatistics(buildFantasyStatisticsEntity(leaguePlayerResponseDTO))
                .playerGameStatistics(buildGameStatisticsEntity(leaguePlayerResponseDTO))
                .playerMiscellaneousInformation(buildMiscellaneousInformationEntity(leaguePlayerResponseDTO))
                .build();
    }

    private PlayerFantasyStatistics buildFantasyStatisticsEntity (ApiClientResponseDTO.LeaguePlayerResponseDTO leaguePlayerResponseDTO) {
        return new PlayerFantasyStatistics.Builder()
                .chanceOfPlayingNextRound(leaguePlayerResponseDTO.chanceOfPlayingNextRound())
                .chanceOfPlayingThisRound(leaguePlayerResponseDTO.chanceOfPlayingThisRound())
                .dreamTeamCount(leaguePlayerResponseDTO.dreamteamCount())
                .expectedPointsNext(leaguePlayerResponseDTO.epNext())
                .expectedPointsThis(leaguePlayerResponseDTO.epThis())
                .eventPoints(leaguePlayerResponseDTO.eventPoints())
                .inDreamTeam(leaguePlayerResponseDTO.inDreamteam())
                .form(leaguePlayerResponseDTO.form())
                .nowCost(leaguePlayerResponseDTO.nowCost())
                .pointsPerGame(leaguePlayerResponseDTO.pointsPerGame())
                .selectedByPercent(leaguePlayerResponseDTO.selectedByPercent())
                .totalPoints(leaguePlayerResponseDTO.totalPoints())
                .transfersIn(leaguePlayerResponseDTO.transfersIn())
                .transfersOut(leaguePlayerResponseDTO.transfersOut())
                .valueForm(leaguePlayerResponseDTO.valueForm())
                .valueSeason(leaguePlayerResponseDTO.valueSeason())
                .bonus(leaguePlayerResponseDTO.bonus())
                .bps(leaguePlayerResponseDTO.bps())
                .expectedGoals(leaguePlayerResponseDTO.expectedGoals())
                .expectedAssists(leaguePlayerResponseDTO.expectedAssists())
                .expectedGoalInvolvements(leaguePlayerResponseDTO.expectedGoalInvolvements())
                .expectedGoalsConceded(leaguePlayerResponseDTO.expectedGoalsConceded())
                .expectedGoalsPer90(leaguePlayerResponseDTO.expectedGoalsPer90())
                .expectedAssistsPer90(leaguePlayerResponseDTO.expectedAssistsPer90())
                .expectedGoalInvolvementsPer90(leaguePlayerResponseDTO.expectedGoalInvolvementsPer90())
                .expectedGoalConcededPer90(leaguePlayerResponseDTO.expectedGoalsConcededPer90())
                .build();
    }

    private PlayerGameStatistics buildGameStatisticsEntity (ApiClientResponseDTO.LeaguePlayerResponseDTO leaguePlayerResponseDTO) {
        return new PlayerGameStatistics.Builder()
                .minutes(leaguePlayerResponseDTO.minutes())
                .goalsScored(leaguePlayerResponseDTO.goalsScored())
                .assists(leaguePlayerResponseDTO.assists())
                .cleanSheets(leaguePlayerResponseDTO.cleanSheets())
                .goalsConceded(leaguePlayerResponseDTO.goalsConceded())
                .ownGoals(leaguePlayerResponseDTO.ownGoals())
                .penaltiesSaved(leaguePlayerResponseDTO.penaltiesSaved())
                .penaltiesMissed(leaguePlayerResponseDTO.penaltiesMissed())
                .yellowCards(leaguePlayerResponseDTO.yellowCards())
                .redCards(leaguePlayerResponseDTO.redCards())
                .saves(leaguePlayerResponseDTO.saves())
                .influence(leaguePlayerResponseDTO.influence())
                .creativity(leaguePlayerResponseDTO.creativity())
                .threat(leaguePlayerResponseDTO.threat())
                .starts(leaguePlayerResponseDTO.starts())
                .startsPer90(leaguePlayerResponseDTO.startsPer90())
                .cleanSheetsPer90(leaguePlayerResponseDTO.cleanSheetsPer90())
                .savesPer90(leaguePlayerResponseDTO.savesPer90())
                .goalsConcededPer90(leaguePlayerResponseDTO.goalsConcededPer90())
                .build();
    }

    private PlayerMiscellaneousInformation buildMiscellaneousInformationEntity (ApiClientResponseDTO.LeaguePlayerResponseDTO leaguePlayerResponseDTO) {
        return new PlayerMiscellaneousInformation.Builder()
                .news(leaguePlayerResponseDTO.news())
                .newsAdded(leaguePlayerResponseDTO.newsAdded())
                .ictIndex(leaguePlayerResponseDTO.ictIndex())
                .influenceRank(leaguePlayerResponseDTO.influenceRank())
                .influenceRankType(leaguePlayerResponseDTO.influenceRankType())
                .creativityRank(leaguePlayerResponseDTO.creativityRank())
                .creativityRankType(leaguePlayerResponseDTO.creativityRankType())
                .threatRank(leaguePlayerResponseDTO.threatRank())
                .threatRankType(leaguePlayerResponseDTO.threatRankType())
                .ictIndexRank(leaguePlayerResponseDTO.ictIndexRank())
                .ictIndexRankType(leaguePlayerResponseDTO.ictIndexRankType())
                .cornersAndIndirectFreeKicksOrder(leaguePlayerResponseDTO.cornersAndIndirectFreekicksOrder())
                .cornersAndIndirectFreeKicksText(leaguePlayerResponseDTO.cornersAndIndirectFreekicksText())
                .directFreeKicksOrder(leaguePlayerResponseDTO.directFreekicksOrder())
                .directFreeKicksText(leaguePlayerResponseDTO.directFreekicksText())
                .penaltiesOrder(leaguePlayerResponseDTO.penaltiesOrder())
                .penaltiesText(leaguePlayerResponseDTO.penaltiesText())
                .nowCostRank(leaguePlayerResponseDTO.nowCostRank())
                .nowCostRankType(leaguePlayerResponseDTO.nowCostRankType())
                .formRank(leaguePlayerResponseDTO.formRank())
                .formRankType(leaguePlayerResponseDTO.formRankType())
                .pointsPerGameRank(leaguePlayerResponseDTO.pointsPerGameRank())
                .pointsPerGameRankType(leaguePlayerResponseDTO.pointsPerGameRankType())
                .selectedRank(leaguePlayerResponseDTO.selectedRank())
                .selectedRankType(leaguePlayerResponseDTO.selectedRankType())
                .build();
    }
}