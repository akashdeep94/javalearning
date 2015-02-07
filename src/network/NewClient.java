/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

/**
 *
 * @author Akash
 *
 */
import java.io.*;
import java.net.*;

public class NewClient {

    BufferedReader br, readKB, readC;
    InputStreamReader isr;
    String userName, password,msg;
    Socket skt;
    PrintWriter out;

    public static void main(String[] args) throws Exception {
        NewClient client = new NewClient();
        client.credentials();

    }

    void credentials() throws Exception {
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);
        System.out.println("Enter Your username");
        userName = br.readLine();
        System.out.println(userName);
        System.out.println("Enter Your password");
        password = br.readLine();
        System.out.println(password);
        skt = new Socket("127.0.0.1", 1500);
        out = new PrintWriter(skt.getOutputStream(), true);
        readC = new BufferedReader(new InputStreamReader(skt.getInputStream()));
        out.println(userName);
        out.println(password);
        msg=readC.readLine();
        System.out.println(msg);
        System.out.println("reached here type now");
         do{
                msg = readKB.readLine();
                out.println(msg);
                
                msg=readKB.readLine();
                System.out.println(msg);
            }
            while(!msg.equals("bye"));

        
        String str = readC.readLine();

        /*}
         else
         System.out.println("Invalid User");
         */
    }

    /*  void chitChat()throws Exception{
     readKB = new BufferedReader(new InputStreamReader(System.in));
     out = new PrintWriter(skt.getOutputStream());
     readC = new BufferedReader(new InputStreamReader(skt.getInputStream()));
     do {
     out.println(readKB.readLine());
     System.out.println(readC.readLine());
     }
     while(!readC.readLine().equals("bye"));
           
     }*/
}
