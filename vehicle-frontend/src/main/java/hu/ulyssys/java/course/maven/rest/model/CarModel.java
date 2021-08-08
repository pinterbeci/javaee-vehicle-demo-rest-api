package hu.ulyssys.java.course.maven.rest.model;

import javax.validation.constraints.Max;

public class CarModel extends CoreRestModel{

    @Max(value = 10)
    private int doorNumbers;

    public CarModel() {
    }

    public int getDoorNumbers() {
        return doorNumbers;
    }

    public void setDoorNumbers(int doorNumbers) {
        this.doorNumbers = doorNumbers;
    }
}
