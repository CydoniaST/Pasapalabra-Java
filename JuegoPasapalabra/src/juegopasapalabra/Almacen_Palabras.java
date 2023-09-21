
package juegopasapalabra;
import java.io.*;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;
/**
 * @author Jose Manuel
 */
public class Almacen_Palabras implements Serializable{
       
    //Creamos un Array para cada palabra.
    public ArrayList<Palabra> palabras_A = new ArrayList<>();
    public ArrayList<Palabra> palabras_B = new ArrayList<>();
    public ArrayList<Palabra> palabras_C = new ArrayList<>();
    public ArrayList<Palabra> palabras_D = new ArrayList<>();
    public ArrayList<Palabra> palabras_E = new ArrayList<>();
    public ArrayList<Palabra> palabras_F = new ArrayList<>();
    public ArrayList<Palabra> palabras_G = new ArrayList<>();
    public ArrayList<Palabra> palabras_H = new ArrayList<>();
    public ArrayList<Palabra> palabras_I = new ArrayList<>();
    public ArrayList<Palabra> palabras_J = new ArrayList<>();
    public ArrayList<Palabra> palabras_L = new ArrayList<>();
    public ArrayList<Palabra> palabras_M = new ArrayList<>();
    public ArrayList<Palabra> palabras_N = new ArrayList<>();
    public ArrayList<Palabra> palabras_Ñ = new ArrayList<>();
    public ArrayList<Palabra> palabras_O = new ArrayList<>();
    public ArrayList<Palabra> palabras_P = new ArrayList<>();
    public ArrayList<Palabra> palabras_Q = new ArrayList<>();
    public ArrayList<Palabra> palabras_R = new ArrayList<>();
    public ArrayList<Palabra> palabras_S = new ArrayList<>();
    public ArrayList<Palabra> palabras_T = new ArrayList<>();
    public ArrayList<Palabra> palabras_U = new ArrayList<>();
    public ArrayList<Palabra> palabras_V = new ArrayList<>();
    public ArrayList<Palabra> palabras_X = new ArrayList<>();
    public ArrayList<Palabra> palabras_Y = new ArrayList<>();
    public ArrayList<Palabra> palabras_Z = new ArrayList<>();
    
    //Método añadir palabra.
    public boolean añadirPalabra(Palabra p){

        boolean añadida =true;
        if((p.palabra.charAt(0)=='K')||(p.palabra.charAt(0)=='W')){return false;}
        if (añadida){    
            switch(p.palabra.charAt(0)){
                case 'A':
                    palabras_A.add(p);
                    break;
                case 'B':
                    palabras_B.add(p);
                    break;
                case 'C':
                    palabras_C.add(p);
                    break;
                case 'D':
                    palabras_D.add(p);
                    break;
                case 'E':
                    palabras_E.add(p);
                    break;
                case 'F':
                    palabras_F.add(p);
                    break;
                case 'G':
                    palabras_G.add(p);
                    break;
                case 'H':
                    palabras_H.add(p);
                    break;
                case 'I':
                    palabras_I.add(p);
                    break;
                case 'J':
                    palabras_J.add(p);
                    break;
                case 'L':
                    palabras_L.add(p);
                    break;
                case 'M':
                    palabras_M.add(p);
                    break;    
                case 'N':
                    palabras_N.add(p);
                    break;    
                case 'Ñ':
                    palabras_Ñ.add(p);
                    break; 
                case 'O':
                    palabras_O.add(p);
                    break;
                case 'P':
                    palabras_P.add(p);
                    break;
                case 'Q':
                    palabras_Q.add(p);
                    break;
                case 'R':
                    palabras_R.add(p);
                    break;
                case 'S':
                    palabras_S.add(p);
                    break;
                case 'T':
                    palabras_T.add(p);
                    break;
                case 'U':
                    palabras_U.add(p);
                    break;
                case 'X':
                    palabras_X.add(p);
                    break;
                case 'Y':
                    palabras_Y.add(p);
                    break;
                case 'Z':
                    palabras_Z.add(p);
                    break;
            }
        }
        return añadida;
    } 
    
    
    public void cargarDesdeFichero() throws FileNotFoundException {
        InputStream ins = new FileInputStream("Palabritas.txt");
        Scanner obj = new Scanner(ins);
        String u = "Definiciones";
        Scanner siguiente = obj;
        
        while (obj.hasNextLine()){

            StringBuilder sb = new StringBuilder();
            sb.append(siguiente.nextLine());
            Palabra palabra = new Palabra(sb);
            this.añadirPalabra(palabra);
            siguiente.nextLine();
            do{
                String s = obj.nextLine();
                Definicion d = new Definicion(s);
                palabra.añadirDefinicion(d);
            }
            while(siguiente.nextLine().equals(u));
        }

    }

}