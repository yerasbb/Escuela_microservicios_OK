import { NgModule } from '@angular/core';
import { Browser } from 'protractor';
import { BrowserModule} from '@angular/platform-browser';
import { AppComponente } from './app.componente';

//los metadatos de un módulo/comp/serv...
//es un objeto JS que le pasamos al @Decorador
@NgModule({
    //components, directives and pipes
    declarations: [AppComponente],
    imports:[BrowserModule],
    bootstrap: [AppComponente],

})
export class AppModulo {}