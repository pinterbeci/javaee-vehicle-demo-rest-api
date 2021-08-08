package hu.ulyssys.java.course.maven.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ship")
public class Ship extends AbstractVehicle {

    @Column(name = "wieght")
    private int weight;


    public Ship() {
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.Ship;
    }
}
