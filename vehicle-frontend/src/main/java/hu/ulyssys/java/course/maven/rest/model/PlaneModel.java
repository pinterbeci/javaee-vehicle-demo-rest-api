package hu.ulyssys.java.course.maven.rest.model;

import javax.validation.constraints.Max;

public class PlaneModel extends CoreRestModel {

    @Max(value = 2500)
    private int passengerNumbers;

    public PlaneModel() {
    }

    public int getPassengerNumbers() {
        return passengerNumbers;
    }

    public void setPassengerNumbers(int passengerNumbers) {
        this.passengerNumbers = passengerNumbers;
    }
}
