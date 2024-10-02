package com.boran;

import static com.boran.GameUtil.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

/** 主人物类 */
public class MainCharcter extends GameObject {
    
    boolean isWalkingLeft, isWalkingUp, isWalkingRight, isWalkingDown;
    boolean isAlive = true;
    @Override
    public void drawMyself(Graphics g) {
        if (isAlive) {
            super.drawMyself(g);
            handleMove();
        }
        
        


    }

    private void handleMove() {
        if (this.isWalkingRight) {
            objPosX += objSpeed;
        }
        if (this.isWalkingLeft) {
            objPosX -= objSpeed;
        }
        if (this.isWalkingUp) {
            objPosY -= objSpeed;
        }
        if (this.isWalkingDown) {
            objPosY += objSpeed;
        }
    }

    public void addDirection(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                isWalkingLeft = true;
                break;
            case KeyEvent.VK_RIGHT:
                isWalkingRight = true;
                break;
            case KeyEvent.VK_UP:
                isWalkingUp = true;
                break;
            case KeyEvent.VK_DOWN:
                isWalkingDown = true;
                break;
            case KeyEvent.VK_SHIFT:
                objSpeed = SLOW;
                break;

            default:
                break;
        }
    }
    
    public void minusDirection(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                isWalkingLeft = false;
                break;
            case KeyEvent.VK_RIGHT:
                isWalkingRight = false;
                break;
            case KeyEvent.VK_UP:
                isWalkingUp = false;
                break;
            case KeyEvent.VK_DOWN:
                isWalkingDown = false;
                break;
            case KeyEvent.VK_SHIFT:
                objSpeed = FAST;
                break;
            default:
                break;
        }
    }
    public MainCharcter(Image img, int objPosX, int objPosY, int objSpeed, int objWidth, int objHeight) {
        super(img, objPosX, objPosY, objSpeed, objWidth, objHeight);
    }

}
