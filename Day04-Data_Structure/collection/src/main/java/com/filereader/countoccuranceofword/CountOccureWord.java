package com.filereader.countoccuranceofword;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountOccureWord {
    public static void main(String[] args) {
        // Specify the file path and the word to search for
        String filename = "A:\\BridgeLab\\Week3\\textfile.txt"; 
        String targetWord = "hello";     // The word you want to count

        // Call the method to count occurrences of the word in the file
        int count = countWordOccurrences(filename, targetWord);

        // Output the result
        System.out.println("The word '" + targetWord + "' appears " + count + " times in the file.");
    }

    // Method to count occurrences of a word in a file
    public static int countWordOccurrences(String filename, String targetWord) {
        int count = 0;
        BufferedReader reader = null;

        try {
            // Create a FileReader to read the file
            FileReader fileReader = new FileReader(filename);

            // Wrap the FileReader in a BufferedReader for efficient reading
            reader = new BufferedReader(fileReader);

            // Read the file line by line
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into words
                String[] words = line.split("\\s+");

                // Loop through the words and count occurrences of the target word
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        } finally {
            // Close the BufferedReader to release resources
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing the file: " + e.getMessage());
            }
        }

        return count;
    }
}