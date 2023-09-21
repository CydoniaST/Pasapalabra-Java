package juegopasapalabra;

import juegopasapalabra.pista.Letras;
import juegopasapalabra.pista.Segunda_Definicion;

public class Ayuda {
    Partida p;
    private int precio;
    private int seleccion;
    Segunda_Definicion segundaDefinicion = new Segunda_Definicion();
    Letras letras= new Letras();
    int x=0;
    Compra compra = new Compra();

    public void ayudaPistaDefinicion1(Partida p){
        if(p.palabrasJugador1.get(p.getI1()).definiciones.size()==1){
                  letras.palabraAMostrarJugador1(p);
                  letras.mostrarLetras();
            }
        else {
            segundaDefinicion.mostrarSegundaDefinicion(p);
        }
    }
     public void ayudaPistaDefinicion(Entrenamiento e){
        if(p.palabrasJugador1.get(p.getI1()).definiciones.size()==1){
                  letras.palabraAMostrarJugador1(p);
                  letras.mostrarLetras();
            }
        else {
            segundaDefinicion.mostrarSegundaDefinicion(p);
        }
    }
    
     public void ayudaPistaDefinicion2(Partida p){
        if(p.palabrasJugador2.get(p.getI2()).definiciones.size()==1){
                  letras.palabraAMostrarJugador2(p);
                  letras.mostrarLetras();
            }
        else{
                segundaDefinicion.mostrarSegundaDefinicion2(p);
        }
    }
     
    public void ayudaPistaDefinicionE(Entrenamiento e){
        if(e.palabrasJugador1.get(e.getI1()).definiciones.size()==1){
                  letras.palabraAMostrarJugadorE(e);
                  letras.mostrarLetras();
            }
            else
                segundaDefinicion.mostrarSegundaDefinicion(e);
    }
     
    public void compra1(Partida p){
        
        System.out.println("La palabra es: " + "'"+compra.mostrarInfoCompra1(p)+"'");
    }
     public void compra(Entrenamiento e){
        System.out.println("La palabra es: " + "'"+compra.mostrarInfoCompra(e)+"'");
    }
    public void compra2(Partida p){
        System.out.println("La palabra es: " + "'"+compra.mostrarInfoCompra2(p)+"'");
    }
    
   
}