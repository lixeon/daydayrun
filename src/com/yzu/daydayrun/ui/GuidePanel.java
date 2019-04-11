package com.yzu.daydayrun.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GuidePanel extends JPanel implements KeyListener {
    private Image background;
    static int index=0;
    String message;
    public GuidePanel() {
        String str=String.valueOf(index++%5);
        if(index%5==1){
            message="通过移动或跳跃撞击金币";
        }
        if(index%5==2){
            message="有时候跳到台阶是不错的选择";
        }
        if(index%5==3){
            message="被飞弹打中直接身亡";
        }
        if(index%5==4){
            message="被妖怪撞击也直接死亡";
        }
        if(index%5==0){
            message="最后会有排行榜哟";
        }
        background = new ImageIcon("image/cjq0"+str+".png").getImage();
    }
    public void keyTyped(KeyEvent e){

    };

    public void keyPressed(KeyEvent e){

    };

    public void keyReleased(KeyEvent e){

    };
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(background, 0, 0, com.yzu.daydayrun.ui.MainFrame.WIDTH, com.yzu.daydayrun.ui.MainFrame.HEIGHT, null);
        g.setColor(Color.CYAN);
        g.setFont(new Font("4", Font.BOLD, 26));
        g.drawString(message, 375, 375);

    }
}
