package com.escalab.model;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class DetalleArriendoPK implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "numero_serie", nullable = false)
	private Maquina maquina;
	
	@ManyToOne
	@JoinColumn(name = "id_arriendo", nullable = false)
	private Arriendo arriendo;
}
