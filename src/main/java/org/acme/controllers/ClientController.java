package org.acme.controllers;

import java.util.List;

import org.acme.entities.Client;
import org.acme.services.ClientService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/clients")
public class ClientController {

    @Inject
    private ClientService service;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<Client> list = service.findAll();
        return Response.ok(list).build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        Client client = service.findById(id);
        return Response.ok(client).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert(Client obj) {
        service.insert(obj);
        return Response.status(Response.Status.CREATED).entity(obj).build();
    }
    
    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Client obj, @PathParam("id") Long id) {
        service.update(obj, id);
        return Response.ok(obj).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
