import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.recursivevsiterativefibinaccai.*;

public class FibonacciComparisonTest {

    @Test
    public void testFibonacciRecursive() {
        assertEquals(55, FibonacciComparison.fibonacciRecursive(10));
        assertEquals(832040, FibonacciComparison.fibonacciRecursive(30));
    }

    @Test
    public void testFibonacciIterative() {
        assertEquals(55, FibonacciComparison.fibonacciIterative(10));
        assertEquals(832040, FibonacciComparison.fibonacciIterative(30));
    }

    @Test
    public void testPerformance() {
        // This test will not assert anything, it's just to test the performance.
        FibonacciComparison.main(new String[0]);
    }
}
