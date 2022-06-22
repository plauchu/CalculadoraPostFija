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
public class RevParentesis{
    
    String cadena;

    public RevParentesis(String cadena) {
        this.cadena = cadena;
    } 
   
    public boolean estaBalanceada(){
        PilaA <Character> pila = new PilaA();
        int i, tam;
        tam=cadena.length();
        i=0;
        boolean band =true;
        
        while(i<tam){
            if(cadena.charAt(i)=='('){
                pila.push(cadena.charAt(i));
            }
            else{
                if(cadena.charAt(i)==')'){
                    if(!pila.isEmpty()){
                        pila.pop();
                    }
                    else{
                        band=false;
                    }
                }
            i++; 
             
            }
        }
    return band;
    }
    
    public static String invierteCad(String cadOrig){
        StringBuilder res= new StringBuilder();
        PilaA <Character> pila= new PilaA();
        int 
        i,n;
        n=cadOrig.length();
        
        for(i=0;i<n;i++){
            pila.push(cadOrig.charAt(i));
        }
        while(!pila.isEmpty()){
            res.append(pila.pop());
        }
             
        return res.toString();
    }
    
    public static boolean pilaContieneOtra(PilaA pila1,PilaA pila2){
        boolean res=false;
        int i;
        
        while(!pila1.isEmpty() && !pila2.isEmpty() && pila1.peek().equals(pila2.peek())){
            pila1.pop();
            pila2.pop();
        }
        if(pila1.isEmpty() && pila2.isEmpty()){
               res=true;
        }
        
        return res;
    }
    
    public static <T> void intercambia(PilaA<T> p1, PilaA<T> p2 ){
        PilaA aux= new PilaA();
        int i=0;
        int j=0;
        
        while(!p2.isEmpty()){
            aux.push(p2.peek());
            p2.pop();
            i++;
        }
        while(!p1.isEmpty()){
            aux.push(p1.peek());
            p1.pop();
            j++;
        }
        while(j!=0){
            p2.push((T) aux.peek());
            aux.pop();
            j--;
        }
        while(i!=0){
            p1.push((T) aux.peek());
            aux.pop();
            i--;
        }
             
    }
    
    
    
}
  
