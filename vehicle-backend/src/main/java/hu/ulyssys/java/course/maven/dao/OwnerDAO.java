package hu.ulyssys.java.course.maven.dao;


import hu.ulyssys.java.course.maven.entity.Owner;


public interface OwnerDAO extends CoreDAO<Owner> {

    Owner findByName(String name);
}
