package countingsort.sortstudentage;

public class CountingSort {

    // Method to perform Counting Sort
    public static void countingSort(int[] ages) {
        // Define the range of ages
        int minAge = 10;
        int maxAge = 18;
        int range = maxAge - minAge + 1;

        // Create a count array to store the frequency of each age
        int[] count = new int[range];
        int[] output = new int[ages.length];

        // Count the occurrences of each age
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Compute cumulative frequencies
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        // Copy the sorted elements back to the original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    // Method to print the array
    public static void printArray(int[] ages) {
        for (int age : ages) {
            System.out.print(age + " ");
        }
        System.out.println();
    }

    // Main method to test the Counting Sort implementation
    public static void main(String[] args) {
        int[] studentAges = {15, 10, 12, 18, 17, 16, 15, 14, 13, 11};

        System.out.println("Original Student Ages:");
        printArray(studentAges);

        countingSort(studentAges);

        System.out.println("Sorted Student Ages:");
        printArray(studentAges);
    }
}