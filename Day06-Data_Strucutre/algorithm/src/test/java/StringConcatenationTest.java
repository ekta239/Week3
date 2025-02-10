import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.stringconcatinationperformance.*;

public class StringConcatenationTest {

    @Test
    public void testConcatenateWithString() {
        String result = StringConcatenation.concatenateWithString(100);
        assertTrue(result.length() > 0);
    }

    @Test
    public void testConcatenateWithStringBuilder() {
        String result = StringConcatenation.concatenateWithStringBuilder(100);
        assertTrue(result.length() > 0);
    }

    @Test
    public void testConcatenateWithStringBuffer() {
        String result = StringConcatenation.concatenateWithStringBuffer(100);
        assertTrue(result.length() > 0);
    }

    @Test
    public void testPerformance() {
        // This test will not assert anything, it's just to test the performance.
        StringConcatenation.main(new String[0]);
    }
}
