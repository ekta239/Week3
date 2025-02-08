package slidingwindowmaximum;

public class Main {
 public static void main(String[] args) {
    slidingWindow sw=new slidingWindow();
    int[] array={0,9,0,5,2,0,0,4};
    int[] result=sw.SlidingWindow(array, 2);
    for (int i=0; i<result.length; i++) {
        System.out.println(result[i]);
    }
 }   
}
