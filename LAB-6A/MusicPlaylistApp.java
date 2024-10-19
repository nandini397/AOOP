import java.util.LinkedList;
import java.util.Scanner;

class MusicPlaylist {
    private LinkedList<String> playlist;
    
    public MusicPlaylist() {
        playlist = new LinkedList<>();
    }
    
    // Add a song to the playlist
    public void addSong(String song) {
        playlist.add(song);
        System.out.println("Song added: " + song);
    }
    
    // Remove a song by name
    public void removeSong(String song) {
        if (playlist.remove(song)) {
            System.out.println("Song removed: " + song);
        } else {
            System.out.println("Song not found in the playlist.");
        }
    }
    
    // Move a song to a different position in the playlist
    public void moveSong(int oldPosition, int newPosition) {
        if (oldPosition >= 0 && oldPosition < playlist.size() && newPosition >= 0 && newPosition < playlist.size()) {
            String song = playlist.remove(oldPosition);
            playlist.add(newPosition, song);
            System.out.println("Moved song to position: " + (newPosition + 1));
        } else {
            System.out.println("Invalid positions provided.");
        }
    }
    
    // Display the playlist
    public void displayPlaylist() {
        if (playlist.isEmpty()) {
            System.out.println("The playlist is empty.");
        } else {
            System.out.println("Playlist:");
            for (int i = 0; i < playlist.size(); i++) {
                System.out.println((i + 1) + ". " + playlist.get(i));
            }
        }
    }
}

public class MusicPlaylistApp {
    public static void main(String[] args) {
        MusicPlaylist musicPlaylist = new MusicPlaylist();
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\nMusic Playlist:");
            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. Move Song");
            System.out.println("4. Display Playlist");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter the song name: ");
                    String song = scanner.nextLine();
                    musicPlaylist.addSong(song);
                    break;
                case 2:
                    System.out.print("Enter the song name to remove: ");
                    String songToRemove = scanner.nextLine();
                    musicPlaylist.removeSong(songToRemove);
                    break;
                case 3:
                    System.out.print("Enter the current position of the song: ");
                    int oldPosition = scanner.nextInt() - 1;
                    System.out.print("Enter the new position of the song: ");
                    int newPosition = scanner.nextInt() - 1;
                    musicPlaylist.moveSong(oldPosition, newPosition);
                    break;
                case 4:
                    musicPlaylist.displayPlaylist();
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
