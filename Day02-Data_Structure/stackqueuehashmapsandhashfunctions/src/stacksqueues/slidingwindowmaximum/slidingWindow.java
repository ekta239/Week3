package slidingwindowmaximum;

import java.util.Deque;
import java.util.LinkedList;

public class slidingWindow {
    
    public int[] SlidingWindow(int[] array,int k) {
        int[] result=new int[array.length-k+1];
        int a=0;
         Deque<Integer> deque = new LinkedList<>();
        int l=array.length;
        for (int i = 0; i < l; i++) {
            // Remove elements from the front if they are out of the window
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // Remove elements from the back if they are smaller than the current element
            while (!deque.isEmpty() && array[deque.peekLast()] < array[i]) {
                deque.pollLast();
            }

            // Add current element at the back
            deque.offer(i);

            // The front of the deque is the maximum for the window
            if (i >= k - 1) {
                result[i - k + 1] = array[deque.peek()];
            }
        }
    //     for (int i=0; i<array.length-k+1; i++) {
    //         for (int j=i; j<i+k; j++) {
    //             if (a<array[j]) {
    //                 a=array[j];
    //             } 
    //         }
    //     result[i]=a;
    //     a=0;
    // }
return result;
    }
}
