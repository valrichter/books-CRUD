# CREACIÓN DE UN CRUD DE LIBROS PARA UNA BIBLIOTECA - Richter Valentin

### SQL query para crear la tabla de libros
```
CREATE TABLE libro (
titulo VARCHAR(255) PRIMARY KEY,
autor VARCHAR(255) NOT NULL,
genero VARCHAR(255) NOT NULL,
alquilado BOOLEAN NOT NULL
);
```

### Como correr el proyecto
1. Descargar el repositorio
2. Correr el UI.form en el IDE de IntlleiJ porque en NetbEans no es compatible

### Aclaraciones
- Se intento ejecutar dentro de netbeans pero no se pudo
- El programa es lento pues esta conectando a una base de datos en la nube entonces tarda en responder
- Deploy de la db en la pagina externa 'Railway'
- Se implementaron la acciones de ingresar, listar, alquilar y borrar
- Trabajo echo con Java 17

### Requisitos funcionales:

- Creación: Se debe poder crear un nuevo registro.
  - Ingresar: Le permite al usario ingresar un libro con sus respectivas validaciones
a la base de datos, las validaciones se hacen antes en el form para que lleguen
limpias la clase LibroDAO
  
- Listar (Read): Se debe poder listar los registros existentes.
  - Listar: Lista todos los libros que tiene la base de datos

- Actualizar: Se deben poder actualizar los registros existentes.
  - Alquilar: El usario puede dicidir si alquila o devulve un libro ingresando el titulo,
haciendo el chekeo de que no puede alquilar un libro alquilado

- Borrar: Se deben poder borrar los registros existentes.
  - Borrar: El usario puede borar un libro a tarves de ingresar el nombre pero
no puede si el libro esta alquilado

Requisitos técnicos:

- Si no se ha escrito nada, el usuario no debe poder crear un nuevo registro:  
Esta verificaion se hace en el form en la clase UI, con los metodos ```isValidINGRESAR()```,
```isValidALQUILAR``` y ```isValidBORRAR```
- Se debe crear un aviso cuando se creen, listen, actualicen y eliminen:  
Se crea un aviso debajo de los botones mediante un objeto listModel

