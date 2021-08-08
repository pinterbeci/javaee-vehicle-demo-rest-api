package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.entity.AbstractVehicle;
import hu.ulyssys.java.course.maven.entity.Owner;
import hu.ulyssys.java.course.maven.rest.model.CoreRestModel;
import hu.ulyssys.java.course.maven.service.CoreService;
import hu.ulyssys.java.course.maven.service.OwnerService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.stream.Collectors;

public abstract class CoreRestService<T extends AbstractVehicle, M extends CoreRestModel> {

    @Inject
    private OwnerService ownerService;

    @Inject
    private CoreService<T> service;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(service.getAll().stream().map(this::createModelFromEntity).
                collect(Collectors.toList())).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findVehicleByOwnerID(@PathParam("id") Long id) {
        Owner owner = ownerService.findById(id);

        if (owner == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(service.getAll().stream().filter(e -> e.getOwner().equals(owner)).
                collect(Collectors.toList())).build();
    }
    @GET
    @Path("/find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findVehicleByID(@PathParam("id") Long id) {
        T entity = service.findById(id);

        if( entity == null ){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(entity).build();
    }



    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid M model) {

        T entity = initNewEntity();
        populateEntityFromModel(entity, model);
        service.add(entity);
        return Response.ok(createModelFromEntity(entity)).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid M model) {
        T entity = service.findById(model.getId());
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        populateEntityFromModel(entity, model);
        service.update(entity);
        return Response.ok(createModelFromEntity(entity)).build();

    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        T entity = service.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        service.remove(entity);
        return Response.ok().build();
    }

    protected void populateEntityFromModel(T entity, M model) {
        if (model.getOnwerID() != null) {
            entity.setOwner(ownerService.findById(model.getOnwerID()));
        }
        entity.setName(model.getName());
        entity.setLicencePlateNumber(model.getLicencePlateNumber());
    }

    protected M createModelFromEntity(T entity) {
        M model = initNewModel();
        model.setLicencePlateNumber(entity.getLicencePlateNumber());
        model.setId(entity.getId());
        model.setName(entity.getName());
        if (entity.getOwner() != null) {
            model.setOnwerID(entity.getOwner().getId());
        }
        return model;
    }

    protected T initNewEntity() {

        try {
            Class<T> type = (Class<T>) (((ParameterizedType) ((Class) getClass().getGenericSuperclass()).getGenericSuperclass())).getActualTypeArguments()[1];
            return type.getConstructor().newInstance();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }


    protected abstract M initNewModel();
}
