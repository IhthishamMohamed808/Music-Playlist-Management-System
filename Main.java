import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Creating Scanner & Playlist
        Scanner scanner = new Scanner(System.in);
        playlist playlist = null;

        //Printing Options For User
        while (true) {
            System.out.println("\n--- Music Playlist Management System ---");
            System.out.println("1. Create A Playlist");
            System.out.println("2. Add A Song to Playlist");
            System.out.println("3. Remove A Song from Playlist");
            System.out.println("4. Rearrange Songs in Playlist");
            System.out.println("5. Play The Playlist Sequentially");
            System.out.println("6. Play The Playlist in Shuffled Order");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            //User Choice Input
            int option = scanner.nextInt();
            scanner.nextLine();

            //First Option Method
            if (option == 1) {

                //Message To Enter Playlist Name
                System.out.print("Enter playlist name: ");

                //User Input For Play List Name
                String name = scanner.nextLine();

                //Method To Create A New Playlist From User Input
                playlist = new playlist(name);

                //Message When Playlist Is Created
                System.out.println("Playlist created: " + playlist);

            }

            //Second Option Method
            else if (option == 2) {
                if (playlist != null) {

                    //Message To enter song title
                    System.out.print("Enter song title: ");

                    //User Input For song title
                    String title = scanner.nextLine();

                    //Message To enter Artist Name
                    System.out.print("Enter artist name: ");

                    //User Input For The Artist Name
                    String artist = scanner.nextLine();

                    //Storing Song Title And Artist
                    song song = new song(title, artist);

                    //Method To Add Song To Playlist
                    playlist.addSong(song);

                    //Message When a Song is added
                    System.out.println("Song added: " + song);
                }
            }

            //Third Option Method
            else if (option == 3) {
                if (playlist == null) {

                    //Message When A Playlist is not Available
                    System.out.println("Please create a playlist first.");
                    return;
                }

                //Message To Enter Song Title For Removal
                System.out.print("Enter song title to remove: ");

                //User Input For The Name Of Song To Remove
                String title = scanner.nextLine();
                song songToRemove = null;

                //Method To Remove Song
                for (song song : playlist.songs) {
                    if (song.getTitle().equalsIgnoreCase(title)) {
                        songToRemove = song;
                        break;
                    }
                }
                if (songToRemove != null) {

                    //Method To Remove Song From Playlist
                    playlist.removeSong(songToRemove);

                    //Message When Song is Removed
                    System.out.println("Song removed: " + songToRemove);
                } else {

                    //Message When Song is not found in the playlist
                    System.out.println("Song not found in the playlist.");
                }
            }

            //Fourth Option Method
            else if (option==4) {
                if (playlist == null) {

                    //Message When A Playlist is not Available
                    System.out.println("Please create a playlist first.");
                    return;
                }

                //Message To Enter the current position of the song
                System.out.print("Enter the current position of the song: ");

                //User Choice Input
                int fromIndex = scanner.nextInt();

                //Message To Enter the new position for the song
                System.out.print("Enter the new position for the song: ");

                //User Choice Input
                int toIndex = scanner.nextInt();
                scanner.nextLine(); // consume newline
                try {

                    //Method To Rearrange Song In Playlist
                    playlist.rearrangeSong(fromIndex - 1, toIndex - 1); // Converts to zero-based index

                    //Message When Song Is Rearranged
                    System.out.println("Song rearranged.");

                } catch (IndexOutOfBoundsException e) {

                    //Message When Song Number Is Wrong
                    System.out.println("Invalid index. Please try again.");
                }
            }

            //Fifth Option Method
            else if (option==5) {

                //Message When A Playlist is not Available
                if (playlist == null) {
                    System.out.println("Please Create a playlist first.");
                    return;
                }

                //Method To Play Playlist Sequentially
                playlist.playSequentially();
            }

            //Sixth Option Method
            else if (option==6) {

                //Message When A Playlist is not Available
                if (playlist == null) {
                    System.out.println("Please Create a playlist first.");
                    return;
                }

                //Method To Shuffle Playlist
                playlist.playShuffled();
            }

            //Seventh Option Method
            else if (option == 7) {

                //Message To Exit
                System.out.println("exit");
                break;
            } else {

                //Message if User Inputs an Invalid Choice Number
                System.out.println("invalid choice. try again");
            }
        }
    }
}






