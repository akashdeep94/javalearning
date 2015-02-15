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
import java.net.*;
import java.io.*;
public class MultiThreadServer {
    public static void main(String[] args) throws Exception {
      Socket skt;
      ServerSocket sskt;
      BufferedReader readC,readKB;
      PrintWriter out;
      sskt= new ServerSocket(1500);
      skt=sskt.accept();
      readKB = new BufferedReader(new InputStreamReader(System.in));
        readC = new BufferedReader(new InputStreamReader(skt.getInputStream()));
        out = new PrintWriter(skt.getOutputStream(),true);
        SCreadThread SCreadThread = new SCreadThread(readC);
        SCreadThread.start();
        SKBreadThread SKBreadThread = new SKBreadThread(out,readKB);
        SKBreadThread.start();
    }

}

 class SCreadThread extends Thread {

    BufferedReader readC = null;

    SCreadThread(BufferedReader readC) {
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

class SKBreadThread extends Thread{
   String msg="";
   BufferedReader readKB;
   PrintWriter out;
SKBreadThread(PrintWriter out,BufferedReader readKB){
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

   
