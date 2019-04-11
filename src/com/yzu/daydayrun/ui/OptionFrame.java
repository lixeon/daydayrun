package com.yzu.daydayrun.ui;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class OptionFrame extends JFrame implements MouseListener{

	JLabel start, help, exit;
	File f1;
	URL url;
	URI uri;
	AudioClip aau;
	
	public OptionFrame(){
		f1 = new File("sound/YQ.wav");
		uri = f1.toURI();
		try {
			url = uri.toURL();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		aau = Applet.newAudioClip(url);

		aau.loop();

		start = new JLabel(new ImageIcon("image/start.png"));

		start.setBounds(300, 250, 150, 40);

		start.setEnabled(false);

		start.addMouseListener(this);
		this.add(start);

		help = new JLabel(new ImageIcon("image/help.png"));
		help.setBounds(300, 320, 150, 40);
		help.setEnabled(false);

		help.addMouseListener(this);
		this.add(help);

		exit = new JLabel(new ImageIcon("image/exit.png"));
		exit.setBounds(300, 390, 150, 40);
		exit.setEnabled(false);

		exit.addMouseListener(this);
		this.add(exit);

		BackImg back = new BackImg();
		this.add(back);

		this.setSize(1000, 550);

		this.setLocationRelativeTo( null);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		 this.setIconImage(new ImageIcon("image/title.png").getImage());

		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if(e.getSource() == start){
			new StartFrame().start();
			this.dispose();
			aau.stop();
		}

		if(e.getSource() == help){
			new GuideFrame();
			this.dispose();
			aau.stop();

		}
		
		if(e.getSource() == exit){
			this.dispose();
			aau.stop();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == start){
			start.setEnabled(true);
		}
		
		if(e.getSource() == help){
			help.setEnabled(true);
		}
		
		if(e.getSource() == exit){
			exit.setEnabled(true);
		}
	}

	@Override

	public void mouseExited(MouseEvent e) {
		if(e.getSource() == start){
			start.setEnabled(false);
		}
		
		if(e.getSource() == help){
			help.setEnabled(false);
		}
		
		if(e.getSource() == exit){
			exit.setEnabled(false);
		}
	}

	
	public static void main(String[] args) {
		new OptionFrame();
	}
}


class BackImg extends JPanel{
	Image background;
	
	public BackImg(){
		try {
			background = ImageIO.read(new File("image/main.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(background, 0, 0, 1000, 550, null);
	}
}
