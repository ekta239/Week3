package stacksqueues.sortstackusingrecursion;

public class MyStack {
Node head=null;

    public void push(int data) {
        if (head==null) {
            Node newNode=new Node(data);
            head=newNode;
        }
        else {
             Node newNode=new Node(data);
             newNode.next=head;
             head=newNode;
        }
    }
    public int pop() {
        int r=head.data;
        head=head.next;
        return r;
    }

    public int peek() {
        return head.data;
    }


    public boolean isempty() {
        if (head==null) {
            return true;
        }else {
            return false;
        }
    }

    public void display() {
        Node temp=head;
        while(temp!=null) {
            System.out.print(temp.data);
            temp=temp.next;
        }
        System.out.println();
    }
}