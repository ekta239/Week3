import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.binarysearch.firstandlastoccourance.*;
import org.junit.jupiter.api.Test;

public class FirstAndLastOccurrenceTest {

    @Test
    public void testFindFirstAndLast() {
        // Test case 1: Normal case with multiple occurrences
        int[] arr1 = {1, 2, 2, 2, 3, 4, 5};
        int target1 = 2;
        int[] expected1 = {1, 3};
        assertArrayEquals(expected1, FirstAndLastOccurrence.findFirstAndLast(arr1, target1));  // Expected: [1, 3]

        // Test case 2: Target is found only once
        int[] arr2 = {1, 2, 3, 4, 5};
        int target2 = 3;
        int[] expected2 = {2, 2};
        assertArrayEquals(expected2, FirstAndLastOccurrence.findFirstAndLast(arr2, target2));  // Expected: [2, 2]

        // Test case 3: Target is not found in the array
        int[] arr3 = {1, 2, 3, 4, 5};
        int target3 = 6;
        int[] expected3 = {-1, -1};
        assertArrayEquals(expected3, FirstAndLastOccurrence.findFirstAndLast(arr3, target3));  // Expected: [-1, -1]

        // Test case 4: All elements in the array are the target
        int[] arr4 = {5, 5, 5, 5, 5};
        int target4 = 5;
        int[] expected4 = {0, 4};
        assertArrayEquals(expected4, FirstAndLastOccurrence.findFirstAndLast(arr4, target4));  // Expected: [0, 4]

        // Test case 5: Array with no repeated elements
        int[] arr5 = {1, 3, 5, 7, 9};
        int target5 = 7;
        int[] expected5 = {3, 3};
        assertArrayEquals(expected5, FirstAndLastOccurrence.findFirstAndLast(arr5, target5));  // Expected: [3, 3]
    }
}
