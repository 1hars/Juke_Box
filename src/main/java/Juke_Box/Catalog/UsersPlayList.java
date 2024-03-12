package Juke_Box.Catalog;

public class UsersPlayList {
        private String Album_title;
        private String song_Name;
        private String Song_Path;
        public UsersPlayList(){}
        public UsersPlayList(String Song_Path){
            this.Song_Path = Song_Path;
        }

        public UsersPlayList( String Album_title,String song_Name) {
            this.Album_title = Album_title;
            this.song_Name = song_Name;
        }

    public String getSong_Path() {
        return Song_Path;
    }

    public void setSong_Path(String song_Path) {
        Song_Path = song_Path;
    }

    public String getSong_Name() {
            return song_Name;
        }

        public void setSong_Name(String song_Name) {
            this.song_Name = song_Name;
        }

        public String getAlbum_title() {
            return Album_title;
        }

        public void setAlbum_title(String album_title) {
            Album_title = album_title;
        }

        @Override
        public String toString() {
            return "[ " +"Album_title = " + Album_title + " ,song_Name = " + song_Name +"]";
        }
 }

