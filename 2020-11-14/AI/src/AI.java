import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	Image img,imgUP0,imgDOWN0,imgLEFT0,imgRIGHT0;
	Image currentImg;
	int X=120,Y=100;




	public MainCanvas(){
		try{
		//img=Image.createImage("/sayo10.png");
		imgUP0=Image.createImage("/sayo14.png");
		imgDOWN0=Image.createImage("/sayo10.png");
		imgLEFT0=Image.createImage("/sayo12.png");
		imgRIGHT0=Image.createImage("/sayo16.png");

		currentImg=imgUP0;
			//img=Image.createImage("/sayo10.png");
		}catch(IOException e){
			e.printStackTrace();
	
		}
	} 
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,X,Y,0);
	}


	public void keyPressed(int keyCode){
//UP,DOWN,LEFT,RIGHT
	int action=getGameAction(keyCode);
	if(action==UP){
		currentImg=imgUP0;
		Y-=6;
		System.out.println("UP");
		repaint();
	
	}

	if(action==DOWN){
		currentImg=imgDOWN0;
		Y+=6;
		System.out.println("DOWN");
		repaint();
		
	}


	if(action==LEFT){
		currentImg=imgLEFT0;
		X-=6;
		System.out.println("LEFT");
		repaint();
	
	}
	if(action==RIGHT){
		currentImg=imgRIGHT0;
		X+=6;
		System.out.println("RIGHT");
		repaint();
	
	}


	}

}