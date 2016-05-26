import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        AudioFile audioFile = new AudioFile();
        try {
            audioFile.playAudio();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
