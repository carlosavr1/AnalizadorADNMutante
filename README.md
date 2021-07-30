# AnalizadorADNMutante

> **Desplegado en:
https://analizadoradnmutante.azurewebsites.net**

## Analizar ADN

``` bash
POST → /mutant/
https://analizadoradnmutante.azurewebsites.net/mutant
```
> **Ejemplo Mutante:**
{
"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}

> **Ejemplo Humano:**
{
"dna":["ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTT"]
}

## Obtener Estadísticas
``` bash
GET -> /stats
https://analizadoradnmutante.azurewebsites.net/stats
```

## Notas
> **Cobertura `88%`**

> **Alojado en AZURE (API y BD)**
