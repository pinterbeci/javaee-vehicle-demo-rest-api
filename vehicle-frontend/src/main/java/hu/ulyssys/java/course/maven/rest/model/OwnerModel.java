package hu.ulyssys.java.course.maven.rest.model;

import java.util.Date;

public class OwnerModel {

    private Long id;

    private String fullName;

    private Date registrationDate;

    public OwnerModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
