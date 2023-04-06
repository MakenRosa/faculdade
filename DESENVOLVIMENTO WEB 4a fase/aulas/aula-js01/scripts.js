/*
// Imprime "Hello World" no console
console.log("Hello World");

// Define variáveis a e b, soma seus valores e armazena o resultado em c
var a = 5;
var b = 10;
var c = a + b;

// Imprime o valor de c no console
console.log(c);

// Define variáveis de diferentes tipos de dados
var string = "Texto";
var number = 5;
var boolean = true;
var array = [1, 2, 3];
var object = {nome: "Fulano", idade: 25};

// Verifica se a é maior que b e imprime o resultado no console
if (a > b) {
  console.log("A é maior que B");
} else if (a < b) {
  console.log("B é maior que A");
} else {
  console.log("A e B são iguais");
}

// Loop for que imprime os números de 0 a 4 no console
var i;
for (i = 0; i < 5; i++) {
  console.log(i);
}

// Loop while que imprime os números de 0 a 4 no console
var j = 0;
while (j < 5) {
  console.log(j);
  j++;
}

// Define uma função que recebe dois parâmetros e retorna a soma
function soma(a, b) {
  return a + b;
}

// Chama a função soma com os valores 5 e 10 e armazena o resultado em resultado
var resultado = soma(5, 10);

// Imprime o valor de resultado no console
console.log(resultado);

// Exemplo de escopo de variáveis em JavaScript

var a = 5; // variável global

function teste() {
  var b = 10; // variável local
  console.log(a); // 5
  console.log(b); // 10
}

teste();
console.log(a); // 5
console.log(b); // erro: b não está definido
// Exemplo de operadores em JavaScript

var a = 5;
var b = 10;

// Aritméticos
console.log(a + b); // 15
console.log(a - b); // -5
console.log(a * b); // 50
console.log(b / a); // 2
console.log(b % a); // 0

// Comparação
console.log(a == b); // false
console.log(a != b); // true
console.log(a > b); // false
console.log(a < b); // true
console.log(a >= b); // false
console.log(a <= b); // true

// Lógicos
console.log((a < b) && (a != b)); // true
console.log((a == b) || (a > b)); // true
console.log(!(a > b)); // true

// Exemplo de arrays em JavaScript

var array = [1, 2, 3, 4, 5];

console.log(array[0]); // 1
console.log(array[2]); // 3
console.log(array.length); // 5

array.push(6); // adiciona um valor ao final do array
console.log(array); // [1, 2, 3, 4, 5, 6]

array.pop(); // remove o último valor do array
console.log(array); // [1, 2, 3, 4, 5]

// Exemplo de objetos em JavaScript

var pessoa = {
    nome: "João",
    idade: 25,
    altura: 1.80,
    saudacao: function() {
      console.log("Olá, meu nome é " + this.nome);
    }
  };
  
  console.log(pessoa.nome); // João
  pessoa.saudacao(); // Olá, meu nome é João
  */

async function getUsers() {
    const response = await fetch('https://jsonplaceholder.typicode.com/users');
    const data = await response.json();
    return data;
}

function shownames() {
    var users = getUsers();
    users.then(function (data) {
        data.forEach(function (user) {
            console.log(user.name);
        });
    }
    );
}

shownames();