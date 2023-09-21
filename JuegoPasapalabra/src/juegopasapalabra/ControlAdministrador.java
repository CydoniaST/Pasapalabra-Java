
package juegopasapalabra;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class ControlAdministrador {
    
    Almacen_Jugadores stats = new Almacen_Jugadores();
    private ArrayList<Jugador> jugadores;
    private ArrayList<Almacen_Jugadores> jugadoresSesiones = stats.getSesiones();

    String opcion= "";
    int puntos;
    
    
    public ControlAdministrador(){
        
        jugadores = new ArrayList<Jugador>();
        this.puntos = 1000000;
    }
    
    public Jugador encontrarJugadores(String nombre, String clave){
        Jugador auxiliar = null;
        for(int i =0; i < jugadores.size(); i++){
            if(jugadores.get(i).datosJugador()[0].equals(nombre) && jugadores.get(i).datosJugador()[1].equals(clave)){
                auxiliar = jugadores.get(i);
            }
        }
        return (auxiliar);
    }
    public boolean addJugador(String nombre, String clave){
        if(encontrarJugadores(nombre,clave)!=null){
            return(false);
        }else{
            Jugador nuevo = new Jugador(nombre, clave);
            jugadores.add(nuevo);
            return(true);
        }
        
    }
    
    public boolean eliminarJugador(String nombre, String clave){
        if(encontrarJugadores(nombre,clave) != null){
            jugadores.remove(encontrarJugadores(nombre,clave));
            return true;
        }else{
            return false;
        }
    }

    
    public void menuAdministrador(){
        System.out.println("-----------------------------------------");
        System.out.println("Estas en la pantalla del admistrador.");

        System.out.println("- Ver Clasificación. (V)");
        System.out.println("- Añadir jugador. (A)");
        System.out.println("- Eliminar jugador. (E)");
        System.out.println("- Editar jugador. (ED)");
        System.out.println("- Lista de jugadores. (L)");
        System.out.println("- Jugar como administrador. (J)");
        System.out.println("- Añadir Palabras. (AP)");
        System.out.println("- Salir. (S)");
    }
    

}
