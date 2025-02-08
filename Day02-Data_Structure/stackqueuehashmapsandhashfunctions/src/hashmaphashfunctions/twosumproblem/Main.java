package hashmapsandhashfunctions.twosumproblem;
// Main.java
public class Main {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = TwoSum.findTwoSum(nums, target);

        if (result.length == 2) {
            System.out.println("Indices of the two numbers that add up to " + target + ": " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No two sum solution found.");
        }
    }
}