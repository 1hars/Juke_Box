package Juke_Box;

import Juke_Box.Catalog.Song_Path;
import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.LineUnavailableException;
import java.util.List;
public class PlayToSong {

    public void play(List<Song_Path> path) throws UnsupportedAudioFileException, IOException, LineUnavailableException, FileNotFoundException {
        Scanner scn = new Scanner(System.in);
            for (Song_Path p : path) {
                File f = new File(String.valueOf(p));
                try {
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(f);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    String response = "";
                    while (!response.equals("Q")){
                        System.out.println("P = Play, S = Stop, R = Reset, Q = Quit");
                        System.out.println("Enter your Choice");
                        response = scn.next().toUpperCase();

                        switch (response) {
                            case "P":
                                clip.start();
                                break;
                            case "S":
                                clip.stop();
                                break;
                            case "R":
                                clip.setMicrosecondPosition(0);
                                break;
                            case "Q":
                                clip.close();
                                break;
                            default:
                                System.out.println("Not a valid response");
                        }

                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    public void playbyuser(String path) throws UnsupportedAudioFileException, IOException, LineUnavailableException, FileNotFoundException {
        Scanner scn = new Scanner(System.in);
            File f = new File(path);
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(f);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                String response = "";
                while (!response.equals("Q")){
                    System.out.println("P = Play, S = Stop, R = Reset, Q = Quit");
                    System.out.println("Enter your Choice");
                    response = scn.next().toUpperCase();
                    switch (response) {
                        case "P":
                            clip.start();
                            break;
                        case "S":
                            clip.stop();
                            break;
                        case "R":
                            clip.setMicrosecondPosition(0);
                            break;
                        case "Q":
                            clip.close();
                            break;
                        default:
                            System.out.println("Not a valid response");
                    }
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
}

