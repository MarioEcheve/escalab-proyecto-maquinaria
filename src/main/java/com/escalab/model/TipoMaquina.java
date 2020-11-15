package com.escalab.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_maquina")
public class TipoMaquina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTipoMaquina;

	@Column(name = "marca", length = 45, nullable = true)
	private String marca;

	@Column(name = "modelo", length = 45, nullable = true)
	private String modelo;

	@Column(name = "descripcion", length = 100, nullable = true)
	private String descripcion;

	@Column(name = "precio")
	private Integer precio;

	public Integer getIdTipoMaquina() {
		return idTipoMaquina;
	}

	public void setIdTipoMaquina(Integer idTipoMaquina) {
		this.idTipoMaquina = idTipoMaquina;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

}
