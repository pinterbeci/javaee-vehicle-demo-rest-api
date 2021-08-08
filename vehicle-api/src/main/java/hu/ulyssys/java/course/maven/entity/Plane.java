package hu.ulyssys.java.course.maven.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "plane")
public class Plane extends AbstractVehicle {

    @Column(name = "passenger_numbers")
    private int passengerNumbers;

    public Plane() {
    }

    public int getPassengerNumbers() {
        return passengerNumbers;
    }

    public void setPassengerNumbers(int passengerNumbers) {
        this.passengerNumbers = passengerNumbers;
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.Plane;
    }
}