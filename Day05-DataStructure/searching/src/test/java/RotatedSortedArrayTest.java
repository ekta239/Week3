import static org.junit.jupiter.api.Assertions.assertEquals;
import com.binarysearch.rotationpoint.*;
import org.junit.jupiter.api.Test;

public class RotatedSortedArrayTest {

    @Test
    public void testFindRotationPoint() {
        // Test case 1: Normal rotated sorted array
        int[] arr1 = {6, 7, 9, 15, 19, 2, 3};
        assertEquals(2, RotatedSortedArray.findRotationPoint(arr1));
        
        // Test case 2: Array is not rotated
        int[] arr2 = {1, 2, 3, 4, 5};
        assertEquals(1, RotatedSortedArray.findRotationPoint(arr2));
        
        // Test case 3: Array with only one element
        int[] arr3 = {10};
        assertEquals(10, RotatedSortedArray.findRotationPoint(arr3));
        
        // Test case 4: Array rotated at the last element
        int[] arr4 = {30, 40, 50, 10, 20};
        assertEquals(10, RotatedSortedArray.findRotationPoint(arr4));
    }
}
