
*Este proyecto de Java desarrollado en NetBeans forma parte de la asigantura de rogramación Orientado a Objetos del grado de **Ingenieria de Computadores**. *
<p align="center"><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZyFSVrq_LOZcL8y-T-ecQPlopc7WYxjafphKz5Z0qL-EgIFP7IFtnB0wlGSXfEqK_Pw&usqp=CAU"/></p> 

## Tabla de contenidos:
---

- [Descripción y contexto](#descripción-y-contexto)
- [Guía de usuario](#guía-de-usuario)
- [Guía de instalación](#guía-de-instalación)
- [Cómo contribuir](#cómo-contribuir)
- [Código de conducta](#código-de-conducta)
- [Autor/es](#autores)
- [Información adicional](#información-adicional)
- [Licencia](#licencia)
- [Limitación de responsabilidades - Solo BID](#limitación-de-responsabilidades)

## Descripción y contexto
---
Basado en el Juego de Pasapalabra, el proyecto se basa en una aplicación que recrea dicha temática. Esta constituido por un Menu de inicio de sesión, un menú inicial de juego, las respectivas opciones de juego y el juego en si, con opción de jugar entre 2 jugadores o 1 jugador contra IA. Todo ejecutable como archivo JAR en consola o en la propia consola del entorno NetBeans.

Esta proyecto es capaz de crar una pequeña base de datos en los que se guardan los usuarios y contraseñas de cada jugador en un .txt y una clasificación de los jugadores y sus respectivas calificaciones, tambien en otro .txt.

## Guía de usuario
---
Lo primero de todo será iniciar sesion con tu cuenta personal, si no se dispone de una se deberá crear una para poder jugar. Una vez iniciada la sesion el jugador eligira en el menu una de las posibles opciones: 
  - Jugar contra otro juagdor.
  - Jugar contra la IA
  - Ver las diferentes calificaciones.

Una vez haya terminado debera guardar, si lo desea, las clasificaciones y sus puntos. Si no se desea guardar, simplemente deberá elegir la opción de Salir.
 	
## Guía de instalación
---
El archivo jar DEBE estar en la misma carpeta que el fichero binario y el de palabras
para que funcione correctamente. Por eso se ha movido el archivo jar fuera de la carpeta
dist, para que se pueda ejecutar tanto desde el NetBeans como desde una terminal de windows, sin necesidad de realizar una instalación como tal.

### Dependencias

El archivo .txt dónde se guardan las palabras debe tener un
orden determinado. Este orden se representa con los siguientes ejemplos:

Abadia
Definiciones
Templo o monasterio que gobierna un abad o una abadesa.
Definiciones
Una abadía es un monasterio o convento cristiano bajo las órdenes de un abad o una abadesa

Aprobar
Definiciones
Declarar a una persona apta en un examen, una prueba o una asignatura.
Definiciones
Considerar que algo está bien, darlo por bueno, aceptarlo o expresar conformidad con ello.


Todo esto sin comillas y en la misma línea. Hacemos este comentario
porque a veces al comprimir el proyecto el .txt cambia la forma 
lo que conlleva a que no se lean bien las palabras.
   
## Autor/es
---
Erik Mellado.
José Manuel Hernando.
