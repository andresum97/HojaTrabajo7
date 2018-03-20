/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojatrabajo7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

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
        ArrayList<String> mensajeTraducido = new ArrayList<String>();
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
              String[] datos = linea.split(","); //Para poder separar las palabras
              arbol.insertar(new Asociacion<String, String>(datos[0],datos[1]));
           }
           br.close();
           fr.close();
           f = new File("./texto.txt");
           fr = new FileReader(f);
           br = new BufferedReader(fr);
           while((linea = br.readLine())!= null){
              linea = linea.replaceAll("[()]", ""); //Para quitar los parentesis de la linea
              System.out.println(linea);
              String word = "";
              for (int i=0; i<linea.length();i++){
                  if ((!" ".equals(linea.substring(i, i+1))) 
                          && (!".".equals(linea.substring(i, i+1)))){
                    word = word + linea.substring(i, i+1); 
                  } else {
                      Asociacion<String,String> result = arbol.buscar(new Asociacion(word, ""));
                      if (result != null){
                        mensajeTraducido.add(result.value);
                      } else{
                        mensajeTraducido.add("**"+word+"**");
                      }
                      
                      word ="";
                  }
              }
               
           }
           linea ="";
           for (int i=0;i<mensajeTraducido.size();i++){
               linea = linea +" "+mensajeTraducido.get(i);
               
           }
           System.out.println(linea);
           br.close();
           fr.close();
        }catch(Exception e){
            System.err.println("Se produjo un error");
        }
       arbol.mostrarInorder(arbol.getRaiz()); 
       System.out.println("\n");
        
    }
    
}
