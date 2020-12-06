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
	Image heroImageUp, heroImageDown, heroImageLeft, heroImageRight;
	int heroX, heroY;

	public MainCanvas() {
		try {
			heroX = 120;
			heroY = 100;
			heroImageDown = Image.createImage("/sayo11.png");
			heroImageUp = Image.createImage("/sayo01.png");
			heroImageLeft = Image.createImage("/sayo21.png");
			heroImageRight = Image.createImage("/sayo31.png");
			currentImg = heroImageDown;
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
				currentImg = heroImageUp;
				break;
			case DOWN:
				currentImg = heroImageDown;
				break;
			case LEFT:
				currentImg = heroImageLeft;
				break;
			case RIGHT:
				currentImg = heroImageRight;
				break;

		}

		repaint();

	}

	public void HeroMove(int action) {

	}

}