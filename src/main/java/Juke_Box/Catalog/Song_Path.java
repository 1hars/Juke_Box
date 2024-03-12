package Juke_Box.Catalog;

public class Song_Path {
    String song_path;
    public Song_Path(){}
    public String getSong_path() {
        return song_path;
    }

    public void setSong_path(String song_path) {
        this.song_path = song_path;
    }

    @Override
    public String toString() {
        return song_path;
    }
}
