import java.awt.Graphics;

public class Enemy {

	private int posX, posY, width, height;
	private Img img;
	private int moveSpeed;
	
	public Enemy(String filename) {
		img = new Img(filename, 0, 0);
		posX = (int) (Math.random() * 400);
		posY = 0;
		moveSpeed = 2;
	}
	
	public void update() {
		posY += moveSpeed;
	}
	
	public void draw(Graphics g) {
		g.drawImage(img.getImg(), posX, posY, null);
	}
	
	public int getX() {
		return posX; 
	}
	
	public int getY() {
		return posY;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getMoveSpeed() {
		return moveSpeed;
	}
}
