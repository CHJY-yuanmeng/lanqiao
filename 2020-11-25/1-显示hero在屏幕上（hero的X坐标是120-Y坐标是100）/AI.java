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
	int heroX, heroY;

	public MainCanvas() {
		try {
			heroX = 120;
			heroY = 100;
			currentImg= Image.createImage("/sayo11.png");
		} catch (IOException e) {
			e.printStackTrace();

		}
	}
	public void paint(Graphics g) {
		g.setColor(30, 100, 255);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(currentImg, heroX, heroY, 0);
	}
	public void run(){
		while(true){
			
		}
	}
	public void keyPressed(int keyCode) {		
        int action = getGameAction(keyCode);// UP,DOWN,LEFT,RIGHT
		repaint();
	
	}
	public void HeroMove(int action ) {
	
	}

}