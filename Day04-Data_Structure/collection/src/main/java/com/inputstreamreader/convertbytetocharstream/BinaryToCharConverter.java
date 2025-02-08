package com.inputstreamreader.convertbytetocharstream;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class BinaryToCharConverter {

    public static void main(String[] args) {
        String filename = "A:\\BridgeLab\\Week3\\byte.txt"; // Update file path

        String binaryString = readFileAsString(filename);
        if (binaryString != null) {
            String decodedText = binaryToText(binaryString);
            System.out.println("Decoded Text: " + decodedText);
        }
    }

    // Read the binary data from file as a string
    public static String readFileAsString(String filename) {
        try (InputStream inputStream = new FileInputStream(filename)) {
            byte[] bytes = inputStream.readAllBytes(); // Read all bytes
            return new String(bytes, StandardCharsets.UTF_8); // Convert bytes to string
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return null;
        }
    }

    // Convert binary string (like "01001001 00100000 01101100") to readable text
    public static String binaryToText(String binaryString) {
        String[] binaryArray = binaryString.split(" "); // Split by spaces
        StringBuilder text = new StringBuilder();

        for (String binary : binaryArray) {
            try {
                int charCode = Integer.parseInt(binary, 2); // Convert binary to int
                text.append((char) charCode); // Convert int to character
            } catch (NumberFormatException e) {
                System.err.println("Invalid binary data: " + binary);
            }
        }

        return text.toString();
    }
}