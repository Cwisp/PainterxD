import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {

	public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();

	public static boolean inGame = false;
	public static boolean onHome = true;

	// screen dimensions
	public static final int width = 400;
	public static final int height = 600;

	public static Window window;
	public static Map map;
	public static Player p;
	
	public static int lives = 3;
	public static int highScore = 0;
	public static int score = 0;
	
	//public static JPanel panel;

	public static void main(String[] args) {
		window = new Window(width, height);
		map = new Map();
		window.setMap(map);

		p = new Player();
		window.setPlayer(p);

		window.setEnemies(enemies);
		
		while(onHome) {
			window.drawHome();
		}
		
		inGame = true;
		while (true) {
			if (!inGame) {
				window.draw();
			}
			
			if (inGame) {
				map = new Map();
				window.setMap(map);

				p = new Player();
				window.setPlayer(p);

				enemies.clear();
				window.setEnemies(enemies);
				
				lives = 3;
				score = 0;
				gameLoop();
			}
		}
	}

	public static void gameLoop() {
		long time = System.currentTimeMillis();
		long spawntimer = System.currentTimeMillis();
		long scoretimer = System.currentTimeMillis();
		while (inGame) {
			if (System.currentTimeMillis() - spawntimer >= 500) {
				spawntimer = System.currentTimeMillis();
				int i = (int)(Math.random() * 20);
				if (i < 9) {
					enemies.add(new Enemy("assets/yellowpaint.png", true));
				} else if (i < 18) {
					enemies.add(new Enemy("assets/redpaint.png", true));
				} else {
					enemies.add(new Enemy("assets/trojan.png", false));
				}
			}
			if (System.currentTimeMillis() - scoretimer >= 50) {
				scoretimer = System.currentTimeMillis();
				score++;
			}
			if (System.currentTimeMillis() - time >= 5) {
				time = System.currentTimeMillis();
				map.update();
				for (int i = enemies.size() - 1; i >= 0; i--) {
					enemies.get(i).update();
					if (enemies.get(i).getY() >= 600) {
						enemies.remove(i);
					}
				}
				int i = p.checkCollisions(enemies);
				if (i != -1) {
					if (enemies.get(i).getBad()) {
						lives--;
					} else if (lives < 3) {
						lives++;
					}
					enemies.remove(i);
				}
				if (lives <= 0) {
					inGame = false;
				}

				window.draw();
				
				if (score > highScore)
					highScore = score;
			}
		}
	}
}
