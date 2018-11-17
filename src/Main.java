import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Graphics2D;

public class Main {

	public static ArrayList<Enemy> enemies;
	
	public static boolean inGame = false;
	
	private static Graphics2D g2;
	
	public static void main(String[] args) {
		Window window = new Window(600,600);
		
		JPanel panel = new JPanel();
		
		panel.setLayout(null);
		panel.setBounds(0, 0, window.getWidth(), window.getHeight());
		
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("src/trojanbox.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JLabel img = new JLabel();
		panel.add(img);
		g2 = (Graphics2D) img.getGraphics();
		if(myPicture!= null) {
			g2.drawImage(myPicture, 0, 0, null);
		}
		
		window.add(panel);
		
		
//		inGame = true;
//		gameLoop();
	}

	public static void gameLoop() {
		while (inGame) {
			//update map: map will scroll down
			//update enemies: projectiles will also scroll down 
			//update player location to location in player class
			//at set time intervals, will spawn another enemy
			//check collisions
			
		}
	}
}
