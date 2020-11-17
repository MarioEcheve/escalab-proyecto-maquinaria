package com.escalab.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información Maquina")
@Entity
@Table(name = "maquina")
public class Maquina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMaquina;
	
	@Column(name = "numero_serie", length = 30, nullable = false)
	private String numeroSerie;

	@ApiModelProperty(notes = "Estado Maquina debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Estado Maquina debe tener minimo 3 caracteres")
	@Column(name = "estado_maquina", length = 45, nullable = false)
	private String estadoMaquina;

	@ManyToOne
	@JoinColumn(name = "id_tipo_maquina", nullable = false, foreignKey = @ForeignKey(name = "FK_maquina_tipo_maquina"))
	private TipoMaquina tipoMaquina;

	public Integer getIdMaquina() {
		return idMaquina;
	}

	public void setIdMaquina(Integer idMaquina) {
		this.idMaquina = idMaquina;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public String getEstadoMaquina() {
		return estadoMaquina;
	}

	public void setEstadoMaquina(String estadoMaquina) {
		this.estadoMaquina = estadoMaquina;
	}

	public TipoMaquina getTipoMaquina() {
		return tipoMaquina;
	}

	public void setTipoMaquina(TipoMaquina tipoMaquina) {
		this.tipoMaquina = tipoMaquina;
	}
}
