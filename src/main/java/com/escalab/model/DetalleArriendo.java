package com.escalab.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_arriendo")
@IdClass(DetalleArriendoPK.class)
public class DetalleArriendo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDetalleArriendo;

	private Maquina maquina;
	private Arriendo arriendo;

	public Integer getIdDetalleArriendo() {
		return idDetalleArriendo;
	}

	public void setIdDetalleArriendo(Integer idDetalleArriendo) {
		this.idDetalleArriendo = idDetalleArriendo;
	}

	public Maquina getMaquina() {
		return maquina;
	}

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}

	public Arriendo getArriendo() {
		return arriendo;
	}

	public void setArriendo(Arriendo arriendo) {
		this.arriendo = arriendo;
	}
}
