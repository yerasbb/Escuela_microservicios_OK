var texto = "TypeScript es JavaScript";
texto = {};
texto["prop"] = "Con sus virtudes";
console.log(texto);
console.log(texto.prop);

class MiClase {
    private variableMiempre: number;
    public otraProp: string;

    constructor(num:number, op: string){
        this.variableMiembro = num;
        this.otraProp = op;
    }

    metodo(argumento: any): void { //tiene el tipo any , que es cualquier cosa y void
        console.log(`Valores: ${this.variableMiembro},${this.otraProp},${argumento}`);
    }
}

let elObj: MiClase = new MiClase (69, "A comer");
elObj.metodo ("Pero ya");