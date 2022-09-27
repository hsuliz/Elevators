package com.avsystem.homework.elevator;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ElevatorServiceTest {

    @Mock
    private ElevatorList elevatorList;

    @InjectMocks
    private ElevatorService elevatorService;

    private static Stream<Arguments> update_ShouldReturnTrueForCorrectOrFalseForIncorrectData() {
        return Stream.of(
                Arguments.of(0, 0, false),
                Arguments.of(5, 5, true),
                Arguments.of(-2, 0, false),
                Arguments.of(6, 5, false),
                Arguments.of(2, 16, true)
        );
    }

    private List<Elevator> elevatorGenerator(int size) {
        var generatedList = new ArrayList<Elevator>();
        for (int i = 0; i < size; i++) {
            generatedList.add(new Elevator());
        }
        return generatedList;
    }

    @ParameterizedTest
    @MethodSource
    void update_ShouldReturnTrueForCorrectOrFalseForIncorrectData(int id, int size, boolean expected) {
        //given
        var elevator = new Elevator(
                id,
                0,
                0
        );

        when(elevatorList.getList().size()).thenReturn(size);
        when(elevatorList.getList()).thenReturn(elevatorGenerator(size));

        //when
        var actual = elevatorService.update(elevator);

        //then
        assertEquals(expected, actual);
    }

}