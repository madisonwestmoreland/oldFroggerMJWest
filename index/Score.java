import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controls.keyMovement;
import controls.mouseMovement;
import index.Main;

public class Score extends JPanel {
	private static final long serialVersionUID = -646549002494383003L;
	private ImageIcon boardIcon;
	private static String[] topScores;
	private static int y = (Main.GAME_HEIGHT / 2) - 400;
	private static BufferedWriter write;
	private static File scoreFile;

	// new score
	public static void newScore() {
		try {
			// creates a text file
			scoreFile = new File("score.txt");
			if (!scoreFile.exists()) {
				scoreFile.createNewFile();
			}

			FileWriter fileWriter = new FileWriter(scoreFile.getAbsoluteFile(),
					true);
			setWrite(new BufferedWriter(fileWriter));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// add score when level is complete 
	public static void addScore(int score) {
		String scoreStr = String.valueOf(score);
		try {
			getWrite().append(scoreStr);
			getWrite().newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// closing writer if on last level
		if (Main.isLevel2Run()) {
			try {
				write.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	// sum score
	public static void sumScore() {
		int scoreSum = 0;
		FileReader fileReader;
		try {
			fileReader = new FileReader("score.txt");
			BufferedReader reader = new BufferedReader(fileReader);

			int lines = 2;
			String[] scores = new String[lines];

			// adding saved scores from text file
			for (int i = 0; i < lines; i++) {
				scores[i] = reader.readLine();
			}

			int score1 = Integer.valueOf(scores[0]);
			if (scores[1] != null) {
				int score2 = Integer.valueOf(scores[1]);
				scoreSum = score1 + score2;
			} else { 
				scoreSum = score1;
			}
			
			fileReader.close();
			reader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// creating total score new file, creates new text file if needed
		try {
			File totalScoreFile = new File("totalScores.txt");

			if (!totalScoreFile.exists()) {
				totalScoreFile.createNewFile();
			}

			FileWriter fileWriter = new FileWriter(
					totalScoreFile.getAbsoluteFile(), true);
			BufferedWriter scoreWriter = new BufferedWriter(fileWriter); 
			String totalScoreStr = String.valueOf(scoreSum);
			scoreWriter.append(totalScoreStr);
			scoreWriter.newLine();
			scoreWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		// deletes old scores for  new game play and scores
		Path path = scoreFile.toPath();
		try {
			Files.delete(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String[] readFinalScores() {
		FileReader fileReader;
		String[] scores = null;
		try {
			fileReader = new FileReader("totalScores.txt");

			BufferedReader reader = new BufferedReader(fileReader);

			//saves up to 5 scores
			int lines = 5;
			scores = new String[lines];

			// create a list of scores to show on score board 
			for (int i = 0; i < lines; i++) {
				scores[i] = reader.readLine();
			}

			fileReader.close();
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return scores;
	}

	public static BufferedWriter getWrite() {
		return write;
	}

	public static void setWrite(BufferedWriter write) {
		Score.write = write;
	}
	public  Score() {
		addMouseListener(new mouseMovement()); // for mouse movements 
		addKeyListener(new keyMovement()); // for key movements
		setFocusable(true); // allows arrow key use on game board 
		topScores = Score.readFinalScores();
		loadBoard(); 
	}

		private void loadBoard() {
			boardIcon = new ImageIcon("images/Scores.png");
		}
	
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			// draws background
			boardIcon.paintIcon(this, g, 0, 0);
	
			g.setColor(Color.RED);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
			for (int i = 0; i < topScores.length; i++) {
				if (topScores[i] != null) {
					g.drawString(i + ".........." + topScores[i], (Main.GAME_WIDTH / 2) + 25, y);
					y += 50;
				}
			}
	
			// drawing selectable boxes
			Color myColour = new Color(255, 0, 0, 0);
			g.setColor(myColour);
			g.fillRect(600, Main.MENU_HEIGHT - 100, 200, 100);
		}
	
		public static void reset() {
			y = (Main.GAME_HEIGHT / 2) - 200;
			topScores = Score.readFinalScores();
		}
		}
	
