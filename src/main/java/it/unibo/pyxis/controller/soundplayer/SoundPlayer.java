package it.unibo.pyxis.controller.soundplayer;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public final class SoundPlayer {

    private static final String SEPARATOR = File.separator;
    private static final String SOUNDS_PATH = "soundeffects" + SEPARATOR;
    private static final String SOUNDS_END_PATH = ".wav";

    private static double backgroundVolume = 0.2;
    private static double soundEffectVolume = 1;
    private static final Map<Sound, Media> allSounds;

    private static MediaPlayer backgroundMusicPlayer;
    private static MediaPlayer soundEffectPlayer;

    private SoundPlayer() { }

    static {
        allSounds = new HashMap<>(Map.of());
        Arrays.stream(Sound.values()).forEach(s -> {
                try {
                    final Media sound = new Media(
                            ClassLoader.getSystemResource(SOUNDS_PATH + s.getSoundName() + SOUNDS_END_PATH).toURI().toString());
                    allSounds.put(s, sound);
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
        });
    }

    private static MediaPlayer loadMediaPlayer(final Sound sound) {
        return new MediaPlayer(allSounds.get(sound));
    }

    /**
     * Set the volume of the background music.
     * @param volume
     */
    public static void setBackgroundVolume(final double volume) {
        backgroundVolume = volume;
    }

    /**
     * Set the volume of the sound effects.
     * @param volume
     */
    public static void setSoundEffectVolume(final double volume) {
        soundEffectVolume = volume;
    }

    /**
     * Play a {@link Sound} on a loop.
     * @param backgroundMusic
     */
    public static void playBackgroundMusic(final Sound backgroundMusic) {
        backgroundMusicPlayer = loadMediaPlayer(backgroundMusic);
        backgroundMusicPlayer.setVolume(backgroundVolume);
        backgroundMusicPlayer.play();
        backgroundMusicPlayer.setOnEndOfMedia(() -> {
            backgroundMusicPlayer.seek(Duration.ZERO);
            backgroundMusicPlayer.play();
        });
    }

    /**
     * Play a {@link Sound} for its duration.
     * @param soundEffect
     */
    public static void playSoundEffect(final Sound soundEffect) {
        soundEffectPlayer = loadMediaPlayer(soundEffect);
        soundEffectPlayer.setVolume(soundEffectVolume);
        soundEffectPlayer.play();
    }
}
