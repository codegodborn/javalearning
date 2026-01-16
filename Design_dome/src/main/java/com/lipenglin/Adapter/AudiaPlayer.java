package com.lipenglin.Adapter;

public class AudiaPlayer implements MediaPlayer {
    MediaAdapter media;
    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing MP3 file: " + fileName);
        }
        else if (audioType.equalsIgnoreCase("vlc")||audioType.equalsIgnoreCase("mp4")) {
            media = new MediaAdapter(audioType);
        }
    }
}
