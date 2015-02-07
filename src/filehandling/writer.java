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
public class writer {
    public static void main(String[] args) throws Exception
    {
    FileWriter fw = new FileWriter("test.txt",true);
    File f= new File("test.txt");
    fw.write("Akash\n");
    fw.write("Shanky\n");
    fw.write("Rishabh\n");
    fw.flush();
    fw.close();
    System.out.println(f.getAbsolutePath());
    }
    
}
