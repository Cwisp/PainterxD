import java.awt.Graphics;
import java.util.ArrayList;

public class Map {
	
	private int width;
	private int height;
	
	private ArrayList<Img> imgs = new ArrayList<Img>();
	private int scrollSpeed = 1;
			
	public Map() {
		width = 400;
		height = 600;
		
		imgs.add(new Img("assets/red200x400.png", 0, -200));
		imgs.add(new Img("assets/blue200x400.png", 0, 0));
		imgs.add(new Img("assets/green200x400.png", 0, 200));
		imgs.add(new Img("assets/red200x400.png", 0, 400));
	}
	
	public void update() {
		for (int i = imgs.size()-1; i >= 0; i--) {
			imgs.get(i).setY(imgs.get(i).getY()+scrollSpeed);
			if (imgs.get(i).getY() > height) {
				imgs.remove(i);
			}	
		}
		if (imgs.size() < 4) {
			add();
		}
	}
	
	public void draw(Graphics g) {
		for (int i = 0; i < imgs.size(); i++) {
			g.drawImage(imgs.get(i).getImg(), imgs.get(i).getX(), imgs.get(i).getY(), null);
		}
	}
	
	public void add() {
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
}
