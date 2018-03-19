/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojatrabajo7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author alber
 */
public class HojaTrabajo7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File f;
        FileReader fr;
	BufferedReader br;
        BinaryTree<Asociacion<String, String>> arbol = new BinaryTree<>();
        try{
           f = new File("./diccionario.txt");
           fr = new FileReader(f);
           br = new BufferedReader(fr);
           String linea;
           while((linea = br.readLine())!= null){
              linea = linea.replaceAll("[()]", ""); //Para quitar los parentesis de la linea
              System.out.println(linea);
              String[] datos = linea.split(","); //Para poder separar las palabras
              System.out.println(datos[0]);
              System.out.println(datos[1]);
              arbol.insertar(new Asociacion<String, String>(datos[0],datos[1]));
           }
           br.close();
           fr.close();
        }catch(Exception e){
            System.err.println("Se produjo un error");
        }
       arbol.mostrarInorder(arbol.getRaiz());
       System.out.println("\n");
        
    }
    
}
