package hashmapsandhashfunctions.pairwithgivensuminarray;

import java.util.HashSet;

public class PairWithGivenSum {
    // Function to check if there exists a pair with the given sum
    public static boolean hasPairWithSum(int[] arr, int target) {
        HashSet<Integer> visitedNumbers = new HashSet<>();

        for (int number : arr) {
            int complement = target - number;

            // Check if the complement exists in the set
            if (visitedNumbers.contains(complement)) {
                return true; // Pair found
            }

            // Add the current number to the set
            visitedNumbers.add(number);
        }

        return false; // No pair found
    }
}