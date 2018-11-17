import java.util.ArrayList;

public class Player {

	private int posX;
	private int posY;
	
	public Player() {
		
	}
	
	public int getX() {
		return posX;
	}
	
	public int getY() {
		return posY;
	}
	
	public boolean checkCollisions(ArrayList<Enemy> enemies) {
		return false;
	}
	
	//key listener
	//updates position
}
