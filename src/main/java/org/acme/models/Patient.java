package org.acme.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Patient extends PanacheEntity {

    private String name;
    private String surname;
    @Column(unique = true)
    private Integer socialSecurityNumber;
    private Date birthDate;
    @OneToMany(targetEntity=Visit.class, mappedBy="patient", fetch = FetchType.EAGER)
    private List<Visit> visits = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(Integer socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }
}
