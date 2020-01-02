import { Injectable } from '@angular/core';
import { Usuario } from './entidades/Usuario';
import { AlmacenLocalService } from './almacen-local.service'

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  listaUsuario: Usuario[];
  public srvAlm: AlmacenLocalService;
  
  constructor(srvAlm: AlmacenLocalService) { 
23
    this.listaUsuario = [{
       id:1,
       nombre:"PAko", 
       email: "pak@em.com", 
       password: "123", 
       idTemaPreferido: 1},
       {id:2,
        nombre:"Fernando", 
        email: "Fer@em.com", 
        password: "123", 
        idTemaPreferido: 2}];
    this.srvAlm = srvAlm;
       
    this.listaUsuario = srvAlm.leer("usuarios"); 
    
  }

  public getTodosUsuarios(): Usuario[]{
    this.listaUsuario.push({
      id:this.listaUsuario.length,
      nombre:"Fernando", 
      email: "fer@em.com", 
      password: "123", 
      idTemaPreferido: 1});

    this.srvAlm.guardar("usuarios",this.listaUsuario);

    return this.listaUsuario;
  }
}
