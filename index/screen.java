import gamePlay.level1;
import gamePlay.level2;

public class screen {

	
	
	
	public static void load() {
		// first thread loads level
		Thread load = new Thread() {
			public void run() {
				if (Main.isLevel1Run()) {
					level1.reset();
				} else if (Main.isLevel2Run()) {
					level2.reset();
				}
			}
		};
		// displays loading screen
		Thread loadScreen = new Thread() {
			public void run() {
				try {
					Thread.sleep(1000);
					
					// after 1 second, loads game window for level
					Main.getFrame().setVisible(true);
					Main.getLoadScreen().setVisible(false);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		load.start(); 
		loadScreen.start();
	}
	}
