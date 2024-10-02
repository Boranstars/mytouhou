package com.boran;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/** 游戏物体根类 */
public class GameObject {
    Image img;
    protected int objPosX, objPosY;
    int objSpeed;
    int objWidth, objHeight;

    /** 绘制图像 */
    public void drawMyself(Graphics g) {
        g.drawImage(img, objPosX, objPosY, objWidth, objHeight, null);
    }

    /** 返回对应矩形 */
    public Rectangle getRectangle() {
        return new Rectangle(objPosX, objPosY, objWidth, objHeight);
    }

    // 重载构造器
    public GameObject() {
    }

    public GameObject(Image img , int objPosX , int objPosY, int objSpeed, int objWidth, int objHeight) {
        this.img = img;
        this.objPosX = objPosX;
        this.objPosY = objPosY;
        this.objSpeed = objSpeed;
        this.objWidth = objWidth;
        this.objHeight = objHeight;
    }

    public GameObject(Image img, int objPosX, int objPosY, int objSpeed) {
        this(img, objPosX, objPosY);
        this.objSpeed = objSpeed;

    }

    public GameObject(Image img) {
        this.img = img;
        if (this.img != null) {
            this.objWidth = img.getWidth(null);
            this.objHeight = img.getHeight(null);
        }

    }

    public GameObject(Image img, int objPosX, int objPosY) {
        this(img);
        this.objPosX = objPosX;
        this.objPosY = objPosY;
    }

    public void setObjSpeed(int objSpeed) {
        this.objSpeed = objSpeed;
    }

    
}
