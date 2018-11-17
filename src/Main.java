import java.util.ArrayList;

public class Main {

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
		window.setPlayer(p);
		
		inGame = true;
		gameLoop();
	}
	

	public static void gameLoop() {
		long time = System.currentTimeMillis();
		long spawntimer = System.currentTimeMillis();
		while (inGame) {
			if (System.currentTimeMillis() - spawntimer >= 300) {
				spawntimer = System.currentTimeMillis();
				System.out.println("spawn!");
				//spawn
			}
			if (System.currentTimeMillis() - time >= 5) {
				time = System.currentTimeMillis();
				//update enemies
				//window does player movement listener
				//spawn enemies
				//check for collisions
				window.draw();
			}
		}
		window.setVisible(false);
		window.dispose();
	}
}
