package com.sxt.obj;

import com.sxt.obj.GameObj;

import java.awt.*;

/**
 * &#064;program:  com.sxt.obj.BgObj
 * &#064;description:
 * &#064;author:  xiemu
 * &#064;create:  -09-03 13:10
 **/
//一个实体类（背景类）
public class BgObj extends GameObj {
    //重写需要的构造方法和paintSelf方法

    public BgObj() {
        super();
    }

    public BgObj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y += speed;//让y加上速度
        //用if判断背景,实现背景图片的循环移动
        if (y >= 500){
            y = -200;
        }
    }
}
