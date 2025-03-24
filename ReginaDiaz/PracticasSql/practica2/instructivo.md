## Instructivo md para la creacion de database, schema y tables de nuevas entidades 

# Primero mi análisis definido es mis dos entidades que serán 
1.Clientes
2.Productos 
- la relacion de estas dos entidades son de uno a muchos en cuestión de que un cliente puede tener muchos productos, pero un producto no puede tener muchos clientes.
- Mi schema se llamara (ventas)
# Los atributos de la tabla seran los siguientes:
- Clientes
-- id
-- nombre_cliente
-- num_telefono
-- ubicacion
-- productos_id (clave foranea )

# Tabla catalogo, por que los datos están predefinidos
- Productos
-- id 
-- nombre_producto
-- cantidad
-- costo 

# Ingresar a tu usuario postgres de linux 
- comando: sudo -i -u postgres

# Ingresar a la terminal de postgres con el usuario admin a la database db0, para despues crear la nueva db 
- comando: psql -U admin -d db0

# Cree mi nueva data base llamada (negocio)
- comando: create database negocio;

# Dentro de mi data base negocio, cree mi esquema llamado (ventas)
- comando: create schema ventas;

# Dentro de mi schema ventas voy a crear 2 tablas llamadas Clientes y Productos con los atributos integrados
- comando: create table ventas.productos(id serial primary key, nombre_producto text,cantidad int, costo float);
- comando: create table ventas.clientes(id serial primary key, nombre_cliente text,num_telefono varchar(10), productos_id int references ventas.productos(id));
<!-- varchar es un tipo de dato de texto que define-->

# Insertar datos dentro de esas tablas 
- comando: insert into ventas.productos(nombre_producto,cantidad,costo) values ('', , ,);
- comando insert into ventas.clientes(nombre_cliente,num_telefono,ubicacion,productos_id) values('', ,'', );

# Verificar los registros de esas tablas con querys 
- select * from ventas.productos;
- select * from ventas.clientes;