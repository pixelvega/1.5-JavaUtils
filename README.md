# 1.5-JavaUtils

## Nivel 1

### Ejercicio 1
  Crea una clase que liste alfabéticamente el contenido de un directorio recibido por parámetro.

### Ejercicio 2
  Añade a la clase del ejercicio anterior, la funcionalidad de listar un árbol de directorios con el contenido de todos sus niveles (recursivamente) de forma que se impriman en pantalla en orden alfabético dentro de cada nivel, indicando además si es un directorio (D) o un archivo (F), y su última fecha de modificación.

### Ejercicio 3
  Modifica el ejercicio anterior. Ahora, en lugar de mostrar el resultado por la pantalla, guarda el resultado en un archivo TXT.

### Ejercicio 4
  Añade la funcionalidad de leer cualquier archivo TXT y muestra su contenido por consola.

### Ejercicio 5
  Ahora el programa debe serializar un Objeto Java a un archivo .ser y después debe desserializarlo.


## Nivel 2

### Ejercicio 1

Ejecuta el ejercicio 3 del nivel anterior parametrizando todos los métodos en un archivo de configuración.

Puedes utilizar un archivo Java Properties, o bien la librería Apache Commons Configuration si lo prefieres.

Del ejercicio anterior, parametriza lo siguiente:

Directorio a leer.
Nombre y directorio del archivo TXT resultante.


## Nivel 3
### Ejercicio 1

Crea una utilidad que encripte y desencripte los archivos resultantes de los niveles anteriores.

Utiliza el algoritmo AES en modo de trabajo ECB o CBC con método de llenado PKCS5Padding. Se puede utilizar javax.crypto o bien org.apache.commons.crypto.
