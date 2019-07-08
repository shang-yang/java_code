package cn.shangyang.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class Plane extends GameObject {

	boolean live = true;
	boolean left,up,right,down;
	
	@Override
	public void drawMySelf(Graphics g) {
		// TODO Auto-generated method stub
		if(live) {
			g.drawImage(img, (int)x, (int)y, null);
			
			if(left) {
				x -= speed;
			}
			if(right) {
				x += speed;
			}
			if(up) {
				y -= speed;
			}
			if(down) {
				y += speed;
			}
		} else {
			
		}
	}

	public Plane(Image img, double x, double y) {
		super(img, x, y);
		this.speed = 3;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
		// TODO Auto-generated constructor stub
	}
	
	//按下某个键，增加方向
	public void addDirection(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		}
	}
	
	//松开某个键
	public void minusDirection(KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_LEFT:
            left = false;
            break;
        case KeyEvent.VK_UP:
            up = false;
            break;
        case KeyEvent.VK_RIGHT:
            right = false;
            break;
        case KeyEvent.VK_DOWN:
            down = false;
            break;
        default:
            break;
        }
    }
}
