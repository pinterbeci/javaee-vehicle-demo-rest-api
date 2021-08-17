package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.MenuItem;
import hu.ulyssys.java.course.maven.service.MenuItemService;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuElement;
import org.primefaces.model.menu.MenuModel;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScoped
public class MenuProviderMBean {

    @Inject
    private MenuItemService service;

    @Inject
    private LoggedInUserBean loggedInUserBean;


    public MenuModel getMenuModel() {
        DefaultMenuModel menuModel = new DefaultMenuModel();
        service.getAll().forEach(menuItem -> {
            addMenuItem(menuModel, menuItem);
        });

  /*      addMenuItem(menuModel, "CAR", "/xhtml/car.xhtml", "pi pi-directions");
        addMenuItem(menuModel, "SHIP", "/xhtml/ship.xhtml", "pi pi-directions");
        addMenuItem(menuModel, "PLANE", "/xhtml/plane.xhtml", "pi pi-directions");
        addMenuItem(menuModel, "OWNER", "/xhtml/owner.xhtml", "pi pi-directions");
        addMenuItem(menuModel, "Pintér úr instája", "https://instagram.com/pinterbeci", "pi pi-directions");
       */
        return menuModel;
    }

  /*  private void addMenuItem(DefaultMenuModel menuModel, String label, String href, String icon) {

//kommentezett rész összefügg, csak rövidítés történt
        DefaultMenuItem element = new DefaultMenuItem();
        element.setHref(href);
        element.setValue(label);
        element.setIcon(icon);
        menuModel.getElements().add(element);

    }*/

    private void addMenuItem(DefaultMenuModel menuModel, MenuItem menuItem) {

        DefaultMenuItem element = new DefaultMenuItem();
        element.setHref(menuItem.getUrl());
        element.setValue(menuItem.getLabel());

        if (Boolean.FALSE.equals(menuItem.getAdminFunction()) || menuItem.getAdminFunction() == null
                || (Boolean.TRUE.equals(menuItem.getAdminFunction()) && loggedInUserBean.isAdmin()))
            menuModel.getElements().add(element);

    }
}
