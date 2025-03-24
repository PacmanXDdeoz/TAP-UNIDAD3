# Instructivo de análisis de entidades y creación de bases de dato.
1. Análisis de entidades
Las entidades que se analizarán son las siguientes:
Géneros
Películas
Estas entidades están centradas en un catálogo de películas de cine, el tipo de relacion de estas dos entidades es uno a muchos, ya que un género puede tener muchas películas. De este modo, la persona que escoja un género tendrá varias opciones de películas para ver. 

2. Creación de bases de datos
Para crear una base de datos, entraremos a la terminal de PostgreSQL y ejecutaremos el siguiente comando para crear una base de datos llamada "CinemaBD". (Como se muestra en la imagen Practica2_1.png).

3. Creación del esquema
Para crear un esquema, es necesario estar dentro de la base de datos y ejecutar el siguiente comando:
create schema "audiovisual";

Nota: Es importante crear el esquema, ya que si no lo hacemos, no se podrán crear tablas dentro de la base de datos. (Como se muestra en la imagen Practica2_2.png).

4. Creación de tablas
Tabla Géneros
Para crear una tabla, es necesario estar dentro de la base de datos y ejecutar el siguiente comando:

CREATE TABLE audiovisual.generos (  id serial primary key, name text, trendy text);

Esta tabla tiene tres columnas: id, name y trendy. La columna id es la clave primaria y es una columna auto-incremental. La columna name contiene el nombre del género y la columna trendy indica si el género es popular y su nivel de popularidad (Alta, Media o Baja). La tabla no tiene ninguna clave foránea, ya que se utilizará como catálogo para la tabla películas. Se registran los datos de los géneros en la tabla. (Como se muestra en la imagen Practica2_3.png).

Tabla Películas
De manera similar, se crea una tabla llamada películas. Para crear esta tabla, es necesario estar dentro de la base de datos y ejecutar el siguiente comando: (Como se muestra en la imagen Practica2_4.png)

CREATE TABLE audiovisual.peliculas (  id serial primary key, title text, genero_id int references audiovisual.generos(id), year int, length int);

Esta tabla tiene cinco columnas: id, title, genero_id, year y length. La columna id es la clave primaria y es una columna auto-incremental. La columna title contiene el título de la película, genero_id es la columna que contiene el id de la tabla géneros, lo que establece la relación con la tabla de géneros. La columna year contiene el año de lanzamiento de la película y la columna length contiene la duración de la película. La tabla incluye una clave foránea (genero_id), que se utiliza para que cada película tenga un género asociado. Se registran los datos de las películas en la tabla. (Como se muestra en la imagen Practica2_5.png).

5. Catálogo de películas
Al finalizar, obtendremos una lista de películas donde se podrán mostrar varios títulos con el mismo género. (Como se muestra en la imagen Practica2_6.png).

    