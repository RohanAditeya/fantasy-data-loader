package com.fantasy.data.loader.task.runner;

import com.fantasy.data.loader.task.client.FantasyPremierLeagueApiClient;
import com.fantasy.data.loader.task.model.ApiClientResponseDTO;
import com.fantasy.data.loader.task.service.LeaguePlayerService;
import com.fantasy.data.loader.task.service.LeagueTeamService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(value = MockitoExtension.class)
public class FantasyApiClientTaskRunnerTest {

    @InjectMocks
    private FantasyApiClientTaskRunner fantasyApiClientTaskRunner;
    @Mock
    private FantasyPremierLeagueApiClient fantasyPremierLeagueApiClient;
    @Mock
    private LeaguePlayerService leaguePlayerService;
    @Mock
    private LeagueTeamService leagueTeamService;

    @Test
    public void runTest () throws Exception {
        ResponseEntity<ApiClientResponseDTO.BootstrapApiResponseDTO> mockResponse = ResponseEntity.of(Optional.ofNullable(mock(ApiClientResponseDTO.BootstrapApiResponseDTO.class, RETURNS_DEEP_STUBS)));
        doReturn(mockResponse).when(fantasyPremierLeagueApiClient).getBootstrapData();
        doNothing().when(leaguePlayerService).convertAndWriteLeaguePlayerRecords(anyList());
        doNothing().when(leagueTeamService).convertAndWriteLeagueTeamRecords(anyList());

        fantasyApiClientTaskRunner.run(null);

        verify(fantasyPremierLeagueApiClient, times(1)).getBootstrapData();
        verify(leaguePlayerService, times(1)).convertAndWriteLeaguePlayerRecords(anyList());
        verify(leagueTeamService, times(1)).convertAndWriteLeagueTeamRecords(anyList());
    }
}