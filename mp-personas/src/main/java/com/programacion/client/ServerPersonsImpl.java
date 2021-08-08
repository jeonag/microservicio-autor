package com.programacion.client;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.programacion.modelo.TipoDireccion;

@ApplicationScoped
public class ServerPersonsImpl {
	
	@Inject
	@RestClient
	ServerPersons cliente;
	
	public List<TipoDireccion> listarDirecciones(){
		return cliente.listarDirecciones();
	}
	

}
