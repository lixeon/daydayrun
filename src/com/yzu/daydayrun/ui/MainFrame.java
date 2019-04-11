package com.yzu.daydayrun.ui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class MainFrame extends JFrame{

	public static final int WIDTH = 1000;
	public static final int HEIGHT = 550;

	com.yzu.daydayrun.ui.GamePanel gp = null;
	File f1;
	URL url;
	URI uri;
	AudioClip aau;
	public MainFrame(){
		f1 = new File("sound/game.wav");
		uri = f1.toURI();
		try {
			url = uri.toURL();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		aau = Applet.newAudioClip(url);

		aau.loop();
		gp = new GamePanel();
		
		gp.action();
		this.addKeyListener(gp);
		this.add(gp);

		this.setSize(WIDTH, HEIGHT);
		this.setTitle("天天酷跑");
		this.setResizable(false);
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon("image/title.png").getImage());
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		while(true){
			if(gp.isOver == true){
				this.dispose();
				aau.stop();
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
