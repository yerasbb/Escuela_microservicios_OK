import { Injectable } from '@angular/core';
import { Usuario } from './entidades/Usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  listaUsuario: Usuario[];
  
  constructor() { 

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

  }

  public getTodosUsuarios(): Usuario[]{
    return this.listaUsuario;
  }
}
