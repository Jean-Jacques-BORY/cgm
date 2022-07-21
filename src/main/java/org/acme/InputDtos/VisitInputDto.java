package org.acme.InputDtos;

import org.acme.models.Patient;
import org.acme.models.VisitReasonEnum;
import org.acme.models.VisitTypeEnum;
import java.util.Date;

public class VisitInputDto {

    public VisitInputDto() {
    }

    private Long id;
    private Long patientId;
    private Date date;
    private VisitTypeEnum type;
    private VisitReasonEnum reason;
    private String familyHistory;

    public VisitInputDto(Long patientId, Date date, VisitTypeEnum type, VisitReasonEnum reason, String familyHistory) {
        this.patientId = patientId;
        this.date = date;
        this.type = type;
        this.reason = reason;
        this.familyHistory = familyHistory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setFamilyHistory(String familyHistory) {
        this.familyHistory = familyHistory;
    }

    public Long getPatientId() {
        return patientId;
    }

    public Date getDate() {
        return date;
    }

    public String getFamilyHistory() {
        return familyHistory;
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
}
