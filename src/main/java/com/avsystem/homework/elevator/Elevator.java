package com.avsystem.homework.elevator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Elevator {

    private Integer id;
    private Integer currentFlor;
    private Integer destinationFlor;

}
