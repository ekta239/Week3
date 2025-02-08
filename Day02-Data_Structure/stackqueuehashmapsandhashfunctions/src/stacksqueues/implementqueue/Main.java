package stacksqueues.implementqueue;

public class Main {
    public static void main(String[] args) {
        
    
    QueueUsingStack q= new QueueUsingStack();
    q.enque(1);
    q.enque(2);
    q.enque(3);
    q.enque(4);
    q.display();
    q.dequeue();
    q.display();
    q.dequeue();
    q.display();
}
}
