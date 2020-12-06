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
	// Image heroImageUp1, heroImageUp0, heroImageUp2, heroImageDown1, heroImageDown0, heroImageDown2;
	// Image heroImageLeft1, heroImageLeft0, heroImageLeft2, heroImageRight0, heroImageRight1, heroImageRight2;
	// Image heroImageUp[],heroImageDown[],heroImageLeft[],heroImageRight[];
	Image heroAllImage[][];
	int heroX, heroY;
	int UpFlag, DownFlag, LeftFlag, RigthFlag;

	public MainCanvas() {
		try {
			heroX = 120;
			heroY = 100;

			UpFlag = 0;
			DownFlag = 0;
			LeftFlag = 0;
			RigthFlag = 0;

			heroAllImage=new Image[4][3];

			for(int i=0;i<heroAllImage.length;i++){
				for(int j=0;j<heroAllImage[i].length;j++){
					heroAllImage[i][j]=Image.createImage("/sayo"+i+j+".png");
				}
			}

			// heroImageUp=new Image[3];
			// heroImageDown=new Image[3];
			// heroImageLeft=new Image[3];
			// heroImageRight=new Image[3];

			// for(int i=0;i<heroImageRight.length;i++){
			// 	heroImageUp[i]=Image.createImage("/sayo0"+i+".png");	
			// 	heroImageDown[i]=Image.createImage("/sayo1"+i+".png");
			// 	heroImageLeft[i]=Image.createImage("/sayo2"+i+".png");	
			// 	heroImageRight[i]=Image.createImage("/sayo3"+i+".png");		
			// }
			// for(int i=0;i<)
			// heroImageUp1 = Image.createImage("/sayo01.png");
			// heroImageUp0 = Image.createImage("/sayo00.png");
			// heroImageUp2 = Image.createImage("/sayo02.png");
			// heroImageDown1 = Image.createImage("/sayo11.png");
			// heroImageDown0 = Image.createImage("/sayo10.png");
			// heroImageDown2 = Image.createImage("/sayo12.png");
			// heroImageLeft1 = Image.createImage("/sayo21.png");
			// heroImageLeft0 = Image.createImage("/sayo20.png");
			// heroImageLeft2 = Image.createImage("/sayo22.png");
			// heroImageRight0 = Image.createImage("/sayo30.png");
			// heroImageRight1 = Image.createImage("/sayo31.png");
			// heroImageRight2 = Image.createImage("/sayo32.png");
			


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
				if (UpFlag == 0) {
					currentImg = heroAllImage[0][1];
					UpFlag = 1;
				} else if (UpFlag == 1) {
					currentImg = heroAllImage[0][0];
					UpFlag = 2;
				} else if (UpFlag == 2) {
					currentImg = heroAllImage[0][1];
					UpFlag = 3;
				} else if (UpFlag == 3) {
					currentImg = heroAllImage[0][2];
					UpFlag = 0;
				}
				heroY -= 4;
				break;
			case DOWN:
				if (DownFlag == 0) {
					currentImg = heroAllImage[1][1];
					DownFlag = 1;
				} else if (DownFlag == 1) {
					currentImg = heroAllImage[1][0];
					DownFlag = 2;
				} else if (DownFlag == 2) {
					currentImg = heroAllImage[1][1];
					DownFlag = 3;
				} else if (DownFlag == 3) {
					currentImg = heroAllImage[1][2];
					DownFlag = 0;
				}
				heroY += 4;
				break;
			case LEFT:

				if (LeftFlag == 0) {
					currentImg = heroAllImage[2][1];
					LeftFlag = 1;
				} else if (LeftFlag == 1) {
					currentImg = heroAllImage[2][0];
					LeftFlag = 2;
				} else if (LeftFlag == 2) {
					currentImg = heroAllImage[2][1];
					LeftFlag = 3;
				} else if (LeftFlag == 3) {
					currentImg = heroAllImage[2][2];
					LeftFlag = 0;
				}
				heroX -= 4;
				break;
			case RIGHT:
				if (RigthFlag == 0) {
					currentImg = heroAllImage[3][1];
					RigthFlag = 1;
				} else if (RigthFlag == 1) {
					currentImg = heroAllImage[3][0];
					RigthFlag = 2;
				} else if (RigthFlag == 2) {
					currentImg = heroAllImage[3][1];
					RigthFlag = 3;
				} else if (RigthFlag == 3) {
					currentImg = heroAllImage[3][2];
					RigthFlag = 0;
				}
				heroX += 4;
				break;

		}

		repaint();

	}

	public void HeroMove(int action) {

	}

}