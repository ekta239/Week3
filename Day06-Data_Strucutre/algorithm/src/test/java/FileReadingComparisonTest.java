import org.junit.jupiter.api.Test;

import java.io.IOException;
import com.largefilereadefficiently.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileReadingComparisonTest {

    @Test
    public void testReadWithFileReader() throws IOException {
        String filePath = "com//file.txt"; // Provide a path to a small test file
        FileReadingComparison.readWithFileReader(filePath);
    }

    @Test
    public void testReadWithInputStreamReader() throws IOException {
        String filePath ="com//file.txt"; // Provide a path to a small test file
        FileReadingComparison.readWithInputStreamReader(filePath);
    }

    @Test
    public void testPerformance() {
        // This test will not assert anything, it's just to test the performance.
        FileReadingComparison.main(new String[0]);
    }
}
