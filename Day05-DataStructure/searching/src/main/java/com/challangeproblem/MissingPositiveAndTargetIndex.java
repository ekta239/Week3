package com.challangeproblem;
import java.util.Arrays;

public class MissingPositiveAndTargetIndex {

    // Function to find the first missing positive integer
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;

        // Mark each number nums[i] as visited by putting it in the range [1, n]
        for (int i = 0; i < n; i++) {
            // If nums[i] is in the valid range [1, n] and nums[i] is not at the correct position
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] and nums[nums[i] - 1]
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            }
        }

        // Traverse the array to find the first missing positive integer
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // If no missing number is found, return n + 1
        return n + 1;
    }

    // Function to perform binary search to find the index of the target number
    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;  // Target found, return the index
            } else if (nums[mid] < target) {
                left = mid + 1;  // Search the right half
            } else {
                right = mid - 1;  // Search the left half
            }
        }

        return -1;  // Target not found
    }

    // Main function to demonstrate both functionalities
    public static void main(String[] args) {
        // Example array for finding the first missing positive
        int[] nums = {3, 4, -1, 1};
        System.out.println("First Missing Positive: " + findFirstMissingPositive(nums));  // Expected: 2

        // Example array for finding the target index using binary search
        Arrays.sort(nums);  // Sort the array first before applying binary search
        int target = 4;
        System.out.println("Index of " + target + ": " + binarySearch(nums, target));  // Expected: 2 (since sorted array: [-1, 1, 3, 4])
    }
}

