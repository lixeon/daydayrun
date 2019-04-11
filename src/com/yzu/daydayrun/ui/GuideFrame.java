package com.yzu.daydayrun.ui;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import javax.swing.*;

public class GuideFrame extends JFrame{
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 550;
    com.yzu.daydayrun.ui.GuidePanel gp = null;
    File f1;
    URL url;
    URI uri;
    AudioClip aau;
    public GuideFrame(){
        f1 = new File("sound/YQ.wav");
        uri = f1.toURI();
        try {
            url = uri.toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        aau = Applet.newAudioClip(url);

        aau.loop();

        JButton next=new JButton("下一条建议");
        JButton end=new JButton("返回选择界面");
        next.setBounds(900, 0, 100, 40);
        next.setForeground(Color.BLUE);

        next.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        end.setBounds(900, 35, 100, 40);
        end.setForeground(Color.BLUE);

        end.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GuideFrame();
            }
        });
        end.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new com.yzu.daydayrun.ui.OptionFrame();
            }
        });
        this.add(next);
        this.add(end);
        gp = new com.yzu.daydayrun.ui.GuidePanel();
        this.addKeyListener(gp);
        this.add(gp);


        this.setSize(WIDTH, HEIGHT);
        this.setTitle("帮助");
        this.setResizable(false);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon("image/title.png").getImage());
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new GuideFrame();
    }
}
