import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Window extends JFrame {
	public Window(int x, int y) {
		setLayout(null);
		setSize(x, y);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Dots and Boxes");
		
		Toolkit tk = Toolkit.getDefaultToolkit();

		Dimension screenDim = tk.getScreenSize();

		int xPos = (screenDim.width / 2) - (this.getWidth() / 2);
		int yPos = (screenDim.height / 2) - (this.getHeight() / 2);
		
		setLocation(xPos, yPos);
		setVisible(true);
	}
}
