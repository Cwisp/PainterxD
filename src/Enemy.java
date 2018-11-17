
public class Enemy {

	private int posX, posY, width, height;
	private Img img;
	
	public Enemy(String filename) {
		img = new Img(filename, 0, 0);
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
	
}
