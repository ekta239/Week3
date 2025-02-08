package com.filereader.readlineusingfilereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.server.SocketSecurityException;
//create class ReadLine
public class readLine {
//main method, 
    public void ReadLine(String str) {
        //create object for filereader and pass file location
        //create object for bufferreader
        //try catch block for exception handling and print file statement
        String line;
        try (BufferedReader br=new BufferedReader(new FileReader(str))) {
            while ((line=br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();   
        }   
    }
    public static void main(String[] args) {
        String S2="A:\\BridgeLab\\Week3\\textfile.txt";
        readLine rl=new readLine();
        rl.ReadLine(S2);
    }
}

