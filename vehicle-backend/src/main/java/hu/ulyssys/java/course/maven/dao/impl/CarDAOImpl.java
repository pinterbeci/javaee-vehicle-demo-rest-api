package hu.ulyssys.java.course.maven.dao.impl;

import hu.ulyssys.java.course.maven.dao.CarDAO;
import hu.ulyssys.java.course.maven.entity.Car;


import javax.ejb.Stateless;


@Stateless
public class CarDAOImpl extends CoreDAOImpl<Car> implements CarDAO {

    @Override
    protected Class<Car> getManagedClass() {
        return Car.class;
    }
}
