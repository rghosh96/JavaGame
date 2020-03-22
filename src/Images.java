import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {
	
	public static Image player;
	public static Image enemy;
	public static Image grass;
	public static Image tree;
	public static Image flowers;
	public static Image water;
	public static Image cloud;
	public static Image collect;
	public static Image bullets;
	public static Image planet;
	public static Image portal;
	public static Image instr;
	public static Image boss;
	
	public static void init() {
        try {
            player = ImageIO.read(new File("player.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            enemy = ImageIO.read(new File("bad.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            grass = ImageIO.read(new File("floor.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
 

        
        try {
            flowers = ImageIO.read(new File("stars.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            water = ImageIO.read(new File("water.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        try {
            bullets = ImageIO.read(new File("ammo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            planet = ImageIO.read(new File("planet.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            collect = ImageIO.read(new File("collect.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            cloud = ImageIO.read(new File("cloud.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            portal = ImageIO.read(new File("portal.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            instr = ImageIO.read(new File("instructions.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            boss
            = ImageIO.read(new File("boss.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        
	}

}
