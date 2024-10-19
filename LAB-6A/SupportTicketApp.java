import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class SupportTicketSystem {
    private Queue<String> ticketQueue;
    
    public SupportTicketSystem() {
        ticketQueue = new LinkedList<>();
    }
    
    // Add a new ticket to the queue
    public void addTicket(String ticket) {
        ticketQueue.add(ticket);
        System.out.println("Ticket added: " + ticket);
    }
    
    // Process (remove) the next ticket in line
    public void processTicket() {
        if (!ticketQueue.isEmpty()) {
            String ticket = ticketQueue.poll();
            System.out.println("Processed ticket: " + ticket);
        } else {
            System.out.println("No tickets to process.");
        }
    }
    
    // Display all pending tickets
    public void displayTickets() {
        if (ticketQueue.isEmpty()) {
            System.out.println("No pending tickets.");
        } else {
            System.out.println("Pending Tickets:");
            for (String ticket : ticketQueue) {
                System.out.println(ticket);
            }
        }
    }
}

public class SupportTicketApp {
    public static void main(String[] args) {
        SupportTicketSystem supportSystem = new SupportTicketSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\nCustomer Support Ticket System:");
            System.out.println("1. Add Ticket");
            System.out.println("2. Process Ticket");
            System.out.println("3. Display Tickets");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter the ticket description: ");
                    String ticket = scanner.nextLine();
                    supportSystem.addTicket(ticket);
                    break;
                case 2:
                    supportSystem.processTicket();
                    break;
                case 3:
                    supportSystem.displayTickets();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
        
        scanner.close();
    }
}
