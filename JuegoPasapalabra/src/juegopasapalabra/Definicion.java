/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegopasapalabra;
/**
 *
 * @author Jose Manuel
 */
public class Definicion {
    public String definicion;
    
    public Definicion(String d){
        if(d!= null)definicion = d;
        else System.err.println("Introduce una definicion.");
    }
    

    
    public String getDefinicion(){
        return definicion;
    }
   
}
