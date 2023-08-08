import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
// loads board for each level
public class screenGraphics extends JPanel {
	private static final long serialVersionUID = 365819059906688378L;
	private ImageIcon loadingIcon = new ImageIcon("images/loading.png");
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		
		loadingIcon.paintIcon(this, g, 0, 0);
	}
}