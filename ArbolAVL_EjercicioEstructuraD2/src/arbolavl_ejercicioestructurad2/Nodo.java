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
public class Nodo {

    int info;
    Nodo derecho;
    Nodo izquierdo;
    int factorBalance;

    public Nodo(int info) {
        this.info = info;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public Nodo getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }

    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public void setFactorBalance(int factorBalance) {
        this.factorBalance = factorBalance;
    }

    public int getFactorBalance() {
        return factorBalance;
    }

}
