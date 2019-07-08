package cn.shangyang.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

/**
 * 炮弹类
 * @author shangyang
 *
 */
public class Shell extends GameObject {

	double degree;

	public Shell() {
		x = 200;
		y = 200;
		width = 10;
		height = 10;
		speed = 3;
		
		degree = Math.random()*Math.PI*2;
		// TODO Auto-generated constructor stub
	}

	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.BLACK);
		
		g.fillOval((int)x, (int)y, width, height);
		
		//炮弹沿着任意角度飞行
		x += speed*Math.cos(degree);
        y += speed*Math.sin(degree);
        
     
      //如下代码，用来实现碰到边界，炮弹反弹回来(原理和打台球游戏一样)
        if(y>Constant.GAME_HEIGHT-height||y<30){
            degree = -degree;
        }
        if(x<0||x>Constant.GAME_WIDTH-width){
            degree = Math.PI-degree;
        }
        
        //返回给外部，变回以前的颜色
        g.setColor(c);
	}
	
	
	public Shell(Image img, double x, double y, double degree) {
		super(img, x, y);
		this.degree = degree;
	}
	
}
