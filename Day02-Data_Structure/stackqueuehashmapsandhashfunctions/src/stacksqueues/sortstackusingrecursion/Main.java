package stacksqueues.sortstackusingrecursion;

public class Main {
    public static void main(String[] args) {
        MyStack St= new MyStack();
        sortStack ss=new sortStack();
        St.push(5);
        St.push(4);
        St.push(9);
        St.push(3);
        System.out.println("Stack befor sorting.");
        St.display();
        MyStack r=ss.sorting(St);
        System.out.println("stack after sorting.(in descending order.)");
        r.display();
    }
}
