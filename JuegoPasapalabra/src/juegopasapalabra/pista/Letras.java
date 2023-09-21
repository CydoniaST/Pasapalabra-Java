package juegopasapalabra.pista;
import java.util.Random;
import juegopasapalabra.*;

public class Letras {
    Partida p;

    private StringBuilder palabra;
    int[]posiciones;
    int posicionOculta;
    private int numCaracteresOcultos;

    public void mostrarLetras(){
        StringBuilder palabraPista = new StringBuilder(palabra);
        numCaracteresOcultos =  (int)(palabra.length()*0.66);
        int[] posicionesOcultas = new Random().ints(1, palabra.length()).distinct().limit(numCaracteresOcultos).toArray();
        for(int i=0;i<posicionesOcultas.length;i++){
            palabraPista.replace(posicionesOcultas[i], posicionesOcultas[i]+1, "*"); 
        }
        System.out.println(palabraPista);
    }

    public StringBuilder palabraAMostrarJugador1(Partida p){
        this.palabra = p.palabrasJugador1.get(p.getI1()).palabra;
        return palabra;
    }
//
    public StringBuilder palabraAMostrarJugador2(Partida p){
        this.palabra = p.palabrasJugador2.get(p.getI2()).palabra;
        return palabra;
    }

    public StringBuilder palabraAMostrarJugadorE(Entrenamiento e){
        this.palabra = e.palabrasJugador1.get(e.getI1()).palabra;
        return palabra;
    }

}