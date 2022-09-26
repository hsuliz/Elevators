package com.avsystem.homework.elevator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Elevator {

    private int id;
    private int currentFlor;
    private int destinationFlor;

}
