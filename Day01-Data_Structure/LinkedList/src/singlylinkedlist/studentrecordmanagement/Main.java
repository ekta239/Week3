package singlylinkedlist.sutdentrecordmanagement;

public class Main {
          public static void main(String[] args) {
            StudentList studentList = new StudentList();
    
            // Adding students
            studentList.addStudentAtEnd(1, "Alice", 20, "A");
            studentList.addStudentAtEnd(2, "Bob", 21, "B");
            studentList.addStudentAtBeginning(3, "Charlie", 19, "A+");
            studentList.addStudentAtPosition(1, 4, "David", 22, "B+");
    
            // Displaying all students
            System.out.println("All Student Records:");
            studentList.displayStudents();
    
            // Searching for a student
            Node student = studentList.searchStudentByRollNumber(2);
            if (student != null) {
                System.out.println("Found Student: Roll Number: " + student.rollNumber + ", Name: " + student.name);
            } else {
                System.out.println("Student not found.");
            }
    
            // Updating a student's grade
            studentList.updateStudentGrade(1, "A+");
    
            // Deleting a student record
            studentList.deleteStudentByRollNumber(3);
    
            // Displaying all students after deletion
            System.out.println("Student Records after deletion:");
            studentList.displayStudents();
        }
    }