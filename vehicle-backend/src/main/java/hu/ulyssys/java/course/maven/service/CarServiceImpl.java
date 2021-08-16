package hu.ulyssys.java.course.maven.service;


import hu.ulyssys.java.course.maven.dao.CarDAO;
import hu.ulyssys.java.course.maven.entity.Car;

import javax.ejb.Stateless;
import java.util.List;


@Stateless
public class CarServiceImpl extends AbstractServiceImpl<Car> implements CarService {

    @Override
    public List<Car> findOnwerByID(Long id) {
        return ((CarDAO) dao).findOnwerByID(id);
    }
}
