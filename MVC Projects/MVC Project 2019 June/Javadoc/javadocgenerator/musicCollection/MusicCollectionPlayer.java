package musicCollection;

import java.util.List;

import interfaces.Adders;
import interfaces.ControlPlayable;
import interfaces.MemoryControl;
import interfaces.Playable;
import interfaces.Playback;

public class MusicCollectionPlayer implements Playback,ControlPlayable,Playable,Adders,MemoryControl {
	private List<Collection> Playlist;
	/**
	 * Start playing
	 */
	@Override
	public void Play(String string) {
		// TODO Auto-generated method stub
		
	}
	/**
	 *Pause playing
	 */
	@Override
	public void Pause() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Stop playing
	 */
	@Override
	public void Stop() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * plays next song
	 */
	@Override
	public void Next(String name) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * plays previous song
	 */
	@Override
	public void Previous(String name) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	/**
	 * repeat song
	 */
	@Override
	public void Repeat(String song) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * play song at normal row
	 */
	
	/**
	 * adjust the volume 
	 */
	@Override
	public void Volume(int volume) {
		// TODO Auto-generated method stub
		
	}
        /**
         * Adds a song from the given directory
         * @param filePath directory
         */
	@Override
	public void Add(String filePath) {
		// TODO Auto-generated method stub
		
	}
        /**
         * Adds a folder from the given directory
         * @param filePath directory
         */
	@Override
	public void AddFolder(String filePath) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * save list
	 * @param filePath
	 */
	@Override
	public void save(String filePath) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * save list
	 * @param filePath
	 */
	@Override
	public void saveAs(String filePath) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * open a file/list
	 * @param filePath
	 */
	@Override
	public void open(String filePath) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * export file
	 * @param filePath
	 */
	@Override
	public void export(String filePath) {
		// TODO Auto-generated method stub
		
	}
        /**
         * Retruns playlist
         * @return playlist
         */
	public List<Collection> getPlaylist() {
		return Playlist;
	}
        /**
         * Sets playlist
         * @param playlist playlist 
         */
	public void setPlaylist(List<Collection> playlist) {
		Playlist = playlist;
	}
/**
 * plays random songs from a playlist
 * @param col playlist
 */
    @Override
    public void Random(Collection col) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
	
	
}
