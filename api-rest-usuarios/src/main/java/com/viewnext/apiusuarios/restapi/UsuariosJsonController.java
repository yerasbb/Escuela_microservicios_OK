package com.viewnext.apiusuarios.restapi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.apiusuarios.entidades.Tema;
import com.viewnext.apiusuarios.entidades.TemaDeUsuario;
import com.viewnext.apiusuarios.entidades.TemaDeUsuarioPK;
import com.viewnext.apiusuarios.entidades.Usuario;
import com.viewnext.apiusuarios.model.AlmacenDAOTemas;
import com.viewnext.apiusuarios.model.AlmacenDAOTemasDeUsuarios;
import com.viewnext.apiusuarios.model.AlmacenDAOUsuarios;

@RestController()
@RequestMapping("/api/json/usuarios")
@CrossOrigin(origins="*")
public class UsuariosJsonController {

	// Inyeccion de dependencias: Spring se encarga de instanciar el DAO (obj, no interfaz) y asignarlo a nuestro Restcontroller
	@Autowired 
	private AlmacenDAOUsuarios dao;

	
	@Autowired
	private AlmacenDAOTemasDeUsuarios daoTemasUsu;
	
	@Autowired
	private AlmacenDAOTemas daoTemas;
	
	@PostMapping()
	public Usuario crearUsuario(@RequestBody Usuario usuario) {    // Recibe sin ID en el body de la peticion http y deserializa el JSON a un obj Usuario
		return dao.save(usuario);       // Devuelve con ID
	}
	
	@DeleteMapping(value = "/{id}")
	public void borrarUsuario(@PathVariable Integer id) {
		
		daoTemasUsu.DeleteTemasDeUnUsuario(id);
		dao.deleteById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Usuario modificarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
	
		usuario.setId(id);
		return dao.save(usuario);
	}
	
	@GetMapping
	public List<Usuario> leerTodos() {
		return dao.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Usuario getUsuario(@PathVariable Integer id) {
		
		Optional <Usuario> usu = dao.findById(id);
		return usu.orElse(null);
	}
	
	
	@PostMapping(value="/formulario")
	public Usuario crearUsuarioPorParam(@RequestParam (name="nombre")String name, @RequestParam String email, @RequestParam String password) {
		
		Usuario usu = new Usuario(null, name, email, password);
		return dao.save(usu);
	}
	
	@GetMapping(value = "/{idUsuario}/temas_usu")
	public List<TemaDeUsuario> getTemasDeUsuario(@PathVariable Integer idUsuario) {
		
		List<TemaDeUsuario> temasUsu = daoTemasUsu.findTemasDeUnUsuario(idUsuario);
		return temasUsu;
	}
	
	@GetMapping(value = "/{idUsuario}/temas")
	public List<Tema> getTemasPorUsuario(@PathVariable Integer idUsuario) {
		
		List<Tema> temasUsu = daoTemas.findTemasPorUsuario(idUsuario);
		return temasUsu;
	}
	
	@PostMapping(value="/{id}/temas/{idt}")
	public TemaDeUsuario addTemaDeUsuario(@PathVariable Integer id, @PathVariable(name="idt") Integer idTema) {
		
		TemaDeUsuario nuevoTema = new TemaDeUsuario(id, idTema);
		
		return daoTemasUsu.save(nuevoTema);
	}
	
	@DeleteMapping(value="/{id}/temas/{idt}")
	public String deleteTemaDeUsuario(@PathVariable Integer id, @PathVariable(name="idt") Integer idTema) {
		
		daoTemasUsu.deleteById(new TemaDeUsuarioPK(id, idTema));
		
		return "Tema de usuario borrado";
	}
}
