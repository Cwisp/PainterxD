import java.util.ArrayList;

public class Player {

	private int posX, posY, width, height;
	private Img img;
	
	public Player() {
		img = new Img("assets/bear.png", 0, 0);
		posX = 200-img.getImg().getWidth()/2;
		img.setX(posX);
		posY = 600-img.getImg().getHeight();
		img.setY(posY);
		width = img.getImg().getWidth();
	}
	
	public int getX() {
		return posX;
	}
	
	public int getY() {
		return posY;
	}
	
	public void setX(int x) {
		this.posX = x;
	}
	
	public void setY(int y) {
		this.posY = y;
	}
	
	public Img getImg() {
		return img;
	}
	
	public void update() {
		
	}
	
	public boolean checkCollisions(ArrayList<Enemy> enemies) {
		for (int i = 0; i < enemies.size(); i++) {
			if (enemies.get(i).getY() > posY + enemies.get(i).getHeight() && ((enemies.get(i).getX() > posX && enemies.get(i).getX() < posX + width) || (enemies.get(i).getX() > posX - enemies.get(i).getWidth() && enemies.get(i).getX() < posX)))
				return true;	
		}

		return false;
	}
	
	//key listener
	//updates position
}
