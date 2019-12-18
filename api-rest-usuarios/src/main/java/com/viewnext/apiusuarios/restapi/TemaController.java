package com.viewnext.apiusuarios.restapi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.viewnext.apiusuarios.model.AlmacenDAOTemas;

@RestController()
@RequestMapping("/api/tema")
public class TemaController {

	// Inyeccion de dependencias: Spring se encarga de instanciar el DAO (obj, no interfaz) y asignarlo a nuestro Restcontroller
	@Autowired 
	private AlmacenDAOTemas dao;
	
	@PostMapping()
	public Tema crearTema(@RequestBody Tema tema) {    // Recibe sin ID en el body de la peticion http y deserializa el JSON a un obj Temas
		return dao.save(tema);       // Devuelve con ID
	}
	
	@PostMapping(value = "/lista")
	public void crearListaTemas(@RequestBody List<Tema> tema) {
		for(Tema lista: tema) {
			dao.save(lista);
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public void borrarTema(@PathVariable Integer id) {
		
		dao.deleteById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Tema modificarTema(@PathVariable Integer id, @RequestBody Tema tema) {
	
		tema.setId(id);
		return dao.save(tema);
	}
	
	@GetMapping
	public List<Tema> leerTodos() {
		return dao.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Tema getTema(@PathVariable Integer id) {
		
		Optional <Tema> tema = dao.findById(id);
		return tema.orElse(null);
	}

	@PostMapping(value="/formulario")
	public Tema crearTemasPorParam(@RequestParam (name="nombre")String name, @RequestParam String descripcion) {
		
		Tema tema = new Tema(null, name, descripcion);
		return dao.save(tema);
	}
}
