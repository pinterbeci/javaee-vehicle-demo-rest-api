package hu.ulyssys.java.course.maven.dao.impl;

import hu.ulyssys.java.course.maven.dao.OwnerDAO;
import hu.ulyssys.java.course.maven.entity.Owner;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Stateless
public class OwnerDAOImpl extends CoreDAOImpl<Owner> implements OwnerDAO {

    @Override
    protected Class<Owner> getManagedClass() {
        return Owner.class;
    }

    @Override
    public Owner findByName(String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Owner> criteriaQuery = criteriaBuilder.createQuery(Owner.class);
        Root<Owner> root = criteriaQuery.from(Owner.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("fullName"), name));
        TypedQuery<Owner> query = entityManager.createQuery(criteriaQuery);

        //TypedQuery<Farmer> query = entityManager.createQuery("select f from Farmer f where f.fullName=:name", Farmer.class);
        List<Owner> list = query.getResultList();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
