package hashmapsandhashfunctions.pairwithgivensuminarray;

public class Main {
    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7};
        int target = 17;

        boolean result = PairWithGivenSum.hasPairWithSum(arr, target);

        if (result) {
            System.out.println("There exists a pair with the given sum.");
        } else {
            System.out.println("No pair exists with the given sum.");
        }
    }
}