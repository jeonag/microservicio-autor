package com.programacion.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;


import com.programacion.client.ServerPersonsImpl;

//import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.programacion.modelo.*;
//import com.programacion.rest.authorService;
import com.programacion.service.ServicioPersonas;

@ApplicationScoped
@Transactional
public class ServicioPersonasImpl implements ServicioPersonas {

	@PersistenceContext
	EntityManager em;

	@Inject
	ServerPersonsImpl direccionServicio;

	@Override
	public Persona findById(Integer id) {
		Persona person = em.find(Persona.class, id);
		em.detach(person);
		return person;
	}

	@Override
	public List<Persona> listAll() {
		TypedQuery<Persona> que = em.createQuery("SELECT b FROM Persona b order by b.id", Persona.class);
//		return que.getResultList();
		List<Persona> listaPer = que.getResultList();
		List<TipoDireccion> listaDireccion = direccionServicio.listarDirecciones();
		List<Persona> lista = new ArrayList<>();

		for (Persona per : listaPer) {
			for (TipoDireccion dir : listaDireccion) {
				if (per.getTipodireccion_id() == dir.getId()) {
					per.setTipoDireccion(dir);
					lista.add(per);
				}
			}
		}
		return lista;

	}

	@Transactional
	@Override
	public Persona create(Persona persona) {
		if (Objects.nonNull(persona.getId())) {
			throw new IllegalStateException("Id null");
		}
		em.persist(persona);
		return persona;
	}

	@Transactional
	@Override
	public void updatePersona(Persona persona) {
//		Persona entity = em.find(Persona.class, persona.getId());
//		entity.setIsbn(persona.getIsbn());
//		entity.setTitle(persona.getTitle());
//		entity.setAuthor_id(persona.getAuthor_id());
	}

	@Transactional
	@Override
	public void deleteById(Integer id) {
		Persona entity = em.find(Persona.class, id);
		em.remove(entity);
	}

	

}
