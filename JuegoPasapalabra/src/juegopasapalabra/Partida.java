package juegopasapalabra;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;



public class Partida extends Almacen_Palabras{
    
    //Variables con método get
    int numPalabras;
    int puntosPartida = 5;
    String contestar;
    int aciertos1=0;
    int fallos1=0;
    int aciertos2=0;
    int fallos2=0;
    String nombre1;
    String nombre2;

    //Fecha
    Date fecha = new Date(Calendar.getInstance().getTimeInMillis());
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
    String fechaTexto = formatter.format(fecha);
//    LocalDateTime Fecha = LocalDateTime.now();
    
    public int i1=0;
    public int i2=0;
    boolean alternar;
    int x1=1;
    int x2=1;
    int pedirAyuda = 0;
    String accesoAyuda;
    
    //Clases
    Estadisticas estadisticas = new Estadisticas();
    Ayuda ayuda = new Ayuda();
    
    int ayudacion1 = 0;
    int ayudacion2 = 0;
    int compras1 = 0;
    int compras2= 0;
    int puntosJugador1;
    int puntosJugador2;
    
    //ArrayList de Arraylist
    public ArrayList<ArrayList<Palabra>> palabras = new ArrayList<>();
    public ArrayList<Palabra> palabrasJugador1 = new ArrayList<>();
    public ArrayList<Palabra> palabrasJugador2 = new ArrayList<>();

    
    public boolean jugar(Jugador jugador1, Jugador jugador2, Almacen_Palabras almacen,Rosco r){
        
        boolean partidaIniciada = true;
        this.nombre1 = jugador1.nombre;
        this.nombre2 = jugador2.nombre;
                
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
            int index2 = (int)(Math.random() * palabras.get(i).size()); 
            while(index==index2){
                index = (int)(Math.random() * palabras.get(i).size()); 
                index2 = (int)(Math.random() * palabras.get(i).size());
            }
                palabrasJugador1.add(palabras.get(i).get(index));
                palabrasJugador2.add(palabras.get(i).get(index2));
        }
        
        if (jugador1.nombre.equals(jugador2.nombre)) return false;
        else{
                jugador1.estadisticas.puntos = jugador1.estadisticas.puntos - getPuntosPartida();
                jugador2.estadisticas.puntos = jugador2.estadisticas.puntos - getPuntosPartida();
                
                this.puntosJugador1 = jugador1.estadisticas.puntos;
                this.puntosJugador2 = jugador2.estadisticas.puntos;
                
                    if(jugador1.estadisticas.puntos<0||jugador2.estadisticas.puntos<0||r.num_letras<=0||r.num_letras>palabras.size())
                    { 
                        if(jugador1.estadisticas.puntos<0){
                            System.out.println(jugador1.nombre +" No tiene puntos suficientes para jugar.");
                        }else{
                            System.out.println(jugador2.nombre +" No tiene puntos suficientes para jugar.");
                        }
                        
                        return false;
                    }
                    else{
                        this.numPalabras = r.getNumLetras();
                    }
                    System.out.println();
                    System.out.println("Esta partida tiene fecha:");
                    System.out.println(fechaTexto);
                    System.out.println();
                    this.buclePartida();

                    this.ganadorPartida(jugador1, jugador2);

        }
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

                if(x1 ==1) {System.out.println("*********PRIMERA VUELTA*********");}
                if(x1 ==2) {System.out.println("*********SEGUNDA VUELTA*********");}
                System.out.println("Turno de: " + this.nombre1);
                int defAleatoria = (int)(Math.random() * palabrasJugador1.get(i1).definiciones.size());
                System.out.println("Empieza por la letra: " + palabrasJugador1.get(i1).palabra.charAt(0));
                System.out.println(palabrasJugador1.get(i1).definiciones.get(defAleatoria).definicion);
               
                this.pedirAyudaJugador1();
                
                if(getContestar().contentEquals(palabrasJugador1.get(i1).palabra)){
                    System.out.println("Palabra acertada");
                    aciertos1 = aciertos1+1;
                    palabrasJugador1.get(i1).setAcertada();

                    i1++;
                    if(x1 ==1){
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
        if(i1==getNumeroPalabras() && x1==2){
              alternar = false;
        }
            this.alternar = siguienteJugador;
            return alternar;

    }
    private boolean jugador2Partida(){
        boolean siguiente = true;
        boolean siguienteJugador = true;
        while(i2<getNumeroPalabras() && siguiente){

            
            if(palabrasJugador2.get(i2).getAcertada() == true|| palabrasJugador2.get(i2).getFallada() ==true){
                i2++;
                return siguiente;
            }
            else{
                
                if(x2 ==1) {System.out.println("*********PRIMERA VUELTA*********");}
                if(x2 ==2) {System.out.println("*********SEGUNDA VUELTA*********");}
                System.out.println("Contesta: " + this.nombre2);
                int defAleatoria = (int)(Math.random() * palabrasJugador2.get(i2).definiciones.size());
                System.out.println(palabrasJugador2.get(i2).definiciones.get(defAleatoria).definicion);
                
                this.pedirAyudaJugador2();
                


                if(getContestar().contentEquals(palabrasJugador2.get(i2).palabra)){
                    System.out.println("Palabra acertada");
                    aciertos2 =aciertos2+1;
                    palabrasJugador2.get(i2).setAcertada();
                    i2++;
                    if(x2==1){
                        if(i2>=getNumeroPalabras()){
                            x2++;
                            i2=0;
                        }
                        siguiente = true; 
                    }
                    if(x2==2){
                        siguiente = true;
                    }
                       
                }

                else if(getContestar().contentEquals("Pasapalabra")){
                    System.out.println("Palabra pasada");
                    this.palabrasJugador2.get(i2).setAplazada();
                    i2++;
                    if(x2 == 1){
                        if(i2>=getNumeroPalabras()){
                                x2++;
                                i2=0;
                                break;
                        }
                        else break;
                    }
                    else if (x2==2){
                        this.palabrasJugador2.get(i2-1).setFallada();
                        fallos2 = fallos2 +1;
                        siguiente = true;
                    }
                    
                    else break;
                }

                else{
                    System.out.println("Palabra fallada");
                    fallos2 =fallos2+ 1;
                    this.palabrasJugador2.get(i2).setFallada();

                    i2++;
                    if(x2==1){
                        if(i2>=getNumeroPalabras()){
                            x2++;
                            i2=0;
                            break;
                        }
                        else break;
                    }
                    else if (x2==2){
                    siguiente = true;
                    }
                    else break;
                }
                }
        }
        if(i2==getNumeroPalabras() && x2==2){
            alternar = false;
        }
        else this.alternar = siguienteJugador;
        return siguienteJugador;
    }
    

    public void buclePartida(){
        
        this.jugador1Partida();
        this.jugador2Partida();    
        while(alternar){
            this.jugador1Partida();
            this.jugador2Partida();
        }
    }
    public void ganadorPartida(Jugador jugador1, Jugador jugador2){
        if(getAciertos1()>getAciertos2()){
            System.out.println("Gana: " + getNombre1());
            if(getAciertos1() == getNumeroPalabras()){
                this.puntosJugador1 += 100;
            }
            else{
                this.puntosJugador1 += 10;
            }
            this.ganaJugador1(jugador1, jugador2);
        }
        else if(getAciertos1() == getAciertos2()){
            System.out.println("Empate, se procederá al recuento de fallos, quien tenga menos fallos, ganará la partida y 10 puntos.");
            if(getFallos1() < getFallos2()){
                System.out.println("Gana: " + getNombre1());
                this.puntosJugador1 += 10;
                this.ganaJugador1(jugador1, jugador2);
                
            }
            else if(getFallos1() > getFallos2()){
                System.out.println("Gana: " + getNombre2());
                this.puntosJugador2 += 10;
                this.ganaJugador2(jugador1, jugador2);
            }
            else{
                System.out.println("Empate técnico, ambos jugadores ganan 10 puntos.");
                this.puntosJugador1 = this.puntosJugador1 + 10;
                this.puntosJugador2 = this.puntosJugador2 + 10;
                this.empate(jugador1, jugador2);
            }
            
        }
        else{
            System.out.println("--------------------------");
            System.out.println("Gana: " + getNombre2());
            if(getAciertos2() == getNumeroPalabras()){
               this.puntosJugador2 += 100;
            }
            else{
                this.puntosJugador2+= 10;
            }
            this.ganaJugador2(jugador1, jugador2);
        }
        
        System.out.println();
        System.out.println("Recuento de la partida: ");
        System.out.println("El jugador: " + getNombre1()+ " ha conseguido un total de:");
        System.out.println("Palabras acertadas: " + getAciertos1());
        System.out.println("Palabras falladas: " + getFallos1());
        System.out.println("El jugador: " + getNombre2()+ " ha conseguido un total de:");
        System.out.println("Palabras acertadas: " + getAciertos2());
        System.out.println("Palabras falladas: " + getFallos2());
        System.out.println("--------------------------");
        
        this.validarPuntosJ1(jugador1);
        this.validarPuntosJ2(jugador2);
    }
    
    //Partida ganada por jugador 1
    public void ganaJugador1(Jugador jugador1, Jugador jugador2){
        jugador1.estadisticas.ganador(jugador1,true, false, false, jugador1.estadisticas.getPuntos());
        jugador2.estadisticas.ganador(jugador2,false, false, true, jugador2.estadisticas.getPuntos());
        
    }
    
    //Partida ganada por jugador 2
    public void ganaJugador2(Jugador jugador1, Jugador jugador2){
        jugador1.estadisticas.ganador(jugador1,false, false, true, jugador1.estadisticas.getPuntos());
        jugador2.estadisticas.ganador(jugador2,true, false, false, jugador2.estadisticas.getPuntos());
    }
    
    //Partida empatada
    public void empate(Jugador jugador1, Jugador jugador2){
        jugador1.estadisticas.ganador(jugador1,false, true, false, jugador1.estadisticas.getPuntos());
        jugador2.estadisticas.ganador(jugador2,false, true, false, jugador2.estadisticas.getPuntos());
    }
    
    //Método con el que se ofrece ayuda a jugador 1
    public void pedirAyudaJugador1(){
        try{
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
                           if(puntosJugador1 >= 20){
                               System.out.println("La palabra comprada es: ");
                               palabrasJugador1.get(i1).setPedirAyuda(true);
                               palabrasJugador1.get(i1).setAcertada();
                               ayuda.compra1(this);
                               puntosJugador1 -= 20;
                               compras1 ++;
                           }else{
                               System.out.println("No puedes comprar mas, puntos insuficientes");
                           }

                        }else if(accesoAyuda.equals("Definicion")){
                            if(puntosJugador1 >= 5){
                                palabrasJugador1.get(i1).setPedirAyuda(true);
                                ayuda.ayudaPistaDefinicion1(this);
                                puntosJugador1 -= 5;
                                ayudacion1++;
                            }else{
                               System.out.println("No puedes comprar mas, puntos insuficientes");
                            }
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
            catch(Exception e){
            System.err.println("Has introducido un dato no válido, prueba a introducir números enteros.");
        }
    }
        //Método con el que se ofrece ayuda a jugador 2
    
    public void pedirAyudaJugador2(){
        try{
            do{
                System.out.println("Si necesitas ayuda pulsa 1, si no la necesitas pulsa 0");
                Scanner ayuda1 = new Scanner(System.in);
                while (!ayuda1.hasNextInt()) { 
                    System.out.println("Por favor intruduce un número válido.");
                    ayuda1.next();
                }
                if(palabrasJugador2.get(i2).pedirAyuda()== false){
                    
                    pedirAyuda = ayuda1.nextInt();
                    
                    if(pedirAyuda == 1){
                        System.out.println("¿Que tipo de ayuda necesitas? Escribe : Compra o Definicion");
                        Scanner eleccion = new Scanner(System.in);
                        while (!eleccion.hasNext("Compra")&&!eleccion.hasNext("Definicion")) { 
                            System.out.println("Introduce una palabra correcta");
                            this.accesoAyuda= eleccion.next();
                        }
                        this.accesoAyuda= eleccion.next();
                        if(accesoAyuda.equals("Compra")){    
                           if(puntosJugador2 >= 20){
                               System.out.println("La palabra comprada es: ");
                               palabrasJugador2.get(i2).setPedirAyuda(true);
                               palabrasJugador2.get(i2).setAcertada();
                               ayuda.compra2(this);
                               puntosJugador2 -= 20;
                               compras2 ++;
                           }else{
                               System.out.println("No puedes comprar mas, puntos insuficientes");
                           }

                        }else if(accesoAyuda.equals("Definicion")){
                            if(puntosJugador2 >= 5){
                                palabrasJugador2.get(i2).setPedirAyuda(true);
                                ayuda.ayudaPistaDefinicion2(this);
                                puntosJugador2 -= 5;
                                ayudacion2++;
                            }else{
                               System.out.println("No puedes comrpar mas, puntos insuficientes");
                           }

                        }
                    }
                    else if (pedirAyuda == 0){
                        System.out.println ("No has solicitado ayuda");
                    }
                }
            }
            while(pedirAyuda != 1 && pedirAyuda != 0);
            
            if(palabrasJugador2.get(i2).getAcertada()){
                this.contestar=palabrasJugador2.get(i2).palabra.toString();
            }
            else{
                Scanner datos2 = new Scanner(System.in);
                System.out.println("Introducir palabra:");
                contestar = datos2.nextLine();
            }
        }
        catch(Exception e){
            System.err.println("Has introducido un dato no válido, prueba a introducir números enteros.");
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
    public int getI2(){
        return i2;
    }
    public String getNombre1(){
        return nombre1;
    }
    public String getNombre2(){
        return nombre2;
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
    public int getAciertos2(){
        return aciertos2;
    }
    public int getFallos1(){
        return fallos1;
    }
    public int getFallos2(){
        return fallos2;
    }
    public int getPuntosJ1(){
        return this.puntosJugador1;
    }
    public void validarPuntosJ1(Jugador j1){
        j1.estadisticas.puntos = puntosJugador1;
    }
    public void validarPuntosJ2(Jugador j2){
        j2.estadisticas.puntos = puntosJugador2;
    }
}