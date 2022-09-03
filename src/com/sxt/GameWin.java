package com.sxt;

import com.sxt.obj.BgObj;
import com.sxt.obj.EnemyObj;
import com.sxt.obj.PlaneObj;
import com.sxt.obj.ShellObj;
import com.sxt.utils.GameUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * &#064;program:  GameWin
 * &#064;description:
 * &#064;author:  XieMu
 * &#064;create:  -09-03 08:53
 **/
public class GameWin extends JFrame {//GameWin 是普通的java类 继承JFrame便具有了创建窗口的功能
//首先完成窗口的绘制
    //游戏状态：0 未开始 1 游戏中 2 暂停 3 通关失败 4 通关成功
    static int state = 0;//先定义游戏的默认状态

    Image offScreenImage = null ;//定义一个变量offScreenImage
    int width = 550;//单独提出宽和高的变量
    int height = 1000;
    //游戏的重绘次数
    int count =1;
    //背景图对象
    BgObj bgObj = new BgObj(GameUtils.bgImg,0,-200,2);
    //我方飞机对象//窗口引用当前对象
    PlaneObj planeObj = new PlaneObj(GameUtils.planeImg,250,450,20,30,0,this);




    public void launch(){
        //一、设置窗口是否可见
        this.setVisible(true);//默认是False窗口不可见
        //设置窗口大小
        this.setSize(width,height);
        //设置窗口位置
        this.setLocationRelativeTo(null);//让它在屏幕中央
        //设置窗口标题
        this.setTitle("飞机大战");

        GameUtils.gameObjList.add(bgObj);
        GameUtils.gameObjList.add(planeObj);
        //游戏的点击启动事件
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1 && state == 0){
                    state = 1;
                    repaint();
                }
            }
        });

        //重复绘制
        while (true){//背景图不断移动需要重复调用paint方法
            if (state == 1){
                createObj();
                repaint();//每隔30ms调用一次repaint方法
            }

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }//创建一个启动方法,在这个方法中，将设置窗口的信息

    @Override//Ctrl+O，搜索paint，重写paint方法
    public void paint(Graphics g) {//为窗口添加图片和文字
        //在paint方法中初始化变量offScreenImage
        if (offScreenImage == null){
            offScreenImage = createImage(width,height);
        }
        //获取offScreenImage的画笔对象
        Graphics gImage = offScreenImage.getGraphics();
        gImage.fillRect(0,0,500,500);//用gImage填充一个宽500高500的区域,有四个实参
        if (state == 0){
            gImage.drawImage(GameUtils.bgImg,0,0,null);
            gImage.drawImage(GameUtils.bossImg,220,120,null);
            gImage.drawImage(GameUtils.explodeImg,270,350,null);//用画笔g绘制图片
            gImage.setColor(Color.yellow);
            gImage.setFont(new Font("仿宋",Font.BOLD,40));
            gImage.drawString("点击开始游戏",180,300);
        }
        if (state == 1){//将BgObj的PaintSelf方法绘制到此代码块中
            //运行中
            for (int i = 0; i < GameUtils.gameObjList.size() ; i++){
                GameUtils.gameObjList.get(i).paintSelf(gImage);
            }
        }
        //把新图片一次性绘制到主窗口中
        g.drawImage(offScreenImage,0,0,null);
        count++;

    }

    void createObj(){
        //我方子弹
        //通过匿名类的方式创建子弹对象
        if (count%4 == 0){
            GameUtils.shellObjList.add(new ShellObj(GameUtils.shellImg,planeObj.getX()+3,planeObj.getY()-15,14,29,14,this));
            GameUtils.gameObjList.add(GameUtils.shellObjList.get(GameUtils.shellObjList.size() - 1));
        }//通过索引获取shellObjList的最后一个元素
        if (count%4 == 0){
            GameUtils.enemyObjList.add(new EnemyObj(GameUtils.enemyImg,(int)(Math.random()*110)*5,0,60,60,1,this));
            GameUtils.gameObjList.add(GameUtils.enemyObjList.get(GameUtils.enemyObjList.size() -1)) ;

        }

    }
    public static void main(String[] args){
        //获取窗口类的对象
        GameWin gameWin = new GameWin();
        gameWin.launch();//运行launch方法
    }



}
