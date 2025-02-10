package com.largefilereadefficiently;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileReadingComparison {

    // Method to read using FileReader (Character Stream)
    public static void readWithFileReader(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        char[] buffer = new char[1024];
        while (fileReader.read(buffer) != -1) {
            // Do nothing with the data, just read it
        }
        fileReader.close();
    }

    // Method to read using InputStreamReader (Byte Stream)
    public static void readWithInputStreamReader(String filePath) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8);
        char[] buffer = new char[1024];
        while (inputStreamReader.read(buffer) != -1) {
            // Do nothing with the data, just read it
        }
        inputStreamReader.close();
    }

    // Helper method to measure time taken for file reading
    public static long measureFileReadingTime(Runnable method, String filePath) throws IOException {
        long startTime = System.nanoTime();
        method.run();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static void main(String[] args) {
        String filePath = "file.txt"; // Replace with your file path

        try {
            // File size 1MB
            System.out.println("Reading 1MB file:");
            long fileReaderTime1MB = measureFileReadingTime(() -> {
                try {
                    readWithFileReader(filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }, filePath);
            System.out.println("FileReader time: " + fileReaderTime1MB / 1000000.0 + " ms");

            long inputStreamReaderTime1MB = measureFileReadingTime(() -> {
                try {
                    readWithInputStreamReader(filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }, filePath);
            System.out.println("InputStreamReader time: " + inputStreamReaderTime1MB / 1000000.0 + " ms");

            // File size 100MB
            System.out.println("\nReading 100MB file:");
            long fileReaderTime100MB = measureFileReadingTime(() -> {
                try {
                    readWithFileReader(filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }, filePath);
            System.out.println("FileReader time: " + fileReaderTime100MB / 1000000.0 + " ms");

            long inputStreamReaderTime100MB = measureFileReadingTime(() -> {
                try {
                    readWithInputStreamReader(filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }, filePath);
            System.out.println("InputStreamReader time: " + inputStreamReaderTime100MB / 1000000.0 + " ms");

            // File size 500MB
            System.out.println("\nReading 500MB file:");
            long fileReaderTime500MB = measureFileReadingTime(() -> {
                try {
                    readWithFileReader(filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }, filePath);
            System.out.println("FileReader time: " + fileReaderTime500MB / 1000000.0 + " ms");

            long inputStreamReaderTime500MB = measureFileReadingTime(() -> {
                try {
                    readWithInputStreamReader(filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }, filePath);
            System.out.println("InputStreamReader time: " + inputStreamReaderTime500MB / 1000000.0 + " ms");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
