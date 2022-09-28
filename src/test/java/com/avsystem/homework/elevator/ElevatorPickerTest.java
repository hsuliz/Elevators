package com.avsystem.homework.elevator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ElevatorPickerTest {

    @Mock
    private ElevatorList elevatorList;
    @InjectMocks
    private ElevatorPicker elevatorPicker;

    @Test
    void pick_ShouldReturnCorrectIdForElevators() {
        //given
        var expectedId = 3;
        var givenList = List.of(
                new Elevator(1, 1, 1),
                new Elevator(2, 10, 1),
                new Elevator(3, 5, 1)
        );
        var givenMap = Map.of(
                1, List.of(1),
                2, List.of(9),
                3, List.of(5, 6)
        );

        when(elevatorList.getList()).thenReturn(givenList);

        //when
        elevatorPicker.pick(1);
        elevatorPicker.pick(5);
        elevatorPicker.pick(6);
        elevatorPicker.pick(9);

        //then
        assertThat(elevatorPicker.queueMap).isEqualTo(givenMap);
    }


}