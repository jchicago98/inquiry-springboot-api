package com.inquiryspringboot.inquiryAPI.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Inquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String firstName;
    String lastName;
    Date yearBorn;
    String email;
    String password;

    boolean isActive = true;

    public Inquiry(){}

    public Inquiry(Integer id, String firstName, String lastName, Date yearBorn, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearBorn = yearBorn;
        this.email = email;
        this.password = password;
    }

    public Inquiry(Integer id, String firstName, String lastName, Date yearBorn, String email, String password, boolean isActive) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearBorn = yearBorn;
        this.email = email;
        this.password = password;
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

    public String getPassword() { return password;}

    public void setPassword(String password) {this.password = password;}

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
