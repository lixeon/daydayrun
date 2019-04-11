package com.yzu.daydayrun.entity;



import com.yzu.daydayrun.ui.MainFrame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Stair {

    public static final int WIDTH = 200;
    public static final int HEIGHT = 37;

    private BufferedImage image;
    private int x, y;
    private int xSpeed;
    private int index;
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

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Stair() {

        try {
            image = ImageIO.read(new File("image/hhh.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        index = 0;
        x = random.nextInt(500)+MainFrame.WIDTH;
        y = 270-random.nextInt(150);
        xSpeed = 2;
    }

    public void step() {
        x -= xSpeed;
    }

    public void paintStair(Graphics g) {
        g.drawImage(image, x, y, WIDTH, HEIGHT, null);
    }
}