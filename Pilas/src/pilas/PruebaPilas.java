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
public class PruebaPilas {

    /**
     * @param args the command line arguments
     */
    
    private static void imprime(PilaA pila){
        PilaA aux= new PilaA();
        
        while(!pila.isEmpty()){
            System.out.println("\n"+pila.peek());
            aux.push(pila.peek());
            pila.pop(); 
        }
        while(!aux.isEmpty()){
            pila.push(aux.peek());
            aux.pop(); 
        }
        
    }
    
    public static void main(String[] args) {
        
        RevParentesis rev= new RevParentesis("(Yo estoy bien)");
        PilaA prueba1= new PilaA();
        prueba1.push('1');
        prueba1.push('1');
        prueba1.push('2');
        prueba1.push('2');
        prueba1.push('2');
        prueba1.push('3');
        prueba1.push('3');
        PilaA prueba2= new PilaA();
        prueba2.push(1);
        prueba2.push(2);
        prueba2.push(3);
        prueba2.push(4);
        String nom="Rodrigo Plauchu";
        int num=16;
        PilaA prueba3= new PilaA();
        prueba3.push("Hola");
        prueba3.push(2);
        prueba3.push(2);
        prueba3.push("Hola");
        
        
        //System.out.println(prueba1.peek());
        //System.out.println(RevParentesis.pilaContieneOtra(prueba1, prueba2));
        //System.out.println(rev.estaBalanceada());
        //System.out.println(RevParentesis.invierteCad(nom));
        //System.out.println(Ejercicios.convierteBinario(num));
        //imprime(prueba1);
        //Ejercicios.eliminaRepetidos(prueba1);
        //imprime(prueba1);
        //System.out.println(prueba1.imprime(prueba1));
        //System.out.println(prueba2.imprime(prueba2));
        //RevParentesis.intercambia(prueba1, prueba2);
        //System.out.println(prueba1.imprime(prueba1));
        //System.out.println(prueba2.imprime(prueba2));
        //System.out.println(prueba3.imprime(prueba3));
        //System.out.println(prueba3.multiPops(7));
        //System.out.println(prueba3.imprime(prueba3));
        
        //System.out.println(prueba3.imprime(prueba3));
        //Ejercicios.comparaElementos(prueba3);
        System.out.println(Ejercicios.checar(prueba3));
    }
    
}
