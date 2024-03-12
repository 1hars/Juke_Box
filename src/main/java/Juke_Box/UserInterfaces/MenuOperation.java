package Juke_Box.UserInterfaces;

import Juke_Box.Catalog.Song_Path;
import Juke_Box.Catalog.Songs;
import java.util.List;

import Juke_Box.Catalog.UsersPlayList;
import Juke_Box.PlayToSong;
import Juke_Box.Services.JukeBoxService;

import java.util.Scanner;
public class MenuOperation {

    JukeBoxService service = new JukeBoxService();
    public void showJuke_Box_Menu() {
        Scanner scn = new Scanner(System.in);
        String str = "Y";
        while(str.equalsIgnoreCase("y")) {
            System.out.println("1. View Playlist");
            System.out.println("2. View Sorted Playlist Based on Artist Name");
            System.out.println("3. Search Based on Categories");
            System.out.println("4. Create Playlist");
            System.out.println("5. View Content of Created PlayList");
            System.out.println("6. Want to Play Song");
            System.out.println("7. Play Song from Created list");
            System.out.println("Enter Choice Between 1/2/3/4/5/6/7");
            int n = scn.nextInt();
            switch (n){
                case 1:
                   List<Songs> sl = service.songList();
                   for(Songs ct : sl){
                            System.out.println(ct);
                        }
                        break;
                case 2:
                    List<Songs> slist = service.songList();
                    service.sortSongListByName(slist);
                    break;
                case 3:
//                    System.out.println("Enter the category - Genre,Artist,Name");
                    String check = "Y";
                    while(check.equalsIgnoreCase("Y")) {
                        System.out.println("Enter the category - Genre,Artist,Name");
                        String str1 = scn.next();
                        if (str1.equalsIgnoreCase("Genre")) {
                            System.out.println("Enter Genres name : ");
                            String gen = scn.next();
                            service.searchGenre(gen);
                        } else if (str1.equalsIgnoreCase("Artist")) {
                            System.out.println("Enter Artist name : ");
                            String art = scn.next();
                            service.searchArtist(art);

                        } else if (str1.equalsIgnoreCase("Name")) {
                            System.out.println("Enter Song Name : ");
                            String nam = scn.next();
                            service.searchName(nam);
                        } else {
                            System.out.println("Enter correct category");
                        }
                        System.out.println("Do you want to search again Y/N");
                        check = scn.next();
                    }
                         break;
                case 4:
                    System.out.println("Enter Album_title");
                    String title = scn.next();
                    System.out.println("Enter Song_Name");
                    String name = scn.next();
                    UsersPlayList list = new UsersPlayList(title,name);
                    int i = service.addAlbum(list);
                    if(i>0){
                        System.out.println("Elbum added");
                    }else{
                        System.out.println("Somthing went wrong");
                    }
                    break;
                case 5:
                    service.contentofCreatedList();
                    break;
                case 6:
                    try {
                        List<Song_Path> p = service.file_Path();
                        PlayToSong s = new PlayToSong();
                        s.play(p);
                        break;
                    }catch(Exception ee){
                        ee.printStackTrace();
                        System.out.println("Path error");
                    }
                    break;
                case 7:
                    JukeBoxService jk = new JukeBoxService();
                    System.out.println("Enter the song name");
                    String string = scn.next();
                    String path = jk.addPathTodb(string);
                    PlayToSong s = new PlayToSong();
                    try{
                        s.playbyuser(path);
                    }
                    catch (Exception ee){}
                    break;
                default:
                    System.out.println("Error");
            }
            System.out.println("Do you want to continue y/n");
            str = scn.next();
        }

    }

}

