package stacksqueues.sortstackusingrecursion;

public class sortStack {
    
    
    // public MyStack sorting(MyStack S) {
    //     MyStack result=new MyStack();
        
    //     while (!S.isempty()) {
    //         int temp=S.pop();
    //         while (!result.isempty() && temp<result.peek()) {
    //             S.push(result.pop());
    //         }
    //         result.push(temp);
    //     }
    //     return result;
    // }
    public MyStack sorting(MyStack S) {
        if (S.isempty()) {
            return new MyStack();
        }
        
        int temp = S.pop();
        MyStack sortedStack = sorting(S);
        
        insertInSortedOrder(sortedStack, temp);
        
        return sortedStack;
    }
    
    private void insertInSortedOrder(MyStack stack, int element) {
        if (stack.isempty() || element >= stack.peek()) {
            stack.push(element);
            return;
        }
        
        int temp = stack.pop();
        insertInSortedOrder(stack, element);
        stack.push(temp);
    }
    
}
