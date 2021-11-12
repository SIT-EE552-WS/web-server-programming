package edu.stevens.friccobo.demo1;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.Map;

import static org.hamcrest.Matchers.containsString;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class ProfessorViewServletTest {

    @LocalServerPort
    Integer port;

    @Test
    public void testGet() {
        RestAssured
                .given()
                .when()
                .get("http://localhost:" + port + "/professor")
                .then()
                .statusCode(200);
    }

    @Test
    public void testGetStudentAssignment() {
        RestAssured
                .given()
                .when()
                .get("http://localhost:" + port + "/student?assignmentId=9999")
                .then()
                .statusCode(404);
    }

    @Test
    public void testGetStudentAssignment2() {
        RestAssured
                .given()
                .formParam("assignmentId", "1234")
                .formParam("githubUrl", "www.example.com")
                .when()
                .post("http://localhost:" + port + "/professor")
                .then()
                .statusCode(200);

        RestAssured
                .given()
                .when()
                .get("http://localhost:" + port + "/student?assignmentId=1234")
                .then()
                .statusCode(200)
                .body(containsString("example.com"))
        ;
    }
}
