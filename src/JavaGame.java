import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class JavaGame extends JFrame implements ActionListener{
	Game gameLoop;
	JavaGame() {
	Inputs keys = new Inputs();
	

	
	addKeyListener(keys);
	gameLoop = new Game(keys, this);
	setSize(960, 960);
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	add(gameLoop);
	setLocationRelativeTo(null);
	setVisible(true);
	
	JMenuBar jmb = new JMenuBar();
	setJMenuBar(jmb);
	JMenu menu = new JMenu("[alterverse menu]");
	jmb.add(menu);
	
	JMenuItem main = new JMenuItem("Menu");
	JMenuItem resume = new JMenuItem("Resume Game");
	JMenuItem save = new JMenuItem("Save Game");
	JMenuItem load = new JMenuItem("Load Game");
	JMenuItem pause = new JMenuItem("Pause Game");
	JMenuItem exit = new JMenuItem("Exit Game");
	JMenuItem instructions = new JMenuItem("Game Instructions");
	menu.add(main);
	menu.add(resume);
	menu.add(pause);
	menu.add(exit);
	menu.add(instructions);
	menu.add(save);
	menu.add(load);
	
	pause.addActionListener(this);
	pause.setActionCommand("pause");
	exit.addActionListener(this);
	exit.setActionCommand("exit");
	instructions.addActionListener(this);
	instructions.setActionCommand("instructions");
	main.addActionListener(this);
	main.setActionCommand("main");
	resume.addActionListener(this);
	resume.setActionCommand("resume");
	}
	



	public static void main(String[] args) {
		
		JFrame frame = new JavaGame();
		
//		pause.addActionListener(m);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "pause" ) {
			MenuOptions.setOption(gameLoop.pauseState);
			MenuOptions.music.stopMusic();
			MenuOptions.music.setSong("#3.wav");
			MenuOptions.music.startMusic();
		}
		if (e.getActionCommand() == "exit" ) {
			this.dispose();
		}
		if (e.getActionCommand() == "instructions" ) {
			MenuOptions.setOption(gameLoop.instrState);
			MenuOptions.music.stopMusic();
			MenuOptions.music.setSong("#3.wav");
			MenuOptions.music.startMusic();
		}
		if (e.getActionCommand() == "main" ) {
			MenuOptions.setOption(gameLoop.menuState);
			MenuOptions.music.stopMusic();
			MenuOptions.music.setSong("#1.wav");
			MenuOptions.music.startMusic();
		}
		if (e.getActionCommand() == "resume" ) {
			MenuOptions.setOption(gameLoop.gameState);
			MenuOptions.music.stopMusic();
			MenuOptions.music.setSong("#2.wav");
			MenuOptions.music.startMusic();
		}
	}
}
	
	

