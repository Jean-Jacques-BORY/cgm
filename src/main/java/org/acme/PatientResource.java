package org.acme;

import org.acme.models.Patient;
import org.acme.repositories.PatientRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("patient")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class PatientResource {

    @Inject
    PatientRepository patientRepository;

    @GET
    public List<Patient> findAll() {
        return patientRepository.findAll().list();
    }

    @GET
    @Path("{id}")
    public Patient findById(Long id) {
        return patientRepository.findById(id);
    }

}