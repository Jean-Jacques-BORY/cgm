package org.acme;

import org.acme.InputDtos.VisitInputDto;
import org.acme.models.Patient;
import org.acme.models.Visit;
import org.acme.repositories.PatientRepository;
import org.acme.repositories.VisitRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("visit")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class VisitResource {

    @Inject
    VisitRepository visitRepository;
    @Inject
    PatientRepository patientRepository;

    @POST
    @Path("create")
    @Transactional
    public Response create(VisitInputDto visitInputDto) {

        Patient patient = patientRepository.findById(visitInputDto.getPatientId());
        if (patient == null) {
            throw new WebApplicationException("patient with id of " + visitInputDto.getPatientId() + " does not exist.", 404);
        }
        Visit visit = new Visit(patient,visitInputDto.getDate(),visitInputDto.getType(),
                visitInputDto.getReason(),visitInputDto.getFamilyHistory());
        visitRepository.persist(visit);
        return Response.ok().status(201).build();
    }

    @GET
    public Visit getOne(Long id) {
        return visitRepository.findById(id);
    }

    @PUT
    @Path("update")
    @Transactional
    public Visit update(VisitInputDto visitInputDto) {
        Visit visit = visitRepository.findById(visitInputDto.getId());
        if (visit == null) {
            throw new WebApplicationException("Visit with id of " + visitInputDto.getId() + " does not exist.", 404);
        }
        visit.setDate(visitInputDto.getDate());
        visit.setType(visitInputDto.getType());
        visit.setReason(visitInputDto.getReason());
        visit.setFamilyHistory(visitInputDto.getFamilyHistory());
        visitRepository.persist(visit);
        return visit;
    }


}