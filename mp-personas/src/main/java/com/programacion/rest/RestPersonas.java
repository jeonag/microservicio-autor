package com.programacion.rest;

import java.net.UnknownHostException;
import java.util.List;

import javax.ws.rs.Produces;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import com.programacion.modelo.Persona;
import com.programacion.service.ServicioPersonas;

@Path("/personas")
@ApplicationScoped
public class RestPersonas {

	@Inject
	ServicioPersonas serivicioPersonas;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Persona> listar() throws UnknownHostException {
		System.out.println("\n [servicioPersonas]");
		return serivicioPersonas.listAll();
	}


	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Persona listarById(@PathParam("id") Integer id) throws UnknownHostException {
		System.out.println("\n [servicioPersonas]");
		return serivicioPersonas.findById(id);
	}


	@POST
	@Transactional
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Persona person) throws UnknownHostException{
		serivicioPersonas.create(person);
		return Response.created(UriBuilder.fromResource(RestPersonas.class).path(String.valueOf(person.getId())).build())
				.build();
	}

	@PUT
	@Path("/{id}")
	@Transactional
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") Integer id, Persona person) throws UnknownHostException{
		serivicioPersonas.updatePersona(person);
		return Response.noContent().build();
	}
	@DELETE
	@Transactional
	@Path("{id}")
	public void delete(@PathParam("id") Integer id) throws UnknownHostException{ 
		Persona person = serivicioPersonas.findById(id);
		serivicioPersonas.deleteById(person.getId());
	}

}
