package com.recursivevsiterativefibinaccai;

public class FibonacciComparison {

    // Recursive approach (O(2^n))
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative approach (O(N))
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    // Helper method to measure time for the function
    public static long measureTime(Runnable method) {
        long startTime = System.nanoTime();
        method.run();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static void main(String[] args) {
        int[] testValues = {10, 30, 50};  // Different values for Fibonacci

        for (int n : testValues) {
            System.out.println("Fibonacci(" + n + "):");

            // Recursive Fibonacci
            try {
                long recursiveTime = measureTime(() -> {
                    fibonacciRecursive(n);
                });
                System.out.println("Recursive time: " + recursiveTime / 1000000.0 + " ms");
            } catch (StackOverflowError e) {
                System.out.println("Recursive: Unfeasible (StackOverflowError)");
            }

            // Iterative Fibonacci
            long iterativeTime = measureTime(() -> {
                fibonacciIterative(n);
            });
            System.out.println("Iterative time: " + iterativeTime / 1000000.0 + " ms");

            System.out.println();
        }
    }
}
