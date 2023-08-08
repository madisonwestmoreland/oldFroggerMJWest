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
//import gamePlay.level1;
import gameObjects.Car;
import gameObjects.Truck;


public class level2 extends JPanel implements ActionListener {
	private static final long serialVersionUID = 7704761091317274700L;

	// stationary object icons
	private ImageIcon backgroundIcon, playerIcon, lily1, lily2, lily3;

	// variables used to animate player
	private static String playerIconPath = "images/playerstillup.png";
	private static int playerX = 210, playerY = Main.GAME_HEIGHT, score = 2500;
	private static String strScore = String.valueOf(score);

	// game over booleans
	private static boolean gameOver = false;

	// game timer/ score
	private static Timer game2Timer;

	// loading mobile objects
	private Car car = new Car();
	private Truck truck = new Truck();
	
	// loading in game board, starts game timer
	public level2() {
		addKeyListener(new keyMovement());
		setFocusable(true);
		setGame2Timer(new Timer(10, this));
		Score.newScore();
		loadImages(); 
		level2.reset();
		getGame2Timer().start();
	}

	//images each object getting loaded into game
	 
	private void loadImages() {
		backgroundIcon = new ImageIcon("images/level2.png");
		playerIcon = new ImageIcon(playerIconPath);
		lily1 = new ImageIcon("images/lilypad.png");
		lily2 = new ImageIcon("images/lilypad.png");
		lily3 = new ImageIcon("images/lilypad.png");
	}

	//reloading player
	private void loadPlayer() {
		playerIcon = new ImageIcon(playerIconPath);
	}

	//paints game graphics to the board
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// drawing background
		backgroundIcon.paintIcon(this, g, 0, 0);
		// drawing lily pads 
		lily1.paintIcon(this, g, 70, 80);
		lily2.paintIcon(this, g, 210, 80);
		lily3.paintIcon(this, g, 350, 80);
		// drawing car
		car.paintComponent(g);
		// drawing truck
		truck.paintComponent(g);
		// drawing player
		loadPlayer();
		playerIcon.paintIcon(this, g, playerX, playerY);
		// font for score
		Font scoreFont = new Font("TimesRoman", Font.BOLD, 30);
		Font gameFont = new Font("TimesRoman", Font.PLAIN, 25);
		// updating strScore to new score value
		strScore = String.valueOf(score);
		// drawing top text
		g.setFont(gameFont);
		g.drawString("Esc: Menu", 20, 40);
		g.setFont(scoreFont);
		g.drawString("Score: " + strScore, 165, 40);
		g.setFont(gameFont);
		g.drawString("R: Restart", 360, 40);
		// game over/won screens
		if (isGameOver()) {
			g.setColor(Color.RED);
			g.drawString("GAME OVER", 150, 420);
			getGame2Timer().stop();
		}
	}

	/**
	 * @param e
	 * 
	 *            repaints and updates board
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		// checking valid score
		if (score == 0) {
			getGame2Timer().stop();
			setGameOver(true);
		} else {
			// update score
			score -= 1;
		}

		// checking if won
		if (playerX > 35 && playerX < 105 && playerY < 71) {
			Score.addScore(score);
			Main.setLevel2Run(false);
			Main.setMenuRun(true);
			level2.reset();
			getGame2Timer().stop();
			Score.sumScore(); // sums all scores together
			Main.windowOption();
		} else if (playerX > 175 && playerX < 245 && playerY < 71) {
			Score.addScore(score);
			Main.setLevel2Run(false);
			Main.setMenuRun(true);
			level2.reset();
			getGame2Timer().stop();
			Score.sumScore(); // sums all scores together
			Main.windowOption();
		} else if (playerX > 315 && playerX < 385 && playerY < 71) {
			Score.addScore(score);
			Main.setLevel2Run(false);
			Main.setMenuRun(true);
			level2.reset();
			getGame2Timer().stop();
			Score.sumScore(); // sums all scores together
			Main.windowOption();
		} 
		// checking if lost
		else if (playerY < 70) {
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
		playerY = Main.GAME_HEIGHT - 69;
		playerIconPath = "images/playerstillup.png";
		// reset score
		score = 2500;
		// reset cars
		Car.setCar5XPos(140);
		Car.setCar6XPos(-70);
		Car.setCar7XPos(70);
		Car.setCar8XPos(-140);
		Car.setCar9XPos(Main.GAME_WIDTH - 69);
		Car.setCar10XPos(Main.GAME_WIDTH + 69);
		Car.setCar11XPos(Main.GAME_WIDTH + 210);
		// reset trucks
		Truck.setTruck3XPos(Main.GAME_WIDTH);
		Truck.setTruck4XPos(Main.GAME_WIDTH + 70);
		Truck.setTruck5XPos(-70);
		// restart game timer
		getGame2Timer().start();
	}

	// getter and setter for player's y position 
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
	//check if level is lost ie 'game over'
	public static boolean isGameOver() {
		return gameOver;
	}
	//setting game over
	public static void setGameOver(boolean gameOver) {
		level2.gameOver = gameOver;
	}
	// getter and setter for game timer
	public static Timer getGame2Timer() {
		return game2Timer;
	}

	public static void setGame2Timer(Timer gameTimer) {
		level2.game2Timer = gameTimer;
	}
}
	


