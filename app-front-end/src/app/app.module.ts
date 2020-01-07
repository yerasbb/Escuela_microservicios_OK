import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { RegistroUsuarioComponent } from './registro-usuario/registro-usuario.component';
import {FormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListaUsuariosComponent } from './lista-usuarios/lista-usuarios.component';
import { FormularioModComponent } from './formulario-mod/formulario-mod.component';



@NgModule({
  declarations: [
    AppComponent,
    ListaUsuariosComponent,
    RegistroUsuarioComponent,
    FormularioModComponent //Los servicios por defecto son Singleton
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule, //Para poder usar  HTTP en toda la app
    FormsModule //Para poder usar el sistema de formularios
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
