package juegopasapalabra;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Jugador implements Serializable{
    public String nombre, clave;        
    public Estadisticas estadisticas = new Estadisticas();
    
    public Jugador(){
        estadisticas.puntos = 100;
    }
    
    public Jugador(String nombre, String clave){
        this.nombre= nombre;
        this.clave = clave;
        estadisticas.puntos = 100;

    }
    
    public String[] datosJugador(){
        String[] temp = {this.nombre, this.clave};
        return temp;
    }
    
    public void setNombre(String nombre){
       this.nombre = nombre;
    }
   
    public String getNombre(){
       
       return nombre;
    } 
    public int getPuntos(){
       
       return estadisticas.getPuntos();
    } 
    
    public int getGanadas(){
        return this.estadisticas.ganadas;
    }
   
    public void setClave(String clave){
       this.clave = clave;
   }
   
    public String getClave(){
       return clave;
   }

}

