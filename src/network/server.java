/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

/**
 *
 * @author Akash
 */
import java.net.*;
import java.io.*;
public class server {
    public static void main(String[] args) {
        ServerSocket sskt;
        Socket skt;
        PrintWriter out;
        BufferedReader readC,readKB;
        String msg,userName,password;
        try{
            sskt = new ServerSocket(1500);
            skt=sskt.accept();
            readC = new BufferedReader(new InputStreamReader(skt.getInputStream()));
            readKB = new BufferedReader(new InputStreamReader(System.in));
            out= new PrintWriter(skt.getOutputStream(),true);
            
            do{
                msg = readC.readLine();
                System.out.println(msg);
                msg=readKB.readLine();
                out.println(msg);
            }
            while(!msg.equals("bye"));
            
        }
        catch(Exception e){
            System.out.println("server()"+ e);
        
        }
    }
}
