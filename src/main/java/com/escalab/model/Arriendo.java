package com.escalab.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="arriendo")
public class Arriendo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idArriendo;
	
	@Column(name="monto_final", nullable = false)
	private Integer montoFinal;
	
	@Column(name="fecha_inicio", nullable = false)
	private Date fechaInicio;
	
	@Column(name="fecha_termino", nullable = false)
	private Date fechaTermino;
	
	@Column(name="observacion", nullable = true)
	private String observacion;
	
	@Column(name="fecha_entrega", nullable = false)
	private Date fechaEntrega;
	
	@Column(name="estado_arriendo", nullable = false , length = 1)
	private String estadoArriendo;
	
	@ManyToOne
	@JoinColumn(name = "rut_cliente", nullable = false, foreignKey = @ForeignKey(name = "FK_arriendo_cliente"))
	private Cliente cliente;

	public Integer getIdArriendo() {
		return idArriendo;
	}

	public void setIdArriendo(Integer idArriendo) {
		this.idArriendo = idArriendo;
	}

	public Integer getMontoFinal() {
		return montoFinal;
	}

	public void setMontoFinal(Integer montoFinal) {
		this.montoFinal = montoFinal;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaTermino() {
		return fechaTermino;
	}

	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getEstadoArriendo() {
		return estadoArriendo;
	}

	public void setEstadoArriendo(String estadoArriendo) {
		this.estadoArriendo = estadoArriendo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
