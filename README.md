# WupoWebApp

Esta aplicación web se ha desarrollado para presentar como prueba a Wupo. El back-end se ha desarrollado en Java con el framework Spring Boot, y el front-end haciendo uso de React. Se utiliza una base de datos PostgreSQL.
El back-end expone 4 API REST:
- Ruta POST "/": Permite hacer login a un usuario dado su nombre de usuario y contraseña. Si no existe el usuario, lo registra en el sistema.
- Ruta POST "/user": Permite enviar un pago a un usuario, dado su nombre de usuario y el valor a transferir.
- Ruta GET "/admin": Consulta un API externo y escribe el resultado obtenido en el log de la aplicación.
- Ruta GET "/historico": Permite obtener el historico de pagos realizados en el sistema.

Se hace uso de JWT para autorizar el acceso a los API, mediante un token.
Para ejecutar el back-end:
1. Ejecutar el archivo de bash "create-env-var.sh" para crear las variables de entorno necesarias para el funcionamiento de la app. Utilizar el comando "source create-env-var-sh" para tal fin.
2. Correr el comando "./gradlew bootRun" desde la carpeta raiz del back-end (la carpeta "demo")

El front-end hace uso de elementos de React-Bootstrap para estilo.
Para ejecutar el front:
1. Desde la carpeta raíz del proyecto ("my-app") ejecutar el comando "npm start"

## PENDIENTES
1. Se agregó la configuración inicial de HTTPS en front y back, pero se dejó desactivada.
2. Está pendiente configurar los permisos de roles para restringir el acceso a algunos endpoints del back.