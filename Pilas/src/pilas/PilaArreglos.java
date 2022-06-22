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
public interface PilaArreglos <T>{
    
    public void pushIzq(T dato);
    
    public T popIzq();
    
    public T peekIzq();
    
    public void pushDer(T dato);
    
    public T popDer();
    
    public T peekDer();
    
    public boolean isEmptyIzq();
    
    public boolean isEmptyDer();
}
