package com.programacion.service;

import java.util.List; 
import com.programacion.model.TipoDireccion;

public interface ServicioTipoDireccion {

	public TipoDireccion findById(Integer id);

	public List<TipoDireccion> listAll();

	public TipoDireccion create(TipoDireccion direccion);

	public void updateTipoDireccion(TipoDireccion direccion);

	public void deleteById(Integer id);

}
