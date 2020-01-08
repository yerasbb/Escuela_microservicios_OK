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
  usuario: Usuario;
  usuarioModif: Usuario;
  public srvUsu: UsuariosRestService;
  id: number;

  
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

  eliminar(id: number){

    this.id = id;

    //El delete no devuelve datos
    this.srvUsu.delete(this.id).subscribe(() => {alert(`Usuario con id ${id} eliminado`);
    this.ngOnInit();});
   

  }

  modificar(usuario: Usuario){
    // var win = window.open('app-registro-usuario', '_blank');
    this.srvUsu.modify(usuario).subscribe(() => { alert(`Usuario con id ${usuario.id} modificado`);
    this.ngOnInit();});
    // win.focus();
  }

}
