package Juke_Box.Services;

import Juke_Box.Catalog.UsersPlayList;
import Juke_Box.DB.DBConnection;
import Juke_Box.Catalog.Songs;
import Juke_Box.Catalog.Song_Path;
import Juke_Box.Juke_BoxApp;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JukeBoxService {
    DBConnection cn;
    Connection myconnection;
    public JukeBoxService(){
        try{
            cn = new DBConnection();
            myconnection = cn.getConnection();
        }
        catch(Exception ee){
            System.out.println("Not ready to shoot");
        }
    }
    public List<Songs> songList(){
        List<Songs> list = new ArrayList<>();
        try {
            Statement state = myconnection.createStatement();
            ResultSet st = state.executeQuery("Select * from Catalog");
            while(st.next()){
                Songs cat = new Songs();
                cat.setSong_Name(st.getString("song_Name"));
                cat.setArtist(st.getString("artist_Name"));
                cat.setGenre(st.getString("genre_Name"));
                list.add(cat);
            }
        }
        catch(SQLException ee){
            System.out.println("Sql Exception");
        }
        return list;
    }
    public void sortSongListByName(List<Songs> list) {
//        Comparator<Songs> comparator = Comparator.comparing(Songs::getArtist);
//        Collections.sort(list, comparator);
        Collections.sort(list);
        for(Songs c : list){
            System.out.println(c);  
        }
    }
    public void searchGenre(String gen){
        List<Songs> list = new ArrayList<>();
        try {
            PreparedStatement ps = myconnection.prepareStatement("Select * from Catalog where genre_Name=?");
            ps.setString(1,gen);
            ResultSet rset = ps.executeQuery();
            while(rset.next()){
                Songs cat = new Songs();
                cat.setSong_Name(rset.getString("song_Name"));
                cat.setArtist(rset.getString("artist_Name"));
                cat.setGenre(rset.getString("genre_Name"));
                list.add(cat);
            }
            for(Songs ct : list){
                System.out.println(ct);
            }
        }
        catch (SQLException ee){
            System.out.println("Sql Exceptiom");
        }
    }

    public void searchArtist(String str){
        List<Songs> list = new ArrayList<>();
        try {
            PreparedStatement ps = myconnection.prepareStatement("Select * from Catalog where artist_Name=?");
            ps.setString(1,str);
            ResultSet rset = ps.executeQuery();
            while(rset.next()){
                Songs cat = new Songs();
                cat.setSong_Name(rset.getString("song_Name"));
                cat.setArtist(rset.getString("artist_Name"));
                cat.setGenre(rset.getString("genre_Name"));
                list.add(cat);
            }
            for(Songs ct : list){
                System.out.println(ct);
            }
        }
        catch (SQLException ee){
            System.out.println("Sql Exceptiom");
        }
    }

    public void searchName(String name){
        List<Songs> list = new ArrayList<>();
        try {
            PreparedStatement ps = myconnection.prepareStatement("Select * from Catalog where song_Name=?");
            ps.setString(1,name);
            ResultSet rset = ps.executeQuery();
            while(rset.next()){
                Songs cat = new Songs();
                cat.setSong_Name(rset.getString("song_Name"));
                cat.setArtist(rset.getString("artist_Name"));
                cat.setGenre(rset.getString("genre_Name"));
                list.add(cat);
            }
            for(Songs ct : list){
                System.out.println(ct);
            }
        }
        catch (SQLException ee){
            System.out.println("Sql Exceptiom");
        }

    }
    public int addAlbum(UsersPlayList list){
        int roweffected = 0;
        try{
            PreparedStatement pst = myconnection.prepareStatement("Insert into User_Playlist(Album_title,song_Name)Values(?,?)");
            pst.setString(1,list.getAlbum_title());
            pst.setString(2,list.getSong_Name());
            roweffected = pst.executeUpdate();
        }
        catch(Exception ee){
            System.out.println("Not inserted ");
        }
        return roweffected;
    }
    public String addPathTodb(String name){
        int row = 0;
        String path = null;
        if(name.equalsIgnoreCase("295")){
            try{
                PreparedStatement pst = myconnection.prepareStatement("Update User_Playlist SET Song_Path = ? where song_Name = ?");
                pst.setString(1,"G:\\Juke_Box\\src\\main\\resources\\295.wav");
                pst.setString(2,"295");
                path = "G:\\Juke_Box\\src\\main\\resources\\295.wav";
                row = pst.executeUpdate();

            }
            catch(Exception ee){
                System.out.println("Not inserted ");
            }
        }
        else if(name.equalsIgnoreCase("Do-Pal-Ki")){
            try{
                PreparedStatement pst = myconnection.prepareStatement("Update User_Playlist SET Song_Path = ? where song_Name = ?");
                pst.setString(1,"G:\\Juke_Box\\src\\main\\resources\\Do-Pal-Ki.wav");
                pst.setString(2,"Do-Pal-Ki");
                path = "G:\\Juke_Box\\src\\main\\resources\\Do-Pal-Ki.wav";
                row = pst.executeUpdate();
            }
            catch(Exception ee){
                System.out.println("Not inserted ");
            }
        }
        else if(name.equalsIgnoreCase("Ram-Aayenge")){
            try{
                PreparedStatement pst = myconnection.prepareStatement("Update User_Playlist SET Song_Path = ? where song_Name = ?");
                pst.setString(1,"G:\\Juke_Box\\src\\main\\resources\\Ram-Aayenge.wav");
                pst.setString(2,"Ram-Aayenge");
                path = "G:\\Juke_Box\\src\\main\\resources\\Ram-Aayenge.wav";
                row = pst.executeUpdate();
            }
            catch(Exception ee){
                System.out.println("Not inserted ");
            }
        }
        else{
            System.out.println("Song does not exist");
        }
        return path;

    }

    public void contentofCreatedList(){
        List list = new ArrayList();
        try{
            PreparedStatement ps = myconnection.prepareStatement("Select * from User_Playlist");
            ResultSet rset = ps.executeQuery();
            while(rset.next()){
                UsersPlayList cat = new UsersPlayList();
                cat.setAlbum_title(rset.getString("Album_title"));
                cat.setSong_Name(rset.getString("Song_Name"));
                list.add(cat);
            }
            for(Object o : list){
                System.out.println(o);
            }
        }
        catch(Exception ee){
            System.out.println("content error");
        }
    }
    public List<Song_Path> file_Path(){
        List<Song_Path> list = new ArrayList<>();
        try{
            PreparedStatement ps = myconnection.prepareStatement("Select file_Path from Catalog");
            ResultSet rset = ps.executeQuery();
            while(rset.next()){
                Song_Path cat = new Song_Path();
                cat.setSong_path(rset.getString("file_Path"));
                list.add(cat);
            }
        }
        catch(SQLException ee){
            System.out.println("File path error");
        }
        return list;
    }


}


