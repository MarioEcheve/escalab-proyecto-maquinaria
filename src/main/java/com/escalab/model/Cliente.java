package com.escalab.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información del Cliente")
@Entity
@Table(name="cliente")

public class Cliente {
	
	@Id
	@Column(name = "rut_cliente", length = 9, nullable = false)
	private String rutCliente;
	
	@ApiModelProperty(notes = "Nombres debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Nombres debe tener minimo 3 caracteres")
	@Column(name="nombres", nullable = false , length = 45)
	private String nombres;
	
	@ApiModelProperty(notes = "Apellido Paterno debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Apellido Paterno debe tener minimo 3 caracteres")
	@Column(name="apellido_paterno", nullable = false , length = 45)
	private String apellidoPaterno;
	
	@ApiModelProperty(notes = "Apellido Materno debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Apellido Materno debe tener minimo 3 caracteres")
	@Column(name="apellido_materno", nullable = false , length = 45)
	private String apellidoMaterno;
	
	@ApiModelProperty(notes = "Telefono debe tener 10 caracteres")
	@Size(min = 10, max = 10, message = "Telefono debe tener 10 caracteres")
	@Column(name="telefono", nullable = true , length = 10)
	private String telefono;
	
	@Email
	@Column(name = "email", nullable = true, length = 45)
	private String email;
	
	@ApiModelProperty(notes = "Nacionalidad tener minimo 3 caracteres")
	@Size(min = 3, message = "Nacionalidad tener minimo 3 caracteres")
	@Column(name="nacionalidad", nullable = true , length = 45)
	private String nacionalidad;
	
	@ApiModelProperty(notes = "Nombre Empresa debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Nombre Empresa debe tener minimo 3 caracteres")
	@Column(name="nombre_empresa", nullable = false , length = 45)
	private String nombreEmpresa;

	public String getRutCliente() {
		return rutCliente;
	}

	public void setRutCliente(String rutCliente) {
		this.rutCliente = rutCliente;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
}
