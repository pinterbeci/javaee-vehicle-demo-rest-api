package hu.ulyssys.java.course.maven.dao.impl;

import hu.ulyssys.java.course.maven.dao.ShipDAO;
import hu.ulyssys.java.course.maven.entity.Ship;

import javax.ejb.Stateless;


@Stateless
public class ShipDAOImpl extends CoreDAOImpl<Ship> implements ShipDAO {

    @Override
    protected Class<Ship> getManagedClass() {
        return Ship.class;
    }
}
