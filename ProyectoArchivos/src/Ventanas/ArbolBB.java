/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

/**
 *
 * @author keviu
 */
public class ArbolBB {
      
      NodoArbol raiz;
    public void ArbolBB(){
         raiz=null;
    }
 
    public boolean esVacio(){
        return (raiz == null);
    }
 
    public void insertar(String dato,NodoArbol actual){
        NodoArbol nuevo = new NodoArbol(dato);
        if (esVacio()) {
            
            nuevo.dato = dato;
            nuevo.hd = null;
            nuevo.hi = null;
            raiz = nuevo;
        }
        else {
            if (dato.compareTo(raiz.dato) > 0) {
                raiz.hd=dato;
            }
            if (dato < raiz.dato){
                (raiz.hi).insertar(dato);
            }
        }
    }
    public void insertar(T Valor, Nodo<T> actual, Comparasion comparar)
        {
             Nodo< T > nuevo = new Nodo<T>(Valor);
            

            if (actual==null)
            { //Es la raiz
                cantidad++;
                Raiz = nuevo;
            }
            else if (comparar(Valor, actual.valor) == 1)
            {
                if (actual.Izq == null)
                {
                    actual.Izq = nuevo;
                    cantidad++;
                }
                else
                    insertar(Valor, actual.Izq, comparar);
            }
            else if (comparar(Valor, actual.valor) == -1)
            {
                if (actual.Der == null)
                {
                    actual.Der = nuevo;
                    cantidad++;
                }
                else
                    insertar( Valor, actual.Der, comparar);
            }

 
    
    
}
