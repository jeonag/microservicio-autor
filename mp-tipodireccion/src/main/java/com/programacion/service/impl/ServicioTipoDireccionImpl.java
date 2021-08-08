package com.programacion.service.impl;

import java.util.List;
import java.util.Objects;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.programacion.model.TipoDireccion;
import com.programacion.service.ServicioTipoDireccion;

@Transactional
@ApplicationScoped
public class ServicioTipoDireccionImpl implements ServicioTipoDireccion {

	@Inject
	EntityManager em;

	@Inject
	@ConfigProperty(name = "quarkus.http.port", defaultValue = "8080")
	private Integer appPort;

	public TipoDireccion findById(Integer id) {
		TipoDireccion direccion = em.find(TipoDireccion.class, id);
		em.detach(direccion);
		return direccion;
	}

	@Override
	public List<TipoDireccion> listAll() {
		TypedQuery<TipoDireccion> que = em.createQuery("SELECT c FROM TipoDireccion c", TipoDireccion.class);
		return que.getResultList();

//		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
//		CriteriaQuery<TipoDireccion> query = criteriaBuilder.createQuery(TipoDireccion.class);
//		query.from(TipoDireccion.class);
//		return em.createQuery(query).getResultList();
	}

	@Transactional
	@Override
	public TipoDireccion create(TipoDireccion t_direccion) {
		if (Objects.nonNull(t_direccion.getId())) {
			throw new IllegalStateException("Id null");
		}
		em.persist(t_direccion);
		return t_direccion;
	}

	@Transactional
	@Override
	public void updateTipoDireccion(TipoDireccion direccion) {
		TipoDireccion entity = em.find(TipoDireccion.class, direccion.getId());
		entity.setDescripcion(direccion.getDescripcion());
	}

	@Transactional
	@Override
	public void deleteById(Integer id) {
		TipoDireccion entity = em.find(TipoDireccion.class, id);
		em.remove(entity);
	}

}