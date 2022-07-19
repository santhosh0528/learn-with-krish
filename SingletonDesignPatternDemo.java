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
public class SingletonDesignPatternDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // get only one object of SingleObject class to a variable
        SingleObject obj = SingleObject.getInstance();
        System.out.println("Print 1st variable :"+ obj);

        // get only one object of SingleObject class to another variable
        SingleObject obj2 = SingleObject.getInstance();
        System.out.println("Print 2nd variable :"+ obj2);


        //access method of singleObject class
        obj.showMessage();
    
    }
    
}
