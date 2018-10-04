package �����M��;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class Final extends JFrame implements ActionListener, KeyListener {

	static Final frame = new Final();
	
	static Font font = new Font("Serief", Font.BOLD, 20);
	static Font font1 = new Font("�з���", Font.BOLD, 25);
	
	// panels
	static JPanel pan_home = new JPanel(); // ����
	static JPanel pan_game = new JPanel(); // �C������
	static JPanel pan_how = new JPanel(); // ���k����
	static JPanel pan_staff = new JPanel(); // �s�@�H��

	// ����pan_home
	static JButton start = new JButton("start");
	static JButton how = new JButton("���k����");
	static JButton staff = new JButton("�s�@�H��");
	static JButton bear = new JButton("");
	static JButton lion = new JButton("");
	static JLabel background_home = new JLabel("");
	static ImageIcon img_bear = new ImageIcon("����.gif");
	static ImageIcon img_lion = new ImageIcon("���.gif");
	static ImageIcon img_home = new ImageIcon("background_home.jpg");

	// �C��pan_game
	static JButton back_game = new JButton("�^�D�e��");
	static ImageIcon img_game = new ImageIcon("background_game.jpg");
	
	static JLabel background_game = new JLabel("");
	
	static Timer timer_gugu_drop = new Timer(30, null);
	static Timer timer_snail_drop = new Timer(30, null);
	static Timer timer_pig_drop = new Timer(30, null);
	static Timer timer_teddy_drop = new Timer(30, null);
	
	
	static Timer timer_peach = new Timer(30, null);
	static Timer timer_gugu = new Timer(30, null);
	static Timer timer_pig = new Timer(30, null);
	static Timer timer_bat = new Timer(30, null);
	static Timer timer_snail = new Timer(30, null);
	static Timer timer_teddy = new Timer(30, null);

	
	static Timer timer_direction_gugu = new Timer(1000, null);
	static Timer timer_direction_snail = new Timer(1000, null);
	static Timer timer_direction_pig = new Timer(1000, null);
	static Timer timer_direction_teddy = new Timer(1000, null);
	
	
	// static Timer time_direction_pig = new Timer(30, null);
	// static Timer timer_direction_bat = new Timer(30, null);
	// static Timer timer_direction_snail = new Timer(30, null);
	// static Timer timer_direction_teddy = new Timer(30, null);

	static Random ran_gugu = new Random();
	static Random ran_snail = new Random();
	
	static JButton peach = new JButton("");

	static JButton gugu = new JButton("");
	static JButton pig = new JButton("");
	static JButton bat = new JButton("");
	static JButton snail = new JButton("");
	static JButton teddy = new JButton("");

	static ImageIcon img_peach_right = new ImageIcon("peach�knew.gif");
	static ImageIcon img_gugu_right = new ImageIcon("�Ǫ�/ۣۣ�_���k.gif");
	static ImageIcon img_pig_right = new ImageIcon("�Ǫ�/�ΪΥk.gif");
	static ImageIcon img_bat_right = new ImageIcon("�Ǫ�/�����k.gif");
	static ImageIcon img_snail_right = new ImageIcon("�Ǫ�/���_�k.gif");
	static ImageIcon img_teddy_right = new ImageIcon("�Ǫ�/�o�����k.gif");
	
	
	static ImageIcon img_peach_left = new ImageIcon("peach��new.gif");
	static ImageIcon img_gugu_left = new ImageIcon("�Ǫ�/ۣۣ�_����.gif");
	static ImageIcon img_pig_left = new ImageIcon("�Ǫ�/�ΪΥ�.gif");
	static ImageIcon img_bat_left = new ImageIcon("�Ǫ�/������.gif");
	static ImageIcon img_snail_left = new ImageIcon("�Ǫ�/���_��.gif");
	static ImageIcon img_teddy_left = new ImageIcon("�Ǫ�/�o������.gif");

	
	static int direction_gugu = 0;	
	static int direction_peach = 1;
	static int direction_pig = 0;	
	static int direction_bat = 1;
	static int direction_snail = 0;	
	static int direction_teddy = 1;

	static Random ran = new Random();

			// �p��
	static JLabel lab_score = new JLabel("�������� : 0");
	static int score = 0;
	
			// �p��
	static JLabel hp = new JLabel("life & time");

	
	
	
	// ���k����pan_how
	static JButton back_how = new JButton("��BACK");
	static ImageIcon img_how = new ImageIcon("");

	
	
	// �s�@�H��pan_staff
	static JButton back_staff = new JButton("��BACK");
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

		
		
		
		
		// pan_home ����

		bear.setBounds(70, 199, img_bear.getIconWidth(), img_bear.getIconHeight());
		bear.setIcon(img_bear);
		bear.setContentAreaFilled(false);
		bear.setBorder(new LineBorder(null, 0));

		lion.setBounds(500, 207, img_lion.getIconWidth(), img_lion.getIconHeight());
		lion.setIcon(img_lion);
		lion.setContentAreaFilled(false);
		lion.setBorder(new LineBorder(null, 0));

		start.setBounds(280, 230, 90, 30);
		how.setBounds(280, 270, 90, 30);
		staff.setBounds(280, 310, 90, 30);

		background_home.setBounds(0, 0, img_home.getIconWidth(), img_home.getIconHeight());
		background_home.setIcon(img_home);

		pan_home.add(start);
		pan_home.add(how);
		pan_home.add(staff);
		pan_home.add(lion);
		pan_home.add(bear);
		pan_home.add(background_home);

		
		
		
		
		// pan_game~~

		background_game.setIcon(img_game);
		background_game.setBounds(0, -18, img_game.getIconWidth(), img_game.getIconHeight());
		pan_game.add(peach);
		peach.setIcon(img_peach_right);
		peach.setBounds(310, 230, img_peach_right.getIconWidth(), img_peach_right.getIconHeight());
		peach.setContentAreaFilled(false);
		peach.setBorder(new LineBorder(null, 0));		
		
		
		
		//���� ��q
		pan_game.add(lab_score);
		lab_score.setFont(font);
		lab_score.setBounds(50, 0, 130, 40);
		pan_game.add(hp);
		hp.setFont(font);
		hp.setBounds(400, 0, 130, 40);
		pan_game.add(back_game);
		back_game.setBounds(595, 0, 100, 40);

		// peach����
		timer_peach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Point p = peach.getLocation();

				int newlocation = ran.nextInt(600);
				//����ۣۣ
				Boolean intersection_gugu = peach.getBounds().intersects(gugu.getBounds());
				if (intersection_gugu == true) {
					timer_gugu_drop.start();
					timer_direction_gugu.stop();
					gugu.setLocation(newlocation, -100);
					score+=1;
					lab_score.setText("�������� : "+score);
				}
				
				//�������_
				Boolean intersection_snail = peach.getBounds().intersects(snail.getBounds());
				if (intersection_snail == true) {
					timer_snail_drop.start();
					timer_direction_snail.stop();
					snail.setLocation(newlocation, -100);
					score+=1;
					lab_score.setText("�������� : "+score);
				}
				if (direction_peach == 0) { // �V���e�i
					
					peach.setIcon(img_peach_left);
					Double nx = -7 * Math.cos(Math.toRadians(0));
					Double ny = -7 * Math.sin(Math.toRadians(0));

					Point pnew = new Point();
					pnew.x = p.x + nx.intValue();
					pnew.y = p.y + ny.intValue();
					peach.setLocation(pnew.x, pnew.y);
					if (pnew.x < 0) {
						peach.setLocation(0, 230);
					}

				}
				if (direction_peach == 1) { // �V�k�e�i
					
					peach.setIcon(img_peach_right);
					Double nx = 7 * Math.cos(Math.toRadians(0));
					Double ny = 7 * Math.sin(Math.toRadians(0));

					Point pnew = new Point();
					pnew.x = p.x + nx.intValue();
					pnew.y = p.y + ny.intValue();
					peach.setLocation(pnew.x, pnew.y);

					if (pnew.x > 619) {
						peach.setLocation(619, 230);

					}

				}

			}
		});

		
		// ۣۣ�_������ ~~~
		
		pan_game.add(gugu);
		gugu.setIcon(img_gugu_left);
		gugu.setBounds(300, -100, img_gugu_right.getIconWidth(), img_gugu_right.getIconHeight());
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
				System.out.println("ۣۣ��V"+direction_gugu); // consoleۣۣ��V
				Point gugugu = gugu.getLocation();

				if (gugugu.x > img_home.getIconWidth() - img_gugu_right.getIconWidth() - 167) {
					direction_gugu = 0;

				}
				if (gugugu.x <= 167) {
					direction_gugu = 1;
				}
			}
		});

		timer_gugu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Point a = gugu.getLocation();
				if (a.y == 255) {

					if (direction_gugu == 0) { // �V���e�i
				
						gugu.setIcon(img_gugu_left);//�]�wۣۣ�Ϥ��¥�
						Double nx = -5.0;

						Point b = new Point();
						b.x = a.x + nx.intValue();
						gugu.setLocation(b.x, 255);
					}

					if (direction_gugu == 1) { // �V�k�e�i

						gugu.setIcon(img_gugu_right);//�]�wۣۣ�Ϥ��¥k
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
		snail.setBounds(200, -100, img_snail_right.getIconWidth(), img_snail_right.getIconHeight());
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
				System.out.println("���_��V"+direction_snail); // console���_��V
				Point psnail = snail.getLocation();

				if (psnail.x > img_home.getIconWidth() - img_snail_right.getIconWidth() - 167) {
					direction_snail = 0;
					
				}
				if (psnail.x <= 140) {
					direction_snail = 1;
					
				}
			}
		});

		timer_snail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Point a = snail.getLocation();
				if (a.y == 288) {

					if (direction_snail == 0) { // �V���e�i

						snail.setIcon(img_snail_left);//�]�w���_�¥���
						Double nx = -3.0;

						Point b = new Point();
						b.x = a.x + nx.intValue();
						snail.setLocation(b.x, 288);
					}

					if (direction_snail == 1) { // �V�k�e�i
						
						snail.setIcon(img_snail_right);//�]�w���_�¥k��
						Double nx = 3.0;

						Point b = new Point();
						b.x = a.x + nx.intValue();

						snail.setLocation(b.x, 288);
					}
				}
			}
		});
		
		
		pan_game.add(background_game);
		
		
		
		
		// pan_how

		back_how.setBounds(0, 0, 90, 30);
		pan_how.add(back_how);

		
		
		
		
		
		
		
		// pan_staff

		name1.setBounds(50, 80, 150, 40);
		name2.setBounds(220, 80, 150, 40);
		name3.setBounds(390, 80, 150, 40);
		number1.setBounds(50, 130, 150, 40);
		number2.setBounds(220, 130, 150, 40);
		number3.setBounds(390, 130, 150, 40);
		name1.setFont(font1); // �]�w�r���˦�
		name2.setFont(font1);
		name3.setFont(font1);
		number1.setFont(font);
		number2.setFont(font);
		number3.setFont(font);

		background_staff.setBounds(0, 0, img_staff.getIconWidth(), img_staff.getIconHeight());
		background_staff.setIcon(img_staff);
		back_staff.setBounds(0, 0, 80, 30);
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
		back_staff.addActionListener(frame);

		
		//

		
		frame.addKeyListener(frame);
		frame.setFocusable(true);
		frame.setResizable(false);//�����ϥΪ̽վ�����j�p

		
		// �[�JPanel

		
		frame.add(pan_staff);
		frame.add(pan_how);
		frame.add(pan_game);
		frame.add(pan_home);

		
		pan_home.setVisible(true);
		pan_game.setVisible(false);
		pan_how.setVisible(false);
		pan_staff.setVisible(false);

		
		frame.setVisible(true);
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

		int key = arg0.getKeyCode();

		switch (key) {
		case KeyEvent.VK_UP:

			break;
		case KeyEvent.VK_LEFT:

			direction_peach = 0;
			System.out.println(direction_peach + "�H����");
			break;

		case KeyEvent.VK_RIGHT:

			direction_peach = 1;
			System.out.println(direction_peach + "�H���k");
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
			timer_gugu_drop.start();	
			timer_snail_drop.start();
			timer_peach.start();
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

			pan_game.setVisible(false);
			pan_home.setVisible(true);
			score = 0;
			timer_direction_gugu.stop();
			timer_gugu.stop();

		}
		if (btn == back_how) {
			pan_how.setVisible(false);
			pan_home.setVisible(true);
		}

		if (btn == back_staff) {
			pan_staff.setVisible(false);
			pan_home.setVisible(true);
		}

	}
}