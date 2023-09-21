package juegopasapalabra;

/**
 *
 * @author Jose Manuel
 */
public class Compra {
    private StringBuilder palabra;
    public StringBuilder mostrarInfoCompra1(Partida p){
        this.palabra = p.palabrasJugador1.get(p.getI1()).palabra;
        return palabra;
    }
   
    public StringBuilder mostrarInfoCompra2(Partida p){
        this.palabra = p.palabrasJugador2.get(p.getI2()).palabra;
        return palabra;
    }
     public StringBuilder mostrarInfoCompra(Entrenamiento e){
        this.palabra = e.palabrasJugador1.get(e.getI1()).palabra;
        return palabra;
    }

    public void ToString(){
        palabra.toString();
    }

}