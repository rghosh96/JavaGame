import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GraphicsEnvironment;

import java.io.*;
import sun.audio.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class GameOver extends MenuOptions {
	JPanel p;
	JFrame frame;
	Game game;
	MusicPlayer music;
	Inputs key;
	
	public GameOver(Game g, JFrame f, Inputs k) {
		super();
		frame = f;
		game = g;
		key = k;
		p = new JPanel();
		p.setBackground(Color.black);
		p.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel j = new JLabel("game over.");
		JLabel start = new JLabel("oh no! you are forever trapped in the alterverse...");
		start.setForeground(Color.white);
		c.gridx = 0;
		c.gridy = 450;
		p.add(start, c);

		

		
		
		Font font = new Font("Courier", Font.BOLD, 30);
		j.setForeground(Color.pink);
		j.setFont(font);
		p.add(j);
		
	
	    frame.add(p);
		frame.setVisible(true);


		
	}
	
	public static void playMusic() {
		InputStream music;
		try {
			music = new FileInputStream(new File("#1.wav"));
			AudioStream audio = new AudioStream(music);
			AudioPlayer.player.start(audio);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error!");
		}
	}


	@Override
	public void updateState() {

			
			
	}

	
	@Override
	protected Tiles getTile(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void updateImage(Graphics g) {
		p.paint(g);

	}

}
