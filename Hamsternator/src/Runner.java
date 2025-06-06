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
public class Runner extends JPanel implements ActionListener, MouseListener, KeyListener {
	Hamster h = new Hamster(200, 850);
	Background b = new Background();
	EagHealth e = new EagHealth(160, -600);
	ArrayList<Cloud> c = new ArrayList<Cloud>();
	ArrayList<Building> buildings = new ArrayList<Building>();
	ArrayList<Road> r = new ArrayList<Road>();
	Eagle E = new Eagle(10,400);
	PowerUp powerUp = new PowerUp(1, 2010, 900); 
	Obstacles cars = new Obstacles(1, 2010, 900); 
	
	public void paint(Graphics g) {
		
		super.paintComponent(g);
		
		b.paint(g);
		
		for (Building asdf: buildings) {
			asdf.paint(g);
		}
		
		e.paint(g);
		
		for (Cloud asdf:c) {//draw all clouds
			asdf.paint(g);
		}
			
		for (Road asdf: r) {
			asdf.paint(g);
		}
		
		powerUp.paint(g);
		cars.paint(g);
		E.paint(g);

		h.paint(g);
		
		if (powerUp.isColliding(h)) {
			System.out.println("hiiting ham");
		}
		
		
//		System.out.println("End of paint");
	}


	public static void main(String[] arg) {
		Runner m = new Runner();
	}
	Timer animationTimer;
	public Runner() {
		
		JFrame f = new JFrame("Method Use");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(2000,1100);
		
		for (int i = 0; i < 10; i++) {
			
			Cloud a = new Cloud((int)(Math.random()*2000), (int)(Math.random()*400));
			a.setRandomCloud();
			c.add(a);
		}
		
		for (int i = 0; i < 20; i++) {
			
			Building a = new Building((int)(Math.random()*2100) - 100, (int)(Math.random()*200) + 215) ;
			a.setRandomBuilding();
			buildings.add(a);
		}
		
		for (int i = 0; i < 3; i++) {
		    int roadY = 700 + i * 100;  // place roads at 700, 800, 900
		    Road temp = new Road(0, roadY);
		    temp.setScaleY(7);  // set scale to 1 (or whatever you need)
		    r.add(temp);
		}
		
		
		animationTimer = new Timer(16, this);
		f.add(this);
		f.addMouseListener(this);
		animationTimer.start();
		f.setVisible(true);
		this.setPreferredSize(new Dimension(2000, 1000));
		
	    this.setFocusable(true);          // make sure Runner JPanel can get focus
	    this.requestFocusInWindow();      // request focus so it actually receives key events
	    this.addKeyListener(this);        // register Runner as its own KeyListener


		
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

		System.out.println(arg0.getKeyCode());
		
		int key = arg0.getKeyCode();

        int moveAmount = 50; // how much hamster moves per key press

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
            h.setX(h.getX() - moveAmount);
        }
        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
            h.setX(h.getX() + moveAmount);
        }
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
            h.setY(h.getY() - moveAmount);
        }
        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
            h.setY(h.getY() + moveAmount);
        }
        
        double newX = h.getX();
        double newY = h.getY();

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
            newX -= moveAmount;
        }
        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
            newX += moveAmount;
        }
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
            newY -= moveAmount;
        }
        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
            newY += moveAmount;
        }

        // Keep inside bounds (example 0 to 2000 width, 0 to 1000 height)
        newX = Math.max(0, Math.min(newX, 2000-h.getWidth()));
        newY = Math.min(newY, 950);
        

        h.setX(newX);
        h.setY(newY);
        
        repaint();
		
	}

	public void keyReleased(KeyEvent arg0) { 
		// TODO Auto-generated method stub
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}