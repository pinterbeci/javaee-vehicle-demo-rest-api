package hu.ulyssys.java.course.maven.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "vehicle_owner")
public class Owner extends AbstractEntity {

    @Column(name = "full_name")
    private String fullName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "registration_date")
    private Date registrationDate;


    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return Objects.equals(fullName, owner.fullName) && Objects.equals(registrationDate, owner.registrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, registrationDate);
    }
}