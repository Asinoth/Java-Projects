package musicCollection;

public class Song {
	private String compName;
	private String composer;
	private String filePath;
	/**
	 * Creates new song
	 * @param filePath
	 */
	Song(String filePath){
		this.filePath=filePath;
	}
	/**
	 * Returns composition name
	 * @return compName
	 */
	public String getCompName() {
		return compName;
	}
	/**
	 * Set composition name
	 * @param compName
	 */
	public void setCompName(String compName) {
		this.compName = compName;
	}
	/**
	 * Returns name of composer
	 * @return composer
	 */
	public String getComposer() {
		return composer;
	}
	/**
	 * Set composer's name
	 * @param composer
	 */
	public void setComposer(String composer) {
		this.composer = composer;
	}
	/**
	 * Return the file path of file
	 * @return filePath
	 */
	public String getFilePath() {
		return filePath;
	}
	/**
	 * Set the file path of file
	 * @param filePath
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
