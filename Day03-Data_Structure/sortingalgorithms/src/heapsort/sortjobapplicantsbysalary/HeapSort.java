package heapsort.sortjobapplicantsbysalary;

public class HeapSort {

    // Method to perform heap sort
    public static void heapSort(double[] salaries) {
        int n = salaries.length;

        // Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // One by one extract elements from the heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to the end
            double temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Call heapify on the reduced heap
            heapify(salaries, i, 0);
        }
    }

    // Method to heapify a subtree rooted with node i
    public static void heapify(double[] salaries, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            double swap = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(salaries, n, largest);
        }
    }

    // Method to print the array
    public static void printArray(double[] salaries) {
        for (double salary : salaries) {
            System.out.print(salary + " ");
        }
        System.out.println();
    }

    // Main method to test the Heap Sort implementation
    public static void main(String[] args) {
        double[] expectedSalaries = {60000, 75000, 50000, 90000, 80000};

        System.out.println("Original Expected Salaries:");
        printArray(expectedSalaries);

        heapSort(expectedSalaries);

        System.out.println("Sorted Expected Salaries:");
        printArray(expectedSalaries);
    }
}