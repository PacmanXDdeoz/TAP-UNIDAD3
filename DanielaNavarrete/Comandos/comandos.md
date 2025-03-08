wsl --install -d debian

**Para instalar Linux**

sudo -i -u postgres

**Para entrar al usuario postgres*

psql 

**Para entrar al usuario psql**

créate user admin with password '123';

**Para crear usuario**

alter user admin superuser createdb createrole;

**Para modificar un usuario o rol existente. Permite cambiar atributos como la contraseña o limite de conexiones**
créate database db0 owner admin;

**Para crear una nueva base de datos llamada db0 y asigna al usuario 'admin' como propietario.**
show hba_file;

**Muestra la ubicación del archivo de configuración "pg_hba.conf" usado para la autenticación del cliente, 
al ejecutarlo el comando devuelve una ruta del archivo hba**

\c **Para checar en que usuario y base de datos estamos conectados**

\l **Enlistar la base de datos**

\du **Para ver los usuarios**

sudo nano "ruta del archivo"

**Para editar la autenticación del cliente**
