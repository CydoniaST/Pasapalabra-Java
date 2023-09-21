package juegopasapalabra;

import java.util.ArrayList;


public class Palabra {
    private char inicial;
    public StringBuilder palabra;
    public boolean acertada,fallada, aplazada,ayuda;
    

    public ArrayList<Definicion> definiciones = new ArrayList<>();
    Almacen_Palabras p = new Almacen_Palabras();
            
    public Palabra(StringBuilder palabrita){
        this.palabra = palabrita;
        this.inicial = palabra.charAt(0);
        this.ayuda = false;
    }
    
    public Palabra(){
        
    }

    public boolean añadirDefinicion(Definicion d){
        boolean añadido = true;
        
        if(d==null)return false;
        
        if(añadido){
            definiciones.add(d);
        }
           return añadido;
    }
    
    public boolean borrarDefinicion(Definicion d){
        boolean borrado = true;
        
        if(d==null)return false;
        
        if(borrado){
            definiciones.remove(d);
        }
           return borrado;
    }

    
   public char getInicial(){
       return inicial;
   }
   public StringBuilder getPalabra(){
       return palabra;
   }
   
   public void setInicial(char i){
       inicial = i;
   }
   public boolean getAcertada(){
       return this.acertada;
   }
   public void setAcertada(){
       this.acertada = true;
   }
   public void setAcertada2(){
       this.acertada = false;
   }
   public boolean getFallada(){
       return this.fallada;
   }
   public void setFallada(){
       this.fallada = true;
   }
   public void setFallada2(){
       this.fallada = false;
   }
   public boolean getAplazada(){
       return this.aplazada;
   }
   public void setAplazada(){
       this.aplazada = true;
   }
   public void setAplazada2(){
       this.aplazada = false;
   }
   public void mostrar(){
       System.out.println("Se está mostrando la palabra: "+ palabra.toString());
   }
   public boolean pedirAyuda(){
       return ayuda;
   }
   public void setPedirAyuda(boolean b){
       this.ayuda = true;
   }
   
    
}
