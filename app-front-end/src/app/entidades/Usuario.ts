export class Usuario{


    // constructor(){

    // }

    constructor(usuario?: any){
        
        if(arguments.length==1){
            this.id = usuario.id;
            this.nombre= usuario.nombre;
            this.password= usuario.password;
            this.email= usuario.email;
            this.idTemaPreferido= usuario.idTemaPreferido
        }

    }


    public id: number;
    public nombre: string;
    public email: string;
    public password: string;
    public idTemaPreferido: number;
}