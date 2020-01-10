package com.viewnext.apiusuarios.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.viewnext.apiusuarios.entidades.Usuario;
import com.viewnext.apiusuarios.model.AlmacenDAOUsuarios;

@Service
public class ServicioUsuarios implements UserDetailsService {
	
	@Autowired 
	private AlmacenDAOUsuarios dao;

	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		
		Usuario usu = dao.findByNombre(username);
		
		List<GrantedAuthority> listaRoles = new ArrayList<GrantedAuthority>();
		listaRoles.add(new SimpleGrantedAuthority("ADMIN"));
		//Aquí deberíamos tener una tabla para los roles 
		//donde usuario tuviese una FK a la tabla de roles 
		//o un campo con el rol asociado
		//o una conexión contra LDAP...
		//o un RestTemplate pidiendo el usuario a otro microservicio
		
		UserDetails detallesUsuario = new User(usu.getNombre(), usu.getPassword(), listaRoles);
		
		return detallesUsuario;
	}

}
