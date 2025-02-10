import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static java.lang.System.*;
import static java.util.Collection.*;
import com.searchtargetinlargedataset.*;
public class Searchcomp {
    @Test
    void searchComparison(){
        SearchComparison sc=new SearchComparison();
        int [] arr={1000,2000,10000,5000,100000,50000,20000};
        assertNotEquals(sc.measureBinarySearchTime(arr, 500), sc.measureBinarySearchTime(arr, 500));
    }
    
}
