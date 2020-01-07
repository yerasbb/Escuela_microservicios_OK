import { Component, OnInit } from '@angular/core';
import { NgModel } from '@angular/forms';
import {Usuario} from '../entidades/Usuario';
import { UsuariosRestService } from '../usuarios-rest.service';

@Component({
  selector: 'app-registro-usuario',
  templateUrl: './registro-usuario.component.html',
  styleUrls: ['./registro-usuario.component.css']
})
export class RegistroUsuarioComponent implements OnInit {

  usuario: Usuario = new Usuario();
  nombre = null;
  email = null;
  password = null;
  idTemaPreferido = null;
  //id: number;
  estaRegistrado: boolean = false;
  //variable = "un valor"

  constructor(private usuRestSrv: UsuariosRestService) { }

  ngOnInit() {
  }

  enviar(){
    //this.variable = "OTRO VALOR";
    this.usuario.nombre = this.nombre;
    this.usuario.email = this.email;
    this.usuario.password = this.password;
    this.usuario.idTemaPreferido = this.idTemaPreferido;

    this.usuRestSrv.registro(this.usuario).subscribe(usuRecibido => {
    this.usuario = usuRecibido;
    this.estaRegistrado = (typeof this.usuario.id !== undefined);
  });
    //Falta terminar de rellenar el objeto e invocar al servicio con los datos.
  }

}
