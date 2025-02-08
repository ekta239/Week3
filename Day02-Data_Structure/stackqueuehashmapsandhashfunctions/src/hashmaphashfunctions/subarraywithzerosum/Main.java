package hashmapsandhashfunctions.subarraywithzerosum;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 1, 2, -4, 2, -1};
        List<int[]> zeroSumSubarrays = ZeroSumSubarrays.findSubarraysWithZeroSum(arr);

        // Print the results
        System.out.println("Subarrays with zero sum:");
        for (int[] subarray : zeroSumSubarrays) {
            System.out.println("Start: " + subarray[0] + ", End: " + subarray[1]);
        }
    }
}