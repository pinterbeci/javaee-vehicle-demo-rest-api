package hu.ulyssys.java.course.maven.rest.model;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

public abstract class CoreRestModel {

    private Long id;

    @NotEmpty
    private String name;

    private String type;

    private String manufacturer;

    private String licencePlateNumber;

    private Long onwerID;

    public Long getOnwerID() {
        return onwerID;
    }

    public void setOnwerID(Long onwerID) {
        this.onwerID = onwerID;
    }

    public CoreRestModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getLicencePlateNumber() {
        return licencePlateNumber;
    }

    public void setLicencePlateNumber(String licencePlateNumber) {
        this.licencePlateNumber = licencePlateNumber;
    }
}
