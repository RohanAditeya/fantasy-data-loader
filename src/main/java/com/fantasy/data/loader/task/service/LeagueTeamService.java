package com.fantasy.data.loader.task.service;

import com.fantasy.data.loader.task.model.ApiClientResponseDTO;

import java.util.List;

public interface LeagueTeamService {

    void convertAndWriteLeagueTeamRecords (List<ApiClientResponseDTO.LeagueTeamResponseDTO> leagueTeamResponseDTOS);
}