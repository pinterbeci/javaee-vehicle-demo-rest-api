package hu.ulyssys.java.course.maven.mbean;



import hu.ulyssys.java.course.maven.entity.Plane;
import hu.ulyssys.java.course.maven.service.CoreService;
import hu.ulyssys.java.course.maven.service.OwnerService;
import hu.ulyssys.java.course.maven.service.PlaneService;


import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;


@Named
@ViewScoped
public class PlaneCRUDMBean extends OwnerAwareCRUDMBean<Plane> implements Serializable {

    @Inject
    public PlaneCRUDMBean(PlaneService service, OwnerService ownerService) {
        super(service, ownerService);
    }

    @Override
    protected String dialogName() {
        return "planeDialog";
    }

    @Override
    protected Plane initNewEntity() {
        return new Plane();
    }
}