import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.binarysearch.valuein2dmatrix.*;
import org.junit.jupiter.api.Test;

public class MatrixSearchTest {

    @Test
    public void testSearchMatrix() {
        // Test case 1: Target is found in the matrix
        int[][] matrix1 = {
            {1, 4, 7, 11},
            {2, 5, 8, 12},
            {3, 6, 9, 16},
            {10, 13, 14, 17}
        };
        int target1 = 5;
        assertTrue(MatrixSearch.searchMatrix(matrix1, target1));  // Expected: true
        
        // Test case 2: Target is not found in the matrix
        int target2 = 20;
        assertFalse(MatrixSearch.searchMatrix(matrix1, target2));  // Expected: false
        
        // Test case 3: Target is at the start of the matrix
        int target3 = 1;
        assertTrue(MatrixSearch.searchMatrix(matrix1, target3));  // Expected: true
        
        // Test case 4: Target is at the end of the matrix
        int target4 = 17;
        assertTrue(MatrixSearch.searchMatrix(matrix1, target4));  // Expected: true
        
        // Test case 5: Empty matrix
        int[][] matrix2 = {};
        int target5 = 5;
        assertFalse(MatrixSearch.searchMatrix(matrix2, target5));  // Expected: false
    }
}
