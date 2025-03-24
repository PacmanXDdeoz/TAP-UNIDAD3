<font color="red">**Instructivo Desafio**</font>

1. Se ingresa a la consola de comandos de postgres en la base de datos db0:

<font color="blue">**psql -U admin db0**</font>

2. Se crea la base de datos "Astronomia_Estudio":

<font color="blue">**create database "Astronomia_Estudio";**</font>

3. Se cambia a la base de datos recien creada:

<font color="blue">**\c "Astronomia_Estudio"**</font>

4. Se crea el esquema sistema_solar:

<font color="blue">**create schema sistema_solar;**</font>

5. Se crea la tabla estrellas:

<font color="blue">**create table sistema_solar.estrellas (id serial primary key, nameStar text, masssolar float(3), distanceearth float(3));**</font>

6. Se crea la tabla planetas y se relaciona con el id de la tabla estrellas:

<font color="blue">**create table sistema_solar.planetas (id serial primary key, namePlanet text, massPlanet text, type_planet text, id_estrellas int references sistema_solar.estrellas (id));**</font>

7. Se insertan los datos correspondientes en la tabla estrellas, siendo la siguiente lista:
- Sol        
- Gliese 876
- 82 Eridani 
- Gliese 581
- Gliese 667 C
- 61 Virgins
- Trappist-1
- 55 Cancri
- HD 69830
- HD 40307


<font color="blue">**insert into sistema_solar.estrellas (nameStar, masssolar, distantceearth) values ('estrella', 1, 1.6);**</font>

8. Se insertan los datos correspondientes en la tabla Planetas, con la siguiente lista:

- Tierra
- Saturno
- HD69830 c
- Gliese 667 cd
- Gliese 581b  
- TRAPPIST-1f  
- Jupiter
- Rho Cancri c
- HD 40307g
- Jansenn

<font color="blue">**insert into sistema_solar.estrellas (nameStar, masssolar, distantceearth) values ('estrella', 1, 1.6);**</font>

9. Se imprimen las tablas completas para mostrar todos los datos y la relación que hay entre las tablas Estrellas y Planetas:

<font color="blue">**select * from sistema_solar.estrellas;**</font>

<font color="blue">**select * from sistema_solar.planetas;**</font>

<font color="red">**Relación entre entidades**</font>

Las relaciones entre las entidades "Estrellas" y "Planetas", es el propio sistema solar, ya que cada uno cuenta con una estrella y sistema puede contener varios planetas, por lo tanto es una relación de muchos a uno.