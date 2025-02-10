package com.searchtargetinlargedataset;
import java.util.Arrays;

public class SearchComparison {

    // Linear Search Implementation
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;  // Return the index if target is found
            }
        }
        return -1;  // Return -1 if target is not found
    }

    // Binary Search Implementation
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;  // Return the index if target is found
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;  // Return -1 if target is not found
    }

    // Helper method to measure time for Linear Search
    public static long measureLinearSearchTime(int[] arr, int target) {
        long startTime = System.nanoTime();
        linearSearch(arr, target);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // Helper method to measure time for Binary Search
    public static long measureBinarySearchTime(int[] arr, int target) {
        long startTime = System.nanoTime();
        binarySearch(arr, target);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static void main(String[] args) {
        // Dataset sizes for comparison
        int[] sizes = {1000, 10000, 1000000};
        int target = 12345;  // Example target to search

        for (int size : sizes) {
            // Create a large dataset
            int[] data = new int[size];
            for (int i = 0; i < size; i++) {
                data[i] = i;  // Populate the array with values from 0 to N-1
            }

            // Measure and print Linear Search Time
            long linearTime = measureLinearSearchTime(data, target);
            System.out.println("Dataset Size: " + size);
            System.out.println("Linear Search Time: " + linearTime / 1000000.0 + " ms");

            // Measure and print Binary Search Time
            Arrays.sort(data);  // Sort the array first for binary search
            long binaryTime = measureBinarySearchTime(data, target);
            System.out.println("Binary Search Time: " + binaryTime / 1000000.0 + " ms");
            System.out.println();
        }
    }
}
