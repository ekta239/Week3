import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import com.linearsearch.wordinlistofsentance.*;

public class SearchForWordTest {

    @Test
    public void testFindSentenceWithWord() {
        // Test case 1: Word found in the second sentence
        String[] sentences1 = {
            "The quick brown fox jumps over the lazy dog.",
            "I love programming in Java.",
            "This is a sample sentence."
        };
        assertEquals("I love programming in Java.", SearchForWord.findSentenceWithWord(sentences1, "Java"));
        
        // Test case 2: Word not found in any sentence
        String[] sentences2 = {
            "The quick brown fox jumps over the lazy dog.",
            "I love programming in Python.",
            "This is a sample sentence."
        };
        assertEquals("Not Found", SearchForWord.findSentenceWithWord(sentences2, "Java"));
        
        // Test case 3: Word found in the first sentence
        String[] sentences3 = {
            "This is the best sentence with Java in it.",
            "The quick brown fox jumps over the lazy dog.",
            "I love programming."
        };
        assertEquals("This is the best sentence with Java in it.", SearchForWord.findSentenceWithWord(sentences3, "Java"));
        
        // Test case 4: Word not found, empty array
        String[] sentences4 = {};
        assertEquals("Not Found", SearchForWord.findSentenceWithWord(sentences4, "Java"));
    }
}
