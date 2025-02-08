package stacksqueues.stockspanproblem;

import java.util.Stack;

public class stockSpan {
    
    public int[] Spancalculate(int[] arr) {

          
       int l = arr.length;
       int[] span=new int[l];
       MyStack s=new MyStack();
       for (int i=0; i<l; i++) {
        while (!s.isempty() && arr[s.peek()]<=arr[i]) {
            s.pop();
        }
        if (s.isempty()) {
            span[i]=i+1;
        }
        else {
        span[i] = i-s.peek();

        }
       s.push(i);
}
       return span;


// int l=arr.length;
// int[] result = new int[l];
// result[0]=1;
// for (int i=1; i<l; i++) {
//     if (arr[i] < arr[i-1]) {
//         result[i]=1;
//     }
//     else {
//         for(int j=1; j<=i+1; j++) {
//             if (arr[j]<=arr[i]) {
//                 result[i]++;
//             }
//         }
//     }
// }
// return result;
// int n = arr.length;
//         int[] result = new int[n];
//         Stack<Integer> stack = new Stack<>();

//         // First day always has a result of 1
//         result[0] = 1;
//         stack.push(0); // Push index of first element

//         for (int i = 1; i < n; i++) {
//             // Pop indices where the price is less than or equal to current price
//             while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
//                 stack.pop();
//             }

//             // If stack is empty, all previous arr were smaller, so result = i + 1
//             result[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());

//             // Push current index onto stack
//             stack.push(i);
//         }
//         return result;    

// }
}
}
