package Juke_Box.Catalog;

public class Songs implements Comparable<Songs>{
    private String song_Name;
    private String genre;
    private String artist;
    public Songs(){}

    public Songs(String song_Name, String genre, String artist) {
        this.song_Name = song_Name;
        this.genre = genre;
        this.artist = artist;
    }

    public String getSong_Name() {
        return song_Name;
    }

    public void setSong_Name(String song_Name) {
        this.song_Name = song_Name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "[" +
                "song_Name = " + song_Name +
                ", genre = " + genre +
                ", artist = " + artist +
                "]";
    }

    @Override
    public int compareTo(Songs o) {
        return this.song_Name.compareTo(o.song_Name);
    }
}
