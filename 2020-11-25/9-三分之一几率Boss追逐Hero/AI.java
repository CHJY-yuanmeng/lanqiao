import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.util.Random;
// import javafx.scene.image.Image;

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

class MainCanvas extends Canvas implements Runnable {
	Image heroCurrentImg;
	Image falseHeroCurrentImg;
	Image heroAllImage[][];
	int heroX, heroY, falseHeroX, falseHeroY;
	// int UpFlag, DownFlag, LeftFlag, RigthFlag;
	int allFlag;
	Thread thread;

	public MainCanvas() {
		try {
			heroX = 120;
			heroY = 100;
			falseHeroX = 0;
			falseHeroY = 0;
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

			falseHeroCurrentImg = heroCurrentImg = heroAllImage[1][1];
			thread = new Thread(this);
			thread.start();
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public void paint(Graphics g) {
		g.setColor(30, 100, 255);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(heroCurrentImg, heroX, heroY, 0);
		g.drawImage(falseHeroCurrentImg, falseHeroX, falseHeroY, 0);
	}

	public void run() {
		Random ran = new Random();
		while (true) {
			// System.out.print(ran.nextInt(3)+"$$$");
			// System.out.print("&&&&&");
			// System.out.print(Math.random()+"$$$");
			try {
				Thread.sleep(200);

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			if (ran.nextInt(3) == 0) {

				if (falseHeroY < heroY) {
					falseHeroY += 2;
				} else {
					falseHeroY -= 2;
				}
				if (falseHeroX < heroX) {
					falseHeroX += 2;
				} else {
					falseHeroX -= 2;
				}
			}
			repaint();
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

	}

	public void HeroMove(int action) {
		if (allFlag == 0) {
			heroCurrentImg = heroAllImage[action][1];
			allFlag = 1;
		} else if (allFlag == 1) {
			heroCurrentImg = heroAllImage[action][0];
			allFlag = 2;
		} else if (allFlag == 2) {
			heroCurrentImg = heroAllImage[action][1];
			allFlag = 3;
		} else if (allFlag == 3) {
			heroCurrentImg = heroAllImage[action][2];
			allFlag = 0;
		}

	}

}