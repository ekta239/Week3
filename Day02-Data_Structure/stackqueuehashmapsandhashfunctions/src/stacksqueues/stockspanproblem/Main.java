package stacksqueues.stockspanproblem;

public class Main {
    public static void main(String[] args) {
        stockSpan sp=new stockSpan();
        int[] arr={100,80,60,70,60,75,85};
        int[] result=sp.Spancalculate(arr);

        System.out.println("Input array: ");
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("\nSpan array: ");
        for (int i=0;i<result.length; i++) {
            System.out.print(result[i]+" ");
        }
    }
}
