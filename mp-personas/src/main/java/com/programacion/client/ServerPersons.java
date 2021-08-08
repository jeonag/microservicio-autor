package com.programacion.client;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.programacion.modelo.TipoDireccion;

@RegisterRestClient(baseUri = "http://127.0.0.1:8085/direcciones")
public interface ServerPersons {
	
	@GET
	@Consumes(value = MediaType.APPLICATION_JSON)
	public List<TipoDireccion> listarDirecciones();
}
