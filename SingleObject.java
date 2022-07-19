/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleton.design.pattern;

/**
 *
 * @author Admin
 */
public class SingleObject {
    //Step 1
    private static SingleObject instance = new SingleObject();

    //Step 2
    private SingleObject(){};

    //Step 3
    public static SingleObject getInstance(){
        return instance;
    }

    //a method to print something
    public void showMessage(){
        System.out.println("Hello World!");
    }
    
}
