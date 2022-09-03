package com.sxt.obj;

import com.sxt.GameWin;

import java.awt.*;

/**
 * &#064;program:  GameObj
 * &#064;description:
 * &#064;author:  xiemu
 * &#064;create:  -09-03 12:16
 **/
//游戏元素父类的编写
public class GameObj {
    Image img;
    int x;
    int y;
    int width;
    int height;
    double speed;
    GameWin frame;

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWedth() {
        return width;
    }

    public void setWedth(int wedth) {
        this.width = wedth;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public GameWin getFrame() {
        return frame;
    }

    public void setFrame(GameWin frame) {
        this.frame = frame;
    }


    //有参构造
    public GameObj() {
    }

    public GameObj(Image img, int x, int y, double speed) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public GameObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.frame = frame;
    }

    public void paintSelf(Graphics gImage){
        gImage.drawImage(img,x,y,null);
    }
    //编写获取自身矩形的方法
    public Rectangle getRec(){
        return new Rectangle(x,y,width,height);
    }
}
