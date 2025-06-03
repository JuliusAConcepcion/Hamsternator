import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
public class Runner extends JPanel implements ActionListener, MouseListener{
	Hamster h = new Hamster();
	Background b = new Background();
	EagHealth e = new EagHealth(300,-1000);
	ArrayList<Cloud> c = new ArrayList<Cloud>();
	Road r = new Road(0,800);
	Road r2 = new Road(0,700);
	
	public void paint(Graphics g) {
		
		super.paintComponent(g);
		
		b.paint(g);
		
		h.paint(g);
        
		e.paint(g);
		
		for (Cloud asdf:c) {//draw all clouds
			asdf.paint(g);
		}
		
		r.paint(g);
		r2.paint(g);
		
        
		
	
	
	
	}


	public static void main(String[] arg) {
		Runner m = new Runner();
	}
	Timer animationTimer;
	public Runner() {
		JFrame f = new JFrame("Method Use");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(2000,1000);
		r.setScale(10, 7);
		r2.setScale(10, 7);
		
		for (int i = 0; i < 10; i++) {
			
			Cloud a = new Cloud((int)(Math.random()*2000), (int)(Math.random()*300));
			a.setRandomCloud();
			c.add(a);
		}
		
		
		
		
		animationTimer = new Timer(16, this);
		f.add(this);
		f.addMouseListener(this);
		animationTimer.start();
		f.setVisible(true);
		
	}
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	
	}

	
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		System.out.println(arg0.getKeyCode()+" asdf");
	}

	public void keyReleased(KeyEvent arg0) { 
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}