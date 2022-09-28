package com.avsystem.homework.elevator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ElevatorControllerTest {

    @Mock
    private ElevatorService elevatorService;

    @InjectMocks
    private ElevatorController elevatorController;

    @Test
    void getElevators_ShouldReturnListOfElevators() {
        //given
        var elevators = List.of(
                new Elevator(1, 2, 3),
                new Elevator(2, 2, 7),
                new Elevator(3, 5, 1)
        );

        when(elevatorService.status()).thenReturn(elevators);

        //when
        var actual = elevatorController.getElevators();

        //then
        assertThat(actual.size()).isEqualTo(3);
    }

    @Test
    void putElevator_ShouldAcceptThePutMethod() {
        //given
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(elevatorService.update(any(Elevator.class))).thenReturn(true);

        //when
        Elevator elevator = new Elevator(1, 5, 7);
        ResponseEntity<String> responseEntity = elevatorController.putElevator(elevator);

        //then
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
    }

    @Test
    void postPickUp() {
        //given
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        //when
        ResponseEntity<String> responseEntity = elevatorController.postPickUp(5);

        //then
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

}