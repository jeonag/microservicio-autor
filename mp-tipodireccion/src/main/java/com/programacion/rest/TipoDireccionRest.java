package com.programacion.rest;

import java.util.List;
import javax.ws.rs.Produces;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import com.programacion.model.TipoDireccion;
import com.programacion.service.ServicioTipoDireccion;

@Path("/direcciones")
@ApplicationScoped
public class TipoDireccionRest {

	@Inject
	ServicioTipoDireccion servicioTipoDireccion;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TipoDireccion> listAll() {
		return servicioTipoDireccion.listAll();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public TipoDireccion findById(@PathParam("id") Integer id) {
		return servicioTipoDireccion.findById(id);

	}

	@POST
	@Transactional
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(TipoDireccion dir) {
		servicioTipoDireccion.create(dir);
		return Response
				.created(UriBuilder.fromResource(TipoDireccionRest.class).path(String.valueOf(dir.getId())).build())
				.build();

	}

	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Response update(@PathParam("id") Integer id, TipoDireccion dir) {
		servicioTipoDireccion.updateTipoDireccion(dir);
		return Response.noContent().build();

	}

	@DELETE
	@Transactional
	@Path("{id}")
	public void delete(@PathParam("id") Integer id) {
		TipoDireccion autor = servicioTipoDireccion.findById(id);
		servicioTipoDireccion.deleteById(autor.getId());
	}

}
