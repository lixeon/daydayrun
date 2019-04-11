package com.yzu.daydayrun.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Pet {
	private int dx, dy;
	private BufferedImage[] dimages = new BufferedImage[6];
	public BufferedImage dimage;
	private int width, height;
	private int index;
	com.yzu.daydayrun.entity.Person p;

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public BufferedImage getDimage() {
		return dimage;
	}

	public void setDimage(BufferedImage dimage) {
		this.dimage = dimage;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Person getP() {
		return p;
	}

	public void setP(Person p) {
		this.p = p;
	}

	public Pet(Person p) {
		this.p = p;
		dimages = new BufferedImage[6];
		try {
			for (int i = 0; i < 6; i++) {
				dimages[i] = ImageIO.read(new File("image/d" + (i + 1) + ".png"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		dx = p.getX() + 85;
		dy = 345;
		index = 0;
	}

	public void step(){
		dimage = dimages[index++/10%dimages.length];
	}
	
	public void paintPet(Graphics g){
		g.drawImage(dimage, dx, dy, null);
	}
}
