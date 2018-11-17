import java.awt.Graphics;
import java.awt.event.*;

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
		addKeyListener(new PlayerKeyListener());
		p = new Player();
	}

	public void draw() {
		Graphics g = this.getGraphics();
		g.drawImage(p.getImg().getImg(), p.getX(), p.getY(), null);
	}

	private class PlayerKeyListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
			int keyCode = arg0.getKeyCode();
			switch (keyCode) {
			case KeyEvent.VK_UP:
				break;
			case KeyEvent.VK_DOWN:
				break;
			case KeyEvent.VK_LEFT:
				if (p.getX() >= 10) {
					p.setX(p.getX() - 10);
				}
				System.out.println("left");
				break;
			case KeyEvent.VK_RIGHT:
				if (p.getX() <= width - 10) {
					p.setX(p.getX() + 10);
				}
				System.out.println("right");
				// handle right
				break;
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {

		}

		@Override
		public void keyTyped(KeyEvent arg0) {

		}
	}
}
