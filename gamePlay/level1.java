import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import controls.keyMovement;
import index.Main;
import index.Score;
import gameObjects.Car;
import gameObjects.Truck;

public class level1 extends JPanel implements ActionListener {
	private static final long serialVersionUID = 7704761091317274700L;

	// stationary object icons
	private ImageIcon backgroundIcon, playerIcon, lily1, lily2, lily3;

	// variables used to animate player
	private static String playerIconPath = "images/playerstillup.png";
	private static int playerX = 210, playerY = Main.GAME_HEIGHT - 117, score = 2500;
	private static String strScore = String.valueOf(score);

	// gameover  booleans
	private static boolean gameOver = false;

	// game timer/score
	private static Timer gameTimer;

	// loading mobile objects
	private Car car = new Car();
	private Truck truck = new Truck();

	
	 //loading in board,starts game timer
	public level1() {
		addKeyListener(new keyMovement());
		setFocusable(true);
		setGameTimer(new Timer(10, this));
		Score.newScore();
		loadImages(); 
		getGameTimer().start();
	}

	// images for each object gets loaded into game

	private void loadImages() {
		backgroundIcon = new ImageIcon("images/level1.png");
		playerIcon = new ImageIcon(playerIconPath);
		lily1 = new ImageIcon("images/lilypad.png");
		lily2 = new ImageIcon("images/lilypad.png");
		lily3 = new ImageIcon("images/lilypad.png");
	}


	 //Reloading player 
	
	private void loadPlayer() {
		playerIcon = new ImageIcon(playerIconPath);
	}

//paints the graphics to the  board
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// drawing background
		backgroundIcon.paintIcon(this, g, 0, 0);
		// drawing lily pads 
		lily1.paintIcon(this, g, 70, 95);
		lily2.paintIcon(this, g, 210, 95);
		lily3.paintIcon(this, g, 350, 95);
		// drawing car
		car.paintComponent(g);
		// drawing truck
		truck.paintComponent(g);
		// drawing player
		loadPlayer();
		playerIcon.paintIcon(this, g, playerX, playerY);
		//font for score
		Font scoreFont = new Font("TimesRoman", Font.BOLD, 30);
		Font gameFont = new Font("TimesRoman", Font.PLAIN, 25);
		// updating strScore to new score value
		strScore = String.valueOf(score);
		// drawing top text
		g.setFont(gameFont);
		g.drawString("Esc: Menu", 20, 40);
		g.setFont(scoreFont);
		g.drawString("score: " + strScore, 165, 40);
		g.setFont(gameFont);
		g.drawString("R: Restart", 360, 40);
		// game over/won screens
		if (isGameOver()) {
			g.setColor(Color.RED);
			g.drawString("GAME OVER", 150, 420);
			getGameTimer().stop();
		}
	}


	 //repaints and updates board
	@Override
	public void actionPerformed(ActionEvent e) {

		// checking valid score
		if (score == 0) {
			getGameTimer().stop();
			setGameOver(true);
		} else {
			// update score
			score -= 1;
		}

		// checking if player won the game
		if (playerX > 35 && playerX < 105 && playerY < 71) {
			Score.addScore(score); // adding score to text file
			Main.setLevel2Run(true); // starting level2
			Main.setLevel1Run(false); // ending level1
			level2.reset(); // reseting level 2
			getGameTimer().stop(); // stopping level1
			Main.windowOption(); // changing window view
		} else if (playerX > 175 && playerX < 245 && playerY < 71) {
			Score.addScore(score); // adding score to text file
			Main.setLevel2Run(true); // starting level2
			Main.setLevel1Run(false); // ending level1
			level2.reset(); // reseting level 2
			getGameTimer().stop(); // stopping level1
			Main.windowOption(); // changing window view
		} else if (playerX > 315 && playerX < 385 && playerY < 71) {
			Score.addScore(score); // adding score to text file
			Main.setLevel2Run(true); // starting level2
			Main.setLevel1Run(false); // ending level1
			level2.reset(); // reseting level 2
			getGameTimer().stop(); // stopping level1
			Main.windowOption(); // changing window view
		} 
		// checking if player lost the game
		else if (playerY < 70) {
			getGameTimer().stop();
			setGameOver(true);
		}

		// draw
		repaint();

	}

	//resetting current level
	public static void reset() {
		// reset booleans
		gameOver = false;
		// reset player
		playerX = 210;
		playerY = Main.GAME_HEIGHT - 117;
		playerIconPath = "images/playerstillup.png";
		score = 2500;
		Car.setCar1XPos(-70);
		Car.setCar2XPos(Main.GAME_WIDTH);
		Car.setCar3XPos(-280);
		Car.setCar4XPos(Main.GAME_WIDTH + 350);
		Truck.setTruck1XPos(Main.GAME_WIDTH);
		Truck.setTruck2XPos(Main.GAME_WIDTH + 280);
		getGameTimer().start();
	}

		//getter and setter for player's y position
	public static int getPlayerY() {
		return playerY;
	}


	public static void setPlayerY(int i) {
		playerY = i;
	}

	// getter and setter for player's x position 
	public static int getPlayerX() {
		return playerX;
	}

	public static void setPlayerX(int i) {
		playerX = i;
	}

	// setting player's icon for start/reset of level
	public static void setPlayerIconPath(String path) {
		playerIconPath = path;
	}
	// checking if level lost
	public static boolean isGameOver() {
		return gameOver;
	}
	//setting game over
	public static void setGameOver(boolean gameOver) {
		level1.gameOver = gameOver;
	}
	//getter and setter for game timer
	public static Timer getGameTimer() {
		return gameTimer;
	}

	public static void setGameTimer(Timer gameTimer) {
		level1.gameTimer = gameTimer;
	}


}
