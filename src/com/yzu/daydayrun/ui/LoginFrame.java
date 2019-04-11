package com.yzu.daydayrun.ui;

import com.yzu.daydayrun.db.DoDenglu;
import com.yzu.daydayrun.entity.User;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {
    JLabel userLabel;
    JLabel pwdLabel;
    JTextField userText;
    JPasswordField pwdText;
    JButton loginBtn, cancelBtn;
    String username;
    String userpwd;

    File f1;
    URL url;
    URI uri;
    AudioClip aau;

    public static String playerusername;

    public LoginFrame() {
        f1 = new File("sound/background.wav");
        uri = f1.toURI();
        try {
            url = uri.toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        aau = Applet.newAudioClip(url);

        aau.loop();

        userLabel = new JLabel("用户名");
        userLabel.setBounds(40, 160, 150, 30);
        this.add(userLabel);

        pwdLabel = new JLabel("密码");
        pwdLabel.setBounds(40, 210, 150, 30);
        this.add(pwdLabel);

        userText = new JTextField(10);
        userText.setBounds(90, 165, 120, 25);

        userText.setFocusable(true);

        userText.setBorder(BorderFactory.createLoweredBevelBorder());
        this.add(userText);

        pwdText = new JPasswordField();
        pwdText.setBounds(90, 215, 120, 25);
        pwdText.setFocusable(true);

        pwdText.setBorder(BorderFactory.createLoweredBevelBorder());
        this.add(pwdText);

        loginBtn = new JButton("登录");
        loginBtn.setBounds(80, 265, 65, 30);

        loginBtn.setForeground(Color.BLUE);

        loginBtn.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DoDenglu dl = new DoDenglu();
                User user = dl.findUser(userText.getText(),pwdText.getText());
                String username=userText.getText();
                String userpwd=pwdText.getText();
                if (username.length() == 0||userpwd.length()==0) {
                    JOptionPane.showMessageDialog(null, "请输入用户名");
                }else{
                    if (user!=null) {
                        new OptionFrame();
                        dispose();
                        aau.stop();
                    }else{
                        JOptionPane.showMessageDialog(null, "用户名或密码不正确！");
                    }
                }
            }
        });
        this.add(loginBtn);

        cancelBtn = new JButton("注册");
        cancelBtn.setBounds(155, 265, 65, 30);
        cancelBtn.setForeground(Color.blue);
        cancelBtn.setBorder(BorderFactory.createLineBorder(Color.blue));

        cancelBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                aau.stop();
                new RegisterFrame();
            }
        });
        this.add(cancelBtn);

        BackImage back = new BackImage();
        back.setBounds(0, 0, 599, 330);
        this.add(back);

        this.setLayout(null);
        this.setSize(599, 330);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(new ImageIcon("image/title.png").getImage());
        this.setVisible(true);
    }

    public static void main(String[] args) {
        LoginFrame frame = new LoginFrame();
    }
}



class BackImage extends JPanel{
    Image background;

    public BackImage(){
        try {
            background = ImageIO.read(new File("image/loginBg.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(background, 0, 0, null);
    }
}