package com.avsystem.homework.elevator;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ElevatorController {

    private final ElevatorService elevatorService;

    @PostMapping("/pick")
    public ResponseEntity<String> postPickUp(
            @RequestParam(name = "reqFlor") int requestFlor,
            @RequestParam(name = "movDir") int movingDirection
    ) {
        elevatorService.pickUp(requestFlor, movingDirection);
        return new ResponseEntity<>("Pick up request sent!!", HttpStatus.OK);
    }

    @GetMapping("/elevators")
    public List<Elevator> getElevators() {
        return elevatorService.status();
    }

    @PutMapping("/elevator")
    public ResponseEntity<String> putElevator(
            @RequestBody Elevator elevator
    ) {
        if (elevatorService.update(elevator)) {
            return new ResponseEntity<>(
                    "Elevator added!!",
                    HttpStatus.CREATED
            );
        } else {
            return new ResponseEntity<>(
                    "Couldn't add the elevator!! Wrong data!!",
                    HttpStatus.BAD_REQUEST
            );
        }
    }

}
