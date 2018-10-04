package �����M��;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Final extends JFrame implements ActionListener, KeyListener, MouseListener {

	static Final frame = new Final();

	static AudioStream btnbgm;

	static Font font = new Font("Serief", Font.BOLD, 20);
	static Font font1 = new Font("�ө���", Font.BOLD, 13);
	static Font font2 = new Font("�з���", Font.BOLD, 25);

	// panels
	static JPanel pan_home = new JPanel(); // ����
	static JPanel pan_game = new JPanel(); // �C������
	static JPanel pan_how = new JPanel(); // ���k����
	static JPanel pan_staff = new JPanel(); // �s�@�H��

	// ����pan_home

	static AudioStream homebgm;
	static JButton start = new JButton("start");
	static JButton how = new JButton("���k����");
	static JButton staff = new JButton("�s�@�H��");
	static ImageIcon img_btn_start = new ImageIcon("�r��/�}�l.png");
	static ImageIcon img_btn_how = new ImageIcon("�r��/����.png");
	static ImageIcon img_btn_staff = new ImageIcon("�r��/�s�@�H��.png");

	static JButton bear = new JButton("");
	static JButton lion = new JButton("");
	static JLabel background_home = new JLabel("");
	static ImageIcon img_bear = new ImageIcon("����.gif");
	static ImageIcon img_lion = new ImageIcon("���.gif");
	static ImageIcon img_home = new ImageIcon("background_home.jpg");

	// �C��pan_game

	static AudioStream gamebgm;

	static ImageIcon img_back_game = new ImageIcon("�r��/�^�D�e��.png");
	static JButton back_game = new JButton("�^�D�e��");
	static ImageIcon img_game = new ImageIcon("background_game.jpg");

	static ImageIcon[] img_numbers = new ImageIcon[10];

	static JLabel background_game = new JLabel("");

	static Timer timer_gugu_drop = new Timer(30, null);
	static Timer timer_snail_drop = new Timer(30, null);
	static Timer timer_pig_drop = new Timer(30, null);
	static Timer timer_teddy_drop = new Timer(30, null);
	static Timer timer_oc_drop = new Timer(30, null);
	static Timer timer_fish_drop = new Timer(30, null);
	static Timer timer_green_drop = new Timer(30, null);
	static Timer timer_tank_drop = new Timer(30, null);
	static Timer timer_dra_drop = new Timer(30, null);
	static Timer timer_tiger_drop = new Timer(30, null);

	static Timer timer_peach = new Timer(30, null);

	static Timer timer_gugu = new Timer(30, null);
	static Timer timer_pig = new Timer(30, null);
	static Timer timer_snail = new Timer(30, null);
	static Timer timer_teddy = new Timer(30, null);
	static Timer timer_oc = new Timer(30, null);
	static Timer timer_fish = new Timer(30, null);
	static Timer timer_green = new Timer(30, null);
	static Timer timer_dra = new Timer(30, null);
	static Timer timer_tank = new Timer(30, null);
	static Timer timer_tiger = new Timer(30, null);

	static Timer timer_direction_gugu = new Timer(1000, null);
	static Timer timer_direction_snail = new Timer(1000, null);
	static Timer timer_direction_pig = new Timer(1000, null);
	static Timer timer_direction_teddy = new Timer(1000, null);
	static Timer timer_direction_oc = new Timer(1000, null);
	static Timer timer_direction_fish = new Timer(1000, null);
	static Timer timer_direction_tank = new Timer(1000, null);
	static Timer timer_direction_green = new Timer(1000, null);
	static Timer timer_direction_tiger = new Timer(1000, null);
	static Timer timer_direction_dra = new Timer(1000, null);

	static Timer timer_hp = new Timer(100, null);

	static Random ran_gugu = new Random();
	static Random ran_snail = new Random();

	static JButton peach = new JButton("");
	static JButton peachpeople = new JButton("");
	static JButton peachkill = new JButton("");

	static JButton gugu = new JButton("");
	static JButton pig = new JButton("");
	static JButton snail = new JButton("");
	static JButton teddy = new JButton("");
	static JButton oc = new JButton("");
	static JButton fish = new JButton("");
	static JButton tank = new JButton("");
	static JButton tiger = new JButton("");
	static JButton dra = new JButton("");
	static JButton green = new JButton("");

	static ImageIcon img_peachhit_right = new ImageIcon("peach�k��.gif");
	static ImageIcon img_peachhit_left = new ImageIcon("peach����.gif");

	static ImageIcon img_peach_right = new ImageIcon("peach�knew.gif");
	static ImageIcon img_gugu_right = new ImageIcon("�Ǫ�/ۣۣ�_���k.gif");
	static ImageIcon img_pig_right = new ImageIcon("�Ǫ�/�v�a�ΪΥk.gif");
	static ImageIcon img_snail_right = new ImageIcon("�Ǫ�/���_�k.gif");
	static ImageIcon img_teddy_right = new ImageIcon("�Ǫ�/�o�����k.gif");
	static ImageIcon img_oc_right = new ImageIcon("�Ǫ�/�����k.gif");
	static ImageIcon img_fish_right = new ImageIcon("�Ǫ�/���k.gif");
	static ImageIcon img_tank_right = new ImageIcon("�Ǫ�/�Ԩ��k.gif");
	static ImageIcon img_dra_right = new ImageIcon("�Ǫ�/�]�s�k.gif");
	static ImageIcon img_green_right = new ImageIcon("�Ǫ�/�W�ź���F�k.gif");
	static ImageIcon img_tiger_right = new ImageIcon("�Ǫ�/�Ѫ�k.gif");

	static ImageIcon img_peach_left = new ImageIcon("peach��new.gif");
	static ImageIcon img_gugu_left = new ImageIcon("�Ǫ�/ۣۣ�_����.gif");
	static ImageIcon img_pig_left = new ImageIcon("�Ǫ�/�v�a�ΪΥ�.gif");
	static ImageIcon img_snail_left = new ImageIcon("�Ǫ�/���_��.gif");
	static ImageIcon img_teddy_left = new ImageIcon("�Ǫ�/�o������.gif");
	static ImageIcon img_oc_left = new ImageIcon("�Ǫ�/������.gif");
	static ImageIcon img_fish_left = new ImageIcon("�Ǫ�/����.gif");
	static ImageIcon img_tank_left = new ImageIcon("�Ǫ�/�Ԩ���.gif");
	static ImageIcon img_dra_left = new ImageIcon("�Ǫ�/�]�s��.gif");
	static ImageIcon img_green_left = new ImageIcon("�Ǫ�/�W�ź���F��.gif");
	static ImageIcon img_tiger_left = new ImageIcon("�Ǫ�/�Ѫꥪ.gif");

	static int direction_peach;
	static int direction_gugu = 0;
	static int direction_pig = 0;
	static int direction_snail = 0;
	static int direction_teddy = 1;
	static int direction_oc = 0;
	static int direction_fish = 0;
	static int direction_tank = 0;
	static int direction_dra = 1;
	static int direction_green = 0;
	static int direction_tiger = 1;

	static Random ran = new Random();

	// �p��

	static ImageIcon img_score = new ImageIcon("�r��/����.png");
	static JLabel lab_score = new JLabel("���� : ");
	static int score;
	static JButton score_1 = new JButton("");
	static JButton score_2 = new JButton("");

	// �p��

	static ImageIcon[] img_hp = new ImageIcon[12];
	static JLabel lab_hp = new JLabel("");
	static int hp;
	static int hpp[] = new int[12];

	// pan_gg
	
	static AudioStream ggbgm;
	static JPanel pan_gg = new JPanel();
	static ImageIcon img_backgroung_gg = new ImageIcon("background_gg.jpg");
	static JLabel background_gg = new JLabel("");
	static JButton back_gg = new JButton("�^����");
	static JLabel finalscore = new JLabel("");
	static ImageIcon img_back_gg = new ImageIcon("�r��/�^�D�e��.png");
	// ���k����pan_how
	static JButton back_how = new JButton("��BACK");
	static ImageIcon img_back_how = new ImageIcon("�r��/�^�D�e��.png");
	static JLabel background_how = new JLabel("");
	static JLabel peach_how = new JLabel("");
	static JLabel gugu_how = new JLabel("");
	static ImageIcon img_how = new ImageIcon("background_game.jpg");
	static ImageIcon img_peach_how = new ImageIcon("peach.png");
	static ImageIcon img_gugu_how = new ImageIcon("ۣۣ�_��.png");
	static ImageIcon img_story = new ImageIcon("�r��/���Ф�.png");

	// �s�@�H��pan_staff
	static JButton back_staff = new JButton("��BACK");
	static ImageIcon img_back_staff = new ImageIcon("�r��/�^�D�e��.png");

	static ImageIcon img_members = new ImageIcon("�r��/�s�@�H��-2.jpg");

	static JLabel name1 = new JLabel("���K��");
	static JLabel name2 = new JLabel("�׸ֲ[");
	static JLabel name3 = new JLabel("���۸�");
	static JLabel number1 = new JLabel("S04353015");
	static JLabel number2 = new JLabel("S04353041");
	static JLabel number3 = new JLabel("S04353044");

	static JLabel background_staff = new JLabel("");
	static ImageIcon img_staff = new ImageIcon("bg_staff.jpg");

	public static void main(String[] args) {

		frame.addWindowListener(new WindowAdapter() { // �������s
			public void windowClosing(WindowEvent ev) {
				System.exit(0);
			}
		});
		

		pan_home.setLayout(null);
		pan_game.setLayout(null);
		pan_gg.setLayout(null);
		pan_how.setLayout(null);
		pan_staff.setLayout(null);

		//
		frame.setTitle("8787game");
		frame.setLocation(200, 200);
		frame.setSize(700, 400);

		pan_home.setBounds(0, 0, 700, 400);
		pan_game.setBounds(0, 0, 700, 400);
		pan_how.setBounds(0, 0, 700, 400);
		pan_staff.setBounds(0, 0, 700, 400);
		pan_gg.setBounds(0, 0, 700, 400);
		for (int a = 0; a < 10; a++) {
			img_numbers[a] = new ImageIcon("�Ʀr/" + a + ".png");
		}

		for (int a = 0; a < 12; a++) {
			img_hp[a] = new ImageIcon("���/" + a + ".png");
		}

		// pan_home ����

		bear.setBounds(70, 199, img_bear.getIconWidth(), img_bear.getIconHeight());
		bear.setIcon(img_bear);
		bear.setContentAreaFilled(false);
		bear.setBorder(new LineBorder(null, 0));

		lion.setBounds(500, 207, img_lion.getIconWidth(), img_lion.getIconHeight());
		lion.setIcon(img_lion);
		lion.setContentAreaFilled(false);
		lion.setBorder(new LineBorder(null, 0));

		start.setIcon(img_btn_start);
		how.setIcon(img_btn_how);
		staff.setIcon(img_btn_staff);

		start.setBounds(285, 230, 90, 30);
		how.setBounds(285, 270, 90, 30);
		staff.setBounds(285, 310, 90, 30);

		start.setContentAreaFilled(false);
		how.setContentAreaFilled(false);
		staff.setContentAreaFilled(false);

		background_home.setBounds(0, 0, img_home.getIconWidth(), img_home.getIconHeight());
		background_home.setIcon(img_home);

		pan_home.add(start);
		pan_home.add(how);
		pan_home.add(staff);
		pan_home.add(lion);
		pan_home.add(bear);
		pan_home.add(background_home);

		// pan_game~~

		try {
			InputStream input = new FileInputStream("���B�p��bgm.wav");
			homebgm = new AudioStream(input);
		} catch (Exception e) {
			e.printStackTrace();
		}

		AudioPlayer.player.start(homebgm);
		background_game.setIcon(img_game);
		background_game.setBounds(0, -18, img_game.getIconWidth(), img_game.getIconHeight());
		pan_game.add(peach);

		peach.setContentAreaFilled(false);
		peach.setBorder(new LineBorder(null, 0));

		peachpeople.setContentAreaFilled(false);
		peachpeople.setBorder(new LineBorder(null, 0));
		peachkill.setContentAreaFilled(false);
		peachkill.setBorder(new LineBorder(null, 0));

		pan_game.add(peachpeople);
		pan_game.add(peachkill);

		// pan_gg ����

		pan_gg.add(back_gg);
		back_gg.setBounds(605, 0, 100, 40);
		back_gg.setIcon(img_back_gg);
		pan_gg.add(finalscore);
		finalscore.setFont(font);
		finalscore.setBounds(200, 100, 300, 60);
		background_gg.setBounds(0, 0, img_backgroung_gg.getIconWidth(), img_backgroung_gg.getIconHeight());
		background_gg.setIcon(img_backgroung_gg);
		pan_gg.add(background_gg);

		// ���� ��q

		pan_game.add(lab_score);
		lab_score.setIcon(img_score);
		lab_score.setBounds(30, 0, 110, 43);
		pan_game.add(score_1);
		score_1.setBounds(120, 0, img_numbers[0].getIconWidth(), img_numbers[0].getIconHeight());
		score_1.setContentAreaFilled(false);
		score_1.setBorder(new LineBorder(null, 0));

		pan_game.add(score_2);
		score_2.setBounds(160, 0, img_numbers[0].getIconWidth(), img_numbers[0].getIconHeight());
		score_2.setContentAreaFilled(false);
		score_2.setBorder(new LineBorder(null, 0));

		pan_game.add(lab_hp);
		lab_hp.setFont(font);
		lab_hp.setBounds(300, 0, img_hp[0].getIconWidth(), img_hp[0].getIconHeight());

		pan_game.add(back_game);
		back_game.setIcon(img_back_game);
		back_game.setBounds(605, 0, 100, 40);
		back_game.setContentAreaFilled(false);

		// peach����
		timer_peach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Point p = peach.getLocation();

				int newlocation = ran.nextInt(600);

				// ����ۣۣ
				Boolean intersection_gugu = peachkill.getBounds().intersects(gugu.getBounds());
				if (intersection_gugu == true) {
					timer_gugu_drop.start();
					timer_direction_gugu.stop();
					gugu.setLocation(newlocation, -100);
					score += 1;

					if (score <= 87) {
						int score_10 = (score - (score % 10)) / 10;
						int score_0 = score % 10;
						score_1.setIcon(img_numbers[score_10]);
						score_2.setIcon(img_numbers[score_0]);
					}

				}

				// �������_
				Boolean intersection_snail = peachkill.getBounds().intersects(snail.getBounds());
				if (intersection_snail == true) {
					timer_snail_drop.start();
					timer_direction_snail.stop();
					snail.setLocation(newlocation, -80);
					score += 1;

					if (score <= 87) {
						int score_10 = (score - (score % 10)) / 10;
						int score_0 = score % 10;
						score_1.setIcon(img_numbers[score_10]);
						score_2.setIcon(img_numbers[score_0]);
					}

				}

				// �����Ϊ�
				Boolean intersection_pig = peachkill.getBounds().intersects(pig.getBounds());
				if (intersection_pig == true) {
					timer_pig_drop.start();
					timer_direction_pig.stop();
					pig.setLocation(newlocation, -90);
					score += 1;

					if (score <= 87) {
						int score_10 = (score - (score % 10)) / 10;
						int score_0 = score % 10;
						score_1.setIcon(img_numbers[score_10]);
						score_2.setIcon(img_numbers[score_0]);
					}

				}

				// �����o����
				Boolean intersection_teddy = peachkill.getBounds().intersects(teddy.getBounds());
				if (intersection_teddy == true) {
					timer_teddy_drop.start();
					timer_direction_teddy.stop();
					teddy.setLocation(newlocation, -130);
					score += 1;

					if (score <= 87) {
						int score_10 = (score - (score % 10)) / 10;
						int score_0 = score % 10;
						score_1.setIcon(img_numbers[score_10]);
						score_2.setIcon(img_numbers[score_0]);
					}

				}

				// ��������
				Boolean intersection_oc = peachkill.getBounds().intersects(oc.getBounds());
				if (intersection_oc == true) {
					timer_oc_drop.start();
					timer_direction_oc.stop();
					oc.setLocation(newlocation, -120);
					score += 1;

					if (score <= 87) {
						int score_10 = (score - (score % 10)) / 10;
						int score_0 = score % 10;
						score_1.setIcon(img_numbers[score_10]);
						score_2.setIcon(img_numbers[score_0]);
					}

				}

				// �����]�s
				Boolean intersection_dra = peachkill.getBounds().intersects(dra.getBounds());
				if (intersection_dra == true) {
					timer_dra_drop.start();
					timer_direction_dra.stop();
					dra.setLocation(newlocation, -155);
					score += 1;

					if (score <= 87) {
						int score_10 = (score - (score % 10)) / 10;
						int score_0 = score % 10;
						score_1.setIcon(img_numbers[score_10]);
						score_2.setIcon(img_numbers[score_0]);
					}

				}

				// �������N�ԾԨ�
				Boolean intersection_tank = peachkill.getBounds().intersects(tank.getBounds());
				if (intersection_tank == true) {
					timer_tank_drop.start();
					timer_direction_tank.stop();
					tank.setLocation(newlocation, -345);
					score += 1;

					if (score <= 87) {
						int score_10 = (score - (score % 10)) / 10;
						int score_0 = score % 10;
						score_1.setIcon(img_numbers[score_10]);
						score_2.setIcon(img_numbers[score_0]);
					}

				}

				// �����W�ź���F
				Boolean intersection_green = peachkill.getBounds().intersects(green.getBounds());
				if (intersection_green == true) {
					timer_green_drop.start();
					timer_direction_green.stop();
					green.setLocation(newlocation, -345);
					score += 1;

					if (score <= 87) {
						int score_10 = (score - (score % 10)) / 10;
						int score_0 = score % 10;
						score_1.setIcon(img_numbers[score_10]);
						score_2.setIcon(img_numbers[score_0]);
					}

				}

				if (direction_peach == 0) { // �V���e�i

					Double nx = -3.5 * Math.cos(Math.toRadians(0));
					Double ny = -3.5 * Math.sin(Math.toRadians(0));

					Point pnew = new Point();
					pnew.x = p.x + nx.intValue();
					pnew.y = p.y + ny.intValue();

					Point peoplenew = new Point();
					Point killnew = new Point();

					Point people = peach.getLocation();
					Point kill = peach.getLocation();

					peoplenew.x = people.x + nx.intValue() + 25;
					peoplenew.y = people.y + ny.intValue() + 5;
					killnew.x = kill.x + nx.intValue() + 3;
					killnew.y = kill.y + ny.intValue() + 57;
					peachpeople.setLocation(peoplenew.x, peoplenew.y);
					peachkill.setLocation(killnew.x, killnew.y);

					peach.setLocation(pnew.x, pnew.y);
					if (pnew.x < 0) {
						peach.setLocation(0, 230);
					}
				}

				if (direction_peach == 1) { // �V�k�e�i

					Double nx = 3.5 * Math.cos(Math.toRadians(0));
					Double ny = 3.5 * Math.sin(Math.toRadians(0));

					Point pnew = new Point();
					pnew.x = p.x + nx.intValue();
					pnew.y = p.y + ny.intValue();
					peach.setLocation(pnew.x, pnew.y);

					Point people = peach.getLocation();
					Point kill = peach.getLocation();

					Point peoplenew = new Point();
					Point killnew = new Point();
					peoplenew.x = people.x + nx.intValue() + 12;
					peoplenew.y = people.y + ny.intValue() + 5;
					killnew.x = kill.x + nx.intValue() + 64;
					killnew.y = kill.y + ny.intValue() + 57;
					peachpeople.setLocation(peoplenew.x, peoplenew.y);
					peachkill.setLocation(killnew.x, killnew.y);

					if (pnew.x > 595) {
						peach.setLocation(595, 230);

					}

				}
			}
		});
		timer_hp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean hit_snail = peachpeople.getBounds().intersects(snail.getBounds());
				Boolean hit_gugu = peachpeople.getBounds().intersects(gugu.getBounds());
				Boolean hit_teddy = peachpeople.getBounds().intersects(teddy.getBounds());
				Boolean hit_pig = peachpeople.getBounds().intersects(pig.getBounds());
				Boolean hit_oc = peachpeople.getBounds().intersects(oc.getBounds());
				Boolean hit_dra = peachpeople.getBounds().intersects(dra.getBounds());
				Boolean hit_tank = peachpeople.getBounds().intersects(tank.getBounds());
				Boolean hit_green = peachpeople.getBounds().intersects(green.getBounds());

				// �I��ۣۣ

				if (hit_gugu == true) {
					hp += 1;
					lab_hp.setIcon(img_hp[hp]);
					timer_hp.setDelay(500);
					System.out.println("����BYۣۣ");
					// �Q���Ϥ��ܶ�
					if (direction_peach == 0) {
						peach.setIcon(img_peachhit_left);
					}
					if (direction_peach == 1) {
						peach.setIcon(img_peachhit_right);
					}
				}

				// �I�����_

				else if (hit_snail == true) {
					hp += 1;
					lab_hp.setIcon(img_hp[hp]);
					timer_hp.setDelay(500);
					System.out.println("����BY���_");
					// �Q���Ϥ��ܶ�
					if (direction_peach == 0) {
						peach.setIcon(img_peachhit_left);
					}
					if (direction_peach == 1) {
						peach.setIcon(img_peachhit_right);
					}
				}

				// �I��Ϊ�

				else if (hit_pig == true) {
					hp += 1;
					lab_hp.setIcon(img_hp[hp]);
					timer_hp.setDelay(500);
					System.out.println("����BY�Ϊ�");
					// �Q���Ϥ��ܶ�
					if (direction_peach == 0) {
						peach.setIcon(img_peachhit_left);
					}
					if (direction_peach == 1) {
						peach.setIcon(img_peachhit_right);
					}
				}

				// �I����}��

				else if (hit_teddy == true) {
					hp += 1;
					lab_hp.setIcon(img_hp[hp]);
					timer_hp.setDelay(500);
					System.out.println("����BY����");
					// �Q���Ϥ��ܶ�
					if (direction_peach == 0) {
						peach.setIcon(img_peachhit_left);
					}
					if (direction_peach == 1) {
						peach.setIcon(img_peachhit_right);
					}
				}

				// �I�쳹��

				else if (hit_oc == true) {
					hp += 1;
					lab_hp.setIcon(img_hp[hp]);
					timer_hp.setDelay(500);
					System.out.println("����BY����");
					// �Q���Ϥ��ܶ�
					if (direction_peach == 0) {
						peach.setIcon(img_peachhit_left);
					}
					if (direction_peach == 1) {
						peach.setIcon(img_peachhit_right);
					}
				}

				// �I���]�s

				else if (hit_dra == true) {
					hp += 1;
					lab_hp.setIcon(img_hp[hp]);
					timer_hp.setDelay(500);
					System.out.println("����BY�]�s");
					// �Q���Ϥ��ܶ�
					if (direction_peach == 0) {
						peach.setIcon(img_peachhit_left);
					}
					if (direction_peach == 1) {
						peach.setIcon(img_peachhit_right);
					}
				}

				// �I�쳷�N��

				else if (hit_tank == true) {
					hp += 1;
					lab_hp.setIcon(img_hp[hp]);
					timer_hp.setDelay(500);
					System.out.println("����BY���N��");
					// �Q���Ϥ��ܶ�
					if (direction_peach == 0) {
						peach.setIcon(img_peachhit_left);
					}
					if (direction_peach == 1) {
						peach.setIcon(img_peachhit_right);
					}

				}

				// �I��W�ź���F

				else if (hit_green == true) {
					hp += 1;
					lab_hp.setIcon(img_hp[hp]);
					timer_hp.setDelay(500);
					System.out.println("����BY�W��");
					// �Q���Ϥ��ܶ�
					if (direction_peach == 0) {
						peach.setIcon(img_peachhit_left);
					}
					if (direction_peach == 1) {
						peach.setIcon(img_peachhit_right);
					}

				}

				if (hp == 11) {

					try {
						InputStream in = new FileInputStream("gg.wav");
						ggbgm = new AudioStream(in);

					} catch (Exception u) {
						u.printStackTrace();
					}
					
					
					AudioPlayer.player.start(ggbgm);
					AudioPlayer.player.stop(gamebgm);
					pan_gg.setVisible(true);
					pan_game.setVisible(false);

					timer_peach.stop();
					timer_direction_gugu.stop();
					timer_gugu.stop();
					timer_direction_snail.stop();
					timer_snail.stop();
					timer_direction_pig.stop();
					timer_pig.stop();
					timer_direction_teddy.stop();
					timer_teddy.stop();
					timer_direction_oc.stop();
					timer_oc.stop();
					timer_direction_dra.stop();
					timer_dra.stop();
					timer_direction_tank.stop();
					timer_tank.stop();
					timer_direction_green.stop();
					timer_green.stop();

					timer_hp.stop();

					gugu.setLocation(300, 500);
					snail.setLocation(200, 500);
					pig.setLocation(400, 500);
					teddy.setLocation(100, 500);
					oc.setLocation(300, 500);
					dra.setLocation(400, 500);
					tank.setLocation(500, 500);

					if (score >= 87) {
						finalscore.setText("�`�o�� : 87~����A���S");
					} else {
						finalscore.setText("�`�o�� : " + score);
					}

				}

			}
		});

		// ۣۣ�_������ ~~~

		pan_game.add(gugu);
		gugu.setIcon(img_gugu_left);

		gugu.setContentAreaFilled(false);
		gugu.setBorder(new LineBorder(null, 0));

		// �V�U��
		timer_gugu_drop.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Point aa = gugu.getLocation();

				Double ny = 5.0;

				Point b = new Point();

				b.y = aa.y + ny.intValue();
				gugu.setLocation(aa.x, b.y);
				if (aa.y > 255) {
					gugu.setLocation(aa.x, 255);
					timer_gugu_drop.stop();
					timer_gugu.start();
					timer_direction_gugu.start();
				}
			}
		});

		timer_direction_gugu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				direction_gugu = ran_gugu.nextInt(2);
				// System.out.println("ۣۣ��V" + direction_gugu); // consoleۣۣ��V
				Point gugugu = gugu.getLocation();

				if (gugugu.x > img_home.getIconWidth() - img_gugu_right.getIconWidth() - 250) {
					direction_gugu = 0;

				}
				if (gugugu.x <= 250) {
					direction_gugu = 1;
				}
			}
		});

		timer_gugu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Point a = gugu.getLocation();
				if (a.y == 255) {

					if (direction_gugu == 0) { // �V���e�i

						gugu.setIcon(img_gugu_left);// �]�wۣۣ�Ϥ��¥�
						Double nx = -5.0;

						Point b = new Point();
						b.x = a.x + nx.intValue();
						gugu.setLocation(b.x, 255);
					}

					if (direction_gugu == 1) { // �V�k�e�i

						gugu.setIcon(img_gugu_right);// �]�wۣۣ�Ϥ��¥k
						Double nx = 5.0;

						Point b = new Point();
						b.x = a.x + nx.intValue();

						gugu.setLocation(b.x, 255);
					}
				}
			}
		});

		// ���_���� ~~~

		pan_game.add(snail);
		snail.setIcon(img_snail_left);

		snail.setContentAreaFilled(false);
		snail.setBorder(new LineBorder(null, 0));

		// �V�U��

		timer_snail_drop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Point ppsnail = snail.getLocation();

				Double ny = 5.0;

				Point bsnail = new Point();

				bsnail.y = ppsnail.y + ny.intValue();
				snail.setLocation(ppsnail.x, bsnail.y);

				if (ppsnail.y > 288) {
					snail.setLocation(ppsnail.x, 288);
					timer_snail_drop.stop();
					timer_snail.start();
					timer_direction_snail.start();
				}
			}
		});

		timer_direction_snail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				direction_snail = ran_snail.nextInt(2);
				// System.out.println("���_��V" + direction_snail); // console���_��V
				Point psnail = snail.getLocation();

				if (psnail.x > img_home.getIconWidth() - img_snail_right.getIconWidth() - 250) {
					direction_snail = 0;
				}
				if (psnail.x <= 250) {
					direction_snail = 1;
				}
			}
		});

		timer_snail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Point a = snail.getLocation();
				if (a.y == 288) {

					if (direction_snail == 0) { // �V���e�i

						snail.setIcon(img_snail_left);// �]�w���_�¥���
						Double nx = -3.0;

						Point b = new Point();
						b.x = a.x + nx.intValue();
						snail.setLocation(b.x, 288);
					}

					if (direction_snail == 1) { // �V�k�e�i

						snail.setIcon(img_snail_right);// �]�w���_�¥k��
						Double nx = 3.0;

						Point b = new Point();
						b.x = a.x + nx.intValue();

						snail.setLocation(b.x, 288);
					}
				}
			}
		});

		// �v�a�Ϊβ���~~

		pan_game.add(pig);
		pig.setIcon(img_pig_left);

		pig.setContentAreaFilled(false);
		pig.setBorder(new LineBorder(null, 0));

		// �V�U��

		timer_pig_drop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Point pppig = pig.getLocation();

				Double ny = 7.0;

				Point bpig = new Point();

				bpig.y = pppig.y + ny.intValue();
				pig.setLocation(pppig.x, bpig.y);

				if (pppig.y > 266) {
					pig.setLocation(pppig.x, 266);
					timer_pig_drop.stop();
					timer_pig.start();
					timer_direction_pig.start();
				}
			}
		});

		timer_direction_pig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				direction_pig = ran_snail.nextInt(2);
				// System.out.println("�ΪΤ�V" + direction_pig); // console�ΪΤ�V
				Point ppig = pig.getLocation();

				if (ppig.x > img_home.getIconWidth() - img_pig_right.getIconWidth() - 250) {
					direction_pig = 0;

				}
				if (ppig.x <= 250) {
					direction_pig = 1;

				}
			}
		});

		timer_pig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Point a = pig.getLocation();
				if (a.y == 266) {

					if (direction_pig == 0) { // �V���e�i

						pig.setIcon(img_pig_left);// �]�w�Ϊδ¥���
						Double nx = -5.5;

						Point b = new Point();
						b.x = a.x + nx.intValue();
						pig.setLocation(b.x, 266);
					}

					if (direction_pig == 1) { // �V�k�e�i

						pig.setIcon(img_pig_right);// �]�w�Ϊδ¥k��
						Double nx = 5.5;

						Point b = new Point();
						b.x = a.x + nx.intValue();

						pig.setLocation(b.x, 266);
					}
				}
			}
		});

		// �o��������~~

		pan_game.add(teddy);
		teddy.setIcon(img_teddy_left);

		teddy.setContentAreaFilled(false);
		teddy.setBorder(new LineBorder(null, 0));

		// �V�U��

		timer_teddy_drop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Point ppteddy = teddy.getLocation();

				Double ny = 6.8;

				Point bteddy = new Point();

				bteddy.y = ppteddy.y + ny.intValue();
				teddy.setLocation(ppteddy.x, bteddy.y);

				if (ppteddy.y > 270) {
					teddy.setLocation(ppteddy.x, 270);
					timer_teddy_drop.stop();
					timer_teddy.start();
					timer_direction_teddy.start();
				}
			}
		});

		timer_direction_teddy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				direction_teddy = ran_snail.nextInt(2);
				// System.out.println("������V" + direction_teddy); // console��V
				Point pteddy = teddy.getLocation();

				if (pteddy.x > img_home.getIconWidth() - img_teddy_right.getIconWidth() - 250) {
					direction_teddy = 0;

				}
				if (pteddy.x <= 250) {
					direction_teddy = 1;
				}
			}
		});

		timer_teddy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Point a = teddy.getLocation();
				if (a.y == 270) {

					if (direction_teddy == 0) { // �V���e�i

						teddy.setIcon(img_teddy_left);// �]�w�o�����¥���
						Double nx = -6.3;

						Point b = new Point();
						b.x = a.x + nx.intValue();
						teddy.setLocation(b.x, 270);
					}

					if (direction_teddy == 1) { // �V�k�e�i

						teddy.setIcon(img_teddy_right);// �]�w�o�����¥k��
						Double nx = 6.3;

						Point b = new Point();
						b.x = a.x + nx.intValue();

						teddy.setLocation(b.x, 270);
					}
				}
			}
		});

		// ��������~~

		pan_game.add(oc);
		oc.setIcon(img_oc_left);
		oc.setContentAreaFilled(false);
		oc.setBorder(new LineBorder(null, 0));

		// �V�U��

		timer_oc_drop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Point ppoc = oc.getLocation();

				Double ny = 6.2;

				Point boc = new Point();

				boc.y = ppoc.y + ny.intValue();
				oc.setLocation(ppoc.x, boc.y);

				if (ppoc.y > 250) {
					oc.setLocation(ppoc.x, 250);
					timer_oc_drop.stop();
					timer_oc.start();
					timer_direction_oc.start();
				}
			}
		});

		timer_direction_oc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				direction_oc = ran_snail.nextInt(2);
				// System.out.println("������V" + direction_oc); // console��V
				Point poc = oc.getLocation();

				if (poc.x > img_home.getIconWidth() - img_oc_right.getIconWidth() - 250) {
					direction_oc = 0;

				}
				if (poc.x <= 250) {
					direction_oc = 1;
				}
			}
		});

		timer_oc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Point a = oc.getLocation();
				if (a.y == 250) {

					if (direction_oc == 0) { // �V���e�i

						oc.setIcon(img_oc_left);// �]�w�o�����¥���
						Double nx = -5.3;

						Point b = new Point();
						b.x = a.x + nx.intValue();
						oc.setLocation(b.x, 250);
					}

					if (direction_oc == 1) { // �V�k�e�i

						oc.setIcon(img_oc_right);// �]�w�o�����¥k��
						Double nx = 5.3;

						Point b = new Point();
						b.x = a.x + nx.intValue();

						oc.setLocation(b.x, 250);
					}
				}
			}
		});

		// �]�s����~~

		pan_game.add(dra);
		dra.setIcon(img_dra_left);
		dra.setContentAreaFilled(false);
		dra.setBorder(new LineBorder(null, 0));

		// �V�U��

		timer_dra_drop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Point ppdra = dra.getLocation();

				Double ny = 7.0;

				Point bdra = new Point();

				bdra.y = ppdra.y + ny.intValue();
				dra.setLocation(ppdra.x, bdra.y);

				if (ppdra.y > 220) {
					dra.setLocation(ppdra.x, 220);
					timer_dra_drop.stop();
					timer_dra.start();
					timer_direction_dra.start();
				}
			}
		});

		timer_direction_dra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				direction_dra = ran_snail.nextInt(2);

				// System.out.println("�]�s��V" + direction_oc); // console��V

				Point pdra = dra.getLocation();

				if (pdra.x > img_home.getIconWidth() - img_dra_right.getIconWidth() - 200) {
					direction_dra = 0;
				}
				if (pdra.x <= 250) {
					direction_dra = 1;
				}
			}
		});

		timer_dra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Point a = dra.getLocation();
				if (a.y == 220) {

					if (direction_dra == 0) { // �V���e�i

						dra.setIcon(img_dra_left);// �]�w�]�s�¥���
						Double nx = -7.0;

						Point b = new Point();
						b.x = a.x + nx.intValue();
						dra.setLocation(b.x, 220);
					}

					if (direction_dra == 1) { // �V�k�e�i

						dra.setIcon(img_dra_right);// �]�w�]�s�¥k��
						Double nx = 7.0;

						Point b = new Point();
						b.x = a.x + nx.intValue();

						dra.setLocation(b.x, 220);
					}
				}
			}
		});

		// ���N�ԾԨ�����~~

		pan_game.add(tank);
		tank.setIcon(img_tank_left);
		tank.setContentAreaFilled(false);
		tank.setBorder(new LineBorder(null, 0));

		// �V�U��

		timer_tank_drop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Point pptank = tank.getLocation();

				Double ny = 6.5;

				Point btank = new Point();

				btank.y = pptank.y + ny.intValue();
				tank.setLocation(pptank.x, btank.y);

				if (pptank.y > 165) {
					tank.setLocation(pptank.x, 165);
					timer_tank_drop.stop();
					timer_tank.start();
					timer_direction_tank.start();
				}
			}
		});

		timer_direction_tank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				direction_tank = ran_snail.nextInt(2);

				// System.out.println("�]�s��V" + direction_oc); // console��V

				Point ptank = tank.getLocation();

				if (ptank.x > img_home.getIconWidth() - img_tank_right.getIconWidth() - 200) {
					direction_tank = 0;
				}
				if (ptank.x <= 250) {
					direction_tank = 1;
				}
			}
		});

		timer_tank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Point a = tank.getLocation();
				if (a.y == 165) {

					if (direction_tank == 0) { // �V���e�i

						tank.setIcon(img_tank_left);// �]�w�]�s�¥���
						Double nx = -6.5;

						Point b = new Point();
						b.x = a.x + nx.intValue();
						tank.setLocation(b.x, 165);
					}

					if (direction_tank == 1) { // �V�k�e�i

						tank.setIcon(img_tank_right);// �]�w�]�s�¥k��
						Double nx = 6.5;

						Point b = new Point();
						b.x = a.x + nx.intValue();

						tank.setLocation(b.x, 165);
					}
				}
			}
		});

		// �W�ź���F����~~

		pan_game.add(green);
		green.setIcon(img_green_left);
		green.setContentAreaFilled(false);
		green.setBorder(new LineBorder(null, 0));

		// �V�U��

		timer_green_drop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Point ppgreen = green.getLocation();

				Double ny = 6.0;

				Point bgreen = new Point();

				bgreen.y = ppgreen.y + ny.intValue();
				green.setLocation(ppgreen.x, bgreen.y);

				if (ppgreen.y > 67) {
					green.setLocation(ppgreen.x, 67);
					timer_green_drop.stop();
					timer_green.start();
					timer_direction_green.start();
				}
			}
		});

		timer_direction_green.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				direction_green = ran_snail.nextInt(2);

				// System.out.println("����F��V" + direction_green); // console��V

				Point pgreen = green.getLocation();

				if (pgreen.x > img_home.getIconWidth() - img_green_right.getIconWidth() - 200) {
					direction_green = 0;
				}
				if (pgreen.x <= 250) {
					direction_green = 1;
				}
			}
		});

		timer_green.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Point a = green.getLocation();
				if (a.y == 67) {

					if (direction_green == 0) { // �V���e�i

						green.setIcon(img_green_left);// �]�w����F�¥���
						Double nx = -6.0;
						Point b = new Point();
						b.x = a.x + nx.intValue();
						green.setLocation(b.x, 67);

					}

					if (direction_green == 1) { // �V�k�e�i

						green.setIcon(img_green_right);// �]�w����F�¥k��
						Double nx = 6.0;

						Point b = new Point();
						b.x = a.x + nx.intValue();

						green.setLocation(b.x, 67);
					}
				}
			}
		});

		pan_game.add(background_game);

		// pan_how

		back_how.setBounds(0, 0, 90, 30);
		pan_how.add(back_how);
		back_how.setIcon(img_back_how);
		back_how.setBounds(605, 0, 100, 40);
		back_how.setContentAreaFilled(false);

		background_how.setBounds(0, -18, img_how.getIconWidth(), img_how.getIconHeight());
		background_how.setIcon(img_how);

		JLabel story = new JLabel("");
		story.setBounds(0, 0, img_story.getIconWidth(), img_story.getIconHeight());
		story.setIcon(img_story);
		// pan_how.add(story);

		JLabel story_1 = new JLabel("���@��CutePeach�A�@�ӤH���b���W�A���������M�Q�@�s�ѤW���U���Ǫ�ŧ���A");
		story_1.setFont(font1);
		pan_how.add(story_1);
		story_1.setBounds(20, 90, 600, 30);
		JLabel story_2 = new JLabel("�Ωp��W�ߤ@�֦����Z���h��I���̡I�V�O���ͦs�U�h�a�I");
		story_2.setFont(font1);
		pan_how.add(story_2);
		story_2.setBounds(20, 115, 500, 30);
		JLabel how_1 = new JLabel("�C�����k�G");
		how_1.setFont(font1);
		pan_how.add(how_1);
		how_1.setBounds(20, 155, 600, 30);
		JLabel how_2 = new JLabel("�Q����L�W�� �� ���ӱ�����V�A�{���Ǫ��A�Q�ΪZ��Ĳ�I�Ǫ��������L�̡C");
		how_2.setFont(font1);
		pan_how.add(how_2);
		how_2.setBounds(20, 180, 600, 30);

		peach_how.setIcon(img_peach_how);
		peach_how.setBounds(310, 227, img_peach_how.getIconWidth(), img_peach_how.getIconHeight());
		pan_how.add(peach_how);

		gugu_how.setIcon(img_gugu_how);
		gugu_how.setBounds(210, 237, img_gugu_how.getIconWidth(), img_gugu_how.getIconHeight());
		pan_how.add(gugu_how);

		pan_how.add(background_how);

		// pan_staff

		// name1.setIcon(img_members);

		name1.setBounds(50, 80, 150, 40);
		name2.setBounds(220, 80, 150, 40);
		name3.setBounds(390, 80, 150, 40);
		number1.setBounds(50, 130, 150, 40);
		number2.setBounds(220, 130, 150, 40);
		number3.setBounds(390, 130, 150, 40);
		name1.setFont(font2); // �]�w�r���˦�
		name2.setFont(font2);
		name3.setFont(font2);
		number1.setFont(font);
		number2.setFont(font);
		number3.setFont(font);

		background_staff.setBounds(0, 0, img_staff.getIconWidth(), img_staff.getIconHeight());
		background_staff.setIcon(img_staff);
		back_staff.setBounds(0, 0, 80, 30);
		back_staff.setIcon(img_back_staff);
		back_staff.setBounds(605, 0, 100, 40);
		back_staff.setContentAreaFilled(false);
		pan_staff.add(back_staff);
		pan_staff.add(name1);
		pan_staff.add(name2);
		pan_staff.add(name3);
		pan_staff.add(number1);
		pan_staff.add(number2);
		pan_staff.add(number3);
		pan_staff.add(background_staff);

		// ActionListener

		start.addActionListener(frame);
		how.addActionListener(frame);
		staff.addActionListener(frame);
		back_how.addActionListener(frame);
		back_game.addActionListener(frame);
		back_gg.addActionListener(frame);
		back_staff.addActionListener(frame);

		//

		
		start.addMouseListener(frame);
		how.addMouseListener(frame);
		staff.addMouseListener(frame);
		back_how.addMouseListener(frame);
		back_game.addMouseListener(frame);
		back_gg.addMouseListener(frame);
		back_staff.addMouseListener(frame);
		
		
		//
		frame.addKeyListener(frame);
		frame.setFocusable(true);
		frame.setResizable(false);// �����ϥΪ̽վ�����j�p

		// �[�JPanel

		frame.add(pan_staff);
		frame.add(pan_how);
		frame.add(pan_gg);
		frame.add(pan_game);
		frame.add(pan_home);

		pan_home.setVisible(true);
		pan_game.setVisible(false);
		pan_gg.setVisible(false);
		pan_how.setVisible(false);
		pan_staff.setVisible(false);

		frame.setVisible(true);

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

		int key = arg0.getKeyCode();

		switch (key) {

		case KeyEvent.VK_LEFT:

			direction_peach = 0;
			peach.setIcon(img_peach_left);
			// System.out.println(direction_peach + "�H����");
			break;

		case KeyEvent.VK_RIGHT:

			direction_peach = 1;
			peach.setIcon(img_peach_right);
			// System.out.println(direction_peach + "�H���k");
			break;

		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		JButton btn = (JButton) (arg0.getSource());

		if (btn == start) {
			pan_home.setVisible(false);
			pan_game.setVisible(true);

			score = 0;
			hp = 0;
			lab_hp.setIcon(img_hp[0]);
			timer_peach.start();

			try {
				InputStream in = new FileInputStream("�}�b������.wav");
				gamebgm = new AudioStream(in);

			} catch (Exception e) {
				e.printStackTrace();
			}

			timer_gugu_drop.start();
			timer_snail_drop.start();
			timer_pig_drop.start();
			timer_teddy_drop.start();
			timer_oc_drop.start();
			timer_fish_drop.start();
			timer_green_drop.start();
			timer_dra_drop.start();
			timer_tank_drop.start();
			timer_tiger_drop.start();

			score_1.setIcon(img_numbers[0]);
			score_2.setIcon(img_numbers[0]);
			direction_peach = 1;
			peach.setIcon(img_peach_right);
			timer_hp.start();
			AudioPlayer.player.start(gamebgm);
			AudioPlayer.player.stop(homebgm);

			peach.setBounds(310, 228, img_peach_right.getIconWidth(), img_peach_right.getIconHeight());
			gugu.setBounds(300, -100, img_gugu_right.getIconWidth(), img_gugu_right.getIconHeight());
			snail.setBounds(200, -100, img_snail_right.getIconWidth(), img_snail_right.getIconHeight());
			pig.setBounds(400, -170, img_pig_right.getIconWidth(), img_pig_right.getIconHeight());
			teddy.setBounds(100, -170, img_teddy_right.getIconWidth(), img_teddy_right.getIconHeight());

			oc.setBounds(250, -120, img_oc_right.getIconWidth(), img_oc_right.getIconHeight());
			tank.setBounds(500, -300, img_tank_right.getIconWidth(), img_tank_right.getIconHeight());
			fish.setBounds(400, -170, img_fish_right.getIconWidth(), img_fish_right.getIconHeight());
			green.setBounds(10, -360, img_green_right.getIconWidth(), img_green_right.getIconHeight());
			dra.setBounds(50, -100, img_dra_right.getIconWidth(), img_dra_right.getIconHeight());
			tiger.setBounds(200, -100, img_tiger_right.getIconWidth(), img_tiger_right.getIconHeight());

			peachpeople.setBounds(328, 233, 55, 92);
			peachkill.setBounds(380, 285, 24, 40);

		}

		if (btn == how) {

			pan_home.setVisible(false);
			pan_how.setVisible(true);
		}

		if (btn == staff) {

			pan_home.setVisible(false);
			pan_staff.setVisible(true);
		}

		if (btn == back_game) {
			
			
			try {
				InputStream input = new FileInputStream("���B�p��bgm.wav");
				homebgm = new AudioStream(input);
			} catch (Exception u) {
				u.printStackTrace();
			}
			AudioPlayer.player.start(homebgm);
			AudioPlayer.player.stop(gamebgm);
			pan_game.setVisible(false);
			pan_home.setVisible(true);

			timer_direction_gugu.stop();
			timer_gugu.stop();
			timer_direction_snail.stop();
			timer_snail.stop();
			timer_direction_pig.stop();
			timer_pig.stop();
			timer_direction_teddy.stop();
			timer_teddy.stop();

		}

		if (btn == back_how) {
			pan_how.setVisible(false);
			pan_home.setVisible(true);
		}

		if (btn == back_gg) {
			pan_gg.setVisible(false);
			pan_home.setVisible(true);
			AudioPlayer.player.stop(ggbgm);
			try {
				InputStream input = new FileInputStream("���B�p��bgm.wav");
				homebgm = new AudioStream(input);
			} catch (Exception u) {
				u.printStackTrace();
			}
			AudioPlayer.player.start(homebgm);
		}

		if (btn == back_staff) {
			pan_staff.setVisible(false);
			pan_home.setVisible(true);
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		try {
			InputStream input_1 = new FileInputStream("�i�J���s.wav");
			btnbgm = new AudioStream(input_1);
		} catch (Exception u) {
			u.printStackTrace();
		}
		JButton jbtn = (JButton) (e.getSource()); 
		if (jbtn != null) {
			AudioPlayer.player.start(btnbgm);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}