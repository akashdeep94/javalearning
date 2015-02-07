/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filehandling;

/**
 *
 * @author Akash
 */
import java.io.*;
public class Reader {
    public static void main(String[] args)throws Exception {
        FileReader fr = new FileReader("test.txt");
        int i=0;
        while((i = fr.read())!=-1){
            System.out.print((char)i);
        }
        fr.close();
    }
    
}
