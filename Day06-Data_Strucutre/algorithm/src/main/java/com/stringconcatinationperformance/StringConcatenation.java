package com.stringconcatinationperformance;

public class StringConcatenation {

    // String concatenation using the + operator (inefficient)
    public static String concatenateWithString(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += "string" + i;  // Inefficient due to immutable nature of String
        }
        return result;
    }

    // String concatenation using StringBuilder (efficient, mutable)
    public static String concatenateWithStringBuilder(int n) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append("string").append(i);  // Efficient, mutable
        }
        return result.toString();
    }

    // String concatenation using StringBuffer (thread-safe, slightly slower than StringBuilder)
    public static String concatenateWithStringBuffer(int n) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < n; i++) {
            result.append("string").append(i);  // Thread-safe but slower than StringBuilder
        }
        return result.toString();
    }

    // Helper method to measure time
    public static long measureConcatenationTime(Runnable method, int n) {
        long startTime = System.nanoTime();
        method.run();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};

        for (int size : sizes) {
            System.out.println("Concatenating " + size + " strings:");

            // Measure time for String concatenation
            long stringTime = measureConcatenationTime(() -> concatenateWithString(size), size);
            System.out.println("String concatenation time: " + stringTime / 1000000.0 + " ms");

            // Measure time for StringBuilder concatenation
            long stringBuilderTime = measureConcatenationTime(() -> concatenateWithStringBuilder(size), size);
            System.out.println("StringBuilder concatenation time: " + stringBuilderTime / 1000000.0 + " ms");

            // Measure time for StringBuffer concatenation
            long stringBufferTime = measureConcatenationTime(() -> concatenateWithStringBuffer(size), size);
            System.out.println("StringBuffer concatenation time: " + stringBufferTime / 1000000.0 + " ms");

            System.out.println();
        }
    }
}
