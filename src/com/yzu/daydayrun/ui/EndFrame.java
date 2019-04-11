package com.yzu.daydayrun.ui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.yzu.daydayrun.db.DoList;
import com.yzu.daydayrun.db.DoWriteScore;
import com.yzu.daydayrun.entity.User;
import com.yzu.daydayrun.entity.Person;

public class EndFrame extends JFrame implements MouseListener{
	JLabel lblAgain, lblMain;
	Image image;
	Person p;
    List<User> myuserList;

	private String username = LoginFrame.playerusername;

	public EndFrame(Person p){
		this.p = p;
        DoWriteScore doWriteScore = new DoWriteScore();
        doWriteScore.WriteScore( username,p.getScore());
        if (doWriteScore.getFlag()!=0) {
            System.out.println("success");
        }
        DoList doList = new DoList();
        myuserList = doList.GetList();
        for (User user:myuserList){
            System.out.println(user.getSocre());
        }
		lblAgain =  new JLabel(new ImageIcon("image/again.png"));
		lblAgain.addMouseListener(this);
		lblAgain.setBounds(260, 225, 60, 25);
		
		lblMain = new JLabel(new ImageIcon("image/endMain.png"));
		lblMain.addMouseListener(this);
		lblMain.setBounds(260, 260, 60, 25);
		
		BackEnd be = new BackEnd(p,myuserList);
		be.setBounds(0, 0, 599, 384);
		
		this.add(lblAgain);
		this.add(lblMain);
		this.add(be);
		this.setLayout(null);
		this.setSize(599, 384);
		this.setLocationRelativeTo(null);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon("image/end_1.png").getImage());
		this.setVisible(true);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == lblAgain){

			new com.yzu.daydayrun.ui.StartFrame().start();
			this.dispose();
		}
		
		if(e.getSource() == lblMain){
			new com.yzu.daydayrun.ui.OptionFrame();
			this.dispose();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
	
	
	public static void main(String[] args) {
        System.out.println("success0");
		Person p = new Person();

		new EndFrame(p);
	}
}


class BackEnd extends JPanel{
	Image img;
	Person p;
	List<User> users;
	
	public BackEnd(Person p,List<User> users){
		this.p = p;
		this.users = users;
		try {
			img = ImageIO.read(new File("image/end.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(img, 0, 0, 599, 384, null);
		g.drawString("第一 : " +users.get(0).getSocre(),415,210);
		g.drawString("第二 : " +users.get(1).getSocre(),415,225);
		g.drawString("第三 : " +users.get(2).getSocre(),415,240);
        g.drawString("" +p.getDistance(), 438, 264);
		g.drawString("" +p.getScore(), 438, 302);
	}
}
