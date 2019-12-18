package com.viewnext.apiusuarios.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.validation.constraints.NotNull;

//Permite que esta clase sea usada (como EmbeddedId) por otra clase como ID
@Embeddable
public class TemaDeUsuarioPK implements Serializable {

	private static final long serialVersionUID = -5605757244443886858L;

	@NotNull
	@Column(name="id_usuario")
	private Integer idUsuario;

	@Column(name="id_tema", nullable = false)
	private Integer idTema;
	


	public TemaDeUsuarioPK() {
		super();
	}

	public TemaDeUsuarioPK(@NotNull Integer usuario, Integer tema) {
		super();
		this.idUsuario = usuario;
		this.idTema = tema;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdTema() {
		return idTema;
	}

	public void setIdTema(Integer idTema) {
		this.idTema = idTema;
	}

	
	
}
