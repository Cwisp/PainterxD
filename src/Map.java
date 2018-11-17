import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Map extends JPanel {
	
	private int width;
	private int height;
	
	private ArrayList<Img> imgs = new ArrayList<Img>();
	private int scrollSpeed = 1;
	
	private Player p;
	
	public Map() {
		width = 400;
		height = 600;
		setLayout(null);
		setBounds(0, 0, width, height);
		setOpaque(false);
		setFocusable(true);
		addKeyListener(new PlayerKeyListener());
		imgs.add(new Img("assets/red200x400.png", 0, -200));
		imgs.add(new Img("assets/blue200x400.png", 0, 0));
		imgs.add(new Img("assets/green200x400.png", 0, 200));
		imgs.add(new Img("assets/red200x400.png", 0, 400));
		p = new Player();
	}
	
	void update() {
		Graphics g = getGraphics();
		g.clearRect(0, 0, 400, 600);
		for (int i = imgs.size()-1; i >= 0; i--) {
			imgs.get(i).setY(imgs.get(i).getY()+scrollSpeed);
			if (imgs.get(i).getY() > height) {
				imgs.remove(i);
			} else {
				g.drawImage(imgs.get(i).getImg(), imgs.get(i).getX(), imgs.get(i).getY(), null);
			}	
		}
		if (imgs.size() < 4) {
			add();
		}
		g.drawImage(p.getImg().getImg(), p.getX(), p.getY(), null);
	}
	
	void add() {
		int rand = (int)(Math.random() * 3); 
		String filename = "";
		if (rand == 0) {
			filename = "assets/red200x400.png";
		} else if (rand == 1) {
			filename = "assets/green200x400.png";
		} else if (rand == 2) {
			filename = "assets/blue200x400.png";
		}
		imgs.add(0, new Img(filename, 0, imgs.get(0).getY()-200));
	}
	
	public int getScrollSpeed() {
		return scrollSpeed;
	}
	
	private class PlayerKeyListener implements KeyListener {

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
				if (p.getX()+p.getImg().getImg().getWidth() <= (width - 10)) {
					p.setX(p.getX() + 10);
				}
				System.out.println(p.getX() + "right");
				// handle right
				break;
			}
		}

		public void keyReleased(KeyEvent arg0) {

		}

		public void keyTyped(KeyEvent arg0) {

		}
	}
}
