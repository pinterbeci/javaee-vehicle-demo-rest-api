package hu.ulyssys.java.course.maven.dao.impl;

import hu.ulyssys.java.course.maven.dao.PlaneDAO;
import hu.ulyssys.java.course.maven.entity.Plane;

import javax.ejb.Stateless;


@Stateless
public class PlaneDAOImpl extends CoreDAOImpl<Plane> implements PlaneDAO {

    @Override
    protected Class<Plane> getManagedClass() {
        return Plane.class;
    }
}
