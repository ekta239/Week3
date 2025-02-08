package circularlinkedlist.onlineticketreservationsystem;


class TicketReservationSystem {
    private Ticket head;

    public TicketReservationSystem() {
        this.head = null;
    }

    // Add a new ticket reservation at the end of the circular list
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber);
        if (head == null) {
            head = newTicket;
            head.next = head; // Point to itself to make it circular
        } else {
            Ticket tail = head;
            while (tail.next != head) {
                tail = tail.next; // Find the last node
            }
            tail.next = newTicket; // Last node points to new ticket
            newTicket.next = head; // New ticket points to head
        }
    }

    // Remove a ticket by Ticket ID
    public void removeTicketById(int ticketId) {
        if (head == null) return; // List is empty

        Ticket current = head;
        Ticket previous = null;

        do {
            if (current.ticketId == ticketId) {
                if (previous == null) { // Removing head
                    Ticket tail = head;
                    while (tail.next != head) {
                        tail = tail.next; // Find the last node
                    }
                    if (tail == head) { // Only one node
                        head = null;
                    } else {
                        head = head.next; // Move head to next
                        tail.next = head; // Last node points to new head
                    }
                } else {
                    previous.next = current.next; // Bypass the current ticket
                }
                System.out.println("Ticket ID " + ticketId + " removed successfully.");
                return; // Ticket removed
            }
            previous = current;
            current = current.next;
        } while (current != head);
        System.out.println("Ticket ID " + ticketId + " not found.");
    }

    // Display the current tickets in the list
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = head;
        do {
            System.out.println("Ticket ID: " + temp.ticketId + ", Customer Name: " + temp.customerName +
                    ", Movie Name: " + temp.movieName + ", Seat Number: " + temp.seatNumber +
                    ", Booking Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String searchTerm) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(searchTerm) || temp.movieName.equalsIgnoreCase(searchTerm)) {
                System.out.println("Found Ticket - Ticket ID: " + temp.ticketId + ", Customer Name: " + temp.customerName +
                        ", Movie Name: " + temp.movieName + ", Seat Number: " + temp.seatNumber +
                        ", Booking Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) {
            System.out.println("No tickets found for the search term: " + searchTerm);
        }
    }

    // Calculate the total number of booked tickets
    public int totalBookedTickets() {
        if (head == null) return 0;

        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
 }
}