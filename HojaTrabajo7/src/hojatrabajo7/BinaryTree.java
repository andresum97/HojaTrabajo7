/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojatrabajo7;

/**
 *
 * @author alber
 */
public class BinaryTree<E extends Comparable<E>>{
   /** protected E val; // value associated with node
    protected BinaryTree<E> parent; // parent of node
    protected BinaryTree<E> left, right; // children of node*/
    
    private Nodo<E> raiz;
    
    /**
     * Clase nodo y sus atributos
     * @param <E> Para que sean nodos genericos
     */
    public class Nodo<E>{//<E extends Comparable<E>>{
        E ele;
        Nodo<E> left,right;
        public Nodo(E e){
            left = null;
            right = null;
            ele = e;
        }
    }
    /**
     * Constructor de la clase
     */
    public BinaryTree(){
        raiz = null;
    }
    /**
     * Inserta un nodo en el arbol
     * @param id el elemento a ingresar
     */
    public void insertar(E id){ 
      Nodo<E> temp = new Nodo<E>(id);
      if(raiz==null){
          raiz = temp;
          return;
      }
      Nodo<E> actual = raiz;
      Nodo<E> parent = null;
      while(true){
         parent = actual;
         if(id.compareTo(actual.ele)<0){
             actual = actual.left;
             if(actual==null){
                 parent.left = temp;
                 //return;
             }
         }else{
             actual = actual.right;
             if(actual==null){
                 parent.right= temp;
                 //return;
             }
         }
      }
    }
    /**
     * Muestra si el arbol esta vacio
     * @return verdadero o falso dependiendo del la raiz
     */
    public boolean isEmpty()
    {
		return (raiz == null);
    }
    /**
     * Regresa la raiz
     * @return la raiz
     */
    public Nodo<E> getRaiz(){
        return raiz;
    }
    /**
     * Pone un valor a la raiz
     * @param raiz 
     */
    public void setRaiz(Nodo<E> raiz){
        this.raiz = raiz;
    }
    /**
     * Verifica si existe un nodo en el arbol
     * @param id el valor a buscar
     * @return null
     */
    public E buscar(E id){
        Nodo<E> actual = raiz;
        while(actual!=null){
            if(actual.ele.equals(id)){
                return actual.ele;
            }else
            if(actual.ele.compareTo(id)>0){
                actual = actual.left;
            }else{
                actual = actual.right;
            }
        }
        return null;
    }
    /**
     * Borra un elemento del arbol
     * @param id
     * @return true
     */
    public boolean borrar(E id){
        Nodo<E> padre = raiz;
        Nodo<E> actual = raiz;
        boolean hijoizquierdo = false;
        while(!actual.ele.equals(id)){
            padre = actual;
            if(actual.ele.compareTo(id)>0){
                hijoizquierdo = true;
                actual = actual.left;
            }else{
                hijoizquierdo = false;
                actual = actual.right;
            }
            if(actual==null){
                return false;
            }
        }
        //Caso 1: Si el nodo a borrar no tiene hijos
        if((actual.left==null) && (actual.right == null)){
            if(actual == raiz){
                raiz = null;
            }
            if(hijoizquierdo == true){
                padre.left = null;
            }else{
                padre.right = null;
            }
        }
        //Caso 2: Si el nodo a borrar tiene solo un hijo
        else if(actual.right == null){
            if(actual == raiz){
                raiz = actual.left;
            }else 
            if (hijoizquierdo){
                padre.left = actual.left;
            }else{
                padre.right = actual.left;
            }
        }
        else if(actual.left==null){
           if(actual == raiz){
               raiz = actual.right;
           }else
           if(hijoizquierdo){
               padre.left = actual.right;
           }else{
               padre.right = actual.right;
           }
        }else
         if(actual.left!= null && actual.right!= null){
             Nodo<E> sucesor = getSucesor(actual);
             if(actual == raiz){
                 raiz = sucesor;
             }else
             if(hijoizquierdo){
                 padre.left = sucesor;
             }else{
                 padre.right = sucesor;
             }
             sucesor.left = actual.left;
         }
        return true;
    }
    /**
     * Regresa el sucesor del nodo
     * @param nodo
     * @return al sucesor del nodo
     */
    public Nodo<E> getSucesor(Nodo<E> nodo){
        Nodo<E> sucesor = null;
        Nodo<E> padreSucesor = null;
        Nodo<E> actual= nodo.right;
        while(actual!= null){
            padreSucesor = sucesor;
            sucesor = actual;
            actual = actual.left;
        }
        if(sucesor!= nodo.right){
            padreSucesor.left = sucesor.right;
            sucesor.right = nodo.right;
        }
        return sucesor;
    }
    /**
     * Muestra los nodos del arbol
     * @param nodo nodo a mostrar
     */
    public void mostrar(Nodo<E> nodo){
        if(nodo!= null){
            mostrar(nodo.left);
            System.out.print(nodo.ele+" ");
            mostrar(nodo.right);
        }
    }
}
