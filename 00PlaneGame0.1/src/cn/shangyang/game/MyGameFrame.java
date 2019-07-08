package cn.shangyang.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;

/**
 * 飞机游戏的主窗口
 * @author shangyang
 *
 */
public class MyGameFrame extends JFrame{

	// 将背景图片与飞机图片定义为成员变量
	Image bgImg = GameUtil.getImage("images/bg.jpg");
	Image planeImg = GameUtil.getImage("images/pl.png");
	Plane plane = new Plane(planeImg,250,250);
	ArrayList<Shell> shellList = new ArrayList<Shell>();
	Date startTime = new Date();
	Date endTime;
	int period;
	
	@Override
	public void paint(Graphics g) {//画出整个窗口及部份内容。被系统自动调用
		// TODO Auto-generated method stub
		g.drawImage(bgImg, 0, 0, null);
		plane.drawMySelf(g);//画飞机
		 //画出容器中所有的子弹
        for(int i=0;i<shellList.size();i++){
            Shell b =  shellList.get(i);
            b.draw(g);
            
          //飞机和所有炮弹对象进行矩形检测
            boolean peng = b.getRect().intersects(plane.getRect());
            if(peng){
                plane.live = false;   //飞机死掉,画面不显示
                endTime = new Date();
            }
        }
        if(!plane.live) {
            period = (int)((endTime.getTime()-startTime.getTime())/1000); 
        	g.setColor(Color.RED);
        	g.drawString("时间："+period+"秒",(int)plane.x,(int)plane.y);
        }
	}
	
	//帮助我们反复的重画窗口
	class PainThread extends Thread {
		// TODO Auto-generated method stub
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 定义键盘监听的内部类
	 */
	class KeyMonitor extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			plane.addDirection(e);
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			plane.minusDirection(e);
		}
	}
	
	/**
	 * 初始化窗口
	 */
	public void launchFrame() {
		this.setTitle("殇央——小飞机");
		//窗口默认不可见，设为可见
		this.setVisible(true);
		this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		//窗口左上角顶点的坐标位置
		this.setLocation(300,300);
		
		//增加关闭窗口监听，这样用户点击右上角关闭图标，可以关闭游戏程序
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
					System.exit(0);
			}
		});
		new PainThread().start();
		addKeyListener(new KeyMonitor());
		//初始化，生成一堆炮弹
	    for(int i=0;i<50;i++){
	        Shell b = new Shell();
	        shellList.add(b);
	    }
	}
	
	public static void main(String[] args) {
		MyGameFrame a = new MyGameFrame();
		a.launchFrame();
	}
	
	private Image offScreenImage = null;
	 
	public void update(Graphics g) {
	    if(offScreenImage == null)
	        offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);//这是游戏窗口的宽度和高度
	     
	    Graphics gOff = offScreenImage.getGraphics();
	    paint(gOff);
	    g.drawImage(offScreenImage, 0, 0, null);
	}   
}
