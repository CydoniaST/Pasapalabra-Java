
package juegopasapalabra;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

import java.util.Scanner;


public class Almacen_Jugadores implements Serializable{ 

    public ArrayList<Jugador> sesiones = new ArrayList<Jugador>(); 
    
    Jugador jugadores;
    int position;
    
    public ArrayList getSesiones(){
        return sesiones;        
    }
    
    public int getPosition(){
        
        return position;
    }
    
    public void userAdmin(){
        Jugador admin = new Jugador();
        admin.nombre = "admin";
        admin.clave = "admin";
        admin.estadisticas.puntos = 1000000;
        
        sesiones.add(admin);
    }
            

    public boolean InicioSesion() throws IOException{

        boolean iniciado = false;     
        String datos = "";
        System.out.println();
        System.out.println("------Inicio de Sesión------");
                        
        //Apartir de aqui se inicia sesion
        String pswrd = "";
        String nombre = "";
                                
        boolean existe = false;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Introduzca su nombre de usuario: ");
        nombre = scan.nextLine();
        System.out.println("Introduzca su contrasena: ");
        pswrd = scan.nextLine();
        Jugador jInicio = new Jugador(nombre, pswrd);

        existe = encontrarJugador(jInicio);
        if(existe){

           System.out.println("Sesion iniciada.");
           iniciado = true;
        }else{
            System.out.println("El usuario no existe, registrate por favor.");
            Registro();                        
        }
        
        datos = datos + "Jugadores: ";
        datos = datos +"Usuario: "+ nombre + " ";
        datos = datos + "Contraseña: " + pswrd + " ";

        return iniciado;
    }
    public void Registro() throws IOException{

        
        System.out.println();
        System.out.println("------Registro------");


                    System.out.println("--------------------------------");
                    System.out.println("Registrar cuenta");
                    registrarUsuario();
                    

    }       
        
    public void registrarUsuario() throws IOException{
        String pswrd = "";
        String nombre = "";
        String datos = "\n";
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Introduzca su nombre de usuario: ");
        nombre = scan.nextLine();
        System.out.println("Introduzca su contrasena: ");
        pswrd = scan.nextLine();
        Jugador jNuevo = new Jugador(nombre, pswrd);
        
        datos = datos + "Jugadores: \n";
        datos = datos +"Usuario: "+ nombre + "\n";
        datos = datos + "Contraseña: " + pswrd + "\n";
        
        addJugador(jNuevo);
        position = sesiones.size();
        
    }
    
    public boolean encontrarJugador(Jugador j){
        boolean encontrado = false;
        
        for(int i = 0; i<sesiones.size();i++){
            if(j.nombre.equals(sesiones.get(i).nombre) && j.clave.equals(sesiones.get(i).clave)){
            encontrado = true;
            this.position = i;
            }
        }
        
        return encontrado;
    }
    
   
    public void addJugador(Jugador j){
        sesiones.add(j);

    }
    
    public void addSesion(Jugador j){
        sesiones.add(j);

    }    

     
    public void eliminarJugador(int posicion){
//         
        sesiones.remove(posicion);
    }
    
    public void editarJugador(int posicion){
        if(sesiones.contains(sesiones.get(posicion))){
            String nombreNuevo = "";
            String claveNueva="";
            System.out.println("¿Como lo quieres llamar?");
            Scanner scan = new Scanner(System.in);
            nombreNuevo = scan.nextLine();
            sesiones.get(posicion).setNombre(nombreNuevo);
            System.out.println("¿Cual será la nueva contraseña?");
            
            claveNueva = scan.nextLine();
            sesiones.get(posicion).setClave(claveNueva);
        }
    }
    
    public void visualizarUsuariosRegistrados(){
        
        for(int i = 0; i< sesiones.size(); i++){
            System.out.println("Jugador "+ (i+1) + ":"+ sesiones.get(i).getNombre() + " tiene: " + sesiones.get(i).estadisticas.puntos + " puntos, " + " tiene: " + 
                                sesiones.get(i).estadisticas.ganadas + " partidas ganadas, " + " tiene: " + sesiones.get(i).estadisticas.perdidas + " partidas perdidas y " + 
                                sesiones.get(i).estadisticas.empatadas + " partidas empatadas.");
            
        }
    }
    
    public void datosJugador() throws IOException{
        
        try{
                        
            ObjectOutputStream jugador = new ObjectOutputStream(new FileOutputStream("Jugadores.bin"));

            jugador.writeObject(sesiones);
           
            jugador.close();
            
            System.out.println("Datos guardados con exito.");
        }catch(IOException e){
            System.out.println("Error generando fichero."+ e);
        }
        
    }

    
    public void recuperarDatosJugador(){
        try{
            ObjectInputStream recuperarJugador = new ObjectInputStream(new FileInputStream("Jugadores.bin"));
            
            ArrayList lista_recuperada = (ArrayList)recuperarJugador.readObject();
            
            sesiones = lista_recuperada;
            
            recuperarJugador.close();
            System.out.println();
            System.out.println("-----Datos cargados-----");
            System.out.println("Estos son los jugadores registrados:");
            for(int i= 0; i<sesiones.size(); i++){
                  System.out.println("- "+sesiones.get(i).nombre);
            }
            System.out.println();
        }catch(Exception e){
            System.out.println("Error recuperando datos" +e.getMessage());
        }
        
    }

    public void guardarClasificacion2()throws IOException{
            
            try(FileWriter fw = new FileWriter("Clasificacion.txt", true);
            
            PrintWriter out = new PrintWriter(fw))
            {
                out.print("");
                out.println("La  clasificacion de jugadores es la siguiente: ");
                
                for(int i= 0; i<= sesiones.size()-1;i++){

                    out.println("Jugador "+ (i+1) + ":"+ sesiones.get(i).getNombre() + " tiene: " + sesiones.get(i).estadisticas.puntos + " puntos, " + " tiene: " + 
                                sesiones.get(i).estadisticas.ganadas + " partidas ganadas, " + " tiene: " + sesiones.get(i).estadisticas.perdidas + " partidas perdidas y " + 
                                sesiones.get(i).estadisticas.empatadas + " partidas empatadas.");
                   
                }
                out.close();
                
            } catch (IOException e) {
                
            }
            System.out.println("Clasificacion guardada.");
    }
    
    public void borrarDatos(){
        File archivo1 = new File("Clasificacion.txt");
        if(archivo1.exists()){
            archivo1.delete();
        }
               
    }

    public int verificarUsuarios(){
        int jugadores;
        jugadores = sesiones.size();
        
        return jugadores;
    }
    
    public void control(int posicion){
        System.out.println(" ----------------------------------------------- ");
        System.out.println("+ Tienes : " +sesiones.get(posicion).estadisticas.puntos+ " puntos.          ");
        System.out.println("+ Has ganado: " + sesiones.get(posicion).estadisticas.ganadas  + ", has perdido: " +sesiones.get(posicion).estadisticas.perdidas+ ", has empatado:" +sesiones.get(posicion).estadisticas.empatadas+".");
        for(int i= 0; i<2; i++){
            System.out.println("|                                               |");
        }
        System.out.println(" ----------------------------------------------- ");
    }
    
   
    public void ordenar(){
        ArrayList<Jugador> copia = new ArrayList<>(sesiones);
        
        String eleccion = "";
        int posicion =1;
        
        
         
        System.out.println("¿Quieres la clasificación por puntos o por partidas ganadas? P/G");
        Scanner scan = new Scanner(System.in);
        eleccion = scan.nextLine();
         switch(eleccion){
            case "P":
                copia.sort(Comparator.comparing(Jugador::getPuntos));
                
                for(int x= copia.size()-1; x>=0 ;x--){

                           System.out.println(posicion +"º " +copia.get(x).nombre +" "+ copia.get(x).estadisticas.puntos+ " puntos.");
                           posicion++; 
                }
                break;
            case "G":
                copia.sort(Comparator.comparing(Jugador::getGanadas));
                for(int x= copia.size()-1; x>=0 ;x--){

                           System.out.println(posicion +"º " +copia.get(x).nombre +" "+ copia.get(x).estadisticas.ganadas+ " ganadas.");
                           posicion++; 
                }
                    
                break;
        }
    }
    

}
