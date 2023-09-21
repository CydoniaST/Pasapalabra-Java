package juegopasapalabra.pista;

import juegopasapalabra.Entrenamiento;
import juegopasapalabra.Partida;


public class Segunda_Definicion {
    public void mostrarSegundaDefinicion(Partida p){
        if(p.palabrasJugador1.get(p.getI1()).definiciones.size()>=1){
            int defAleatoria2 = (int)(Math.random() * p.palabrasJugador1.get(p.getI1()).definiciones.size());
            System.out.println(p.palabrasJugador1.get(p.getI1()).definiciones.get(defAleatoria2).definicion);
        }
        else System.out.println("No hay mas definiciones agregadas");
        }
    public void mostrarSegundaDefinicion2(Partida p){
        if(p.palabrasJugador2.get(p.getI2()).definiciones.size()>=1){
            int defAleatoria2 = (int)(Math.random() * p.palabrasJugador2.get(p.getI2()).definiciones.size());
            System.out.println(p.palabrasJugador2.get(p.getI2()).definiciones.get(defAleatoria2).definicion);
        }
        else System.out.println("No hay mas definiciones agregadas");
        }
    public void mostrarSegundaDefinicion(Entrenamiento e){
        if(e.palabrasJugador1.get(e.getI1()).definiciones.size()>=1){
            int defAleatoria2 = (int)(Math.random() * e.palabrasJugador1.get(e.getI1()).definiciones.size());
            System.out.println(e.palabrasJugador1.get(e.getI1()).definiciones.get(defAleatoria2).definicion);
        }
        else System.out.println("No hay mas definiciones agregadas");
        }
    
}
