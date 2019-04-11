package com.yzu.daydayrun.entity;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import javax.imageio.ImageIO;


public class bars    {
    public static int WIDTH = 140;
    public static int HEIGHT = 60;

    private BufferedImage image;
    //坐标
    private int x, y;
    //图片切换变量
    private int index;
    //移动单位
    private int xSpeed;
    Random random = new Random();

    public BufferedImage getImage() {
        return image;
    }
    public void setImage(BufferedImage image) {
        this.image = image;
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
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public int getxSpeed() {
        return xSpeed;
    }
    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public bars(){
        try {
            image=ImageIO.read(new File("image/daodan.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        index=0;
        WIDTH=image.getWidth();
        HEIGHT=image.getHeight();
        x=800;
        y=300;
        index=0;
//        xSpeed=random.nextInt(4)+2;
        xSpeed=2;
    }
    public void step() {
        x -= xSpeed;
        if(x <-WIDTH){
            disapper();
        }
    }
    private void disapper() {
        // TODO Auto-generated method stub
        x=803;
        y=random.nextInt(300-HEIGHT);
        xSpeed=random.nextInt(8)+2;
    }
    public void run(){
        while (true){
            step();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }
    public void paintbars (Graphics g) {
        g.drawImage(image, x, y, WIDTH, HEIGHT, null);
    }
}

