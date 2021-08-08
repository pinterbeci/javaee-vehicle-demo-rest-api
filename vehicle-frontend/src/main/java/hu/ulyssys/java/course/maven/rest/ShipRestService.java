package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.entity.Car;
import hu.ulyssys.java.course.maven.entity.Ship;
import hu.ulyssys.java.course.maven.rest.model.ShipModel;

import javax.ws.rs.Path;

@Path("/ship")
public class ShipRestService extends CoreRestService<Ship, ShipModel> {
    @Override
    protected ShipModel initNewModel() {
        return new ShipModel();
    }

    @Override
    protected Ship initNewEntity() {
        return new Ship();
    }
}
