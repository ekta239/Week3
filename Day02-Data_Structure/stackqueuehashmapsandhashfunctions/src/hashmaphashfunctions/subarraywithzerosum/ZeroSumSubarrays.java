package hashmapsandhashfunctions.subarraywithzerosum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZeroSumSubarrays {
    // Function to find all subarrays with zero sum
    public static List<int[]> findSubarraysWithZeroSum(int[] arr) {
        HashMap<Integer, List<Integer>> sumMap = new HashMap<>();
        List<int[]> result = new ArrayList<>();
        int cumulativeSum = 0;

        // Initialize the map with the cumulative sum of 0 at index -1
        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1); // This helps to handle the case when the sum is zero from the start

        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];

            // If the cumulative sum has been seen before, there are subarrays with zero sum
            if (sumMap.containsKey(cumulativeSum)) {
                List<Integer> indices = sumMap.get(cumulativeSum);
                for (int index : indices) {
                    result.add(new int[]{index + 1, i}); // Store the start and end indices of the subarray
                }
            }

            // Add the current index to the list of indices for this cumulative sum
            sumMap.putIfAbsent(cumulativeSum, new ArrayList<>());
            sumMap.get(cumulativeSum).add(i);
        }

        return result;
    }
}
