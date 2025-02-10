package com.binarysearch.rotationpoint;

public class RotatedSortedArray {

    // Function to find the rotation point
    public static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            int mid = (left + right) / 2;
            
            // If the middle element is greater than the rightmost element, the rotation point is in the right half
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            }
            // If the middle element is less than the rightmost element, the rotation point is in the left half
            else {
                right = mid;
            }
        }
        
        // At the end, left == right, which will be the index of the smallest element
        return arr[left];
    }

    public static void main(String[] args) {
        // Test the function with an example rotated sorted array
        int[] arr = {6, 7, 9, 15, 19, 2, 3};
        System.out.println("Rotation point is: " + findRotationPoint(arr));
    }
}
