import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import index.Main;
import index.Score;
import gamePlay.level1;

public class mouseMovement extends MouseAdapter {
	public void mousePressed(MouseEvent e) {
		int clickY = e.getY(), clickX = e.getX();

		// if menu is currently selected 
		if (Main.isMenuRun()) {
			// selected level
			if (clickY > 210 && clickY < 310 && clickX > 130 && clickX < 680) {
				Main.setMenuRun(false);
				Main.setLevelSelectRun(true);
				Main.windowOption();
			}
			// score board 
			else if (clickY > 330 && clickY < 430 && clickX > 130 && clickX < 690) {
				Main.setLeaderBoardRun(true);
				Main.setMenuRun(false);
				Main.windowOption();
			}
			// play
			else if (clickY > 450 && clickY < 550 && clickX > 300 && clickX < 500) {
				Main.setMenuRun(false);
				Main.setLevel1Run(true);
				Main.windowOption();
				level1.reset(); // starts level1
			}
		}
		// if score board is currently running 
		else if (Main.isLeaderBoardRun()) {
			// back to menu
			if (clickY > Main.MENU_HEIGHT - 100 && clickY < Main.MENU_HEIGHT && clickX > 600 && clickX < 800) {
				Main.setMenuRun(true);
				Main.setLeaderBoardRun(false);
				Main.windowOption();
			}
		}
		// if level selection is currently selected
		else if (Main.isLevelSelectRun()) {
			// level 1 select
			if (clickY > 120 && clickX > 150 && clickX < 370 && clickY < 500) {
				Main.setLevel1Run(true);
				Main.setLevelSelectRun(false);
				Main.windowOption();
			}
			// level 2 select
			else if (clickY > 120 && clickY < 500 && clickX > 430 && clickX < 650) {
				Main.setLevel2Run(true);
				Main.setLevelSelectRun(false);
				Score.newScore();
				Main.windowOption();
			}
		}
	}
}


