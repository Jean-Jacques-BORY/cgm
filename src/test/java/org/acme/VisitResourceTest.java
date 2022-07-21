package org.acme;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.acme.InputDtos.VisitInputDto;
import org.acme.models.Patient;
import org.acme.models.Visit;
import org.acme.models.VisitReasonEnum;
import org.acme.models.VisitTypeEnum;
import org.acme.repositories.PatientRepository;
import org.acme.repositories.VisitRepository;
import org.junit.jupiter.api.Test;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class VisitResourceTest {

    @Inject
    VisitRepository visitRepository;

    @Inject
    PatientRepository patientRepository;

    @Test
    public void testCreateEndpoint() {

        VisitInputDto visitInputDto = new VisitInputDto();
        visitInputDto.setDate(new Date());
        visitInputDto.setPatientId(1L);
        visitInputDto.setType(VisitTypeEnum.HOME);
        visitInputDto.setReason(VisitReasonEnum.URGENT);
        ObjectMapper mapper = new ObjectMapper();
        String visitJson = null;
        try {
            visitJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(visitInputDto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        given().contentType(ContentType.JSON).body(visitJson)
                .when().post("/visit/create")
                .then()
                .statusCode(201);
    }

    @Transactional
    public void testUpdateEndpoint() {
        Patient patient = patientRepository.findById(1L);
        Visit visit = new Visit(patient,
                new Date(), null, null,"history");
        visitRepository.persist(visit);
        patient.getVisits().add(visit);
        patientRepository.persist(patient);
        Visit visitInRepo = visitRepository.findAll().singleResult();
        System.out.println("zz: "+ visitInRepo.id);
        VisitInputDto visitInputDto = new VisitInputDto();
        visitInputDto.setId(visitInRepo.id);
        visitInputDto.setDate(new Date());
        visitInputDto.setPatientId(1L);
        visitInputDto.setType(VisitTypeEnum.HOME);
        visitInputDto.setReason(VisitReasonEnum.URGENT);

        ObjectMapper mapper = new ObjectMapper();
        String visitJson = null;
        try {
            visitJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(visitInputDto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("visitJson "+ visitJson);
        given().contentType(ContentType.JSON).body(visitJson)
                .when().put("/visit/update")
                .then()
                .statusCode(201);
    }
}
