import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {

	public static boolean inGame = false;
	
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
		System.out.println(myPicture.getHeight());
		JLabel img = new JLabel(new ImageIcon(myPicture));
		
		panel.add(img);
		
		window.add(panel);
		
		
//		inGame = true;
//		gameLoop();
	}

	public static void gameLoop() {
		while (inGame) {
			
		}
	}
}
