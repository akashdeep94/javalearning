/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading;

/**
 *
 * @author Akash
 */
public class ThreadMain {
    public static void main(String[] args) {
        ThreadOne ob = new ThreadOne();
        Thread ob2 =new Thread(new ThreadTwo());
        ob.start();
        ob2.start();
        System.out.println("I am inside main hahahah");
    }
    
}
