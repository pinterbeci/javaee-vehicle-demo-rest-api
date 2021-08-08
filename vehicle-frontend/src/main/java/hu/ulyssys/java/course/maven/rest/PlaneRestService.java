package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.entity.Plane;
import hu.ulyssys.java.course.maven.rest.model.PlaneModel;

import javax.ws.rs.Path;

@Path("/plane")
public class PlaneRestService extends CoreRestService<Plane, PlaneModel> {
    @Override
    protected PlaneModel initNewModel() {
        return new PlaneModel();
    }

    @Override
    protected Plane initNewEntity() {
        return new Plane();
    }
}
