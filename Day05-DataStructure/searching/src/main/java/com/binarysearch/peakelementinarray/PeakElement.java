package com.binarysearch.peakelementinarray;

public class PeakElement {

    // Function to find a peak element using Binary Search
    public static int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            // Check if mid is a peak element
            if ((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == arr.length - 1 || arr[mid] > arr[mid + 1])) {
                return arr[mid];  // Return the peak element
            }
            // If the left neighbor is greater, move towards the left half
            else if (mid > 0 && arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            }
            // If the right neighbor is greater, move towards the right half
            else {
                left = mid + 1;
            }
        }

        return -1; // This line should never be reached because there is always a peak in the array.
    }

    public static void main(String[] args) {
        // Test the function with an example array
        int[] arr = {1, 3, 20, 4, 1, 0};
        System.out.println("A peak element is: " + findPeakElement(arr));
    }
}
