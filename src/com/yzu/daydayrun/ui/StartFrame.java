package com.yzu.daydayrun.ui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class StartFrame extends JFrame implements Runnable{

	JLabel backImg;
	JProgressBar jpb;
	
	public StartFrame(){

		backImg = new JLabel(new ImageIcon("image/startFrameBg.jpg"));

		jpb = new JProgressBar();

		jpb.setStringPainted(true);

		jpb.setBackground(Color.ORANGE);
		
		this.add(backImg, BorderLayout.NORTH);
		this.add(jpb, BorderLayout.SOUTH);
		
		this.setSize(568, 349);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setIconImage(new ImageIcon("image/title.png").getImage());
		this.setVisible(true);
	}
	
	public void start() {
		StartFrame sf = new StartFrame();
		Thread th = new Thread(sf);
		this.dispose();
		th.start();
	}

	
	int[] progressValue = {0,50,100};;
	@Override
	public void run() {

		for(int i = 0; i < progressValue.length; i++){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			jpb.setValue(progressValue[i]);
		}
		this.dispose();
		new MainFrame();
	}

	
	public static void main(String[] args) {

		//new StartFrame().start();
	}
}
