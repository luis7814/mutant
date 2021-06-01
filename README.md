# mutant
Prueba mercado libre

#Ejecución
Este es un microservicio construido en sprintboot y gradle. Se puede ejecutar de dos formas:

1- Desde un IDE de JAVA (Eclipse o IntelliJ), corriendo la clase MutantApplication.java.

2- Desde la raiz del proyecto ejecutando el comando "gradle bootRun".

#Url's

En local son:

POST - http://localhost:8081/mutant

{
"dna" : [
"ATGCGA",
"CAGTGC",
"TTATGT",
"AGAAGG",
"CCCCTA",
"TCACTG"
]
}

GET - http://localhost:8081/stats

En AWS son:

http://ec2-34-226-208-200.compute-1.amazonaws.com:8081/mutant

http://ec2-34-226-208-200.compute-1.amazonaws.com:8081/stats