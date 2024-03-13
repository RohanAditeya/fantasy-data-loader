package com.fantasy.data.loader.task.service;

import com.fantasy.data.loader.task.model.ApiClientResponseDTO;

import java.util.List;

public interface LeaguePlayerService {

    void convertAndWriteLeaguePlayerRecords (List<ApiClientResponseDTO.LeaguePlayerResponseDTO> leaguePlayerResponseDTOS);
}