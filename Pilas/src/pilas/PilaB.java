/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas;

/**
 *
 * @author Plauchu
 */
public class PilaB<T> implements PilaArreglos<T> {

    private T[] pila;
    private int topeIzq;
    private int topeDer;
    private final int MAX = 20;

    public PilaB() {
        pila = (T[]) new Object[MAX];
        topeIzq = -1;
        topeDer = pila.length;
    }

    public PilaB(int max) {
        pila = (T[]) new Object[max];
        topeIzq = -1;
        topeDer = pila.length;
    }

    public void pushIzq(T dato) {
        if (topeIzq == pila.length - 1) {//si está lleno expande
            expandeIzq();
        }
        topeIzq++;
        pila[topeIzq] = dato;
    }

    public T popIzq() {
        T res;

        if (isEmptyIzq()) {
            throw new EmptyCollectionException(); //truena y sale
        } else {
            res = pila[topeIzq];
            pila[topeIzq] = null;
            topeIzq--;
        }
        return res;
    }

    public T peekIzq() {
        T res;

        if (!isEmptyIzq()) {
            res = pila[topeIzq];
        } else {
            throw new EmptyCollectionException();
        }
        return res;
    }

    public void pushDer(T dato) {
        if (topeDer == 1) {//si está lleno expande
            expandeDer();
        }
        topeDer--;
        pila[topeDer] = dato;
    }

    private void expandeIzq() {
        T[] nuevo = (T[]) new Object[pila.length * 2];

        for (int i = 0; i <= topeIzq; i++) {
            nuevo[i] = pila[i];
        }
        pila = nuevo; //intercambia la dirección de memoria
    }

    private void expandeDer() {
        T[] nuevo = (T[]) new Object[pila.length * 2];

        for (int i = 0; i <= topeDer; i++) {
            nuevo[i] = pila[i];
        }
        pila = nuevo; //intercambia la dirección de memoria
    }

    public T popDer() {
        T res;

        if (isEmptyDer()) {
            throw new EmptyCollectionException(); //truena y sale
        } else {
            res = pila[topeDer];
            pila[topeDer] = null;
            topeDer++;
        }
        return res;
    }

    public T peekDer() {
        T res;

        if (!isEmptyDer()) {
            res = pila[topeDer];
        } else {
            throw new EmptyCollectionException();
        }
        return res;
    }

    public boolean isEmptyIzq() {
        return topeIzq == -1;
    }

    public boolean isEmptyDer() {
        return topeDer == pila.length;
    }

}
