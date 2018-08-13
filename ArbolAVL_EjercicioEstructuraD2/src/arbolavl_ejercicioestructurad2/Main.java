/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolavl_ejercicioestructurad2;

/**
 *
 * @author gmmonsalve
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static int[] vector_a() { //Método de generación de vector con números aleatorios
        int num;
        int lol[] = new int[5];
        for (int i = 0; i < 5; i++) {
            num = (int) (Math.random() * 100) + 1;
            lol[i] = num;
        }
        return lol;
    }

    public static void main(String[] args) {
        int vector[] = vector_a();
        Nodo raiz = new Nodo(vector[0]);
        ArbolBinario arbol = new ArbolBinario(raiz);

        for (int i = 0; i < vector.length; i++) { //insertar
            arbol.insertarAVL(raiz, vector[i]);
        }
            
    }

}
