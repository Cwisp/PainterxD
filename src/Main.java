import java.util.ArrayList;

public class Main {
	//hi albert
	public static ArrayList<Enemy> enemies;
	
	public static boolean inGame = false;
	
	//screen dimensions
	public static final int width = 400;
	public static final int height = 600;
	
	public static Window window;
	public static Map map;
		
	public static void main(String[] args) {
		window = new Window(width, height);
		
		map = new Map();
		window.setMap(map);
		
		Player p = new Player();
		
		//ppanel = new PlayerPanel();
		//window.add(ppanel);
		//Player player = new Player();
		
		inGame = true;
		gameLoop();
	}
	

	public static void gameLoop() {
		long time = System.currentTimeMillis();
		while (inGame) {
			if (System.currentTimeMillis() - time >= 5) {
				time = System.currentTimeMillis();
				window.draw();
				//update map: map will scroll down
				//update enemies: projectiles will also scroll down 
				//update player location to location in player class
				//at set time intervals, will spawn another enemy
				//check collisions
			}
		}
	}
}
