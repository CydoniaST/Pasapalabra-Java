package juegopasapalabra;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Entrenamiento {
    
    //Variables con método get
    int numPalabras;
    int puntosPartida = 5;
    String contestar;
    int aciertos1=0;
    int fallos1=0;
    String nombre1;
    int prueba = 0;

    //Fecha
    Date fecha = new Date(Calendar.getInstance().getTimeInMillis());
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
    String fechaTexto = formatter.format(fecha);
    
    public int i1=0;
    boolean alternar;
    int x1=1;
    int pedirAyuda = 0;
    String accesoAyuda;
    
    //Clases
    Estadisticas estadisticas = new Estadisticas();
    Ayuda ayuda = new Ayuda();
    
    int ayudacion1 = 0;
    int compras1 = 0;
    int puntosJugador1;
    
    //ArrayList de Arraylist
    public ArrayList<ArrayList<Palabra>> palabras = new ArrayList<>();
    public ArrayList<Palabra> palabrasJugador1 = new ArrayList<>();

    
    public boolean jugar(Jugador jugador1, Almacen_Palabras almacen,Rosco r){
        
        boolean partidaIniciada = true;
        this.nombre1 = jugador1.nombre;
                
        palabras.add(almacen.palabras_A);
        palabras.add(almacen.palabras_B);
        palabras.add(almacen.palabras_C);
        palabras.add(almacen.palabras_D);
        palabras.add(almacen.palabras_E);
        palabras.add(almacen.palabras_F);
        palabras.add(almacen.palabras_G);
        palabras.add(almacen.palabras_H);
        palabras.add(almacen.palabras_I);
        palabras.add(almacen.palabras_J);
        palabras.add(almacen.palabras_L);
        palabras.add(almacen.palabras_M);
        palabras.add(almacen.palabras_N);
        palabras.add(almacen.palabras_Ñ);
        palabras.add(almacen.palabras_O);
        palabras.add(almacen.palabras_P);
        palabras.add(almacen.palabras_Q);
        palabras.add(almacen.palabras_R);
        palabras.add(almacen.palabras_S);
        palabras.add(almacen.palabras_T);
        palabras.add(almacen.palabras_U);
        palabras.add(almacen.palabras_X);
        palabras.add(almacen.palabras_Y);
        palabras.add(almacen.palabras_Z);
        
        
        for(int i =0; i <= r.num_letras - 1 ;i++){
            int index = (int)(Math.random() * palabras.get(i).size()); 
                palabrasJugador1.add(palabras.get(i).get(index));
        }
        
                jugador1.estadisticas.puntos = jugador1.estadisticas.puntos + getPuntosPartida();
                
                this.puntosJugador1 = jugador1.estadisticas.puntos;
                
                    if(jugador1.estadisticas.puntos<0||r.num_letras<=0||r.num_letras>palabras.size())
                    {return false;}
                    else{
                        this.numPalabras = r.getNumLetras();
                    }
                    
                    System.out.println(fechaTexto);
                    this.buclePartida();

        return partidaIniciada;
    }
    //Jugada del primer jugador, selecciona una definicion aleatoria de una palabra aleatoria, y la muestra, si está contestada
    //pasa a la siguiente, sino, debe ser contestada.
    private boolean jugador1Partida(){
        boolean siguienteJugador = true;
        boolean siguiente = true;
        while(i1<getNumeroPalabras() && siguiente){

            
            if(palabrasJugador1.get(i1).getAcertada() == true|| palabrasJugador1.get(i1).getFallada() ==true){
                
                i1++;
                return siguiente;
            }
            else{


                System.out.println("Turno de: " + this.nombre1);
                if(x1 ==1) {System.out.println("*********PRIMERA VUELTA*********");}
                if(x1 ==2) {System.out.println("*********SEGUNDA VUELTA*********");}
                int defAleatoria = (int)(Math.random() * palabrasJugador1.get(i1).definiciones.size());
                System.out.println("Empieza por la letra: " + palabrasJugador1.get(i1).palabra.charAt(0));
                System.out.println(palabrasJugador1.get(i1).definiciones.get(defAleatoria).definicion);
                
                this.pedirAyudaJugador1();
                if(getContestar().contentEquals(palabrasJugador1.get(i1).palabra)){
                    System.out.println("Palabra acertada");
                    aciertos1 = aciertos1+1;
                    palabrasJugador1.get(i1).setAcertada();
                    i1++;
                    if(x1==1){
                        if(i1>=getNumeroPalabras()){
                            x1++;
                            i1=0;
                        }
                        siguiente = true; 
                    }
                    if(x1 ==2){
                        siguiente = true;
                    }
                }

                else if(getContestar().contentEquals("Pasapalabra")){
                    System.out.println("Palabra pasada");
                    this.palabrasJugador1.get(i1).setAplazada();
                    i1++;
                    if(x1==1){
                        if(i1>=getNumeroPalabras()){
                                x1++;
                                i1=0;
                                break;
                        }
                        if(x1 ==2){
                            siguiente = true;
                        }
                        else break;
                        
                    }
                    else if (x1==2){
                        this.palabrasJugador1.get(i1-1).setFallada();
                        fallos1 =fallos1+ 1;
                        siguiente = true;
                    }
                    else break;
                }

                else{
                    System.out.println("Palabra fallada");
                    fallos1 = fallos1+ 1;
                    this.palabrasJugador1.get(i1).setFallada();
                    i1++;
                    if(x1==1){
                        if(i1>=getNumeroPalabras()){
                            x1++;
                            i1=0;
                            break;
                        }
                        else break;
                    }
                    else if (x1==2){
                    siguiente = true;
                    }
                    else break;
                }
            }
        }
        if(i1>=getNumeroPalabras() && x1==2){
              prueba = 1;
              alternar = false;
        }
        
            this.alternar = siguienteJugador;
            return alternar;

    }
    

    public void buclePartida(){
        
        this.jugador1Partida();
        while(alternar && this.prueba ==0){
            this.jugador1Partida();
        }
    }
    
    //Método con el que se ofrece ayuda a jugador 1
    public void pedirAyudaJugador1(){
//        try{
            do{
                System.out.println("Si necesitas ayuda pulsa 1, si no la necesitas pulsa 0");
                Scanner ayuda1 = new Scanner(System.in);
                while (!ayuda1.hasNextInt()) { 
                    System.out.println("Por favor intruduce un número válido.");
                    ayuda1.next();
                }
                if(palabrasJugador1.get(i1).pedirAyuda()== false){
                    pedirAyuda = ayuda1.nextInt();
                    if(pedirAyuda == 1){
                        System.out.println("¿Que tipo de ayuda necesitas? Escribe : Compra o Definicion");
                        Scanner eleccion = new Scanner(System.in);
                        
                        while (!eleccion.hasNext("Compra")&&!eleccion.hasNext("Definicion")) { 
                            System.out.println("Introduce una palabra correcta");
                            this.accesoAyuda= eleccion.next();
                        }
                        this.accesoAyuda= eleccion.next();
                        if(this.accesoAyuda.equals("Compra")){                       
                               palabrasJugador1.get(i1).setPedirAyuda(true);
                               palabrasJugador1.get(i1).setAcertada();
                               ayuda.compra(this);
                               compras1 ++;
                          

                        }else if(accesoAyuda.equals("Definicion")){
                                palabrasJugador1.get(i1).setPedirAyuda(true);
                                ayuda.ayudaPistaDefinicionE(this);
                                ayudacion1++;
                              
                        }
                    }
                    else if (pedirAyuda == 0){
                        System.out.println ("No has solicitado ayuda");
                    }
                }else System.out.println("No puedes pedir mas ayudas de esta palabra.");
            }
            while(pedirAyuda != 1 && pedirAyuda != 0);
            
            if(palabrasJugador1.get(i1).getAcertada()){
                this.contestar=palabrasJugador1.get(i1).palabra.toString();
            }
            else{
                Scanner datos2 = new Scanner(System.in);
                System.out.println("Introducir palabra:");
                contestar = datos2.nextLine();
            }
    }
    
        
    
    //Métodos get y set
    public String getContestar(){
        return contestar;
    }
    public void setContestar(String s){
        this.contestar = s;
    }
    public int getI1(){
        return i1;
    }
  
    public String getNombre1(){
        return nombre1;
    }
  
    public int getNumeroPalabras(){
        return numPalabras;
    }
    public int getPuntosPartida(){
        return puntosPartida;
    }
    public int getAciertos1(){
        return aciertos1;
    }
  
    public int getFallos1(){
        return fallos1;
    }
 
    public int getPuntosJ1(){
        return this.puntosJugador1;
    }
    public void validarPuntosJ1(Jugador j1){
        j1.estadisticas.puntos = puntosJugador1;
    }
    
  
}