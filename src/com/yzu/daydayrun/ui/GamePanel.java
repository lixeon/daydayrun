package com.yzu.daydayrun.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.yzu.daydayrun.entity.Gold;
import com.yzu.daydayrun.entity.*;


public class GamePanel extends JPanel implements KeyListener {

	public boolean isOver = false;

	private Image background;

	private Image showfield;

	private Image distancefield;


	Person person;

	Pet pet;

	Barrs_1[] bars1 = {};

	bars[] bars2={};
	Gold[] golds = {};
    Stair[] stairs = {};
	public static int b = 0;


	public GamePanel() {
		person = new Person();
		System.out.println(person.getUsername0());
		pet = new Pet(person);
		background = new ImageIcon("image/mainBg.png").getImage();

		showfield = new ImageIcon("image/fieldinfo.png").getImage();

		distancefield = new ImageIcon("image/fieldinfo.png").getImage();
	}

	int a = 0;


	@Override
	public void paint(Graphics g) {
		super.paint(g);
		a--;
		person.setDistance(0);
		g.drawImage(background, a, 0, MainFrame.WIDTH, com.yzu.daydayrun.ui.MainFrame.HEIGHT, null);
		g.drawImage(background, MainFrame.WIDTH + a, 0, com.yzu.daydayrun.ui.MainFrame.WIDTH, com.yzu.daydayrun.ui.MainFrame.HEIGHT, null);
		if (a == -MainFrame.WIDTH) {
			a = 0;
		}
		//函数就是变量 包装变形后的变量 不断创造动作 用公式表达出来 以后自然会用到 不断转化
		g.drawImage(showfield, 120, 30, 150, 30, null);
		g.setColor(Color.ORANGE);
		g.setFont(new Font("4", Font.BOLD, 16));
		g.drawString(String.valueOf(person.getScore())+"分", 145, 50);
		g.drawImage(distancefield, 350, 30, 150, 30, null);
		b++;
		g.drawString("距离："+b+"米", 375, 50);

		person.paintPerson(g);

		pet.paintPet(g);

		for (int i = 0; i < bars1.length; i++) {
			bars1[i].paintBarr_1(g);
		}

        for (int i = 0; i < bars2.length; i++) {
            bars2[i].paintbars(g);
        }

        for (int i = 0; i < golds.length; i++) {
			golds[i].paintGold(g);
		}

        for (int i = 0; i < stairs.length; i++) {
            stairs[i].paintStair(g);
        }
	}

	public void stepAction() {
		person.drop();
		person.step();
		pet.step();

		for (int i = 0; i < bars1.length; i++) {
			bars1[i].step();
		}

        for (int i = 0; i < bars2.length; i++) {
            bars2[i].step();
        }

		for (int i = 0; i < golds.length; i++) {
			golds[i].step();
		}

        for (int i = 0; i < stairs.length; i++) {
            stairs[i].step();
        }
	}

	int index = 0;

	public void enteredAction() {
		index++;

		if (index % 500 == 0) {

			Barrs_1 b = new com.yzu.daydayrun.entity.Barrs_1();

			bars1 = Arrays.copyOf(bars1, bars1.length + 1);

			bars1[bars1.length - 1] = b;
		}

        if (index % 1000 == 0) {
            // 生成一个导弹
            index++;
            com.yzu.daydayrun.entity.bars ba = new com.yzu.daydayrun.entity.bars();
            // 扩容，存放生成的导弹
            bars2 = Arrays.copyOf(bars2, bars2.length + 1);
            // 赋值
            bars2[bars2.length - 1] = ba;
        }

        if (index % 30 == 0) {

			com.yzu.daydayrun.entity.Gold b = new Gold();

			golds = Arrays.copyOf(golds, golds.length + 1);

			golds[golds.length - 1] = b;
		}

        //台阶
        if (index % 400 == 0) {
            com.yzu.daydayrun.entity.Stair stair = new com.yzu.daydayrun.entity.Stair();
            stairs = Arrays.copyOf(stairs, stairs.length + 1);
            stairs[stairs.length - 1] = stair;
        }
	}

	boolean flag = true;

	public void wardAction() {

//		for (int i = 0; i < bars1.length; i++) {
//
//			if (person.getY() + person.HEIGHT > bars1[i].getY() && person.getY() < bars1[i].getY() + bars1[i].HEIGHT
//					&& person.getX() + person.WIDTH > bars1[i].getX()
//					&& person.getX() < bars1[i].getX() + bars1[i].WIDTH) {
//
//				person.setX(bars1[i].getX() - person.WIDTH);
//				// flag = false;
//			}
//		}

//        //导弹障碍物
//        for (int i = 0; i < bars2.length; i++) {
//            if (person.getY() + person.HEIGHT > bars2[i].getY() && person.getY() < bars2[i].getY() + bars2[i].HEIGHT
//                    && person.getX() + person.WIDTH > bars2[i].getX()
//                    && person.getX() < bars2[i].getX() + bars2[i].WIDTH) {
//                // 顺着 障碍物移动的方法移动 “图片宽度”个单位
//                person.setX(bars2[i].getX() - person.WIDTH);
//                // flag = false;
//            }
//        }


        for (int i = 0; i < golds.length; i++) {
			if (person.getX() + person.WIDTH > golds[i].getX() && person.getX() < golds[i].getX() + golds[i].WIDTH
					&& person.getY() + person.HEIGHT > golds[i].getY()
					&& person.getY() < golds[i].getY() + golds[i].HEIGHT) {

				int s = person.getScore();
				person.setScore(s + 100);

				golds[i] = golds[golds.length - 1];
				golds = Arrays.copyOf(golds, golds.length - 1);
			}
		}

        //在台阶移动
        for (int i = 0; i < stairs.length; i++) {
//            if (person.getY() + person.HEIGHT > stairs[i].getY() && person.getY() < stairs[i].getY() + stairs[i].HEIGHT
//                    && person.getX() + person.WIDTH > stairs[i].getX()
//                    && person.getX() < stairs[i].getX() + stairs[i].WIDTH) {
//                person.setX(stairs[i].getX() - person.WIDTH);
//            }

            if (stairs[i].getY() - (person.getY() + person.HEIGHT) < 3 && stairs[i].getY() - (person.getY() + person.HEIGHT) > 0
                    && person.getX() + WIDTH > stairs[i].getX()
                    && person.getX() < stairs[i].getX() + stairs[i].WIDTH) {
                person.setY(person.getY() - 2);
            }
	}}

	public void gameOverAction1() {
            for (int i = 0; i < bars1.length; i++) {

                if (person.getY() + person.HEIGHT > bars1[i].getY() && person.getY() < bars1[i].getY() + bars1[i].HEIGHT
                        && person.getX() + person.WIDTH > bars1[i].getX()
                        && person.getX() < bars1[i].getX() + bars1[i].WIDTH
                        ){

                    JOptionPane.showMessageDialog(null, "你已阵亡");
                    isOver = true;
                    flag = false;
                    person.setDistance(b);
                    new com.yzu.daydayrun.ui.EndFrame(person);
                    break;
                }
            }
	}

    public void gameOverAction2() {
        for (int i = 0; i < bars2.length; i++) {

            if (person.getY() + person.HEIGHT > bars2[i].getY() && person.getY() < bars2[i].getY()
                    && person.getX() + person.WIDTH > bars2[i].getX()
                    && person.getX() < bars2[i].getX() )
            {

                JOptionPane.showMessageDialog(null, "你已阵亡");
                isOver = true;
                flag = false;
                person.setDistance(b);
                new com.yzu.daydayrun.ui.EndFrame(person);
                break;
            }
        }
    }

	public void action() {
		new Thread() {
			public void run() {
				while (true) {
					if (flag) {
						enteredAction();
						stepAction();
						wardAction();
						gameOverAction1();
						gameOverAction2();
					}

					repaint();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		}.start();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

		int x = person.getX();
		int y = person.getY();

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			person.setY(y - 120);
			if(flag == false){
				flag = true;
			}
		}
		
		if(person.getY() <= 20){
			person.setY(y);
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			person.setY(y + 120);
		}
		
		if(person.getY() >= 315){
			person.setY(315);
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			person.setX(x - 20);
			pet.setDx(pet.getDx() - 20);
			if(person.getX() <= 0){
				person.setX(0);
				pet.setDx(person.image.getWidth() + 20);
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(flag){
				person.setX(x + 20);
				pet.setDx(pet.getDx() + 20);
			}
		}
		
		if(pet.getDx() >= com.yzu.daydayrun.ui.MainFrame.WIDTH - pet.dimage.getWidth()){
			person.setX(com.yzu.daydayrun.ui.MainFrame.WIDTH - pet.dimage.getWidth() - 85);
			pet.setDx(com.yzu.daydayrun.ui.MainFrame.WIDTH - pet.dimage.getWidth());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
