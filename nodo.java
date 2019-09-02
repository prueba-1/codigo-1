/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diego;

/**
 *
 * @author ALUMNO - FIIS
 */
public class nodo {
   
    private int valor;
    
    private nodo siguiente;

    public void nodo(){
        this.valor = 0;
        this.siguiente = null;
    }
    
    
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodo siguiente) {
        this.siguiente = siguiente;
    }   
}
