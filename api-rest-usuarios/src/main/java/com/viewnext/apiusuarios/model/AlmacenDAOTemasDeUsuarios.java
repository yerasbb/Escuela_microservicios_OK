package com.viewnext.apiusuarios.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.viewnext.apiusuarios.entidades.TemaDeUsuario;
import com.viewnext.apiusuarios.entidades.TemaDeUsuarioPK;

public interface AlmacenDAOTemasDeUsuarios extends JpaRepository<TemaDeUsuario, TemaDeUsuarioPK>{

	@Query(value="SELECT tu.* FROM tema_de_usuario AS tu INNER JOIN usuario AS u ON u.id = tu.id_usuario WHERE tu.id_usuario = ?1", nativeQuery = true)
	public List<TemaDeUsuario> findTemasDeUnUsuario(Integer idUsuario);
	
	@Transactional
	@Modifying
	@Query(value="DELETE FROM tema_de_usuario tu WHERE tu.id_usuario = ?1", nativeQuery = true)
	public void DeleteTemasDeUnUsuario(Integer idUsuario); 
	
}
