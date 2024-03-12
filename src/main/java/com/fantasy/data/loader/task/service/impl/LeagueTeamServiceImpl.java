package com.fantasy.data.loader.task.service.impl;

import com.fantasy.data.loader.task.client.FantasyFootballWebApiClient;
import com.fantasy.data.loader.task.model.ApiClientResponseDTO;
import com.fantasy.data.loader.task.service.LeagueTeamService;
import com.fantasy.football.model.LeagueTeam;
import com.fantasy.football.model.LeagueTeamPrimaryKey;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MarkerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.fantasy.data.loader.task.utils.ServiceConstants.BOOTSTRAP_CALL_LOG_MARKER;

@Slf4j
@Service
public class LeagueTeamServiceImpl implements LeagueTeamService {

    private final FantasyFootballWebApiClient fantasyFootballWebApiClient;

    public LeagueTeamServiceImpl (FantasyFootballWebApiClient fantasyFootballWebApiClient) {
        this.fantasyFootballWebApiClient = fantasyFootballWebApiClient;
    }

    @Override
    public void convertAndWriteLeagueTeamRecords(List<ApiClientResponseDTO.LeagueTeamResponseDTO> leagueTeamResponseDTOS) {
        leagueTeamResponseDTOS.stream().map(this::convertToEntity).forEach(fantasyFootballWebApiClient::createLeagueTeamPlayer);
        log.atInfo().addMarker(MarkerFactory.getMarker(BOOTSTRAP_CALL_LOG_MARKER)).log("Finished calling create league team API for {} teams", leagueTeamResponseDTOS.size());
    }

    private LeagueTeam convertToEntity (ApiClientResponseDTO.LeagueTeamResponseDTO leagueTeamResponseDTO) {
        return new LeagueTeam.Builder()
                .compositeKey(new LeagueTeamPrimaryKey(leagueTeamResponseDTO.name(), leagueTeamResponseDTO.code()))
                .draw(leagueTeamResponseDTO.draw())
                .form(Optional.ofNullable(leagueTeamResponseDTO.form()).orElse(0))
                .loss(leagueTeamResponseDTO.loss())
                .played(leagueTeamResponseDTO.played())
                .points(leagueTeamResponseDTO.points())
                .position(leagueTeamResponseDTO.position())
                .shortName(leagueTeamResponseDTO.shortName())
                .strength(leagueTeamResponseDTO.strength())
                .teamDivision(leagueTeamResponseDTO.teamDivision())
                .unavailable(leagueTeamResponseDTO.unavailable())
                .win(leagueTeamResponseDTO.win())
                .strengthOverallHome(leagueTeamResponseDTO.strengthOverallHome())
                .strengthOverallAway(leagueTeamResponseDTO.strengthOverallAway())
                .strengthAttackHome(leagueTeamResponseDTO.strengthAttackHome())
                .strengthAttackAway(leagueTeamResponseDTO.strengthAttackAway())
                .strengthDefenceHome(leagueTeamResponseDTO.strengthDefenceHome())
                .strengthDefenceAway(leagueTeamResponseDTO.strengthDefenceAway())
                .pulseId(leagueTeamResponseDTO.pulseId())
                .build();
    }
}