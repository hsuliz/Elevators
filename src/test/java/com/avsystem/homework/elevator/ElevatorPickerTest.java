package com.avsystem.homework.elevator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ElevatorPickerTest {

    @Mock
    private ElevatorList elevatorList;

    @InjectMocks
    private ElevatorPicker elevatorPicker;

    @Test
    void test() {
        //given

        var givenList = List.of(
                new Elevator(1, 1, 1),
                new Elevator(2, 2, 1),
                new Elevator(3, 6, 1)
        );
        when(elevatorList.getList()).thenReturn(givenList);

        //when
        elevatorPicker.pick(5);
    }

}