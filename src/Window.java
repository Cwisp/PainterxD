import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Window extends JFrame {
	
	private BufferStrategy strategy;
	private Player p;
	private Map map;
	private ArrayList<Enemy> enemies;
	
	private int width;
	private int height;
	
	private int rbX, rbY, rbWidth, rbHeight;
	private int sbX, sbY, sbWidth, sbHeight;
		
	public Window(int x, int y) {
		setLayout(null);
		width = x;
		height = y;
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Paint the Bruin Bear xD");
		
		Toolkit tk = Toolkit.getDefaultToolkit();

		Dimension screenDim = tk.getScreenSize();

		int xPos = (screenDim.width / 2) - (this.getWidth() / 2);
		int yPos = (screenDim.height / 2) - (this.getHeight() / 2);
		
		setLocation(xPos, yPos);
		setIgnoreRepaint(true);
		setVisible(true);
		
		createBufferStrategy(2);
		strategy = getBufferStrategy();
		
		addKeyListener(new PlayerKeyListener());
		addMouseListener(new Mouse());
	}
	
	public void setMap(Map map) {
		this.map = map;
	}
	
	public void setPlayer(Player p) {
		this.p = p;
	}
	
	public void setEnemies(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
	}
	
	public void draw() {
		Graphics g = strategy.getDrawGraphics();
		
		map.draw(g);
		g.drawImage(p.getImg().getImg(), p.getX(), p.getY(), null);
		for (Enemy enemy : enemies) {
			enemy.draw(g);
		}
		
		drawScore(g);
		drawLives(g);
		
		if (!Main.inGame) {
			drawRestart(g);
			drawHighscore(g);
		}
		
		g.dispose();
		strategy.show();
	}
	
	public void drawHome() {
		Graphics g = strategy.getDrawGraphics();
		
		BufferedImage home = null;
		try {
			home = ImageIO.read(new File("assets/homescreen.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(home, 0, 0, null);
		
		BufferedImage start = null;
		try {
			start = ImageIO.read(new File("assets/startbutton.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		sbWidth = start.getWidth();
		sbHeight = start.getHeight();
		sbX = width/2 - sbWidth/2-100;
		sbY = 100;//height/2 - sbHeight/2 + 75;
		g.drawImage(start, sbX, sbY, null);
		
		g.dispose();
		strategy.show();
	}
	
	public void drawScore(Graphics g) {
		BufferedImage scoretext = null;
		try {
			scoretext = ImageIO.read(new File("assets/scoretext.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(scoretext, 20, 50, null);
		int score = Main.score;
		int length = (int)(Math.log10(score))+1;
		for (int i = length-1; i >= 0; i--) {
			int digit = score % 10;
			score /= 10;
			int xcoord = 120 + i * 20;
			BufferedImage img = null;
			try {
				img = ImageIO.read(new File("assets/num" + digit + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			g.drawImage(img, xcoord, 50, null);
		}
	}
	
	public void drawLives(Graphics g) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("assets/hearthand.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < Main.lives; i++) {
			g.drawImage(img, 290+i*30, 50, null);
		}
	}
	
	public void drawRestart(Graphics g) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("assets/restartbutton.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		rbWidth = img.getWidth();
		rbHeight = img.getHeight();
		rbX = width/2 - rbWidth/2;
		rbY = height/2 - rbHeight/2;
		g.drawImage(img, rbX, rbY, null);
	}
	
	public void drawHighscore(Graphics g) {
		BufferedImage scoretext = null;
		try {
			scoretext = ImageIO.read(new File("assets/highscoretext.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(scoretext, width/2 - scoretext.getWidth()/2, 150, null);
		int score = Main.highScore;
		int length = (int)(Math.log10(score))+1;
		int startxcord = width/2 - (length*10);
		for (int i = length-1; i >= 0; i--) {
			int digit = score % 10;
			score /= 10;
			int xcoord = startxcord + i * 20;
			BufferedImage img = null;
			try {
				img = ImageIO.read(new File("assets/num" + digit + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			g.drawImage(img, xcoord, 200, null);
		}
	}
	
	private class PlayerKeyListener implements KeyListener {

		public void keyPressed(KeyEvent arg0) {
			int keyCode = arg0.getKeyCode();
			switch (keyCode) {
			case KeyEvent.VK_UP:
				break;
			case KeyEvent.VK_DOWN:
				break;
			case KeyEvent.VK_LEFT:
				if (p.getX() >= 10) {
					p.setX(p.getX() - 30);
				}
				break;
			case KeyEvent.VK_RIGHT:
				if (p.getX()+p.getImg().getImg().getWidth() <= (width - 10)) {
					p.setX(p.getX() + 30);
				}
				break;
			}
		}

		public void keyReleased(KeyEvent arg0) {

		}

		public void keyTyped(KeyEvent arg0) {

		}
	}
	
	private class Mouse implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			int x = arg0.getX();
			int y = arg0.getY();
			if (Main.onHome) {
				if (x > sbX && x < sbX + sbWidth && y > sbY && y < sbY + sbHeight) {
					Main.onHome = false;
					Main.inGame = true;
				}
			} else if (!Main.inGame) {
				if (x > rbX && x < rbX + rbWidth && y > rbY && y < rbY + rbHeight) {
					Main.inGame = true;
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
