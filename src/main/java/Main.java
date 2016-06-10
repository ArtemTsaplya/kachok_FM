import web.AudioFile;
import web.PlayerAPI;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        PlayerAPI player = new PlayerAPI();
        player.play("D:\\Ekvalayzer.mpg");
        AudioFile audioFile = new AudioFile();
        try {
            audioFile.playAudio();
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
