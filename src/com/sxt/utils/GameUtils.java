package com.sxt.utils;

import com.sxt.obj.EnemyObj;
import com.sxt.obj.GameObj;
import com.sxt.obj.ShellObj;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * &#064;program:  GameUtils
 * &#064;description:
 * &#064;author:  xiemu
 * &#064;create:  -09-03 09:45
 **/
public class GameUtils {//工具类

   //背景图
    public static Image bgImg = Toolkit.getDefaultToolkit().getImage("imgs/bg.jpg");//在工具类中获取背景图片,类型是Image
   //boss图
    public static Image bossImg = Toolkit.getDefaultToolkit().getImage("imgs/boss.png");
   //爆炸图片
    public static Image explodeImg = Toolkit.getDefaultToolkit().getImage("imgs/explode/e6.gif");
   //我方战斗机图片
    public static Image planeImg = Toolkit.getDefaultToolkit().getImage("imgs/plane.png");//这里都需要回到主窗口创建对象
   //我方子弹图片
    public static Image shellImg = Toolkit.getDefaultToolkit().getImage("imgs/shell.png");
   //敌方飞机图片
   public static Image enemyImg = Toolkit.getDefaultToolkit().getImage("imgs/enemy.png");

    //所有游戏物体的集合
    public static List<GameObj> gameObjList = new ArrayList<>();
   //我方子弹的集合
    public static List<ShellObj> shellObjList = new ArrayList<>();
    //敌方飞机的集合
    public static List<EnemyObj> enemyObjList = new ArrayList<>();
}
