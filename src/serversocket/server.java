/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serversocket;

/**
 *
 * @author Akash
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class server {

    Socket skt;
    ServerSocket sskt;
    BufferedReader readC, readKB;
    PrintWriter out;
    String msg, userName, password;

    public static void main(String[] args) throws Exception {
        server startServer = new server();
        startServer.startServer();
        if (startServer.verifyCredentials()) {
            startServer.chitChat();
        }

    }

    public void startServer() throws Exception {
        sskt = new ServerSocket(1500);
        skt = sskt.accept();

        readKB = new BufferedReader(new InputStreamReader(System.in));
        readC = new BufferedReader(new InputStreamReader(skt.getInputStream()));
        out = new PrintWriter(skt.getOutputStream(), true);

    }

    boolean verifyCredentials() throws Exception {

        userName = readC.readLine();
        password = readC.readLine();
        Scanner scr = new Scanner(new File("password.txt"));
        boolean flag = false;
        while (scr.hasNextLine()) {
            String line = scr.nextLine();
            String Fileusername = line.substring(0, line.indexOf(' '));
            String Filepassword = line.substring(line.indexOf(' ') + 1, line.length());
            if (userName.equals(Fileusername) && password.equals(Filepassword)) {
                System.out.println("Valid user");
                out.println("true");
                flag = true;
                System.out.println("Messagesent");
                break;
            }

        }
        if (!flag) {
            out.println("invalid user");
        }
        return flag;
    }

    public void chitChat() throws Exception {

        do {
            msg = readC.readLine();
            System.out.println(msg);

            msg = readKB.readLine();
            out.println(msg);

        } while (!msg.equals("bye"));
    }
}
