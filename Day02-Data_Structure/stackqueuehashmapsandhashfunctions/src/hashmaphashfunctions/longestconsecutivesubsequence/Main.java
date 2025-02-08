package hashmapsandhashfunctions.longestconsecutivesubsequence;

public class Main {
    public static void main(String[] args) {
        // Example usage: Find the length of the longest consecutive elements sequence in the given array.
        int[] nums = {100, 4, 200, 1, 3, 2};
        int longestSequenceLength = LongestConsecutiveSequence.longestConsecutive(nums);
        
        System.out.println("Length of the longest consecutive elements sequence: " + longestSequenceLength);
    }
}