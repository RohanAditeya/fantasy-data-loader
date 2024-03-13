package com.fantasy.data.loader.task.service.impl;

import com.fantasy.data.loader.task.client.FantasyFootballWebApiClient;
import com.fantasy.data.loader.task.model.ApiClientResponseDTO;
import com.fantasy.football.model.PlayerBasicInformation;
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
public class LeaguePlayerServiceImplTest {

    @InjectMocks
    private LeaguePlayerServiceImpl leaguePlayerService;
    @Mock
    private FantasyFootballWebApiClient fantasyFootballWebApiClient;

    @Test
    public void convertAndWriteLeaguePlayerRecordsTest () {
        ApiClientResponseDTO.LeaguePlayerResponseDTO mockPlayerDto = mock(ApiClientResponseDTO.LeaguePlayerResponseDTO.class, RETURNS_DEEP_STUBS);
        ArgumentCaptor<PlayerBasicInformation> requestBodyCaptor = ArgumentCaptor.forClass(PlayerBasicInformation.class);
        doReturn(mock(ResponseEntity.class)).when(fantasyFootballWebApiClient).createLeaguePlayer(requestBodyCaptor.capture());
        leaguePlayerService.convertAndWriteLeaguePlayerRecords(List.of(mockPlayerDto));
        assertThat(requestBodyCaptor.getValue()).isNotNull();
        assertThat(requestBodyCaptor.getValue().getPlayerFantasyStatistics()).isNotNull();
        assertThat(requestBodyCaptor.getValue().getPlayerGameStatistics()).isNotNull();
        assertThat(requestBodyCaptor.getValue().getPlayerMiscellaneousInformation()).isNotNull();
    }
}