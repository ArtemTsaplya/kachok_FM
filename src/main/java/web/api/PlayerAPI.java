package web.api;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
import uk.co.caprica.vlcj.runtime.x.LibXUtil;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class PlayerAPI {
    public PlayerAPI() {
        registerLibrary();
    }

    /**
     * Runs the audio/video file
     */
    public void play(final String filename) {
        final Canvas videoSurface = new Canvas();
        final List<String> vlcArgs = new ArrayList<String>();
        configureParameters(vlcArgs);
        final EmbeddedMediaPlayer mediaPlayer = createPlayer(vlcArgs, videoSurface);
        mediaPlayer.playMedia(filename);
    }

    /**
     * Important: Notice where is the libvlc, which contains all native functions to manipulate the player * * Windows: libvlc.dll * Linux: libvlc.so
     */
    private void registerLibrary() {
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "d:/vlc-2.2.1");
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
        LibXUtil.initialise();
    }


    /**
     * Configure VLC parameters
     */
    private void configureParameters(final List<String> vlcArgs) {
        vlcArgs.add("--no-plugins-cache");
        vlcArgs.add("--no-video-title-show");
        vlcArgs.add("--no-snapshot-preview"); // Important, if this parameter would not be set on Windows, the app won't work
        if (RuntimeUtil.isWindows()) {
            vlcArgs.add("--plugin-path=D:\\vlc-2.2.1\\plugins");
        }
    }

    /**
     * Build the player
     */

    private EmbeddedMediaPlayer createPlayer(final List<String> vlcArgs, final Canvas videoSurface) {
        EmbeddedMediaPlayerComponent mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        EmbeddedMediaPlayer embeddedMediaPlayer = mediaPlayerComponent.getMediaPlayer();
        MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory(vlcArgs.toArray(new String[vlcArgs.size()]));
        mediaPlayerFactory.setUserAgent("vlcj test player");
        embeddedMediaPlayer.setVideoSurface(mediaPlayerFactory.newVideoSurface(videoSurface));
        embeddedMediaPlayer.setPlaySubItems(true);
        return embeddedMediaPlayer;
    }


}
