import { Component, OnInit } from '@angular/core';
import { UsuariosService } from '../usuarios.service';
import {Usuario} from '../entidades/Usuario';
import { AlmacenLocalService } from '../almacen-local.service';
import { UsuariosRestService } from '../usuarios-rest.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-lista-usuarios',
  templateUrl: './lista-usuarios.component.html',
  styleUrls: ['./lista-usuarios.component.css']
})
export class ListaUsuariosComponent implements OnInit{

  listaUsu: Usuario[];
  public srvUsu: UsuariosRestService;

  
  //Como Usuariosservice es @Injectable, Angular lo instancia y lo pasa 
  //como argumento del constructor automáticamente. IoD
  //Inyección de Dependencias. Esto es como el @Autowire, solo que en Angular no es necesario
  //especificarlo porque ya lo hace automáticamente.
  constructor(srvUsu: UsuariosRestService) {
    
    this.srvUsu = srvUsu;


  }

  ngOnInit() {
    let obserConDatos: Observable<Usuario[]>= this.srvUsu.getTodos();
    //Le decimos al objeto observable que cuando reciba datos, 
    //invoque a esta función callback
    obserConDatos.subscribe(datos => this.listaUsu = datos);

  }

}
