import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.JOptionPane;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class MusicPlayer {
	
	static String f;
	InputStream music;
	AudioStream audio;
	
	
	public void setSong(String fileName) {
		f = fileName;
		try {
			music = new FileInputStream(new File(f));
			audio = new AudioStream(music);
			
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error!");
		}
	}
	
	
	public void startMusic() {
		AudioPlayer.player.start(audio);
		
	}
	
	public void stopMusic() {
		AudioPlayer.player.stop(audio);
	}

}
