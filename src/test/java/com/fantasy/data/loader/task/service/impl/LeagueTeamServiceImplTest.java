package com.fantasy.data.loader.task.service.impl;

import com.fantasy.data.loader.task.client.FantasyFootballWebApiClient;
import com.fantasy.data.loader.task.model.ApiClientResponseDTO;
import com.fantasy.football.model.LeagueTeam;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(value = MockitoExtension.class)
public class LeagueTeamServiceImplTest {

    @InjectMocks
    private LeagueTeamServiceImpl leagueTeamService;
    @Mock
    private FantasyFootballWebApiClient fantasyFootballWebApiClient;

    @Test
    public void convertAndWriteLeagueTeamRecordsTest () {
        ApiClientResponseDTO.LeagueTeamResponseDTO mockTeamDto = mock(ApiClientResponseDTO.LeagueTeamResponseDTO.class, RETURNS_DEEP_STUBS);
        ArgumentCaptor<LeagueTeam> requestBodyCaptor = ArgumentCaptor.forClass(LeagueTeam.class);
        doReturn(mock(ResponseEntity.class)).when(fantasyFootballWebApiClient).createLeagueTeam(requestBodyCaptor.capture());
        leagueTeamService.convertAndWriteLeagueTeamRecords(List.of(mockTeamDto));
        assertThat(requestBodyCaptor.getValue()).isNotNull();
    }
}