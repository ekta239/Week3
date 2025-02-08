package circularlinkedlist.onlineticketreservationsystem;

public class Main {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();
        
        // Adding tickets
        system.addTicket(1, "Alice", "Avengers", "A1");
        system.addTicket(2, "Bob", "Batman", "B2");
        system.addTicket(3, "Charlie", "Avengers", "C3");

        // Displaying tickets
        system.displayTickets();

        // Searching for a ticket
        system.searchTicket("Alice");
        system.searchTicket("Batman");

        // Removing a ticket
        system.removeTicketById(2);
        system.displayTickets();

        // Total booked tickets
        System.out.println("Total booked tickets: " + system.totalBookedTickets());
    }
}
