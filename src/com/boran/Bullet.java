package com.boran;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Bullet extends GameObject {
    double angle;  

    public Bullet(Image img, int objPosX, int objPosY, int objSpeed, int objWidth, int objHeight, double angle) {
        super(img, objPosX, objPosY, objSpeed, objWidth, objHeight);
        this.angle = angle;
    }

    
    
    public Bullet() {
        angle = Math.random() * Math.PI * 2;
        objPosX = 200;
        objPosY = 90;
        objWidth = 10;
        objHeight = 10;
        objSpeed = 7;
    }
   




    @Override
    public void drawMyself(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.ORANGE);
        g.fillOval(objPosX, objPosY, objWidth, objHeight);

        //飞行
        objPosX += objSpeed * Math.cos(angle);
        objPosY += objSpeed * Math.sin(angle);
        if (objPosY > GameUtil.FHEIGHT - objHeight -10 || objPosY < 30) {
            angle = -angle + Math.random();        
        }
        if (objPosX > GameUtil.FWIDTH  - objWidth -10 || objPosX < 10) {
            angle = Math.PI - angle + Math.random()*Math.PI;
        }
        g.setColor(c);

    }

    
}
