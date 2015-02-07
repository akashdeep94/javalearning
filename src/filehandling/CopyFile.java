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

public class CopyFile {

    public static void main(String[] args) throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringBuffer sb = new StringBuffer();
        CopyFile cf = new CopyFile();
        System.out.println("Enter Location of file to be copied");
        String source = br.readLine();
        List<Character> list = new ArrayList<>();
        if (!source.contains("\\")) {
            System.out.println("Invalid location");

        } else {
            int i = source.length() - 1;
            while (source.charAt(i) != '\\') {
                list.add(source.charAt(i));
                i--;
            }

            for (int j = list.size() - 1; j >= 0; j--) {
                sb.append(list.get(j));
            }
            System.out.println("Enter Destination name of filename");
            String output = (br.readLine());
            cf.copy(source, sb, output);
        }

    }

    public void copy(String input, StringBuffer file, String output) throws Exception {
        File f = new File(input);
        if (f.exists()) {

            String path;
            path = input.substring(0, (input.length() - file.length())) + output;
            FileReader fr = new FileReader(input);
            FileWriter fw = new FileWriter(path);
            int i = 0;
            while ((i = fr.read()) != -1) {
                fw.write((char) i);
            }
            fw.flush();
            System.out.println("File copied to location\n"+path);
            fw.close();
            fr.close();

        } else {
            System.out.println("File NOT FOUND");
        }

    }

}
