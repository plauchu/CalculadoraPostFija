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
public class PruebaPilaB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        PilaB pila = new PilaB();

        pila.pushIzq(1);
        pila.pushIzq(2);
        pila.pushIzq(3);
        pila.pushIzq("Último");
        pila.pushDer("Último");
        pila.pushDer(3);
        pila.pushDer(2);
        pila.pushDer(1);

        while (!pila.isEmptyIzq()) {
            System.out.println(pila.peekIzq());
            pila.popIzq();
        }
        while (!pila.isEmptyDer()) {
            System.out.println(pila.peekDer());
            pila.popDer();
        }
    }

}
