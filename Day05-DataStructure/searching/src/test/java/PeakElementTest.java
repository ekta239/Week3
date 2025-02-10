import static org.junit.jupiter.api.Assertions.assertTrue;
import com.binarysearch.peakelementinarray.*;
import org.junit.jupiter.api.Test;

public class PeakElementTest {

    @Test
    public void testFindPeakElement() {
        // Test case 1: Normal array with a peak element in the middle
        int[] arr1 = {1, 3, 20, 4, 1, 0};
        int peak = PeakElement.findPeakElement(arr1);
        assertTrue(peak == 20 || peak == 4);  // The peak could be either 20 or 4

        // Test case 2: Array with all elements increasing
        int[] arr2 = {1, 2, 3, 4, 5};
        int peak2 = PeakElement.findPeakElement(arr2);
        assertTrue(peak2 == 5);  // The peak is at the end of the array

        // Test case 3: Array with all elements decreasing
        int[] arr3 = {5, 4, 3, 2, 1};
        int peak3 = PeakElement.findPeakElement(arr3);
        assertTrue(peak3 == 5);  // The peak is at the beginning of the array

        // Test case 4: Array with one element
        int[] arr4 = {10};
        int peak4 = PeakElement.findPeakElement(arr4);
        assertTrue(peak4 == 10);  // The peak is the only element

        // Test case 5: Array with multiple peaks
        int[] arr5 = {1, 3, 2, 5, 10, 6, 7};
        int peak5 = PeakElement.findPeakElement(arr5);
        assertTrue(peak5 == 3 || peak5 == 10 || peak5 == 7);  // There are multiple peaks
    }
}
