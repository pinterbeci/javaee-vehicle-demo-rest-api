package hu.ulyssys.java.course.maven.mbean;



import hu.ulyssys.java.course.maven.entity.Owner;
import hu.ulyssys.java.course.maven.service.OwnerService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import java.io.Serializable;


@Named
@ViewScoped
public class OwnerCRUDMbean  extends CoreCRUDMBean<Owner> implements Serializable {

    @Inject
    public OwnerCRUDMbean(OwnerService service) {
        super(service);
    }

    @Override
    protected String dialogName() {
        return "ownerDialog";
    }

    @Override
    protected Owner initNewEntity() {
        return new Owner();
    }
}
