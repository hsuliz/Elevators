package com.avsystem.homework.elevator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ElevatorServiceTest {

    @Mock
    private ElevatorList elevatorList;

    @InjectMocks
    private ElevatorService elevatorService;

    static List<Elevator> elevatorListG() {
        return List.of(
                new Elevator(1, 1, 1),
                new Elevator(2, 2, 2),
                new Elevator(3, 4, 5)
        );
    }

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

    @Test
    void up() {
        //given
        var elevatorWithWrongId = new Elevator(
                2,
                0,
                0
        );


        //when
        when(elevatorList.getSize()).thenReturn(2);
        when(elevatorList.getList()).thenReturn(elevatorListG());
        var actual = elevatorService.update(elevatorWithWrongId);

        //then
        Assertions.assertTrue(actual);
    }



}