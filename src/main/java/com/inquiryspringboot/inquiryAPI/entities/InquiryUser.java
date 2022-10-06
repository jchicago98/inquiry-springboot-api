package com.inquiryspringboot.inquiryAPI.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class InquiryUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String firstName;
    String lastName;
    Date yearBorn;
    String email;

    boolean isActive = true;

    public InquiryUser(){}

    public InquiryUser(Integer id, String firstName, String lastName, Date yearBorn, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearBorn = yearBorn;
        this.email = email;
    }

    public InquiryUser(Integer id, String firstName, String lastName, Date yearBorn, String email, boolean isActive) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearBorn = yearBorn;
        this.email = email;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getYearBorn() {
        return yearBorn;
    }

    public void setYearBorn(Date yearBorn) {
        this.yearBorn = yearBorn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public InquiryUser withFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public InquiryUser withLastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public InquiryUser withYearBorn(Date yearBorn){
        this.yearBorn = yearBorn;
        return this;
    }

    public InquiryUser withId(Integer id){
        this.id = id;
        return this;
    }

}
