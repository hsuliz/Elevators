package com.avsystem.homework.elevator;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ElevatorPickerTest {

    @Mock
    private ElevatorList elevatorList;
    @InjectMocks
    private ElevatorPicker elevatorPicker;

    private static Stream<Arguments> pick_ShouldReturnCorrectIdForElevators() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                new Elevator(1, 1),
                                new Elevator(2, 10),
                                new Elevator(3, 5)
                        ),
                        Map.of(
                                1, List.of(1),
                                2, List.of(9),
                                3, List.of(5, 6)
                        )
                )
        );
    }

    @ParameterizedTest
    @MethodSource
    void pick_ShouldReturnCorrectIdForElevators(List<Elevator> givenList, Map<Integer, List<Integer>> givenMap) {
        //given when
        when(elevatorList.getList()).thenReturn(givenList);
        elevatorPicker.pick(1);
        elevatorPicker.pick(5);
        elevatorPicker.pick(6);
        elevatorPicker.pick(9);

        //then
        assertThat(elevatorPicker.queueMap).isEqualTo(givenMap);
    }


}