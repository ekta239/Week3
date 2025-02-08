package com.inputstreamreader.readwriteinputusinginputstreamreader;
import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        String outputFile = "user_input.txt"; // File to store user input

        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             FileWriter fw = new FileWriter(outputFile, true); // Append mode enabled
             BufferedWriter bw = new BufferedWriter(fw)) {

            System.out.println("Enter text to write to the file (type 'exit' to stop):");

            String line;
            while (!(line = br.readLine()).equalsIgnoreCase("exit")) { // Read user input
                bw.write(line);
                bw.newLine(); // Move to next line
            }
            //print output
            System.out.println("User input successfully written to " + outputFile);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
