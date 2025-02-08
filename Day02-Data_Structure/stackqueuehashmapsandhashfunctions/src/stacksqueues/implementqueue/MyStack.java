package stacksqueues.implementqueue;

public class MyStack {

 Node head=null;
    public void push(int data) {
        if (head==null) {
            head=new Node(data);
        }
        else {
            Node newNode=new Node(data);
            newNode.next=head;
            head=newNode;
        }
    }

    public int pop() {
        if (head==null){
            return 0;
        }else {
        int r=head.data;
        head=head.next;
        return r;
    }}
    public boolean isempty() {
        if (head==null) {
            return true;
        }else {
            return false;
        }
     }

     public void display() {
        Node temp=head;
        while (temp!=null){
        System.out.print(temp.data);
        temp=temp.next;
    }
    System.out.println("\n-------------------------------------");
}
}
