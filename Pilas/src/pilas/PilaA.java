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
public class PilaA<T> implements Pila<T> {

    private T[] pila;
    private int tope;
    private final int MAX = 20;

    public PilaA() {
        pila = (T[]) new Object[MAX];
        tope = -1;
    }

    public PilaA(int max) {
        pila = (T[]) new Object[max];
        tope = -1;
    }

    public boolean isEmpty() {
        return tope == -1;
    }

    public void push(T dato) {

        if (tope == pila.length - 1)//si está lleno expande
        {
            expande();
        }
        tope++;
        pila[tope] = dato;
    }

    private void expande() {
        T[] nuevo = (T[]) new Object[pila.length * 2];

        for (int i = 0; i <= tope; i++) {
            nuevo[i] = pila[i];
        }
        pila = nuevo; //intercambia la dirección de memoria
    }

    public T pop() {
        T res;

        if (isEmpty()) {
            throw new EmptyCollectionException(); //truena y sale
        } else {
            res = pila[tope];
            pila[tope] = null;
            tope--;
        }
        return res;
    }

    public T peek() {
        T res;

        if (!isEmpty()) {
            res = pila[tope];
        } else {
            throw new EmptyCollectionException();
        }
        return res;
    }

    public boolean multiPops(int n) {
        boolean res = false;
        PilaA aux = new PilaA();
        int i = 0;

        if (!isEmpty()) {
            while (!isEmpty() && i < n) {
                aux.push(pop());
                i++;
            }
            if (i >= n) {
                res = true;
            } else {
                while(!aux.isEmpty()){
                    push((T) aux.pop());
                }
            }
        }
        
        return res;
    }

    public String imprime(PilaA pila) {
        StringBuilder res = new StringBuilder();
        PilaA aux = new PilaA();

        while (!pila.isEmpty()) {
            res.append("\n" + pila.peek());
            aux.push(pila.peek());
            pila.pop();
        }
        while (!aux.isEmpty()) {
            pila.push((T) aux.peek());
            aux.pop();
        }
        return res.toString();
    }


}
