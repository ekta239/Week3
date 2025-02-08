package com.challangeproblem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PerformanceComparison {

    public static void main(String[] args) throws IOException {

        // StringBuilder and StringBuffer comparison
        String stringToConcatenate = "hello";
        int numIterations = 1_000_000;

        long startTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numIterations; i++) {
            stringBuilder.append(stringToConcatenate);
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuilder time: " + (endTime - startTime) / 1e6 + " ms");

        startTime = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < numIterations; i++) {
            stringBuffer.append(stringToConcatenate);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer time: " + (endTime - startTime) / 1e6 + " ms");

        // FileReader comparison (works for external files)
        String largeFilePath = "user_input.txt"; // Ensure the file exists

        startTime = System.nanoTime();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(largeFilePath))) {
            int wordCount = 0;
            String line;
            while ((line = fileReader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
            System.out.println("FileReader word count: " + wordCount);
        }
        endTime = System.nanoTime();
        System.out.println("FileReader time: " + (endTime - startTime) / 1e6 + " ms");

        // InputStreamReader comparison (works for classpath resources)
        long startTimeis = System.nanoTime();

        InputStream resourceStream = PerformanceComparison.class.getClassLoader().getResourceAsStream(largeFilePath);
        if (resourceStream == null) {
            System.err.println("Error: Resource not found - " + largeFilePath);
        } else {
            try (InputStreamReader streamReader = new InputStreamReader(resourceStream);
                 BufferedReader inputStreamReader = new BufferedReader(streamReader)) {

                int wordCount = 0;
                String line;
                while ((line = inputStreamReader.readLine()) != null) {
                    wordCount += line.split("\\s+").length;
                }
                System.out.println("InputStreamReader word count: " + wordCount);
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
            }
        }

        long endTimeis = System.nanoTime();
        System.out.println("InputStreamReader time: " + (endTimeis - startTimeis) / 1e6 + " ms");
    }
}
