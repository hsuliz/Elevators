package com.avsystem.homework.elevator;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@Slf4j
class ElevatorServiceTest {

    @Mock
    private ElevatorList elevatorList;

    @InjectMocks
    private ElevatorService elevatorService;


    @Test
    void update() {
        //given
        var elevatorWithWrongId = new Elevator(
                -1,
                0,
                0
        );

        //when
        var actual = elevatorService.update(elevatorWithWrongId);

        //then
        Assertions.assertFalse(actual);
    }

}