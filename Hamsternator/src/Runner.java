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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
public class Runner extends JPanel implements ActionListener, MouseListener{
	Hamster h = new Hamster();
	Background b = new Background();
	EagHealth e = new EagHealth();
	Cloud c = new Cloud();
	Road r = new Road();
	public void paint(Graphics g) {
		
		super.paintComponent(g);
		b.init(0,0);
		b.paint(g);
		
		h.paint(g);
        
		e.paint(g);
		c.paint(g);
		c.update();
		r.paint(g);
       
        
		
	
	
	
	}


	public static void main(String[] arg) {
		Runner m = new Runner();
	}
	Timer animationTimer;
	public Runner() {
		JFrame f = new JFrame("Method Use");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(2000,1000);
		
		
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