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
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class NewServer {

    BufferedReader readC, readKB;
    PrintWriter out;
    ServerSocket sskt;
    Socket skt;
    boolean flag = false;
    String userName, password;

    public static void main(String[] args) throws Exception {
        NewServer server = new NewServer();
        if (server.verifyCredentials()) {
            server.chitChat();
        }

    }

    boolean verifyCredentials() throws Exception {
        sskt = new ServerSocket(1500);
        skt = sskt.accept();
        readC = new BufferedReader(new InputStreamReader(skt.getInputStream()));
        userName = readC.readLine();
        password = readC.readLine();
        out = new PrintWriter(skt.getOutputStream());

        Scanner scr = new Scanner(new File("password.txt"));
        boolean flag = false;
        while (scr.hasNextLine()) {
            String line = scr.nextLine();
            String Fileusername = line.substring(0, line.indexOf(' '));
            String Filepassword = line.substring(line.indexOf(' ') + 1, line.length());
            if (userName.equals(Fileusername) && password.equals(Filepassword)) {
                System.out.println("Valid user");
                flag = true;
                break;
            }

        }
        if (!flag) {
            System.out.println("invalid user");
        }
        return flag;
    }

    void chitChat() throws Exception {
        String msg;
        out.println("You are a valid user.Starting converseation");
        System.out.println("reached here");
        
         do{
                msg = readC.readLine();
                System.out.println(msg);
                msg=readKB.readLine();
                out.println(msg);
            }
            while(!msg.equals("bye"));
        
    }

}
