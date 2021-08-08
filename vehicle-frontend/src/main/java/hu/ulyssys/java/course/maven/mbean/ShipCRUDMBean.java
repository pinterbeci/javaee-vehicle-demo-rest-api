package hu.ulyssys.java.course.maven.mbean;



import hu.ulyssys.java.course.maven.entity.Ship;
import hu.ulyssys.java.course.maven.service.CoreService;
import hu.ulyssys.java.course.maven.service.OwnerService;
import hu.ulyssys.java.course.maven.service.ShipService;


import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;


@Named
@ViewScoped
public class ShipCRUDMBean extends OwnerAwareCRUDMBean<Ship> implements Serializable {

    @Inject
    public ShipCRUDMBean(ShipService service, OwnerService ownerService) {
        super(service, ownerService);
    }

    @Override
    protected String dialogName() {
        return "shipDialog";
    }

    @Override
    protected Ship initNewEntity() {
        return new Ship();
    }
}