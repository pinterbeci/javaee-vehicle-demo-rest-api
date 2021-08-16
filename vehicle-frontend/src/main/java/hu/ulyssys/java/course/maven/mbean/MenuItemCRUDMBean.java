package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.MenuItem;
import hu.ulyssys.java.course.maven.service.CoreService;
import hu.ulyssys.java.course.maven.service.MenuItemService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class MenuItemCRUDMBean extends CoreCRUDMBean<MenuItem> implements Serializable {


    @Inject
    public MenuItemCRUDMBean(MenuItemService service) {
        super(service);
    }

    @Override
    protected String dialogName() {
        return "menuDialog";
    }

    @Override
    protected MenuItem initNewEntity() {
        return new MenuItem();
    }
}
