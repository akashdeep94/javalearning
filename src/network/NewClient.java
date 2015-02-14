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

public class NewClient {

    Socket skt;
    BufferedReader readC, readKB;
    PrintWriter out;
    String msg, userName, password, isValid;

    public static void main(String[] args) throws Exception {
        NewClient startChat = new NewClient();
        startChat.startClient();
        if ((startChat.credentials().equals("true"))) {
            System.out.println("You are a valid user.Starting chat");
            startChat.chitChat();
        }
        else 
            System.out.println("Invalid Username or password");

    }

    void startClient() throws Exception {
        skt = new Socket("127.0.0.1", 1500);
        readKB = new BufferedReader(new InputStreamReader(System.in));
        readC = new BufferedReader(new InputStreamReader(skt.getInputStream()));
        out = new PrintWriter(skt.getOutputStream(), true);

    }

    String credentials() throws Exception {

        System.out.println("Enter Your username");
        userName = readKB.readLine();
        System.out.println("Enter Your password");
        password = readKB.readLine();
        out.println(userName);
        out.println(password);
        isValid = readC.readLine();
        return isValid;

    }

    public void chitChat() throws Exception {

        do {
            msg = readKB.readLine();
            out.println(msg);

            msg = readC.readLine();
            System.out.println(msg);

        } while (!msg.equals("bye"));
    }

}
