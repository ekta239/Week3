package doublylinkedlist.liberarymanagementsystem;

public class Main {
    
        public static void main(String[] args) {
            DoublyLinkedList bookList = new DoublyLinkedList();
    
            // Adding books
            bookList.addAtEnd("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 1, true);
            bookList.addAtEnd("1984", "George Orwell", "Dystopian", 2, true);
            bookList.addAtBeginning("To Kill a Mockingbird", "Harper Lee", "Fiction", 3, true);
            
            // Display all books
            System.out.println("Books in forward order:");
            bookList.displayForward();
    
            // Update a book's availability status
            bookList.updateAvailability(1, false);
            System.out.println("\nAfter updating availability of The Great Gatsby:");
            bookList.displayForward();
    
            // Search for books by title
            System.out.println("\nSearching for '1984':");
            bookList.searchByTitle("1984");
    
            // Search for books by author
            System.out.println("\nSearching for books by 'Harper Lee':");
            bookList.searchByAuthor("Harper Lee");
    
            // Remove a book
            bookList.removeByBookId(2);
            System.out.println("\nAfter removing book with ID 2:");
            bookList.displayForward();
    
            // Display all books in reverse order
            System.out.println("\nBooks in reverse order:");
            bookList.displayReverse();
    
            // Count total number of books
            System.out.println("\nTotal number of books in the library: " + bookList.countBooks());
        }
    }