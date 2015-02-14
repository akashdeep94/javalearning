/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Akash
 */
import java.net.*;
import java.io.*;
public class client {
    

    public static void main(String[] args) {
        ServerSocket sskt;
        Socket skt;
        PrintWriter out;
        BufferedReader readC,readKB;
       
        String msg;
        try{
            skt = new Socket("127.0.0.1",1500);
            readC = new BufferedReader(new InputStreamReader(skt.getInputStream()));
            readKB = new BufferedReader(new InputStreamReader(System.in));
            out= new PrintWriter(skt.getOutputStream(),true);
            
            do{
                
                msg = readKB.readLine();
                out.println(msg);
                
                msg=readC.readLine();
                System.out.println(msg);
                
            }
            while(!msg.equals("bye"));
            
        }
        catch(Exception e){
            System.out.println("server()"+ e);
        
        }
    }
}

    

