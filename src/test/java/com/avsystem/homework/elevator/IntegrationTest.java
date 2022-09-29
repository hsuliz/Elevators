package com.avsystem.homework.elevator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        properties = {"elevator.quantity=4"},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class IntegrationTest {
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    @LocalServerPort
    private int port;

    private HttpEntity<String> entity;

    @BeforeEach
    void setUP() {
        entity = new HttpEntity<>(null, headers);
    }

    @Test
    public void getElevators_ShouldReturnCorrectJson() {
        String expected = "[" +
                "{\"id\":1,\"currentFlor\":0}," +
                "{\"id\":2,\"currentFlor\":0}," +
                "{\"id\":3,\"currentFlor\":0}," +
                "{\"id\":4,\"currentFlor\":0}" +
                "]";

        //when
        ResponseEntity<String> actual = restTemplate.exchange(
                createURLWithPort("/api/elevators"),
                HttpMethod.GET, entity, String.class);

        //then
        assertThat(actual.getBody()).isEqualTo(expected);
    }

    @Test
    public void endToEnd() {
        String expected = "[" +
                "{\"id\":1,\"currentFlor\":0}," +
                "{\"id\":2,\"currentFlor\":0}," +
                "{\"id\":3,\"currentFlor\":0}," +
                "{\"id\":4,\"currentFlor\":0}" +
                "]";

        //when
        restTemplate.exchange(
                createURLWithPort("/api/elevator"),
                HttpMethod.PUT, entity, String.class
        );

        ResponseEntity<String> actual = restTemplate.exchange(
                createURLWithPort("/api/elevators"),
                HttpMethod.GET, entity, String.class);

        //then
        assertThat(actual.getBody()).isEqualTo(expected);
    }


    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

    @Test
    public void addCourse() {

        Course course = new Course("Course1", "Spring", "10 Steps",
                List.of("Learn Maven", "Import Project", "First Example", "Second Example"));

        HttpEntity<Course> entity = new HttpEntity<Course>(course, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/students/Student1/courses"),
                HttpMethod.POST, entity, String.class);

        String actual = response.getHeaders()
                .get(HttpHeaders.LOCATION)
                .get(0);

        assertTrue(actual.contains("/students/Student1/courses/"));

    }
}