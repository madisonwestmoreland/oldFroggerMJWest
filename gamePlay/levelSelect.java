import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controls.keyMovement;
import controls.mouseMovement;

public class levelSelect extends JPanel {
			private static final long serialVersionUID = -113642311095723222L;
			
			private ImageIcon selectIcon;
			
				public levelSelect() {
					addMouseListener(new mouseMovement()); // for mouse clicks
					addKeyListener(new keyMovement()); // for key clicks
					setFocusable(true); // allows keyboard input on the board
					loadMenu(); // loads all object images
				}
				
				private void loadMenu() {
					selectIcon = new ImageIcon("images/LevelSelection.png");
				}
				
				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					// drawing background
					selectIcon.paintIcon(this, g, 0, 0);
					
					// drawing clickable boxes
					Color myColour = new Color(255, 0, 0, 0);
					g.setColor(myColour);
					g.fillRect(150, 120, 220, 380);
					g.fillRect(430, 120, 220, 380);
				}
		}


