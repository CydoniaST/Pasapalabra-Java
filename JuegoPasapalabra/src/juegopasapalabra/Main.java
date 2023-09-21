package juegopasapalabra;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main{

    public static void main(String[] args) throws IOException, FileNotFoundException {
        
        
        boolean aplicacionActiva = true;
        boolean juego = true;
        String decision = "";
        String fin = "";
        String guardado = "";
        boolean contestar = true;
        int numJugadores = 0;
        int auxiliar =0;
        String opcion = "";       
        boolean iniciado = false;
        boolean iniciadoOponente = false;
        boolean adminOn = true;
        int positionJug1 = 0;
        int positionJug2= 0;
        
        Almacen_Jugadores j= new Almacen_Jugadores();
        Almacen_Palabras a;
       
        InterfazJuego interfaz = new InterfazJuego();
        ControlAdministrador admin = new ControlAdministrador();
        Partida partida;
        Entrenamiento entrenar;
      
        System.out.println("---------------------------------------------");
        System.out.println("BIENVENIDO AL JUEGO DE PASAPALABRA.");
        System.out.println("---------------------------------------------");
        System.out.println("INSTRUCCIONES: \nComo el juego se muestra por consola, y no por interfaz gráfica. Se deben introducir los valores tal, y como se pide.");
        System.out.println("No te preocupes si te equivocas, puedes introducir el valor correcto después de un mensaje de alerta.");
        System.out.println("---------------------------------------------");
        
        //Recuperar datos antes de iniciar la partida
        System.out.println("¿Deseas cargar los datos guardados antes de iniciar la aplicacion?Si/No");
        
        Scanner entrada4 = new Scanner(System.in);
        String eleccion3 = entrada4.nextLine();
        
        j.borrarDatos();
        if(eleccion3.equals("Si")){
            j.recuperarDatosJugador();
        }
        
                
        //Bucle de aplicacion
        while(aplicacionActiva){
        iniciado = false;
        auxiliar = 0;
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Menu Inicial");        
        
        interfaz.interfazMenu();
         String eleccion2 = entrada.nextLine();
        
        switch(eleccion2){
            case "J":
                         //Interfaz
                        String opcion2 = interfaz.interfazJuego1();
                        switch(opcion2){
                            case "I":
                                iniciado = j.InicioSesion();
                                positionJug1 = j.getPosition();
                                numJugadores ++;
                                juego = true;
                                break;
                            case "R":
                                j.Registro();
                        }
                        if(iniciado == false){
                           System.out.println("No has iniciado sesion, debes tener una sesion iniciada para entrar al juego.");
                           System.out.println();
                           System.out.println("Volviendo al menu inicial.");
                           System.out.println();
                           auxiliar = 1;
                           juego = false;
                       }
                       break;
                         
            case "S":
                aplicacionActiva = false;
                break;
            }
       //Bucle menu de juego
       while(juego){
       
                        String eleccion = interfaz.interfazJuego2();
                        switch(eleccion){
                          case "P":
                           System.out.println();
                           System.out.println("--Inicia sesion con la cuenta de tu oponente."); 
                           iniciadoOponente = j.InicioSesion();
                           positionJug2 = j.getPosition();                           
                           contestar = true;
                           if(iniciadoOponente == true){
                                //Bucle de la Partida
                                while(contestar == true){ 

                                    //Verificamos que existan 2 sesiones iniciadas.
                                    if(j.verificarUsuarios()>=2){
                                        //METER PALABRAS
                                        a = new Almacen_Palabras();
                                        a.cargarDesdeFichero();

                                        //Creamos el Rosco
                                           System.out.println("---------------------------------------------------------");
                                           System.out.println("Para comenzar la partida debes elegir el tamaño del Rosco.");
                                           System.out.print("Tamaño: ");
                                           Scanner scan = new Scanner(System.in);
                                           int y = scan.nextInt();
                                        boolean nPalabrasFalso = true;
                                        do{
                                            try{
                                                if(y>23 || y<=0){
                                                    System.out.println("De que tamaño quieres el rosco");
                                                    scan = new Scanner(System.in);
                                                    y = scan.nextInt();
                                                    nPalabrasFalso = false;
                                                }
                                                else if(y>0 || y<23){
                                                     nPalabrasFalso = true;
                                                }
                                                else {System.out.println("Introduce un valor válido."); nPalabrasFalso =false;}
                                                }
                                                catch(Exception e){
                                                    System.out.println("No disponemos de ese número de palabras...");
                                                }
                                            }
                                         while(!nPalabrasFalso);

                                        Rosco rosco = new Rosco(y); 
                                        partida =  new Partida();

                                        partida.jugar(j.sesiones.get(positionJug1), j.sesiones.get(positionJug2), a, rosco);

                                        System.out.println("Quieres volver a jugar? Si/No");
                                        Scanner contestar2 = new Scanner(System.in);
                                        decision = contestar2.nextLine();
                                        if(decision.equals("No")){
                                            contestar = false;
                                        }else contestar = true;

                                    }else{
                                        System.out.println("Para jugar necesita iniciar sesion con dos jugadores");contestar = false;

                                    }
                                }
                           }
                           
                           break;
                          case "E":
                              int x = 0;
                              contestar = true;
                              //Bucle del entrenamiento
                              while(contestar == true){ 
                                   System.out.println("¿Quieres jugar con la sesion iniciada(I) o quieres jugar con una sesion diferente(D) ?");
                                   Scanner scan2 = new Scanner(System.in);
                                   String y2 = scan2.nextLine();
                                   if(y2.equals("I")){
                                       x=1;
                                   }else if(y2.equals("D")){
                                       x=2;
                                   }else{
                                       System.out.println("Selecciona I o D.");
                                   }
                                   //Inicia.
                                   
                                       //METER PALABRAS
                                       a = new Almacen_Palabras();
                                       a.cargarDesdeFichero();
                                       //Creamos el Rosco
                                       System.out.println("---------------------------------------------------------");
                                       System.out.println("Para comenzar la partida debes elegir el tamaño del Rosco.");
                                       System.out.print("Tamaño: ");
                                      Scanner scan = new Scanner(System.in);
                                      int y = scan.nextInt();
                                      boolean nPalabrasFalso = true;
                                      do{
                                          try{
                                              if(y>23 || y<=0){
                                                  System.out.println("De que tamaño quieres el rosco");
                                                  scan = new Scanner(System.in);
                                                  y = scan.nextInt();
                                                  nPalabrasFalso = false;
                                              }
                                              else if(y>0 || y<23){
                                                   nPalabrasFalso = true;
                                              }
                                              else {System.out.println("Introduce un valor válido."); nPalabrasFalso =false;}
                                              }
                                              catch(Exception e){
                                                  System.out.println("No disponemos de ese número de palabras...");
                                              }
                                          }
                                       while(!nPalabrasFalso);

                                       Rosco rosco = new Rosco(y); 
                                       entrenar  = new Entrenamiento();
                                       
                                       entrenar.jugar(j.sesiones.get(positionJug1), a, rosco);
                                       
                                       System.out.println("Quieres volver a jugar? Si/No");
                                       Scanner contestar2 = new Scanner(System.in);
                                       decision = contestar2.nextLine();
                                       if(decision.equals("No")){
                                           contestar = false;
                                       }else{contestar = true;}
                                                                    
                               }
                              x = 0;
                           break;

                          case "ES":

                              boolean salir = true;
                              String salida = "";
                              
                              if(numJugadores >= 1){
                                   while(salir==true){
                                       if(j.sesiones.isEmpty()){
                                            System.out.println("Parece que no hay usuarios registrados. Para poder ver las estadisticas debes registrar, como minimo, un usuario.");
                                            
                                       }else{
                                           System.out.println("Estas son tus estadisticas " + j.sesiones.get(positionJug1).getNombre());
                                           
                                            j.control(positionJug1);
                                                                                      
                                            System.out.println("| Salir (S)|");
                                           
                                            Scanner exit = new Scanner(System.in);
                                            salida = exit.nextLine();
                                            if(salida.equals("S")){
                                                salir = false;
                                            }
                                       }
                                   }
                              }else{
                                  System.out.println("El numero de partidas jugadas es de 0, para acceder a esta opción debe existir al menos registro de 1 partida.");
                              }

                           break;

                          case "A":
                              adminOn = true;
                              String user, clave;
                              System.out.println("Introduce el usuario y la contraseña de Administrador.");
                              System.out.println("Usuario: ");
                              Scanner userAdmin = new Scanner(System.in);
                              user = userAdmin.nextLine();
                              System.out.println("Contraseña: ");
                              Scanner claveAdmin = new Scanner(System.in);
                              clave = claveAdmin.nextLine();

                              if(user.equals("Admin")&&clave.equals("Admin")){
                                  if(j.sesiones.isEmpty()){
                                      System.out.println("No hay jugadores registrados. Registralos antes de entrar en este modo para poder ver sus estadisticas.");
                                  }else{
                                      while(adminOn == true){
                                       admin.menuAdministrador();
                                       
                                       Scanner variable = new Scanner(System.in);
                                       opcion = variable.nextLine();
                                       switch(opcion){
                                            case "V":

                                               j.ordenar();
                                               System.out.println(" ----------------------------------------------- ");
                                               break;
                                            case "A":
                                               j.registrarUsuario();
                                               break;
                                            case "E":
                                               int posicion;
                                               System.out.println("¿Que jugador te gustaria eliminar?");
                                               for(int i= 0; i<j.sesiones.size();i++){
                                                   System.out.println(i +" "+ j.sesiones.get(i).getNombre());
                                               }
                                               System.out.println("Introduce la posicion del jugador que quieres eliminar: ");
                                               Scanner pos = new Scanner(System.in);
                                               posicion = pos.nextInt();
                                               j.eliminarJugador(posicion);
                                               System.out.println(" ----------------------------------------------- ");
                                               break;
                                            case "ED":
                                               int posicion2;
                                               System.out.println("¿Que jugador te gustaria editar?");
                                               for(int i= 0; i<j.sesiones.size();i++){
                                                   System.out.println(i +" "+ j.sesiones.get(i).getNombre());
                                               }
                                               System.out.println("Introduce la posicion del jugador que quieres editar: ");
                                               Scanner pos2 = new Scanner(System.in);
                                               posicion2 = pos2.nextInt();
                                               
                                               j.editarJugador(posicion2);
                                               System.out.println(" ----------------------------------------------- ");

                                               break;
                                            case "L":
                                               System.out.println();                                               
                                               System.out.println("Los jugadores registrados son los siguientes:");
                                               j.visualizarUsuariosRegistrados();

                                               System.out.println("\n ----------------------------------------------- ");

                                               break;
                                            case "J":
                                                j.userAdmin();
                                                System.out.println("Tu cuenta de administrador ya esta creada, inicia sesion con ella en la partida para jugar.");
                                                adminOn = false;
                                            break;
                                            case "AP":
                                                System.out.println("No se puede.");
   
                                            break;

                                            case "S":
                                               adminOn = false;
                                            break;
                                        }
                                       }
                                  }  
                              }
                          case "S":
                              juego = false;
                            break;
                           }
                         }
       
                    if(auxiliar != 1){
                        System.out.println("¿Quieres guardar tus datos antes de salir? Si/No");
                        Scanner guardar = new Scanner(System.in);
                        guardado = guardar.nextLine();
                        if(guardado.equals("Si")){
                            j.datosJugador();
                            j.guardarClasificacion2();
                        }

                        System.out.println("¿Quieres salir de la aplicacion? Si/No");
                        Scanner salir = new Scanner(System.in);
                        fin = salir.nextLine();

                        if(fin.equals("Si")){
                            aplicacionActiva = false;
                            
                        }
                    }
            }
      
       //Salimos del menu principal para volver al inicio.

        }
    }
    