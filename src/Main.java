import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Main {

	public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();

	public static boolean inGame = false;

	// screen dimensions
	public static final int width = 400;
	public static final int height = 600;

	public static Window window;
	public static Map map;
	public static Player p;
	
	public static JPanel livespanel;
	public static int lives = 3;
	public static int highScore = 0;
	public static int score = 0;

	public static void main(String[] args) {
		window = new Window(width, height);
		livespanel = new JPanel();
		livespanel.setLayout(null);
		livespanel.setBounds(0,0,width,200);
		window.add(livespanel);
		inGame = true;
		while (true) {
			map = new Map();
			window.setMap(map);

			p = new Player();
			window.setPlayer(p);

			window.setEnemies(enemies);
			
			if (inGame) {
				gameLoop();
			}
		}
	}

	public static void gameLoop() {
		long time = System.currentTimeMillis();
		long spawntimer = System.currentTimeMillis();
		while (inGame) {
			if (System.currentTimeMillis() - spawntimer >= 500) {
				spawntimer = System.currentTimeMillis();
				enemies.add(new Enemy("assets/yellowpaint.png"));
			}
			if (System.currentTimeMillis() - time >= 5) {
				score++;
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
					lives--;
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
