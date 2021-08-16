package hu.ulyssys.java.course.maven.service;


import hu.ulyssys.java.course.maven.entity.Car;

import java.util.List;

public interface CarService extends CoreService<Car> {

    List<Car> findOnwerByID(Long id);
}
