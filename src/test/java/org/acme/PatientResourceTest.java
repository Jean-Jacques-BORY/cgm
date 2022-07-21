package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.acme.repositories.PatientRepository;
import org.junit.jupiter.api.Test;
import javax.inject.Inject;
import static io.restassured.RestAssured.given;

@QuarkusTest
public class PatientResourceTest {

    @Inject
    PatientRepository patientRepository;

    @Test
    public void testFindAllEndpoint() {
        given()
          .when().get("/patient")
          .then()
             .statusCode(200);
    }


    @Test
    public void testFindByIdEndpoint() {
        given().pathParam("id", 1)
                .when().get("/patient/{id}")
                .then()
                .statusCode(200);
    }
}