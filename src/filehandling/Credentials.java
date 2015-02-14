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
import java.util.*;

public class Credentials {

    public static void main(String[] args) throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.println("Enter user name");
        String inputUser = br.readLine();
        System.out.println("Enter Password");
        String inputPassword = br.readLine();

        Credentials c = new Credentials();
        c.verifyCredentials(inputUser, inputPassword);
    }

    void verifyCredentials(String inputUser, String inputPassword) throws Exception {
        Scanner scr = new Scanner(new File("password.txt"));
        boolean flag = false;
        while (scr.hasNextLine()) {
            String line = scr.nextLine();
            String username = line.substring(0, line.indexOf(' '));
            String password = line.substring(line.indexOf(' ') + 1, line.length());
            if (inputUser.equals(username) && inputPassword.equals(password)) {
                System.out.println("Valid user");
                flag = true;
                break;
            }

        }
        if (!flag) {
            System.out.println("invalid user");
        }
    }

}
