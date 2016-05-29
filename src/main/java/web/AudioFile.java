package web;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.IOException;

public class AudioFile {
    private Player player;
    public void playAudio() throws IOException {
        FileInputStream audio = new FileInputStream("D:\\music\\Kiss FM - Top 40 Martie1\\1 Play & Win - Slow motion.mp3");
        try {
            player = new Player(audio);
            player.play();

        } catch (JavaLayerException e) {
            e.printStackTrace();
        }

    }
    public void stopAudio()throws IOException {
        player.close();
    }
}
