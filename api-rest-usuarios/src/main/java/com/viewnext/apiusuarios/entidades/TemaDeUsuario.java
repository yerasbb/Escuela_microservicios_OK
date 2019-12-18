package com.viewnext.apiusuarios.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tema_de_usuario")
public class TemaDeUsuario {

	@EmbeddedId
	private TemaDeUsuarioPK idsPk;
	
	@Column(name = "timestamp", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;
	
	@ManyToOne()
	@JoinColumn(name="id_usuario", referencedColumnName = "id", insertable = false, updatable = false)
	private Usuario usuario;
	
	@ManyToOne()
	@JoinColumn(name="id_tema", referencedColumnName = "id", insertable = false, updatable = false)
	private Tema tema;
	
	public TemaDeUsuario() {
		super();
	}
	
	public TemaDeUsuario(Integer idUsuario, Integer idTema) {
		this.idsPk =  new TemaDeUsuarioPK(idUsuario, idTema);
	}

	public TemaDeUsuarioPK getIdsPk() {
		return idsPk;
	}

	public void setIdsPk(TemaDeUsuarioPK idsPk) {
		this.idsPk = idsPk;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	
}
