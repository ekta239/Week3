package com.binarysearch.firstandlastoccourance;

public class FirstAndLastOccurrence {

    // Function to find the first occurrence of the target element
    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;  // Found a match, but keep searching on the left side
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    // Function to find the last occurrence of the target element
    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;  // Found a match, but keep searching on the right side
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    // Function to find both the first and last occurrence of the target element
    public static int[] findFirstAndLast(int[] arr, int target) {
        int[] result = new int[2];
        result[0] = findFirstOccurrence(arr, target);  // First occurrence
        result[1] = findLastOccurrence(arr, target);   // Last occurrence
        return result;
    }

    public static void main(String[] args) {
        // Test the function with an example array
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;
        int[] result = findFirstAndLast(arr, target);
        System.out.println("First occurrence: " + result[0] + ", Last occurrence: " + result[1]);
    }
}
