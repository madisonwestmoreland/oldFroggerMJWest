import java.awt.Graphics;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.ImageIcon;
	import javax.swing.JPanel;
	import javax.swing.Timer;


import index.Main;
import gamePlay.level1;
import gamePlay.level2;
	// creating truck object
	public class Truck extends JPanel implements ActionListener {
		private static final long serialVersionUID = 6789461514097052926L;

		//level 1 truck #1
		private static int truck1XPos = Main.GAME_WIDTH, truck1YPos = Main.GAME_HEIGHT - 412,
				truckVel = - 6;
		//level truck #2
		private static int truck2XPos = Main.GAME_WIDTH + 280,
				truck2YPos = Main.GAME_HEIGHT - 412;
		//level 2 truck #3
		private static int truck3XPos = Main.GAME_WIDTH, truck3YPos = Main.GAME_HEIGHT - 420;
		//level 2 truck #4
		private static int truck4XPos = Main.GAME_WIDTH + 70, truck4YPos = Main.GAME_HEIGHT - 490;
		//level 2 truck #5
		private static int truck5XPos = -70, truck5YPos = Main.GAME_HEIGHT - 210;
		
		private Timer truckTimer = new Timer(25, this);

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			// drawing the truck graphica to the game
			ImageIcon truck = new ImageIcon("images/truck.png");
			if (Main.isLevel1Run()) {
				truck.paintIcon(this, g, truck1XPos, truck1YPos);
				truck.paintIcon(this, g, getTruck2XPos(), getTruck2YPos()); }
			else if (Main.isLevel2Run()) {
				truck.paintIcon(this, g, truck3XPos, truck3YPos);
				truck.paintIcon(this, g, getTruck4XPos(), getTruck4YPos());
				truck.paintIcon(this, g, getTruck5XPos(), getTruck5YPos());
				
			}

			truckTimer.start();
		}

		public void actionPerformed(ActionEvent e) {
			// truck #1 collision with player 
			if (getTruck1XPos() < level1.getPlayerX() + 65
					&& getTruck1XPos() + 140 > level1.getPlayerX()
					&& getTruck1YPos() < level1.getPlayerY() + 65
					&& getTruck1YPos() > level1.getPlayerY()) {
				level1.setGameOver(true);
				truckTimer.stop();
			} else if (getTruck1XPos() < -140) {
				setTruck1XPos(Main.GAME_WIDTH);
			} else {
				setTruck1XPos(getTruck1XPos() + truckVel);
			}

			// truck #2 collision with player
			if (getTruck2XPos() < level1.getPlayerX() + 65
					&& getTruck2XPos() + 130 > level1.getPlayerX()
					&& getTruck2YPos() < level1.getPlayerY() + 65
					&& getTruck2YPos() > level1.getPlayerY()) {
				level1.setGameOver(true);
				truckTimer.stop();
			} else if (getTruck2XPos() < -140) {
				setTruck2XPos(Main.GAME_WIDTH);
			} else {
				setTruck2XPos(getTruck2XPos() + truckVel);
			}
			// truck #3 collision with player 
			if (getTruck3XPos() < level2.getPlayerX() + 70 && getTruck3XPos() + 140 > level2.getPlayerX()
					&& getTruck3YPos() < level2.getPlayerY() + 70 && getTruck3YPos() > level2.getPlayerY()) {
				level2.setGameOver(true);
				truckTimer.stop();
			} else if (getTruck3XPos() < -140) {
				setTruck3XPos(Main.GAME_WIDTH);
			} else {
				setTruck3XPos(getTruck3XPos() + truckVel);
			}
			// truck #4 collision with player 
			if (getTruck4XPos() < level2.getPlayerX() + 70 && getTruck4XPos() + 140 > level2.getPlayerX()
					&& getTruck4YPos() < level2.getPlayerY() + 70 && getTruck4YPos() > level2.getPlayerY()) {
				level2.setGameOver(true);
				truckTimer.stop();
			} else if (getTruck4XPos() < -140) {
				setTruck4XPos(Main.GAME_WIDTH);
			} else {
				setTruck4XPos(getTruck4XPos() + truckVel);
			}
			// truck #5 collision with player
			if (getTruck5XPos() < level2.getPlayerX() + 65 && getTruck5XPos() + 65 > level2.getPlayerX()
					&& getTruck5YPos() < level2.getPlayerY() + 65 && getTruck5YPos() > level2.getPlayerY()) {
				level2.setGameOver(true);
				truckTimer.stop();
			} 
			else if (getTruck5XPos() < -140) {
				setTruck5XPos(Main.GAME_WIDTH);
			} else {
				setTruck5XPos(getTruck5XPos() + truckVel);
		}
				
			

			truckTimer.stop();
			repaint();
		}
		//getters and setters for all trucks (#1to #5) 4 methods per truck
		public static int getTruck1XPos() {
			return truck1XPos;
		}

		public static void setTruck1XPos(int truck1XPos) {
			Truck.truck1XPos = truck1XPos;
		}

		public static int getTruck1YPos() {
			return truck1YPos;
		}

		public static void setTruck1YPos(int truck1YPos) {
			Truck.truck1YPos = truck1YPos;
		}

		public static int getTruck2XPos() {
			return truck2XPos;
		}

		public static void setTruck2XPos(int truck2XPos) {
			Truck.truck2XPos = truck2XPos;
		}

		public static int getTruck2YPos() {
			return truck2YPos;
		}

		public static void setTruck2YPos(int truck2YPos) {
			Truck.truck2YPos = truck2YPos;
		}
		public static int getTruck3XPos() {
			return truck3XPos;
		}

		public static void setTruck3XPos(int truck3XPos) {
			Truck.truck3XPos = truck3XPos;
		}

		public static int getTruck3YPos() {
			return truck3YPos;
		}

		public static void setTruck3YPos(int truck3YPos) {
			Truck.truck3YPos = truck3YPos;
		}

		public static int getTruck4XPos() {
			return truck4XPos;
		}

		public static void setTruck4XPos(int truck4xPos) {
			truck4XPos = truck4xPos;
		}

		public static int getTruck4YPos() {
			return truck4YPos;
		}

		public static void setTruck4YPos(int truck4yPos) {
			truck4YPos = truck4yPos; 
		}
		public static int getTruck5XPos() {
			return truck5XPos;
		}

		public static void setTruck5XPos(int truck5xPos) {
			truck5XPos = truck5xPos;
		}

		public static int getTruck5YPos() {
			return truck5YPos;
		}

		public static void setTruck5YPos(int truck5yPos) {
			truck5YPos = truck5yPos; 
		}

	}