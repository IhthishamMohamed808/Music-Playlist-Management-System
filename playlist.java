import java.util.Collections;
import java.util.LinkedList;

public class playlist {

    //variables to store the playlist's name and the list of songs in it.
    String name;
    LinkedList<song> songs;

    // Constructor to initialize the playlist's name and an empty list of songs.
    public playlist(String name) {
        this.name = name;
        this.songs = new LinkedList<>();
    }

    //Method To Add Song
    public void addSong(song song) {
        songs.add(song);
    }

    //Method To Remove Song
    public void removeSong(song song) {
        songs.remove(song);
    }

    //Method To Rearrange Song
    public void rearrangeSong(int fromIndex, int toIndex) {
        if (fromIndex < 0 || fromIndex >= songs.size() || toIndex < 0 || toIndex >= songs.size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        song song = songs.remove(fromIndex);
        songs.add(toIndex, song);
    }

    //Method To Play Playlist Sequentially
    public void playSequentially() {
        System.out.println("Playing playlist: " + name + " sequentially.");
        for (song song : songs) {
            System.out.println("Playing: " + song);
        }
    }

    //Method To Play Playlist Shuffled
    public void playShuffled() {
        System.out.println("Playing playlist: " + name + " in shuffled order.");
        LinkedList<song> shuffledSongs = new LinkedList<>(songs);
        Collections.shuffle(shuffledSongs);
        for (song song : shuffledSongs) {
            System.out.println("Playing: " + song);
        }
    }

    // Override the toString method to provide a string representation of the playlist.
    @Override
    public String toString() {
        return "Playlist: " + name + ", Songs: " + songs.size();
    }
}
