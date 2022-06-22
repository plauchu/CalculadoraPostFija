/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas;

import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author Plauchu
 */
public class Ejercicios {

    public static <T> void eliminaRepetidos(PilaA pila) {
        PilaA aux = new PilaA();
        int i = 0;
        T elemento;
        elemento = (T) pila.peek();

        if (!pila.isEmpty()) {
            aux.push(pila.peek());
            pila.pop();
        }
        while (!pila.isEmpty()) {
            if (!pila.peek().equals(elemento)) {
                aux.push(pila.peek());
            }
            elemento = (T) pila.pop();

        }
        while (!aux.isEmpty()) {
            pila.push(aux.peek());
            aux.pop();
        }

    }

    public static String convierteBinario(int num) {
        StringBuilder res = new StringBuilder();
        int mod;
        int div;
        PilaA aux = new PilaA();

        while (num >= 1) {
            div = num / 2;
            mod = num % 2;
            if (mod == 1) {
                aux.push(1);
            } else {
                aux.push(0);
            }
            num = div;
        }
        if (aux.isEmpty()) {
            res.append(0);
        }
        while (!aux.isEmpty()) {
            res.append(aux.peek());
            aux.pop();
        }

        return res.toString();
    }

    public static <T> boolean comparaElementos(PilaA<T> pila) {
        boolean res = false;
        PilaA aux1 = new PilaA();
        PilaA aux2 = new PilaA();
        T elemento;
        boolean band = false;
        elemento = pila.peek();

        if (pila.isEmpty()) {
            throw new EmptyCollectionException();
        }

        while (!pila.isEmpty() && !band) {
            if (pila.peek() instanceof Integer) {
                if (((Integer) elemento) >= ((Integer) pila.peek())) {
                    aux1.push(pila.pop());
                } else {
                    aux2.push(pila.pop());
                }
            }
            if (pila.isEmpty() && !aux2.isEmpty()) {
                while (!aux2.isEmpty()) {
                    pila.push((T) aux2.pop());
                }
                elemento = pila.peek();
            } else {
                band = true;

            }
        }

        return res;
    }

    public static String checar(PilaA pila) {
        StringBuilder res = new StringBuilder();

        while (!pila.isEmpty()) {
            if (pila.peek() instanceof String) {
                res.append("\n"+pila.pop());
            } else {
                pila.pop();

            }
        }

        return res.toString();
    }

}
