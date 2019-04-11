package com.yzu.daydayrun.entity;

import com.yzu.daydayrun.ui.MainFrame;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;


public class Gold {
	public static final int WIDTH = 20;
	public static final int HEIGHT = 20;
	private Image image;
	private int x, y;
	private int xSpeed;
	Random rd = new Random();
	
	public Gold(){
		image = new ImageIcon("image/" + (rd.nextInt(6) + 20) + ".png").getImage();
		x = rd.nextInt(200) + MainFrame.WIDTH;
		y = rd.nextInt(300) + 50;
		xSpeed = 2;
	}
	
	public void step(){
		x -= xSpeed;
	}
	
	public void paintGold(Graphics g){
		g.drawImage(image, x, y, WIDTH, HEIGHT, null);
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
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
}
