package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PatientResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/patient")
          .then()
             .statusCode(200)
             .body(is("[{\"id\":1,\"name\":\"Cherry\",\"visits\":[]},{\"id\":2,\"name\":\"Apple\",\"visits\":[]},{\"id\":3,\"name\":\"Banana\",\"visits\":[]}]"));
    }

}