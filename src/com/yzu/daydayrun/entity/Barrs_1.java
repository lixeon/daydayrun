package com.yzu.daydayrun.entity;

import com.yzu.daydayrun.ui.MainFrame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;


public class Barrs_1 {
	public static final int WIDTH = 120;
	public static final int HEIGHT = 160;

	private BufferedImage[] images;

	private BufferedImage image;

	private int x, y;

	private int index;

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

	public Barrs_1(){
		images = new BufferedImage[2];
		try {
			images[0] = ImageIO.read(new File("image/a4.png"));
			images[1] = ImageIO.read(new File("image/a2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		index = 0;
		x = MainFrame.WIDTH + random.nextInt(500);
		y = 430 - HEIGHT;
		xSpeed = 2;
	}

	public void step(){

		image = images[index++/80 % images.length];

		x -= xSpeed;
	}

	public void paintBarr_1(Graphics g){
		g.drawImage(image, x, y, WIDTH, HEIGHT, null);
	}
	
}
