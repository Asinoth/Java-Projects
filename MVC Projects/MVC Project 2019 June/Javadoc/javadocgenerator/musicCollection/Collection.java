package musicCollection;

import java.util.List;

public class Collection {
	private String name;
        
        /**
         * Creates a collection with the given name
         * @param Name name
         */
        
        
        public Collection(String Name){
            this.name=name;
        }
        
	private List<Song> songs;
	
	/**
	 * Return name
	 * @return name
	 */
        
	public String getName() {
		return name;
	}
	/**
	 * Give collection name
	 * @param name name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Return a list of song
	 * @return List<Song>
	 */
	public List<Song> getSongs() {
		return songs;
	}
	/**
	 * Set a list of song
	 * @param songs song list
	 */
	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
}
