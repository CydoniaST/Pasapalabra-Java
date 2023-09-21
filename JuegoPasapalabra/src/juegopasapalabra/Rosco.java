package juegopasapalabra;

/**
 *
 * @author Jose Manuel
 */
public class Rosco {
    public int num_letras;
    public int vueltas;
    
    public Rosco(int numLetras){
        
        if(numLetras>=0){
            this.num_letras = numLetras;
            this.vueltas = 2;
        }else 
            System.err.println("El dato introducido no es válido.");
    }
    
    public int getNumLetras(){
        return num_letras;
    }
    public int getNumVueltas(){
        return this.vueltas;
    }
}
