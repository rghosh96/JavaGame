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

public class PausePage extends MenuOptions {
	JPanel p;
	JFrame frame;
	Game game;
	MusicPlayer music;
	Inputs key;
	
	public PausePage(Game g, JFrame f, Inputs k) {
		super();
		frame = f;
		game = g;
		key = k;
		p = new JPanel();
		p.setBackground(Color.black);
		p.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel j = new JLabel("[ paused ]");
		JLabel start = new JLabel("press *r* again to resume");
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
	


	@Override
	public void updateState() {

			if (key.isResume() ) {
			MenuOptions.setOption(game.gameState);

			}
			
			
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