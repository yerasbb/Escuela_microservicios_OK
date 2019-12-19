package com.viewnext.apiusuarios.restapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.viewnext.apiusuarios.entidades.Usuario;

/**
 * Cliente REST de API Json y XML, a su vez que es una API REST general.
 * @author alumno
 *
 */
@RestController
@RequestMapping("/api/main/usuarios")
public class UsuariosMainController {
	
	String url= "172.16.2.12";
	
	public static class ListaUsuario extends ArrayList<Usuario>{
		
	}
	
	@GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Usuario> leerTodosTodos(){
		
		List<Usuario> listaTotal = null;
		final String uriApiJson = "http://" + url + ":8081/api/usuarios";
		RestTemplate restTemplate = new RestTemplate();
		//Invocamos al método Get http sobre api json 0.0.1
		//y se encarga de des-serializar el JSON En un ArrayList<Usuario>
		listaTotal = restTemplate.getForObject(uriApiJson, ListaUsuario.class);
		
		List<Usuario> listaTotalXML = null;
		//Pedir todos del API XML y añadirlo a la listaTotal
		final String uriApiXML = "http://" + url + ":8082/api/xml/usuarios";
		RestTemplate restTemplateXML = new RestTemplate();
		listaTotalXML = restTemplateXML.getForObject(uriApiXML, ListaUsuario.class);
		
		if(!listaTotalXML.isEmpty()) {
			for (Usuario usuario: listaTotalXML) {
				listaTotal.add(usuario);
			}	
		}
		
		
		return listaTotal;
		
	}

	
	

}
