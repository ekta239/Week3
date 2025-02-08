package singlylinkedlist.sutdentrecordmanagement;
class Node {
    int rollNumber;
    String name;
    int age;
    String grade;
    Node next;

    public Node(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}