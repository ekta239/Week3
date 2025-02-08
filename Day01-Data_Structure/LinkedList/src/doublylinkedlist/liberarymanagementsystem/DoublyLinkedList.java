package doublylinkedlist.liberarymanagementsystem;

class DoublyLinkedList {
    private Book head;
    private Book tail;
    private int count;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    // Add a book at the beginning
    public void addAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        count++;
    }

    // Add a book at the end
    public void addAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        count++;
    }

    // Add a book at a specific position
    public void addAtPosition(int position, String title, String author, String genre, int bookId, boolean isAvailable) {
        if (position <= 0) {
            addAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }

        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        Book current = head;
        int index = 0;

        while (current != null && index < position) {
            current = current.next;
            index++;
        }

        if (current == null) {
            addAtEnd(title, author, genre, bookId, isAvailable);
        } else {
            newBook.prev = current.prev;
            newBook.next = current;
            if (current.prev != null) {
                current.prev.next = newBook;
            }
            current.prev = newBook;
            if (current == head) {
                head = newBook;
            }
            count++;
        }
    }

    // Remove a book by Book ID
    public void removeByBookId(int bookId) {
        Book current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next; // Update head if needed
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev; // Update tail if needed
                }
                count--;
                return;
            }
            current = current.next;
        }
    }

    // Search for a book by title
    public void searchByTitle(String title) {
        Book current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                System.out.println("Found: " + current.title + " by " + current.author + " - Genre: " + current.genre + " - ID: " + current.bookId + " - Available: " + current.isAvailable);
            }
            current = current.next;
        }
    }

    // Search for a book by author
    public void searchByAuthor(String author) {
        Book current = head;
        while (current != null) {
            if (current.author.equalsIgnoreCase(author)) {
                System.out.println("Found: " + current.title + " by " + current.author + " - Genre: " + current.genre + " - ID: " + current.bookId + " - Available: " + current.isAvailable);
            }
            current = current.next;
        }
    }

 // Update a book's availability status
    public void updateAvailability(int bookId, boolean isAvailable) {
        Book current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                current.isAvailable = isAvailable;
                return;
            }
            current = current.next;
        }
    }

    // Display all books in forward order
    public void displayForward() {
        Book current = head;
        while (current != null) {
            System.out.println(current.title + " by " + current.author + " - Genre: " + current.genre + " - ID: " + current.bookId + " - Available: " + current.isAvailable);
            current = current.next;
        }
    }

    // Display all books in reverse order
    public void displayReverse() {
        Book current = tail;
        while (current != null) {
            System.out.println(current.title + " by " + current.author + " - Genre: " + current.genre + " - ID: " + current.bookId + " - Available: " + current.isAvailable);
            current = current.prev;
        }
    }

    // Count the total number of books
    public int countBooks() {
        return count;
    }
}