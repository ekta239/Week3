package doublylinkedlist.moviemanagementsystem;

class DoublyLinkedList {
    private Movie head;
    private Movie tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Add a movie at the beginning
    public void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add a movie at the end
    public void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add a movie at a specific position
    public void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position <= 0) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        Movie newMovie = new Movie(title, director, year, rating);
        Movie current = head;
        int index = 0;

        while (current != null && index < position) {
            current = current.next;
            index++;
        }

        if (current == null) {
            addAtEnd(title, director, year, rating);
        } else {
            newMovie.prev = current.prev;
            newMovie.next = current;
            if (current.prev != null) {
                current.prev.next = newMovie;
            }
            current.prev = newMovie;
            if (current == head) {
                head = newMovie;
            }
        }
    }

    // Remove a movie by title
    public void removeByTitle(String title) {
        Movie current = head;
        while (current != null) {
            if (current.title.equals(title)) {
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
                return;
            }
            current = current.next;
        }
    }

    // Search for movies by director
    public void searchByDirector(String director) {
        Movie current = head;
        while (current != null) {
            if (current.director.equals(director)) {
                System.out.println(current.title + " (" + current.year + ") - Rating: " + current.rating);
            }
            current = current.next;
        }
    }

    // Search for movies by rating
    public void searchByRating(double rating) {
        Movie current = head;
        while (current != null) {
            if (current.rating == rating) {
                System.out.println(current.title + " (" + current.year + ") - Director: " + current.director);
            }
            current = current.next;
        }
    }

    // Display all movies in forward order
    public void displayForward() {
        Movie current = head;
        while (current != null) {
            System.out.println(current.title + " (" + current.year + ") - Director: " + current.director + " - Rating: " + current.rating);
            current = current.next;
        }
    }

    // Display all movies in reverse order
    public void displayReverse() {
        Movie current = tail;
        while (current != null) {
            System.out.println(current.title + " (" + current.year + ") - Director: " + current.director + " - Rating: " + current.rating);
            current = current.prev;
 }
    }

    // Update a movie's rating by title
    public void updateRating(String title, double newRating) {
        Movie current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                current.rating = newRating;
                return;
            }
            current = current.next;
        }
    }
}