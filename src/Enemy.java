import java.awt.Graphics;

public class Enemy {

	private int posX, posY, width, height;
	private Img img;
	private int moveSpeed;
	private boolean bad;
	
	public Enemy(String filename, boolean goodbad) {
		img = new Img(filename, 0, 0);
		posX = (int) (Math.random() * 340 + 30);
		posY = 0;
		width = img.getImg().getWidth();
		height = img.getImg().getHeight();
		//System.out.println(img.getImg().getWidth());
		moveSpeed = 2;
		bad = goodbad;
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
	
	public boolean getBad() {
		return bad;
	}
}
