
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import index.Main;
import gamePlay.level1;
import gamePlay.level2;


public class Car extends JPanel implements ActionListener {
	private static final long serialVersionUID = 6789461514097052926L;
	
	// level 1 car #1
	private static int car1XPos = -70, car1YPos = Main.GAME_HEIGHT - 491,
			carVel = 6;
	//level 1 car #2
	private static int car2XPos = Main.GAME_WIDTH,
			car2YPos = Main.GAME_HEIGHT - 175;
	//level 1 car #3
	private static int car3XPos = -280, car3YPos = Main.GAME_HEIGHT - 271;
	//level 1 car #4
	private static int car4XPos = Main.GAME_WIDTH + 350,
			car4YPos = Main.GAME_HEIGHT - 175;

	//level 2 car #5
	private static int car5XPos = 140, car5YPos = Main.GAME_HEIGHT - 130;
	//level 2 car #6
	private static int car6XPos = -70, car6YPos = Main.GAME_HEIGHT - 130;
	//level 2 car #7
	private static int car7XPos = 70, car7YPos = Main.GAME_HEIGHT - 280;
	//level 2 car #8
	private static int car8XPos = -140, car8YPos = Main.GAME_HEIGHT - 280;
	//level 2 car #9
	private static int car9XPos = Main.GAME_WIDTH - 70, car9YPos = Main.GAME_HEIGHT - 350;
	//level 2  car #10 
	private static int car10XPos = Main.GAME_WIDTH + 70, car10YPos = Main.GAME_HEIGHT - 350;
	//level 2  car #11 
	private static int car11XPos = Main.GAME_WIDTH + 210, car11YPos = Main.GAME_HEIGHT - 350;
	
	// setting speed of the cars in each lane of the game 
	private Timer carTimer = new Timer(25, this);
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// drawing the car graphics to the game
		ImageIcon car = new ImageIcon("images/car.png");
		if (Main.isLevel1Run()) {
			car.paintIcon(this, g, car1XPos, car1YPos);
			car.paintIcon(this, g, car2XPos, car2YPos);
			car.paintIcon(this, g, car3XPos, car3YPos);
			car.paintIcon(this, g, car4XPos, car4YPos); }
		else if (Main.isLevel2Run()) {
			car.paintIcon(this, g, car5XPos, car5YPos);
			car.paintIcon(this, g, car6XPos, car6YPos);
			car.paintIcon(this, g, car7XPos, car7YPos);
			car.paintIcon(this, g, car8XPos, car8YPos);
			car.paintIcon(this, g, car9XPos, car9YPos);
			car.paintIcon(this, g, car10XPos, car10YPos);
			car.paintIcon(this, g, car11XPos, car11YPos); }

		carTimer.start();
	}

	public void actionPerformed(ActionEvent e) {
		// car #1 collision with player
		if (getCar1XPos() < level1.getPlayerX() + 70
				&& getCar1XPos() + 140 > level1.getPlayerX()
				&& getCar1YPos() < level1.getPlayerY() + 70
				&& getCar1YPos() > level1.getPlayerY()) {
			level1.setGameOver(true);
			carTimer.stop();
		} else if (getCar1XPos() > Main.GAME_WIDTH) {
			setCar1XPos(-70);
		} else {
			setCar1XPos(getCar1XPos() + carVel);
		}

		// car #2 collision with player  
		if (getCar2XPos() < level1.getPlayerX() + 65
				&& getCar2XPos() + 65 > level1.getPlayerX()
				&& getCar2YPos() < level1.getPlayerY() + 65
				&& getCar2YPos() > level1.getPlayerY()) {
			level1.setGameOver(true);
			carTimer.stop();
		} else if (getCar2XPos() < -70) {
			setCar2XPos(Main.GAME_WIDTH);
		} else {
			setCar2XPos(getCar2XPos() - carVel);
		}

		// car #3 collision with player
		if (getCar3XPos() < level1.getPlayerX() + 130
				&& getCar3XPos() + 130 > level1.getPlayerX()
				&& getCar3YPos() < level1.getPlayerY() + 130
				&& getCar3YPos() > level1.getPlayerY()) {
			level1.setGameOver(true);
			carTimer.stop();
		} else if (getCar3XPos() > Main.GAME_WIDTH) {
			setCar3XPos(-70);
		} else {
			setCar3XPos(getCar3XPos() + carVel);
		}
		
	//  car #4 collision with player 
			if (getCar4XPos() < level1.getPlayerX() + 65
					&& getCar4XPos() + 65 > level1.getPlayerX()
					&& getCar4YPos() < level1.getPlayerY() + 65
					&& getCar4YPos() > level1.getPlayerY()) {
				level1.setGameOver(true);
				carTimer.stop();
			} else if (getCar4XPos() < -70) {
				setCar4XPos(Main.GAME_WIDTH);
			} else {
				setCar4XPos(getCar4XPos() - carVel);
			}
			
	// collision with player 
			if (car5XPos < level2.getPlayerX() + 65 && car5XPos + 65 > level2.getPlayerX()
					&& car5YPos < level2.getPlayerY() + 65 && car5YPos > level2.getPlayerY()) {
				level2.setGameOver(true);
				carTimer.stop();
			} else if (car5XPos > Main.GAME_WIDTH) {
				car5XPos = -70;
			} else {
				car5XPos += carVel;
			}
	// car #6 collision with player 
			if (car6XPos < level2.getPlayerX() + 65 && car6XPos + 65 > level2.getPlayerX()
					&& car6YPos < level2.getPlayerY() + 65 && car6YPos > level2.getPlayerY()) {
				level2.setGameOver(true);
				carTimer.stop();
			} else if (car6XPos > Main.GAME_WIDTH) {
				car6XPos = -70;
			} else {
				car6XPos += carVel;
			}
	// car #7 collision with player
			if (car7XPos < level2.getPlayerX() + 65 && car7XPos + 65 > level2.getPlayerX()
					&& car7YPos < level2.getPlayerY() + 65 && car7YPos > level2.getPlayerY()) {
				level2.setGameOver(true);
				carTimer.stop();
			} else if (car7XPos > Main.GAME_WIDTH) {
				car7XPos = -70;
			} else {
				car7XPos += carVel;
			}	
	// car #8 collision with player 
			if (car8XPos < level2.getPlayerX() + 65 && car8XPos + 65 > level2.getPlayerX()
					&& car8YPos < level2.getPlayerY() + 65 && car8YPos > level2.getPlayerY()) {
				level2.setGameOver(true);
				carTimer.stop();
			} else if (car8XPos > Main.GAME_WIDTH) {
				car8XPos = -70;
			} else {
				car8XPos += carVel;
			}
	// car #9 collision with player
			if (car9XPos < level2.getPlayerX() + 65 && car9XPos + 65 > level2.getPlayerX()
					&& car9YPos < level2.getPlayerY() + 65 && car9YPos > level2.getPlayerY()) {
				level2.setGameOver(true);
				carTimer.stop();
			} else if (car9XPos < -70) {
				car9XPos = Main.GAME_WIDTH;
			} else {
				car9XPos -= carVel;
			}
	// car #10 collision with player
			if (car10XPos < level2.getPlayerX() + 65 && car10XPos + 65 > level2.getPlayerX()
					&& car10YPos < level2.getPlayerY() + 65 && car10YPos > level2.getPlayerY()) {
				level2.setGameOver(true);
				carTimer.stop();
			} else if (car10XPos < -70) {
				car10XPos = Main.GAME_WIDTH;
			} else {
				car10XPos -= carVel;
			}
	// car #11 collision with player
			if (car11XPos < level2.getPlayerX() + 65 && car11XPos + 65 > level2.getPlayerX()
					&& car11YPos < level2.getPlayerY() + 65 && car11YPos > level2.getPlayerY()) {
				level2.setGameOver(true);
				carTimer.stop();
			} else if (car11XPos < -70) {
				car11XPos = Main.GAME_WIDTH;
			} else {
				car11XPos -= carVel;
			}

		carTimer.stop();
		repaint();
	}
	// getters and setters for call cars(#1 to #11) 4 methods per car
	public static int getCar1XPos() {
		return car1XPos;
	}

	public static void setCar1XPos(int car1XPos) {
		Car.car1XPos = car1XPos;
	}

	public static int getCar1YPos() {
		return car1YPos;
	}

	public static void setCar1YPos(int car1YPos) {
		Car.car1YPos = car1YPos;
	}

	public static int getCar2XPos() {
		return car2XPos;
	}

	public static void setCar2XPos(int car2xPos) {
		car2XPos = car2xPos;
	}

	public static int getCar2YPos() {
		return car2YPos;
	}

	public static void setCar2YPos(int car2yPos) {
		car2YPos = car2yPos;
	}

	public static int getCar3XPos() {
		return car3XPos;
	}

	public static void setCar3XPos(int car3xPos) {
		car3XPos = car3xPos;
	}

	public static int getCar3YPos() {
		return car3YPos;
	}

	public static void setCar3YPos(int car4yPos) {
		car4YPos = car4yPos;
	}
	
	public static int getCar4XPos() {
		return car4XPos;
	}

	public static void setCar4XPos(int car3xPos) {
		car4XPos = car3xPos;
	}

	public static int getCar4YPos() {
		return car4YPos;
	}

	public static void setCar4YPos(int car4yPos) {
		car4YPos = car4yPos;
	}
	public static int getCar5XPos() {
		return car5XPos;
	}

	public static void setCar5XPos(int car5xPos) {
		car5XPos = car5xPos;
	}

	public static int getCar5YPos() {
		return car5YPos;
	}

	public static void setCar5YPos(int car5yPos) {
		car5YPos = car5yPos;
	}


	public static int getCar6XPos() {
		return car6XPos;
	}

	public static void setCar6XPos(int car6xPos) {
		car6XPos = car6xPos;
	}

	public static int getCar6YPos() {
		return car6YPos;
	}

	public static void setCar6YPos(int car6yPos) {
		car6YPos = car6yPos;
	}

	public static int getCar7XPos() {
		return car7XPos;
	}

	public static void setCar7XPos(int car7xPos) {
		car7XPos = car7xPos;
	}

	public static int getCar7YPos() {
		return car7YPos;
	}

	public static void setCar7YPos(int car7yPos) {
		car7YPos = car7yPos;
	}

	public static int getCar8XPos() {
		return car8XPos;
	}

	public static void setCar8XPos(int car8xPos) {
		car8XPos = car8xPos;
	}

	public static int getCar8YPos() {
		return car8YPos;
	}

	public static void setCar8YPos(int car8yPos) {
		car8YPos = car8yPos;
	}

	public static int getCar9XPos() {
		return car9XPos;
	}

	public static void setCar9XPos(int car9xPos) {
		car9XPos = car9xPos;
	}

	public static int getCar9YPos() {
		return car9YPos;
	}

	public static void setCar9YPos(int car9yPos) {
		car9YPos = car9yPos;
	}

	public static int getCar10XPos() {
		return car10XPos;
	}

	public static void setCar10XPos(int car10xPos) {
		car10XPos = car10xPos;
	}

	public static int getCar10YPos() {
		return car10YPos;
	}

	public static void setCar10YPos(int car10yPos) {
		car10YPos = car10yPos;
	}

	public static int getCar11XPos() {
		return car11XPos;
	}

	public static void setCar11XPos(int car11xPos) {
		car11XPos = car11xPos;
	}

	public static int getCar11YPos() {
		return car11YPos;
	}
	public static void setCar11YPos(int car11yPos) {
		car11YPos = car11yPos;
	}
		
	

}