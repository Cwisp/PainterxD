import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {

	public static boolean inGame = false;
	
	public static void main(String[] args) {
		Window window = new Window(400,400);
		
		JPanel panel = new JPanel();
		
		panel.setLayout(null);
		panel.setBounds(0, 0, window.getWidth(), window.getHeight());
		
		JLabel img = new JLabel(new ImageIcon("trojanbox.png"));
		
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
