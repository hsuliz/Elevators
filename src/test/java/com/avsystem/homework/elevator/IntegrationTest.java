package com.avsystem.homework.elevator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@ActiveProfiles("test")
public class IntegrationTest {

    @Autowired
    private WebTestClient webClient;
    @Autowired
    private ElevatorController elevatorController;
    @Autowired
    private ElevatorList elevatorList;
    @Autowired
    private ElevatorPicker elevatorPicker;
    @Autowired
    private ElevatorService elevatorService;

    @Test
    void fullTest() {

        var exepted = List.of();

        webClient.put().uri("/api/elevator")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("{\"id\": 1, \"currentFlor\": 5}")
                .exchange();

        webClient.put().uri("/api/elevator")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("{\"id\": 2, \"currentFlor\": 20}")
                .exchange();

        System.out.println(elevatorList.getList());

        webClient.post().uri("/api/pick/10")
                .exchange();

        webClient.post().uri("/api/step")
                .exchange();

        webClient.get().uri("/api/elevators")
                .exchange()
                .expectStatus().isEqualTo(2);

        System.out.println(elevatorList.getList());
    }


}
