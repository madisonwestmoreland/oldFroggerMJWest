import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controls.keyMovement;
import controls.mouseMovement;

public class menu extends JPanel {
private static final long serialVersionUID = -646549002494383003L;
	
	private ImageIcon menuIcon;
	
		public menu() {
			addMouseListener(new mouseMovement()); // for mouse movements
			addKeyListener(new keyMovement()); // for key movements
			setFocusable(true); // allows keys to be used on board
			loadMenu(); // loads all object images
		}
		
		private void loadMenu() {
			menuIcon = new ImageIcon("images/mainmenu.png");
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			// drawing background
			menuIcon.paintIcon(this, g, 0, 0);
			
			// drawing selectable boxes in menu 
			Color myColour = new Color(255, 0, 0, 0);
			g.setColor(myColour);
			g.fillRect(130, 210, 550, 100);
			g.fillRect(130, 330, 560, 100);
			g.fillRect(310, 450, 200, 100);
		}

}
