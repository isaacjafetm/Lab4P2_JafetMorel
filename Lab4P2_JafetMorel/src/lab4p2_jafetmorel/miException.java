/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4p2_jafetmorel;

/**
 *
 * @author 24661
 */
public class miException extends Exception{

    public miException() {
        super();
    }

    public miException(String string) {
        super(string);
    }

    @Override
    public String toString() {
        return "miException{" + '}';
    }
    
}
