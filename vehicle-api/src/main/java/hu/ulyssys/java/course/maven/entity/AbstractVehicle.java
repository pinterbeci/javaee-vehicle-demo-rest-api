package hu.ulyssys.java.course.maven.entity;


import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractVehicle extends AbstractEntity implements VehicleTypeAware {

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "licence_plate_number")
    private String licencePlateNumber;

    @JoinColumn(name = "owner_id")
    @ManyToOne
    private Owner owner;

    public AbstractVehicle() {
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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
