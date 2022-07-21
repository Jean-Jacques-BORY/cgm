package org.acme.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Visit extends PanacheEntity {

    public Visit(Patient patient, Date date, VisitTypeEnum type, VisitReasonEnum reason, String familyHistory) {
        this.patient = patient;
        this.date = date;
        this.type = type;
        this.reason = reason;
        this.familyHistory = familyHistory;
    }

    public Visit() {
    }

    @ManyToOne
    @JoinColumn(name="patient_id", nullable=false)
    @JsonbTransient
    private Patient patient;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private VisitTypeEnum type;
    private VisitReasonEnum reason;
    private String familyHistory;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public VisitTypeEnum getType() {
        return type;
    }

    public void setType(VisitTypeEnum type) {
        this.type = type;
    }

    public VisitReasonEnum getReason() {
        return reason;
    }

    public void setReason(VisitReasonEnum reason) {
        this.reason = reason;
    }

    public String getFamilyHistory() {
        return familyHistory;
    }

    public void setFamilyHistory(String familyHistory) {
        this.familyHistory = familyHistory;
    }
}
