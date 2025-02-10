package com.linearsearch.firstnegative;

public class FirstNegativeNumber {

    // Function to find the first negative number in the array
    public static int findFirstNegativeNumber(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;  // Return the index of the first negative number
            }
        }
        return -1;  // Return -1 if no negative number is found
    }

    public static void main(String[] args) {
        // Test the function with an example array
        int[] arr = {1, 2, 3, -4, 5, 6};
        System.out.println("Index of first negative number is: " + findFirstNegativeNumber(arr));
    }
}
