package interfaces;

public interface MemoryControl {
	void save(String filePath);
	void saveAs(String filePath);
	void open(String filePath);
	void export(String filePath);
}
