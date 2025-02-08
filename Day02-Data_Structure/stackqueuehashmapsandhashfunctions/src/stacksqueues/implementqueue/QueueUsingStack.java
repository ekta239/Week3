package stacksqueues.implementqueue;

public class QueueUsingStack {
    MyStack S1=new MyStack();
    MyStack S2=new MyStack();




    public void enque(int data) {
        S1.push(data);
     }



    public void dequeue() {
        while(!S1.isempty()) {
       S2.push(S1.pop());
    }
    S2.pop();
    while (!S2.isempty()) {
        S1.push(S2.pop());        
    }}
    public void display(){
        S1.display();
    }

}
