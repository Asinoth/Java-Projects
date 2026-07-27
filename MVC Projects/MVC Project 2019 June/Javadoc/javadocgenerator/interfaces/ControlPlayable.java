package interfaces;

public interface ControlPlayable {
	void Pause();
	void Next(String name);
	void Previous(String name);
	void Volume(int volume);
}
