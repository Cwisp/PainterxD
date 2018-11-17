import java.util.ArrayList;

public class Player {

	private int posX, posY, width, height;
	
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
			if (enemies.get(i).getY() < posY + enemies.get(i).getHeight() && ((enemies.get(i).getX() > posX && enemies.get(i).getX() < posX + width) || (enemies.get(i).getX() > posX - enemies.get(i).getWidth() && enemies.get(i).getX() < posX)))		//only if left and right movement only, might need to change operators to <= etc
				return true;	
		}
		//if any are inside, player dies, game ends
		return false;
	}
	
	//key listener
	//updates position
}
