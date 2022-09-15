package com.inquiryspringboot.inquiryAPI.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Inquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String firstName;
    String lastName;
    String favoriteLanguage;
    int yearStarted;
    boolean isActive = true;

    public Inquiry(){}

    public Inquiry(Integer id, String firstName, String lastName, String favoriteLanguage, int yearStarted) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.favoriteLanguage = favoriteLanguage;
        this.yearStarted = yearStarted;
    }

    public Inquiry(Integer id, String firstName, String lastName, String favoriteLanguage, int yearStarted, boolean isActive) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.favoriteLanguage = favoriteLanguage;
        this.yearStarted = yearStarted;
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

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public int getYearStarted() {
        return yearStarted;
    }

    public void setYearStarted(int yearStarted) {
        this.yearStarted = yearStarted;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
