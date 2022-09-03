package com.sxt.obj;

import com.sxt.GameWin;

import java.awt.*;

/**
 * &#064;program: EnemyObj
 * <p>
 * &#064;description:
 * <p>
 * &#064;author:XieMu
 * <p>
 * &#064;create: -09-03 16:16
 **/
public class EnemyObj extends GameObj{

    @Override
    public Image getImg() {
        return super.getImg();
    }

    public EnemyObj() {
        super();
    }

    public EnemyObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y += speed;
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
