package com.binarysearch.valuein2dmatrix;

public class MatrixSearch {

    // Function to perform binary search in a 2D matrix
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            // Convert mid to row and column
            int row = mid / cols;
            int col = mid % cols;

            // Compare the middle element with the target
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid + 1;  // Search the right half
            } else {
                right = mid - 1;  // Search the left half
            }
        }

        return false;  // Target not found
    }

    public static void main(String[] args) {
        // Test the function with an example matrix
        int[][] matrix = {
            {1, 4, 7, 11},
            {2, 5, 8, 12},
            {3, 6, 9, 16},
            {10, 13, 14, 17}
        };
        int target = 5;
        System.out.println("Target found: " + searchMatrix(matrix, target));  // Output should be true
    }
}
