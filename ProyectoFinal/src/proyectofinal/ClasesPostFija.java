/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.util.ArrayList;
import pilas.PilaA;
import pilas.RevParentesis;

/**
 * Clase Calculadora
 * <pre>
 * Clase con métodos para verificar una expresión algebráica y evlauarla
 * </pre>
 * @author Constanza Ybarra Trapote, Daniel Alejandro Nieto Barreto, Rodrigo Plauchú Rodríguez, Santiago Fernández Gutiérrez Zamora.
 * 
 */
public class ClasesPostFija {
    /**
     * Es operador
     * <pre>
     * Función que determina si un caracter es un operador algebráico
     * </pre>
     * @param c caracter a comparar
     * @return <ul>
     * <li> true: si el caracter es '+','-','*' o '/'</li>
     * <li> false: si el caracter no es '+','-','*' o '/'</li>
     * </ul>
     */
    public static boolean esOperador(char c){
        ArrayList<Character> ops = new ArrayList<Character>();
        ops.add('+');
        ops.add('-');
        ops.add('*');
        ops.add('/');
        return ops.contains(c); //si el caracter coincide con alguno de los elemntos del arreglo
    }
     
    /**
     * Verificar paréntesis
     * <pre>
     * Método para verificar si los paréntesis de 
     * una expresión dada están balanceados, es decir, cada '('
     * tiene un ')' después.
     * Se recibe la expresión como parámetro
     * </pre>
     * @param exp expresión algebráica
     * @return 
     * <ul>
     * <li> true: si los paréntesis están balanceados</li>
     * <li> false: si los paréntesis no están balaceados
     * </ul>
     */
   public static boolean verificarParentesis(String exp){
        PilaA pila = new PilaA();
        int i, tam;
        boolean aux;
        
        tam = exp.length();
        i = 0;
        aux = true;
        while(i < tam && aux){ //recorrer la expresión, se sale si encuentra un error
            if(exp.charAt(i) == '(')
                pila.push(exp.charAt(i));//meter el paréntesis a la pila
            else{
                if(exp.charAt(i) == ')'){
                    if(!pila.isEmpty())//si es correspondido
                        pila.pop();
                    else
                        aux = false; //significa que no estan correspondido
                }
            }
            i++;
        }
        return aux && pila.isEmpty();
    }
    /**
     * Verificar los lados de los operadores
     * <pre>
     * Verificar que un operador de la expresión sea válido, es decir, hay un 
     * valor numérico de cada lado de la expresión.
     * </pre>
     * @param exp expresión algebráica
     * @return <ul>
     * <li> true: si los operadores son válidos.</li>
     * <li> false: si los operadores no son válidos</li>
     * </ul>
     */
     public static boolean verificaLadosOperadores(String exp){
        boolean resp;
        int i,n;
        i=0;
        n=exp.length();
        resp=true;
        while(i<n&&resp){ //recorrer la expresión, se sale si hay un error
            if(esOperador(exp.charAt(i))&&i==0) //si hay un operador al principio
                resp=false;
            else
                if(esOperador(exp.charAt(i)) && ((exp.charAt(i-1)=='(') || (exp.charAt(i+1)==')')) )//si hay un operador y un paréntesis que no haga sentido
                    resp=false;
                else
                    if(i==n-1&&esOperador(exp.charAt(i)))//si hay un operador al último
                        resp=false;
            i++;
        }
        return resp;
    } 
    /**
     * Convertir a posfija
     * <pre>
     * Convertir una expresión algebráica a posfija la cual es una expresión 
     * sin paréntesis en la que un operador influye a los dos 
     * números anteriores.
     * </pre>
     * @param exp expresión algebráica
     * @return String de la expresión en posfija.
     */
    public static String convertirPosfija(String exp){
        StringBuilder res = new StringBuilder();
        PilaA<Character> pila = new PilaA();
        ArrayList<Character> ops = new ArrayList();
        boolean aux;
        char  elem,elem1;
        aux=false;
        
        //jerarquía
        ops.add('-');
        ops.add('+');
        ops.add('/');
        ops.add('*');  
        
        for(int i = 0; i < exp.length(); i++){//recorrer la expresión original caracter por caracter
            elem = exp.charAt(i);
            if(i!=0) 
                elem1=exp.charAt(i-1);//tomar el elemnto anterior
            else
                elem1=elem;//la primera vuelta 
            if(!esOperador(elem) && elem != '(' && elem != ')'){//si es un elemento
                if(elem=='.'){//hay un punto decimal
                    aux=true;
                    if(!esOperador(elem1) && elem1 != '(' && elem1 != ')')//el anterior es un número
                        res.append(elem);
                    else
                        res.append("_" + elem);//si el anterior no es un nùmero, separar con un guión bajo
                }
                else
                    if(aux)
                        res.append(elem);//es un dígito después de un punto decimal
                    else
                        if(i==0)
                            res.append("_" + elem);//es el primer elemento
                        else
                            if(esOperador(elem1) || elem1 == '(' || elem1 == ')')
                                res.append("_" + elem);//es el primer dígito despuès de paréntesis u operador
                            else
                                res.append(elem);//es un dígito de una cifra con más de un dígito
            }
            else{
                if(esOperador(elem)){ //tiene un operador   
                    while(!pila.isEmpty() && ops.indexOf(elem) <= ops.indexOf(pila.peek())){
                        //jerarquia
                        res.append("_" + pila.pop()); //saca el ultimo elemento de la pila y lo mete a la expresión  
                        
                    }
                    pila.push(elem);
                    aux = false;
                }               
            }
            if(elem == '(')
                pila.push(elem); //mete a la pila el operador
            if(elem == ')'){
                while(!pila.isEmpty() && pila.peek() != '(')
                    res.append("_" + pila.pop());
                if(!pila.isEmpty())
                    pila.pop();
                } 
        }
        while(!pila.isEmpty())
            res.append("_" + pila.pop());//separar con un guión bajo e insertar los elementos que faltan
        return res.toString();
    }
    
    /**
     * Calcular posfija
     * <pre>
     * Evalua la expresión pos fija 
     * </pre>
     * @param exp la expresión algerbráica en posfija
     * @return resultado de la expresión en número.
     */
    public static double calculaPostFija(String exp){
        double total;
        PilaA<Double> numeros=new PilaA<Double>();
        int i,n,j;
        char elem,elem1;
        String aux;
        n=exp.length();
        i=0;
        total=0;
        while(i<n){//ciclo recorre la expresión
            elem=exp.charAt(i);
            if(elem!='_'&&!esOperador(elem)){//si es parte de una cifra
                if(elem==':'){//si símbolo de cambio de signo
                    j=i+1;
                    aux="";
                    elem1=exp.charAt(j);
                    while(elem1!='_'){//se recorre la expresión a partir del primer dígito
                        aux=aux+elem1;//concatenación
                        j++;
                        elem1=exp.charAt(j);
                    }
                    numeros.push(Double.parseDouble(aux)*-1);//Se agrega el nùmero encontrado multiplicado por -1 (cambio de signo)
                }
                else{//no hay cambio de signo
                    j=i;
                    aux="";
                    elem1=exp.charAt(j);
                    while(elem1!='_'){//se recorre la expresión a partir del primer dígito
                        aux=aux+elem1;//concatenación
                        j++;
                        elem1=exp.charAt(j);
                    }
                    numeros.push(Double.parseDouble(aux));//se agrega el valor a la pila
                }
                i=j;//salto de i hasta la posición después de terminado la cifra
            }
            else{//es guión u operador
                if(esOperador(elem)){//es operador
                    switch(elem){
                        case'+'://suma
                            total=numeros.pop()+numeros.pop();
                        break;

                        case '-'://resta
                            total=-numeros.pop()+numeros.pop();
                        break;

                        case'*'://multiplicación
                            total=numeros.pop()*numeros.pop();
                        break;

                        case'/'://división
                            total=Math.pow(numeros.pop(),-1)*numeros.pop();
                        break;
                    }
                    numeros.push(total);//se agrega el resultado a la pila de números
                }
                i++;//incremento de i
            }
        }//termina el ciclo 
        return numeros.peek();//se regresa el único dato guardado en la pila (resultado final)
    } 
}

    

