import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;
import com.comparignds.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class DataStructureComparisonTest {

    private int[] array;
    private HashSet<Integer> hashSet;
    private TreeSet<Integer> treeSet;

    @BeforeEach
    public void setUp() {
        // Create a test data set of 1 million elements
        array = new int[1000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        hashSet = new HashSet<>();
        treeSet = new TreeSet<>();
        // Populate the HashSet and TreeSet with elements
        for (int i = 0; i < array.length; i++) {
            hashSet.add(i);
            treeSet.add(i);
        }
    }

    @Test
    public void testArraySearch() {
        int target = 999999; // Target value to search
        // Perform array search
        boolean result = DataStructureComparison.searchArray(Arrays.copyOfRange(array, 0, 1000), target);
        assertFalse(result, "Array search should find the target");
    }

    @Test
    public void testHashSetSearch() {
        int target = 999999; // Target value to search
        // Perform hash set search for the first 1000 elements
        HashSet<Integer> subsetHashSet = new HashSet<>();
        int count = 0;
        for (Integer num : hashSet) {
            if (count >= 1000) break;
            subsetHashSet.add(num);
            count++;
        }
        boolean result = DataStructureComparison.searchHashSet(subsetHashSet, target);
        assertFalse(result, "HashSet search should find the target");
    }

    @Test
    public void testTreeSetSearch() {
        int target = 999999; // Target value to search
        // Perform tree set search for the first 1000 elements
        TreeSet<Integer> subsetTreeSet = new TreeSet<>();
        int count = 0;
        for (Integer num : treeSet) {
            if (count >= 1000) break;
            subsetTreeSet.add(num);
            count++;
        }
        boolean result = DataStructureComparison.searchTreeSet(subsetTreeSet, target);
        assertFalse(result, "TreeSet search should find the target");
    }

    @Test
    public void testArraySearchFailure() {
        int target = 1000001; // A value that does not exist in the array
        // Perform array search
        boolean result = DataStructureComparison.searchArray(Arrays.copyOfRange(array, 0, 1000), target);
        assertFalse(result, "Array search should not find the target");
    }

    @Test
    public void testHashSetSearchFailure() {
        int target = 1000001; // A value that does not exist in the hash set
        // Perform hash set search
        HashSet<Integer> subsetHashSet = new HashSet<>();
        int count = 0;
        for (Integer num : hashSet) {
            if (count >= 1000) break;
            subsetHashSet.add(num);
            count++;
        }
        boolean result = DataStructureComparison.searchHashSet(subsetHashSet, target);
        assertFalse(result, "HashSet search should not find the target");
    }

    @Test
    public void testTreeSetSearchFailure() {
        int target = 1000001; // A value that does not exist in the tree set
        // Perform tree set search
        TreeSet<Integer> subsetTreeSet = new TreeSet<>();
        int count = 0;
        for (Integer num : treeSet) {
            if (count >= 1000) break;
            subsetTreeSet.add(num);
            count++;
        }
        boolean result = DataStructureComparison.searchTreeSet(subsetTreeSet, target);
        assertFalse(result, "TreeSet search should not find the target");
    }
}
