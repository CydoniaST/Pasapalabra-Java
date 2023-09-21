package juegopasapalabra;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Estadisticas implements Serializable{
    int ganadas, perdidas, empatadas, jugadas, puntos;
    

    
   
    public Estadisticas(){
        
    }
    
    
    public void ganador(Jugador j,boolean parGanada, boolean parEmpatada, boolean parPerdida,int puntos){
        this.puntos += puntos;
        
        if(parGanada && !parEmpatada){
            this.jugadas += 1;
            this.ganadas += 1;
        }else if(parEmpatada){
            this.jugadas += 1;
            this.empatadas += 1;
        }else if(parPerdida && !parEmpatada){
            this.jugadas += 1;
            this.perdidas += 1;
        }
        
    }
    
    public int getPuntos(){
        return puntos;
    }

    
    public int ganadas(){
        return ganadas;
    }

}
