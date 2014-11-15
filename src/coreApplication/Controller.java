package coreApplication;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.gstreamer.Gst;

/**
 * The Class is a controller middle-ware to handle elements of our application.
 *
 * @author   Martin
 * @reviewer Baptiste
 */
public final class Controller {

    private SoundRecorder capture = null;
    private SoundPlayer player = null;
    private String mFolderPath = Constants.RECORD_PATH;
    private String pFolderPath = Constants.PLAYL_PATH;

    /**
     * Constructor which instantiate a SoundRecorder element, a Sound player
     * element and both music and playlist default folder according to Constants
     * values.
     */
    public Controller() {
        //Instantiate a new sound recorder with a 
        capture = new SoundRecorder();

        //Instantiate a new audio player.
        player = new SoundPlayer();

        //Initiate the default Music/playlist folder
        mFolderPath = createMusicBaseFolder();
        pFolderPath = createPlaylistBaseFolder();
    }

    //**************************************************************************
    
    /**
     * Create a default folder for recorded files
     *
     * @return absolute path of the folder
     */
    private String createMusicBaseFolder() {
        File dir = new File(Constants.RECORD_PATH);
        dir.mkdir();
        return dir.getAbsolutePath();
    }
    
    /**
     * Get the music folder path.
     * 
     * @return the music folder path string
     */
    public String getMusicFolderPath() {
        return mFolderPath;
    }
    
    /**
     * Set the music folder path.
     * 
     * @param folderPath is new path for music folder.
     */
    public void setMusicFolderPath(String folderPath) {
        this.mFolderPath = folderPath;
    }

    //**************************************************************************
    
    /**
     * Create a default folder for playlists
     *
     * @return absolute path of the folder
     */
    public String createPlaylistBaseFolder() {
        File dir = new File(Constants.PLAYL_PATH);
        dir.mkdir();
        return dir.getAbsolutePath();
    }
    
    /**
     * Get the playlist folder path.
     * 
     * @return the playlist folder path string
     */
    public String getPlaylistFolderPath() {
        return pFolderPath;
    }
    
    /**
     * Set the playlist folder path.
     * 
     * @param folderPath is new path for playlist folder.
     */
    public void setPlaylistFolderPath(String folderPath) {
        this.pFolderPath = folderPath;
    }

    //**************************************************************************
    
    /**
     * Save captured file in the default folder
     *
     * @throws java.io.IOException
     */
    public void saveCapture() throws IOException {
        File f = new File(capture.getFilePath());
        File p = new File(Constants.RECORD_PATH);
        if (f.exists() && !f.isDirectory() && p.exists() && p.isDirectory()) {
            f.renameTo(new File(Constants.RECORD_PATH + File.separator + getDate() + ".mp3"));
        } 
    }
    
    /**
     * Save As... for captured file
     *
     * @param fullpath is the full path of the new file
     * @throws java.io.IOException
     */
    public void saveAsCapture(String fullpath) throws IOException {
        File f = new File(capture.getFilePath());
        String pathWithoutFile = fullpath.substring(0, fullpath.lastIndexOf(File.separator));
        File p = new File(pathWithoutFile);
        if (f.exists() && !f.isDirectory() && p.exists() && p.isDirectory()) {
            if (fullpath.endsWith(".mp3")) {
            f.renameTo(new File(fullpath));
            }else{
            f.renameTo(new File(fullpath + ".mp3"));
            }
        } 
    }

    /**
     * Create a Playlist
     *
     * @param FileName is the name of the new playlist
     * @throws java.io.IOException
     */
    public void createPlaylist(String FileName) throws IOException {
        File f = new File(Constants.PLAYL_PATH + File.separator + FileName + ".pp");
        f.createNewFile();
    }

    //**************************************************************************
    
    /**
     * Start capturing audio with specified quality to temp file
     *
     * @param quality from 10 to 100 (max quality)
     */
    public void captureStart(int quality) {
        capture.setQuality(quality);
        capture.play();
    }
    
    /**
     * Stop capturing audio
     */
    public void captureStop() {
        capture.stop();
    }
    
    //**************************************************************************
    
    /**
     * Play last captured file
     */
    public void playerPlayCaptured() {
        playerPlayFile(capture.getFilePath());
    }
    
    /**
     * Start playing audio file from path
     *
     * @param path full path to file
     */
    public void playerPlayFile(String path) {
        File f = new File(path);
        if (f.exists() && !f.isDirectory()) {
            player.playFile(path);
        }
    }
    
    /**
     * Play audio if player is paused
     */
    public void playerPlay() {
        if (player.isPaused()) {
            player.play();
        }
    }
    
    /**
     * Stop playing audio
     */
    public void playerStop() {
        player.stop();
    }

    /**
     * Pause playing audio
     */
    public void playerPause() {
        player.pause();
    }

    //**************************************************************************
    
    /**
     * Set volume of audio player
     *
     * @param volume from 0 to 100 (max)
     */
    public void playerSetVolume(int volume) {
        player.setVolume(((double) volume) / 100);
    }
    
    /**
     * Test is the player is playing a sound.
     * 
     * @return true or false
     */
    public boolean playerIsPlaying() {
        return player.isPlaying();
    }

    /**
     * Test is the player is in pause mode.
     * 
     * @return true or false
     */
    public boolean playerIsPaused() {
        return player.isPaused();
    }

    /**
     * Get the duration of the playing sound.
     * 
     * @return the duration in seconds
     */
    public long playerGetDuration() {
        return player.getDuration();
    }

    /**
     * Get the position of the playback.
     * 
     * @return the position in seconds.
     */
    public long playerGetPosition() {
        return player.getPostion();
    }
    
    //**************************************************************************
    
    /**
     * Set the player event listener for catching messages
     *
     * @param e is the event listener
     */
    public void setPlayerListener(EventListener e) {
        player.setListener(e);
    }
    
    /**
     * Get the current Time and Date
     * 
     * @return the Date as a string 
     */
    public String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
    
    /**
     * Quit an QST instance
     */
    public void quitGST() {
        Gst.quit();
    }
    
    //**************************************************************************
}
