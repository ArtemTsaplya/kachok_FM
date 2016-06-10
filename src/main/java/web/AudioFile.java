package web;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AudioFile {
    private Player player;

    public AudioFile() {
        FileInputStream audio = null;
        try {
            audio = new FileInputStream("D:\\music\\Kiss FM - Top 40 Martie1\\1 Play & Win - Slow motion.mp3");
            player = new Player(audio);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }

    public void playAudio() throws IOException {
        try {
            player.play();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }

    }

    public void stopAudio() throws IOException {
        player.close();
    }
}
