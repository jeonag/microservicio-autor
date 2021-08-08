package com.programacion.service;

import java.util.List;

import com.programacion.modelo.*; 

public interface ServicioPersonas {
	public Persona findById(Integer id);

	public List<Persona> listAll();

	public Persona create(Persona persona);

	public void updatePersona(Persona persona);

	public void deleteById(Integer id);

	
 

}
