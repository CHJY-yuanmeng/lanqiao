import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

import java.io.*;

public class AI extends MIDlet {
	Display display;
	MainCanvas mc;

	public AI() {
		display = Display.getDisplay(this);
		mc = new MainCanvas();
		display.setCurrent(mc);
	}

	public void startApp() {
	}

	public void destroyApp(boolean unc) {
	}

	public void pauseApp() {
	}
}

class MainCanvas extends Canvas {
	Image currentImg;
	Image heroAllImage[][];
	int heroX, heroY;
	// int UpFlag, DownFlag, LeftFlag, RigthFlag;
	int allFlag;

	public MainCanvas() {
		try {
			heroX = 120;
			heroY = 100;
			allFlag = 0;
			// UpFlag = 0;
			// DownFlag = 0;
			// LeftFlag = 0;
			// RigthFlag = 0;

			heroAllImage = new Image[4][3];

			for (int i = 0; i < heroAllImage.length; i++) {
				for (int j = 0; j < heroAllImage[i].length; j++) {
					heroAllImage[i][j] = Image.createImage("/sayo" + i + j + ".png");
				}
			}

			currentImg = heroAllImage[1][1];
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public void paint(Graphics g) {
		g.setColor(30, 100, 255);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(currentImg, heroX, heroY, 0);
	}

	public void run() {
		while (true) {

		}
	}

	public void keyPressed(int keyCode) {
		int action = getGameAction(keyCode);// UP,DOWN,LEFT,RIGHT
		switch (action) {
			case UP:
				HeroMove(0);
				heroY -= 4;
				break;
			case DOWN:
				HeroMove(1);
				heroY += 4;
				break;
			case LEFT:
				HeroMove(2);
				heroX -= 4;
				break;
			case RIGHT:
				HeroMove(3);
				heroX += 4;
				break;

		}

		repaint();

	}

	public void HeroMove(int action) {
		if (allFlag == 0) {
			currentImg = heroAllImage[action][1];
			allFlag = 1;
		} else if (allFlag == 1) {
			currentImg = heroAllImage[action][0];
			allFlag = 2;
		} else if (allFlag == 2) {
			currentImg = heroAllImage[action][1];
			allFlag = 3;
		} else if (allFlag == 3) {
			currentImg = heroAllImage[action][2];
			allFlag = 0;
		}

	}

}