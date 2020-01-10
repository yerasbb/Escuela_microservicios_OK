package com.viewnext.apiusuarios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.viewnext.apiusuarios.entidades.Usuario;
import com.viewnext.apiusuarios.model.AlmacenDAOUsuarios;

@SpringBootTest
public class ApiRestTestSecurity {

	
	@Autowired 
	private AlmacenDAOUsuarios dao;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
		
	@Test
	public void crearUsuario() {
		Usuario usu = new Usuario();
		usu.setNombre("Jorgito");
//		Encriptamiento 
		String passEncript = bCryptPasswordEncoder.encode("321");
		usu.setPassword(passEncript);
		usu.setEmail("j@gmail.com");
		Usuario usuGuard = dao.save(usu);
		
		assertEquals(usuGuard.getEmail(), usu.getEmail());
		assertEquals(usuGuard.getPassword(), usu.getPassword());
		assertEquals(dao.findByNombre("Jorgito").getNombre(), "Jorgito");
		
		
		
	}
	
}
