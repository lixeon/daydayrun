package com.yzu.daydayrun.ui;

import com.yzu.daydayrun.db.DoRegister;
import com.yzu.daydayrun.entity.User;
import com.yzu.daydayrun.utils.ValidCode;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterFrame extends JFrame {
    JLabel userLabel;
    JLabel pwdLabel;
    JLabel validcode;
    JTextField userText;
    JPasswordField pwdText;
    JButton loginBtn, cancelBtn;
    String username;
    String userpwd;
    private ValidCode vcode;
    File f1;
    URL url;
    URI uri;
    AudioClip aau;

     JTextField jtf_code;

    public RegisterFrame() {
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


          validcode = new JLabel("验证码：");
        validcode.setBounds(40, 260, 150, 30);
        this.add(validcode);

        vcode = new ValidCode();
        vcode.setBounds(250, 255, 120, 25);
        this.add(vcode);

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

         jtf_code = new JTextField();
        jtf_code.setBounds(90, 265, 120, 25);
//        jtf_code.setFocusable(true);

        jtf_code.setBorder(BorderFactory.createLoweredBevelBorder());
        this.add(jtf_code);

        loginBtn = new JButton("确定");
        loginBtn.setBounds(80, 295, 65, 30);

        loginBtn.setForeground(Color.BLUE);

        loginBtn.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (!isValidCodeRight()) {
                    JOptionPane.showMessageDialog(null, "验证码错误！");
                }

                if (isValidCodeRight()) {

                    if (userText.getText().length() == 0 || pwdText.getText().length() == 0) {
                        JOptionPane.showMessageDialog(null, "用户名或密码为空");
                    } else {
                        DoRegister rg = new DoRegister();
                        User u = rg.RegisterUser(userText.getText(), pwdText.getText());
                        if (rg.getFlag() != 0) {
                            JOptionPane.showMessageDialog(null, "注册成功！请返回");
                        } else {
                            JOptionPane.showMessageDialog(null, "注册失败！账号重复");
                        }
                    }
                }
            }
        });
        this.add(loginBtn);

        cancelBtn = new JButton("返回");
        cancelBtn.setBounds(155, 295, 65, 30);
        cancelBtn.setForeground(Color.blue);
        cancelBtn.setBorder(BorderFactory.createLineBorder(Color.blue));

        cancelBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                aau.stop();
                new LoginFrame();
            }
        });
        this.add(cancelBtn);

        BackImage back = new BackImage();
        back.setBounds(0, 0, 599, 360);
        this.add(back);

        this.setLayout(null);
        this.setSize(599, 360);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(new ImageIcon("image/title.png").getImage());
        this.setVisible(true);
    }

    public static void main(String[] args) {
       // RegisterFrame frame = new RegisterFrame();
    }

    /**
     * 验证码的校验
     *
     * @return
     */
    public boolean isValidCodeRight() {

        if (jtf_code == null) {
            return false;
        }
        if (vcode == null) {
            return true;
        }
        if (vcode.getCode().equals(jtf_code.getText())) {
            return true;
        }
        return false;
    }

}



