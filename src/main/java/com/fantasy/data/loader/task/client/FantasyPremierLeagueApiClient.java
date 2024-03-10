package com.fantasy.data.loader.task.client;

import com.fantasy.data.loader.task.model.ApiClientResponseDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.service.annotation.GetExchange;

public interface FantasyPremierLeagueApiClient {

    @GetExchange(url = "api/bootstrap-static/", accept = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ApiClientResponseDTO.BootstrapApiResponseDTO> getBootstrapData();
}