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

public class InstructionsPage extends MenuOptions {
	JPanel p;
	JFrame frame;
	Game game;
	MusicPlayer music;
	Inputs key;
	
	public InstructionsPage(Game g, JFrame f, Inputs k) {
		super();
		p = new JPanel();
		

	}


	@Override
	public void updateState() {

			
			
	}

	@Override
	public void updateImage(Graphics g) {
		p.paint(g);
		g.drawImage(Images.instr, 0, 0, 960, 940,null);

	}
	
	@Override
	protected Tiles getTile(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

}
