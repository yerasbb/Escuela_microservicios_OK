console.log("Mostrar mensaje");


console.log(process.pid);

console.log("Ruta: " + process.cwd());
var unObjeto = new Object();
unObjeto.propiedadA = "Valor A";
unObjeto["propiedadB"] = "Valor B";
console.log(`Valor de A: ${unObjeto['propiedadA']}), Valor de B: ${unObjeto.propiedadB}`);

//Funciones en JS son objetos 
function fun1(parA, parB) {
    return "Resultado fun1: " + parA + ", " + parB;
}

//var fun2 = function(parA, parB) {
// return `Resultado fun2: ${parA}, ${parB}`;
//}

//El ambito de var es a nivel función. El ámbito de let es a nivel de bloque

let fun2 = function(parA, parB) {
    return `Resultado fun2: ${parA}, ${parB}`;
}

var fun3 = new Function("parA", "parB", "return `Resultado fun3: ${parA}, ${parB}`");

//Desde EcmaScript 6, ES2015. Funciones flecha, lambda, anónimas...

var fun4 = (parA, parB) => { return `Resultado fun4: ${parA}, ${parB}` };
var fun5 = (parA, parB) => "Resultado fun5: " + parA + ", " + parB;

console.log(fun1("argumento A", "argumento B"));
console.log(fun2("argumento A", "argumento B"));
console.log(fun3("argumento A", "argumento B"));
console.log(fun4("argumento A", "argumento B"));
console.log(fun5("argumento A", "argumento B"));

//Las tres primeras funciones son idénticas, no hay diferencias entre ellas.
//Sin embargo las funciones lambda aportan limpieza de código y poder usarlas dentro de objetos.