import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import com.challangeproblem.*;
import org.junit.jupiter.api.Test;

public class MissingPositiveAndTargetIndexTest {

    @Test
    public void testFindFirstMissingPositive() {
        // Test case 1: Normal case with missing positive integer
        int[] nums1 = {3, 4, -1, 1};
        assertEquals(2, MissingPositiveAndTargetIndex.findFirstMissingPositive(nums1));  // Expected: 2

        // Test case 2: Case with negative numbers and zero
        int[] nums2 = {-1, -2, -3};
        assertEquals(1, MissingPositiveAndTargetIndex.findFirstMissingPositive(nums2));  // Expected: 1

        // Test case 3: Case with all positive numbers starting from 1
        int[] nums3 = {1, 2, 3};
        assertEquals(4, MissingPositiveAndTargetIndex.findFirstMissingPositive(nums3));  // Expected: 4

        // Test case 4: Case with no missing positive number
        int[] nums4 = {1, 2, 3, 4};
        assertEquals(5, MissingPositiveAndTargetIndex.findFirstMissingPositive(nums4));  // Expected: 5

        // Test case 5: Case with an empty array
        int[] nums5 = {};
        assertEquals(1, MissingPositiveAndTargetIndex.findFirstMissingPositive(nums5));  // Expected: 1
    }

    @Test
    public void testBinarySearch() {
        // Test case 1: Normal case with target found in the array
        int[] nums1 = {1, 3, 4, 7, 9};
        int target1 = 7;
        assertEquals(3, MissingPositiveAndTargetIndex.binarySearch(nums1, target1));  // Expected: 3

        // Test case 2: Target not found in the array
        int target2 = 5;
        assertEquals(-1, MissingPositiveAndTargetIndex.binarySearch(nums1, target2));  // Expected: -1

        // Test case 3: Target is the first element in the array
        int[] nums2 = {1, 3, 5, 6};
        int target3 = 1;
        assertEquals(0, MissingPositiveAndTargetIndex.binarySearch(nums2, target3));  // Expected: 0

        // Test case 4: Target is the last element in the array
        int target4 = 6;
        assertEquals(3, MissingPositiveAndTargetIndex.binarySearch(nums2, target4));  // Expected: 3
    }
}
