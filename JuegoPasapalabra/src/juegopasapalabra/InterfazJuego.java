
package juegopasapalabra;

import java.util.Scanner;

public class InterfazJuego {
    String eleccion;
        public String interfazJuego2(){
           System.out.println("Bienvenido a Pasapalabra. Este es el menú del juego.");
           System.out.println("------------------------------");
           System.out.println("- Selecciona que deseas hacer.");
           System.out.println("------------------------------");
           System.out.println("  | Partida (P) |     | Entrenamiento (E) | ");
           System.out.println("| Estadisticas (ES) |  | Administrador (A) | | Salir (S) |");
           Scanner entrada = new Scanner(System.in);
           System.out.print("Opción: ");
           eleccion = entrada.nextLine();
                   
           
           return eleccion;
       }
        
        public String interfazJuego1(){
           System.out.println("Bienvenido a Pasapalabra. Este es el menú de usuario.");
           System.out.println("------------------------------");
           System.out.println("- Selecciona que deseas hacer.");
           System.out.println("------------------------------");
           System.out.println("  | Iniciar sesion (I) |     | Registrarse(R) | ");
           
           Scanner entrada = new Scanner(System.in);
           System.out.print("Opción: ");
           eleccion = entrada.nextLine();
                   
           
           return eleccion;
       }
        
        public void interfazMenu(){
           
           System.out.println("------------------------------");
           System.out.println("- Selecciona que deseas hacer.");
           System.out.println("------------------------------");
           System.out.println("  | Jugar (J)|     | Salir (S)| ");

       }
        
        
}
