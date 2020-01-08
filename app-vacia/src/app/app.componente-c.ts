import {Component, Input} from '@angular/core';


@Component({
    selector: 'app-comp-c',
    template:
    `<div><h2>Aquí estoy C</h2>
        {{ contador }} <input type="button" (click)="alPulsarBtn()" value="+"/>
    </div>`
})

export /*equivalente a public*/ class AppComponenteC {

    //@Input  indica que la variable nos la pasa el componente padre
    @Input() contador = 0;

    ngOnInit(){
        // this.contador = 7;
    }
    alPulsarBtn(){
        this.contador++;
        console.log("Contador: " + this.contador);
    }

}
