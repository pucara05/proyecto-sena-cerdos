Proyecto SENA - Gestión de Porcinos 🐖
Repositorio: GitHub - pucara05/proyecto-sena-cerdos
Fecha de desarrollo: Abril 2023 - Diciembre 2023

Descripción
Este proyecto, desarrollado como trabajo final en el SENA, es una aplicación web de gestión y administración de porcinos. La plataforma permite registrar, controlar y consultar la información de porcinos mediante un sistema seguro, accesible solo con autenticación, que facilita un entorno eficiente y accesible para la gestión.

Tecnologías Utilizadas
Backend:
Java: Lenguaje de programación principal.
Spring Boot: Para la configuración y estructura del backend.
Spring Security (básico): Implementación de autenticación y autorización de usuarios.
JPA (Java Persistence API) y ORM (Object-Relational Mapping): Para la persistencia en PostgreSQL.
PostgreSQL: Base de datos para almacenar la información.
Lombok: Reducción de código repetitivo en Java.
Thymeleaf: Motor de plantillas para renderizar vistas.
MVC: Arquitectura para organizar el código en capas de Modelo, Vista y Controlador, usando @Controller.

Frontend:
HTML5, CSS3 y JavaScript: Estructura y estilo de la interfaz.
Bootstrap 5: Framework CSS para diseño responsive.

Control de Versiones:
Git y GitHub: Usados para control de versiones y colaboración.
Características del Proyecto 🐷
Gestión de Porcinos:

Registro, consulta, actualización y eliminación de datos de porcinos.
Administración de registros sobre alimentación, salud y características físicas.
Sistema de Usuarios:

Control de acceso mediante login usando Spring Security básico para proteger los datos.
Interfaz Intuitiva:

Diseño responsive y accesible con Bootstrap 5 y Thymeleaf.
CRUD Completo:

Operaciones CRUD (Crear, Leer, Actualizar y Eliminar) para la gestión de registros de porcinos.
Arquitectura MVC:

Separación del código en capas con controladores usando @Controller.
    Instalación y Ejecución
   1.Clona el repositorio:


  git clone https://github.com/pucara05/proyecto-sena-cerdos.git

2. Navega al directorio del proyecto:

bash
Copy code
cd proyecto-sena-cerdos

3. Configura las variables de entorno en application.properties para la conexión a PostgreSQL.

4. Ejecuta el proyecto:

mvn spring-boot:run

# Ejemplos e Imágenes 📸
# Pantalla de Login

# Registro de Porcinos

# Vista de Administrador



Contribuciones
Este proyecto fue desarrollado como parte de la formación en el SENA, y todas las contribuciones se realizaron bajo supervisión académica. Mejoras y sugerencias son bienvenidas.

Contacto
Desarrollador: Daniel Cárdenas
GitHub: pucara05
LinkedIn: www.linkedin.com/in/danielcvillamizar



