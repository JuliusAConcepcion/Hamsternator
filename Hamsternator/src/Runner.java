import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
public class Runner extends JPanel implements ActionListener, MouseListener, KeyListener {
	Hamster h = new Hamster(200, 850);
	Hamster hLocked = new Hamster(800, 850);
	Background b = new Background();
	EagHealth e = new EagHealth(160, -600);
	ArrayList<Cloud> c = new ArrayList<Cloud>();
	ArrayList<Building> buildings = new ArrayList<Building>();
	ArrayList<Road> r = new ArrayList<Road>();
	Eagle E = new Eagle(10,400);
	
	PowerUp powerUp = new PowerUp(1, 2010, 900); 
	Obstacles cars = new Obstacles(1, 2010, 900); 
	Title t = new Title();
	StartButton sb = new StartButton(700, 400);
	EndScreen es = new EndScreen();
	HamHealth hh = new HamHealth(10, 950);
	
	
	boolean gameStarted = false;
	boolean gameOver = false;
    Timer animationTimer;

	
	public void paint(Graphics g) {
		super.paint(g);
		//startscreen graphics
		if (!gameStarted) {
			b.paint(g);
				
		for (Building asdf: buildings) {
			asdf.paint(g);
		}
					
		for (Road asdf: r) {
			asdf.paint(g);
		}
				
		hLocked.paint(g);
		//buttons
		sb.paint(g);
		//add button pressed
		t.paint(g);
		//add happy music here, StartMenuMusic
			return;
	    }
		//gameover graphics
	    if(gameOver){
	    g.setColor(Color.black);
	    g.fill3DRect(0, 0, 2000, 2000, gameOver);
	    es.paint(g);
	    //add end sounds here, eagle-scream.wav and hamsterDying
	       return;
	    }	 
	    
		//running game graphics
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
		hh.paint(g);//overlay, should always be printed last

		if (powerUp.isColliding(h)) {
			PowerUp icon = new PowerUp(powerUp.getType(), 460, 970);
			icon.paint(g);
		}
		if (cars.isColliding(h) ) {
//			hh.hamDmg(); //doesnt change the bar, shows bunch of errors, ethat help
			
		}
		
		
//		System.out.println("End of paint");
	}


	public static void main(String[] arg) {
		Runner m = new Runner();
	}
	
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
		
		
		animationTimer = new Timer(32, this);
		f.add(this);
		f.addMouseListener(this);
		animationTimer.start();
		f.setVisible(true);
		this.requestFocusInWindow();
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
		 sb.update();
	}

	
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//code for game phases, start - running - over
		if (!gameStarted) {
	        gameStarted = true;
	        animationTimer.start();
	        
	        } 
	 	else if (gameOver) {
	        gameOver = false;
	        //resets game
	        h = new Hamster(200, 850);
	    	hh = new HamHealth(10, 950);
	    	E = new Eagle(10,400);
	    	e = new EagHealth(160, -600);
	        cars = new Obstacles(1, 2010, 900);
	    	powerUp = new PowerUp(1, 2010, 900); 
	        gameStarted = false;
	        animationTimer.restart();
	    }
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	    repaint();
	}

	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

//		System.out.println(arg0.getKeyCode());
		
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
        newY = Math.max(650, Math.min(newY, 950));
        
        //ham movement
        h.setX(newX);
        h.setY(newY);
        //eagle follow ham
        E.setX(newX- 300);
        E.setY(newY - 300);
        
        repaint();
		
	}

	public void keyReleased(KeyEvent arg0) { 
		// TODO Auto-generated method stub
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}