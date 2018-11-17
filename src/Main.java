import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;

public class Main {

	public static ArrayList<Enemy> enemies;
	
	public static boolean inGame = false;
	
	//screen dimensions
	public static final int width = 400;
	public static final int height = 600;
	
	public static Map map;
		
	public static void main(String[] args) {
		Window window = new Window(width, height);
		
		JPanel panel = new JPanel();
		
		panel.setLayout(null);
		panel.setBounds(0, 0, window.getWidth(), window.getHeight());
		window.add(panel);
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("src/trojanbox2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Graphics g = panel.getGraphics();
//		int x = 0;
//		int y = 0;
//		long time = 0;
//		while(true) {
//			if (System.currentTimeMillis() - time >= 100) {
//				g.clearRect(0, 0, panel.getWidth(), panel.getHeight());
//				time = System.currentTimeMillis();
//				g.drawImage(myPicture, x, y, null);
//				x+=10;
//				y+=10;
//			}	
//		}
		
		map = new Map();
//		inGame = true;
//		gameLoop();
	}
	

	public static void gameLoop() {
		while (inGame) {
			map.update();
			//update map: map will scroll down
			//update enemies: projectiles will also scroll down 
			//update player location to location in player class
			//at set time intervals, will spawn another enemy
			//check collisions
			
		}
	}
}
