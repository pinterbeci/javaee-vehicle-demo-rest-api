package hu.ulyssys.java.course.maven.service;


import hu.ulyssys.java.course.maven.dao.OwnerDAO;
import hu.ulyssys.java.course.maven.entity.Owner;

import javax.ejb.Stateless;


@Stateless
public class OwnerServiceImpl extends AbstractServiceImpl<Owner> implements OwnerService {

    @Override
    public Owner findByName(String name) {
        return ((OwnerDAO) dao).findByName(name);
    }
}
