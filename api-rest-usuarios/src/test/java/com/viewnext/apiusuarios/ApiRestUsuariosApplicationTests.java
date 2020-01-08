package com.viewnext.apiusuarios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.viewnext.apiusuarios.entidades.Tema;
import com.viewnext.apiusuarios.entidades.Usuario;
import com.viewnext.apiusuarios.model.AlmacenDAOTemas;
import com.viewnext.apiusuarios.model.AlmacenDAOUsuarios;

@SpringBootTest
class ApiRestUsuariosApplicationTests {
	
	//Spring hace un daoTemas = new AlmacenDAOTemas() y lo asigna
	//automaticamente a esta variable, esto es IoD (Inyección de dependencias)
	@Autowired
	private AlmacenDAOTemas daoTemas;
	
	
	@Autowired
	private AlmacenDAOUsuarios daoUsuarios;

//	@Test
	void contextLoads() {
	}
	//TODO: Estos test no sirven porque usan IDs fijos
//	por eso se desactivan
	//@Test
	void testTemaPreferido() {
		Tema tema = daoTemas.findById(1).orElse(null);
		assertEquals(1, tema.getId());
		assertNotEquals(0, tema.getNombre().length());
		
		Usuario usu = daoUsuarios.findById(1).orElse(null);
		//Busca el registro de usuario e instancia un new Usuario
		//mapeando los campos de la tabla en las variables miembro(propiedades), 
		//y también hace lo mismo, en esta llamada con la propiedad de usu.temaPreferido con Tema, 
		//por las anotaciones @ManyToOne y @JoinColumn,
		//Es decir hace otro SELECT * FROM TEMA WHERE....e instancia un new tema() y mapea los campos correspondientes
		
		assertNotNull(usu);
		usu.setIdTemaPreferido(tema.getId());
		
		daoUsuarios.save(usu);
		usu = daoUsuarios.findById(1).orElse(null);
		
		Integer idTemaPref = usu.getIdTemaPreferido();
		assertEquals(tema.getId(), idTemaPref);
		
		Tema temaPref = usu.getTemaPreferido();
		assertEquals(tema.getNombre(), temaPref.getNombre());
		
		Set<Usuario> usuariosPref = tema.getUsuariosPref();
		for (Usuario usuario: usuariosPref) {
			System.out.println("Usuario " + usuario.getNombre() + " prefiere " + tema.getNombre());
		}
		assertNotEquals(0,usuariosPref.size());
		
	}

}
