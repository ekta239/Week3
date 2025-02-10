import static org.junit.jupiter.api.Assertions.assertEquals;
import com.linearsearch.firstnegative.*;
import org.junit.jupiter.api.Test;

public class FirstNegativeNumberTest {

    @Test
    public void testFindFirstNegativeNumber() {
        // Test case 1: Normal array with a negative number
        int[] arr1 = {1, 2, 3, -4, 5, 6};
        
        // Test case 2: Array with no negative number
        int[] arr2 = {1, 2, 3, 4, 5, 6};
        assertEquals(-1, FirstNegativeNumber.findFirstNegativeNumber(arr2));  // No negative number
        
        // Test case 3: Array with the first element being negative
        int[] arr3 = {-1, 2, 3, 4, 5, 6};
        assertEquals(0, FirstNegativeNumber.findFirstNegativeNumber(arr3));  // First element is negative
        
        // Test case 4: Array with only one negative number
        int[] arr4 = {5, 3, -2};
        assertEquals(2, FirstNegativeNumber.findFirstNegativeNumber(arr4));  // Index of -2
    }
}
