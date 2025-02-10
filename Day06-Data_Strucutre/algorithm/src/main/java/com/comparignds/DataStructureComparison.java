package com.comparignds;
import java.util.*;

public class DataStructureComparison {

    // Method to search in an Array (O(N))
    public static boolean searchArray(int[] array, int target) {
        for (int num : array) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    // Method to search in a HashSet (O(1) on average)
    public static boolean searchHashSet(HashSet<Integer> set, int target) {
        return set.contains(target);
    }

    // Method to search in a TreeSet (O(log N))
    public static boolean searchTreeSet(TreeSet<Integer> set, int target) {
        return set.contains(target);
    }

    // Helper method to measure time for a method
    public static long measureTime(Runnable method) {
        long startTime = System.nanoTime();
        method.run();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static void main(String[] args) {
        // Create test data sets of different sizes
        int[] array = new int[1000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        // Populate the HashSet and TreeSet with elements
        for (int i = 0; i < array.length; i++) {
            hashSet.add(i);
            treeSet.add(i);
        }

        int target = 999999; // Target value to search

        int[] testValues = {1000, 100000, 1000000}; // Different dataset sizes

        for (int n : testValues) {
            System.out.println("Searching in dataset of size: " + n);

            // Array Search
            long arraySearchTime = measureTime(() -> {
                searchArray(Arrays.copyOfRange(array, 0, n), target);
            });
            System.out.println("Array search time: " + arraySearchTime / 1000000.0 + " ms");

            // HashSet Search (only considering the first 'n' elements for the test)
            long hashSetSearchTime = measureTime(() -> {
                HashSet<Integer> subsetHashSet = new HashSet<>();
                // Add the first 'n' elements from hashSet to the subset
                int count = 0;
                for (Integer num : hashSet) {
                    if (count >= n) break;
                    subsetHashSet.add(num);
                    count++;
                }
                searchHashSet(subsetHashSet, target);
            });
            System.out.println("HashSet search time: " + hashSetSearchTime / 1000000.0 + " ms");

            // TreeSet Search (only considering the first 'n' elements for the test)
            long treeSetSearchTime = measureTime(() -> {
                TreeSet<Integer> subsetTreeSet = new TreeSet<>();
                // Add the first 'n' elements from treeSet to the subset
                int count = 0;
                for (Integer num : treeSet) {
                    if (count >= n) break;
                    subsetTreeSet.add(num);
                    count++;
                }
                searchTreeSet(subsetTreeSet, target);
            });
            System.out.println("TreeSet search time: " + treeSetSearchTime / 1000000.0 + " ms");

            System.out.println();
        }
    }
}
