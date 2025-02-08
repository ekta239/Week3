package doublylinkedlist.moviemanagementsystem;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList movieList = new DoublyLinkedList();

        // Adding movies
        movieList.addAtEnd("Inception", "Christopher Nolan", 2010, 8.8);
        movieList.addAtEnd("The Godfather", "Francis Ford Coppola", 1972, 9.2);
        movieList.addAtBeginning("The Dark Knight", "Christopher Nolan", 2008, 9.0);
        
        // Display all movies
        System.out.println("Movies in forward order:");
        movieList.displayForward();

        // Update a movie's rating
        movieList.updateRating("Inception", 9.0);
        System.out.println("\nAfter updating Inception's rating:");
        movieList.displayForward();

        // Search for movies by director
        System.out.println("\nMovies directed by Christopher Nolan:");
        movieList.searchByDirector("Christopher Nolan");

        // Remove a movie
        movieList.removeByTitle("The Godfather");
        System.out.println("\nAfter removing The Godfather:");
        movieList.displayForward();

        // Display all movies in reverse order
        System.out.println("\nMovies in reverse order:");
        movieList.displayReverse();
    }
}