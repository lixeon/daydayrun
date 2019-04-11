package com.yzu.daydayrun.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Person {
	public static final int WIDTH = 90;
	public static final int HEIGHT = 100;
	private int x, y;
	private int score;
	private int distance;

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	private String username0;
	private BufferedImage[] images;
	public BufferedImage image;
	public int life;
	private int index;

	public String getUsername0() {
		return username0;
	}

	public void setUsername0(String username0) {
		this.username0 = username0;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Person() {
		life = 10;
		score = 0;
		x = 50;
		y = 315;
		index = 0;
		images = new BufferedImage[9];
		try {
			for (int i = 0; i < images.length; i++) {
				images[i] = ImageIO.read(new File("image/" + (i + 1) + ".png"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		image = images[0];
	}

	public void step(){
		image = images[index++/20%images.length];
	}

	public void drop(){
		y += 2;
		if(y >= 315){
			y = 315;
		}
	}

	public void paintPerson(Graphics g){
		g.drawImage(image, x, y, WIDTH, HEIGHT, null);
	}
}
