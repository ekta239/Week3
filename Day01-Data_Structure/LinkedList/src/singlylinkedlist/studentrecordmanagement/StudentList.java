package singlylinkedlist.sutdentrecordmanagement;

class StudentList {
    private Node head;

    // Add a new student record at the beginning
    public void addStudentAtBeginning(int rollNumber, String name, int age, String grade) {
        Node newNode = new Node(rollNumber, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    // Add a new student record at the end
    public void addStudentAtEnd(int rollNumber, String name, int age, String grade) {
        Node newNode = new Node(rollNumber, name, age, grade);
        if (head == null) {
            head = newNode;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }

    // Add a new student record at a specific position
    public void addStudentAtPosition(int position, int rollNumber, String name, int age, String grade) {
        if (position < 0) {
            System.out.println("Invalid position");
            return;
        }
        Node newNode = new Node(rollNumber, name, age, grade);
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current = head;
        for (int i = 0; i < position - 1; i++) {
            if (current == null) {
                System.out.println("Position out of bounds");
                return;
            }
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // Delete a student record by Roll Number
    public void deleteStudentByRollNumber(int rollNumber) {
        Node current = head;
        Node previous = null;
        while (current != null && current.rollNumber != rollNumber) {
            previous = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
            return;
        }
        if (previous == null) {
            head = current.next; // Deleting the head
        } else {
            previous.next = current.next; // Bypass the current node
        }
    }

    // Search for a student record by Roll Number
    public Node searchStudentByRollNumber(int rollNumber) {
        Node current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Display all student records
    public void displayStudents() {
        Node current = head;
        if (current == null) {
            System.out.println("No student records found.");
            return;
        }
        while (current != null) {
            System.out.println("Roll Number: " + current.rollNumber + ", Name: " + current.name + ", Age: " + current.age + ", Grade: " + current.grade);
            current = current.next;
        }
    }

    // Update a student's grade based on their Roll Number
    public void updateStudentGrade(int rollNumber, String newGrade) {
        Node student = searchStudentByRollNumber(rollNumber);
        if (student != null) {
            student.grade = newGrade;
            System.out.println("Updated grade for Roll Number " + rollNumber + " to " + newGrade);
        } else {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        }
    }
}