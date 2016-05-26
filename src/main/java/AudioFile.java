import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.IOException;

public class AudioFile {
    public void playAudio() throws IOException {
        FileInputStream audio = new FileInputStream("D:\\music\\Kiss FM - Top 40 Martie1\\1 Play & Win - Slow motion.mp3");
        try {
            Player player = new Player(audio);
            player.play();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }
}
