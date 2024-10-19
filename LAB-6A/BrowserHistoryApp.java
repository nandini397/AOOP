import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class BrowserHistory {
    private Deque<String> history;
    private Deque<String> forwardHistory;
    private String currentPage;
    
    public BrowserHistory() {
        history = new ArrayDeque<>();
        forwardHistory = new ArrayDeque<>();
    }
    
    // Add a new page to the history
    public void visitPage(String page) {
        if (currentPage != null) {
            history.push(currentPage);
        }
        currentPage = page;
        forwardHistory.clear(); // Clear forward history when a new page is visited
        System.out.println("Visited: " + page);
    }
    
    // Go back to the previous page
    public void goBack() {
        if (!history.isEmpty()) {
            forwardHistory.push(currentPage);
            currentPage = history.pop();
            System.out.println("Back to: " + currentPage);
        } else {
            System.out.println("No previous page.");
        }
    }
    
    // Go forward to the next page
    public void goForward() {
        if (!forwardHistory.isEmpty()) {
            history.push(currentPage);
            currentPage = forwardHistory.pop();
            System.out.println("Forward to: " + currentPage);
        } else {
            System.out.println("No next page.");
        }
    }
    
    // Display the current page
    public void displayCurrentPage() {
        if (currentPage == null) {
            System.out.println("No page is currently opened.");
        } else {
            System.out.println("Current Page: " + currentPage);
        }
    }
}

public class BrowserHistoryApp {
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory();
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\nBrowser History:");
            System.out.println("1. Visit Page");
            System.out.println("2. Go Back");
            System.out.println("3. Go Forward");
            System.out.println("4. Display Current Page");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter the page URL: ");
                    String page = scanner.nextLine();
                    browserHistory.visitPage(page);
                    break;
                case 2:
                    browserHistory.goBack();
                    break;
                case 3:
                    browserHistory.goForward();
                    break;
                case 4:
                    browserHistory.displayCurrentPage();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
        
        scanner.close();
    }
}
