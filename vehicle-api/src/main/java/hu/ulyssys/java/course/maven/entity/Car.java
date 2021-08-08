package hu.ulyssys.java.course.maven.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "car")
@Entity
public class Car extends AbstractVehicle {
    @Column(name = "door_number")
    private int doorNumbers;

    public Car() {
    }

    public int getDoorNumbers() {
        return doorNumbers;
    }

    public void setDoorNumbers(int doorNumbers) {
        this.doorNumbers = doorNumbers;
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.Car;
    }
}