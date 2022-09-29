## To run this:

    mvn spring-boot:run

## Explanation

REST application where user can send 4 types of requests:

1. `PUT:api/elevator` updating the elevator. Must be a json with Elevator object.
2. `GET:api/elevators` returns list of all elevators.
3. `PUT:api/pick/{floor}` getting floor request.
4. `POST:api/step` start to simulate elevators behaviour.

So basically user can communicate with program by REST-API. User can declare number of elevators in `properties.yml`.

## Solution

Created Spring Controller for API. Main class is `ElevatorPicker`. Its pick the best elevator for request and simulates
movement by threads.

## Example

After the execution, creating a bean with ElevatorList name. Contains all the elevators. They have default value with
floor 0. So, to start, you need to update values by `PUT:api/elevator`. After, you can send pick requests
by `PUT:api/pick/{floor}`. And to simulate the elevator, use `POST:api/step` and to check status,
use `GET:api/elevators`. Values might change.