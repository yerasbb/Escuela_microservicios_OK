var texto = "TypeScript es JavaScript";
texto = {};
texto["prop"] = "Con sus virtudes";
console.log(texto);
console.log(texto.prop);
var MiClase = /** @class */ (function () {
    function MiClase(num, op) {
        this.variableMiembro = num;
        this.otraProp = op;
    }
    MiClase.prototype.metodo = function (argumento) {
        console.log("Valores: " + this.variableMiembro + "," + this.otraProp + "," + argumento);
    };
    return MiClase;
}());
var elObj = new MiClase(69, "A comer");
elObj.metodo("Pero ya");
