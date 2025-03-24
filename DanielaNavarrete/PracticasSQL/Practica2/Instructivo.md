Primeramente abrimos la interfaz y nos meteremos a una base de datos cualquiera.
**psql -U admibn -d S4V++
Una vez dentro, creamos una base de datos llamada “proveedoresdb;”
Y después usamos el comando \c para cambiarnos de la base de datos actual a la que acabamos de crear.
create database proveedoresdb;
\c proveedoresdb
Ahora, crearemos un schema llamado “InventarioDB;”, esto nos ayudará después para la creación de nuestras tablas.
Create schema Inventario DB;
Ahora crearemos una tabla llamada “Proveedor” y enlistaremos los atributos que queremos poner que en este caso será el id, el nombre, el contacto y el teléfono.
Create table inventariodb.”Proveedor” (id serial primary key, nombre text, contacto text, teléfono varchar (15));
Acto seguido, llenaremos los campos con todos los datos, todos tienen que coincidir con el tipo de dato que hemos metido anteriormente.
Insert into inventariodb.”Proveedor” (nombre, contacto, teléfono) values (‘Distribuidora el sol’, ‘Juan Perez’, ‘555-123-4567’);…
Ahora veremos todos los datos que hemos insertado con un select * from nombre del esquema.nombre de la tabla;
Y como podemos ver tenemos enlistados el nombre de los proveedores, su contacto y su teléfono.
Ahora creareamos otra tabla igual pero esta la llamaremos “Producto” y con la diferencia de que aquí además de poner otros atributos pondremos, el proveedor_id.
Create table inventariodb.”Producto” (id serial primary key, nombre text, descripción text, proveedor_id int references inventariodb.”Proveedor” (id), precio int);
Insertaremos los datos, solo que en este caso utilizaremos el id del proveedor de la tabla anteriormente creada, es decir la tabla de proveedor.
Insert into inventariodb.”Producto” (nombre, descripción, proveedor_id, precio) values (‘Papas’, ‘Papas fritas con sabor a limón’, 1, 20);… etc


Veremos como en este caso, tenemos el nombre del producto, la descripción del producto y su precio, con la diferencia de que aquí estamos llamando datos de la tabla anterior, y se muestra en el proveedor_id que aquí nos indicaría que el proveedor_id de las papas es “Distribuidora el sol”
