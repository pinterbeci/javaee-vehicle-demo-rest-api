package hu.ulyssys.java.course.maven.dao.impl;

import hu.ulyssys.java.course.maven.dao.CarDAO;
import hu.ulyssys.java.course.maven.entity.Car;


import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;


@Stateless
public class CarDAOImpl extends CoreDAOImpl<Car> implements CarDAO {

    @Override
    protected Class<Car> getManagedClass() {
        return Car.class;
    }

    @Override
    public List<Car> findOnwerByID(Long id) {

        //todo figyelj oda, hogy van megadva az ID!!!!!!!
        //:[paraméter neve]
        TypedQuery<Car> query =
                entityManager.createQuery("SELECT n FROM Car n WHERE n.owner.id = :id ORDER BY n.id", getManagedClass());
        query.setParameter("id", id);
        return query.getResultList();
    }
}

