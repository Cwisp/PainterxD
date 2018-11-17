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
		for (int i = 0; i < enemies.size(); i++) {
			enemies[i].getX();
		}
		//if any are inside, player dies, game ends
		return false;
	}
	
	//key listener
	//updates position
}
