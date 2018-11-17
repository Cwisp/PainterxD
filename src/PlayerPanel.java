import java.awt.Graphics;

import javax.swing.JPanel;

public class PlayerPanel extends JPanel {

	private int width;
	private int height;
	private Player p;
	
	public PlayerPanel() {
		width = 400;
		height = 600;
		setLayout(null);
		setBounds(0, 0, width, height);
		setOpaque(false);
		
		p = new Player();
	}
	
	public void draw() {
		Graphics g = getGraphics();
		g.drawImage(p.getImg().getImg(), p.getX(), p.getY(), null);
	}
	
}
