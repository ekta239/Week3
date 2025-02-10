import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import com.sortinglargedataefficiently.*;

public class SortingComparisonTest {

    @Test
    public void testBubbleSort() {
        int[] arr = {5, 2, 9, 1, 5, 6};
        int[] expected = {1, 2, 5, 5, 6, 9};
        
        SortingComparison.bubbleSort(arr);
        
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSort() {
        int[] arr = {5, 2, 9, 1, 5, 6};
        int[] expected = {1, 2, 5, 5, 6, 9};
        
        SortingComparison.mergeSort(arr);
        
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testQuickSort() {
        int[] arr = {5, 2, 9, 1, 5, 6};
        int[] expected = {1, 2, 5, 5, 6, 9};
        
        SortingComparison.quickSort(arr, 0, arr.length - 1);
        
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortingPerformance() {
        int[] data = new int[10000];
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 1000000);
        }

        // Measure performance for each algorithm
        long bubbleSortTime = SortingComparison.measureSortTime(() -> SortingComparison.bubbleSort(data.clone()), data);
        long mergeSortTime = SortingComparison.measureSortTime(() -> SortingComparison.mergeSort(data.clone()), data);
        long quickSortTime = SortingComparison.measureSortTime(() -> SortingComparison.quickSort(data.clone(), 0, data.length - 1), data);

        System.out.println("Bubble Sort Time: " + bubbleSortTime / 1000000.0 + " ms");
        System.out.println("Merge Sort Time: " + mergeSortTime / 1000000.0 + " ms");
        System.out.println("Quick Sort Time: " + quickSortTime / 1000000.0 + " ms");
    }
}
