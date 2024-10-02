package com.boran;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static com.boran.GameUtil.*;

/**
 * MyGameFrame
 */
public class MyGameFrame extends Frame {
    Image bgImage = GameUtil.getImage("images/bg.jpg");
    Image mcImage = GameUtil.getImage("images/marisa.png");
    MainCharcter marisa = new MainCharcter(mcImage, 200, 200, FAST, 50, 50);
    Bullet[] bullets = new Bullet[20];
    

    // 初始化窗口
    public void launchFrame() {

        this.setTitle("TouHouFantasy");
        this.setVisible(true);
        this.setSize(FWIDTH, FHEIGHT);
        this.setLocation(300, 300);

        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);

            }

        });
        // 启动窗口绘制线程
        new PaintThread().start();
        //启动键盘监听
        this.addKeyListener(new KeyMonitor());

        //初始化炮弹
        for (int i = 0; i < bullets.length; i++) {
            bullets[i] = new Bullet();
        }

    }
    //绘制
    @Override
    public void paint(Graphics g) {
        g.drawImage(bgImage, 0, 0, FWIDTH, FHEIGHT, null);
        marisa.drawMyself(g);
        for (int i = 0; i < bullets.length; i++) {
            bullets[i].drawMyself(g);

            boolean isCrashed = bullets[i].getRectangle().intersects(marisa.getRectangle());
            if (isCrashed) {
                System.out.println("p"+ i );
                marisa.isAlive = false;
            }
        }
        

    }
    
    /**键盘监听内部类 */
    class KeyMonitor extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            marisa.addDirection(e);
            if (e.getKeyCode() == KeyEvent.VK_R && marisa.isAlive == false) {
                marisa.isAlive =true;
            }
            super.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            marisa.minusDirection(e);
            super.keyReleased(e);
        }
        
    }
    /** 重画线程 */
    class PaintThread extends Thread {

        @Override
        public void run() {
            long slptime = 1000 / FPS;
            while (true) {
                repaint();
                try {
                    Thread.sleep(slptime);
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
            }
        }

    }

    /** 游戏主程序 */
    public static void main(String[] args) {
        MyGameFrame frame = new MyGameFrame();
        frame.launchFrame();
    }

    // 启用双缓冲加载
    private Image offScreenImage = null;

    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(FWIDTH, FHEIGHT);
        }

        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);

    }

}