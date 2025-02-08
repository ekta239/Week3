package hashmapsandhashfunctions.twosumproblem;
import java.util.HashMap;

class TwoSum {
    // Function to find two indices such that their values add up to the target
    public static int[] findTwoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if the complement exists in the map
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i }; // Return the indices
            }

            // Store the index of the current element
            numMap.put(nums[i], i);
        }

        // Return an empty array if no solution is found
        return new int[0];
    }
}