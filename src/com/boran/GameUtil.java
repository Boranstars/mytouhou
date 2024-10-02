package com.boran;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
/**工具类 */
public class GameUtil {

    public static final int FWIDTH = 480;
    public static final int FHEIGHT = 640;
    public static int FPS = 50;
    public static int FAST = 10;
    public static int SLOW = 5;
    //构造器私有.
    private GameUtil(){}

    public static Image getImage(String path) {
        Image img = null;
        URL url = GameUtil.class.getClassLoader().getResource(path);
        try {
            img = ImageIO.read(url);
        } catch (IOException e) {

            e.printStackTrace();
        }

        return img;

    }
}
