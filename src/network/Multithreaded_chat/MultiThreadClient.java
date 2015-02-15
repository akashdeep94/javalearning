/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network.Multithreaded_chat;

/**
 *
 * @author Akash
 */
import java.io.*;
import java.net.*;

 public class MultiThreadClient {

    public static void main(String[] args) throws Exception {
        Socket skt;
        BufferedReader readC, readKB;
        PrintWriter out;
        String msg;

        skt = new Socket("127.0.0.1", 1500);
        readKB = new BufferedReader(new InputStreamReader(System.in));
        readC = new BufferedReader(new InputStreamReader(skt.getInputStream()));
        out = new PrintWriter(skt.getOutputStream(),true);
        CreadThread CreadThread = new CreadThread(readC);
        CreadThread.start();
        KBreadThread KBreadThread = new KBreadThread(out,readKB);
        KBreadThread.start();
    }

}

 class CreadThread extends Thread {

    BufferedReader readC = null;

    CreadThread(BufferedReader readC) {
        this.readC = readC;

    }

    @Override
    public void run() {
        String msg = "";
        try {
            do {
                msg = readC.readLine();
                System.out.println(msg);

            } while (!msg.equals("bye"));

        } catch (Exception e) {
            System.out.println("Read Exception" + e);
        }

    }

}

class KBreadThread extends Thread{
   String msg="";
   BufferedReader readKB;
   PrintWriter out;
KBreadThread(PrintWriter out,BufferedReader readKB){
 this.readKB=readKB;
 this.out=out;
 
}
   @Override
   public void run(){
       try{
           do{
               msg=readKB.readLine();
               out.println(msg);
           
           }
           while(!msg.equals("bye"));
       }
       catch(Exception e){
           System.out.println("Exception in writting to socket"+ e);
       }
}

}


