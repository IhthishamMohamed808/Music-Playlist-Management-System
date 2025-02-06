public class song {
    //variables to store the song's title and artist.
    String title;
    String artist;


    // Constructor to initialize the song's title and artist.
    public song(String title, String artist) {
        this.title = title;
        this.artist = artist;

    }
    // Getter method to retrieve the title of the song.
    public String getTitle() {
        return title;
    }

    // Getter method to retrieve the artist of the song.
    public String getArtist() {
        return artist;
    }


    // Override the toString method to return a string representation of the song object.
    @Override
    public String toString() {
        return "Title: " + title + ", Artist: " + artist;
    }
}
