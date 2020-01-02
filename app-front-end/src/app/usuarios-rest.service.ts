import { Injectable } from '@angular/core';
import { AlmacenLocalService } from './almacen-local.service'
import { Usuario } from './entidades/Usuario';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';



@Injectable({
  providedIn: 'root'
})
export class UsuariosRestService {

  /*url = "http://172.16.2.12:8081/api/usuarios"*/
  url = "http://localhost:8081/api/json/usuarios"
  
  listaUsuario: Usuario[];
  public srvAlm: AlmacenLocalService;

  constructor(srvAlm: AlmacenLocalService,
    public clienteHttp: HttpClient) { }

  getTodos(): Observable<Usuario[]>{

   let observableHttp =  this.clienteHttp.get<Usuario[]>(this.url);
   return observableHttp;
    
  }

  
}
