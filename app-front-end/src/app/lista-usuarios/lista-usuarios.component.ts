import { Component, OnInit } from '@angular/core';
import { UsuariosService } from '../usuarios.service';

@Component({
  selector: 'app-lista-usuarios',
  templateUrl: './lista-usuarios.component.html',
  styleUrls: ['./lista-usuarios.component.css']
})
export class ListaUsuariosComponent implements OnInit {

  listaUsu: Usuario[];
  //Como Usuariosservice es @Injectable, Angular lo instancia y lo pasa 
  //como argumento del constructor automáticamente. IoD
  //Inyección de Dependencias.
  constructor(public srvUsu: UsuariosService) { }

  ngOnInit() {
    this.listaUsu = this.srvUsu.getTodosUsuarios();
  }

}
