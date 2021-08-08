package hu.ulyssys.java.course.maven.service;



import hu.ulyssys.java.course.maven.entity.Owner;



public interface OwnerService extends CoreService<Owner> {
    Owner findByName(String name);
}
