import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
	Hamster h = new Hamster(500, 850);
	Hamster hLocked = new Hamster(800, 850);
	Background b = new Background();
	EagHealth e = new EagHealth(160, -600);
	ArrayList<Cloud> c = new ArrayList<Cloud>();
	ArrayList<Building> buildings = new ArrayList<Building>();
	ArrayList<Road> r = new ArrayList<Road>();
	Eagle E = new Eagle(10,400);
	ArrayList<Obstacles> cars = new ArrayList<Obstacles>();
	Ammo am = new Ammo();
	
	PowerUp powerUp = new PowerUp(1, 2010, 900); 
//	Obstacles cars = new Obstacles(1, 2010, 900); 
	Title t = new Title();
	StartButton sb = new StartButton(700, 400);
	EndScreen es = new EndScreen();
	WinScreen ws = new WinScreen();
	HamHealth hh = new HamHealth(10, 950);
	
	
	boolean gameStarted = false;
	boolean gameLose = false;
	boolean gameWin = false;
    Timer animationTimer;
    boolean ammo = true;
    boolean shield = false;
    boolean tempShield = false;
    int tempShieldTimer = 2000;

	
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
		
	    if(gameLose){
	    	g.setColor(Color.black);
	    	g.fill3DRect(0, 0, 2000, 2000, gameLose);
	    	es.paint(g);
	    	ammo = false;
	    	shield = false;
	    //add end sounds here, eagle-scream.wav and hamsterDying
	       return;
	    }	
	    
	    if (gameWin) {
	    	g.setColor(Color.black);
	    	g.fill3DRect(0, 0, 2000, 2000, gameLose);
	    	ws.paint(g);
	    	ammo = false;
	    	shield = false;
	    	
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
		
		h.paint(g);
		
		powerUp.paint(g);
		
		for (Obstacles asdf: cars) {
			asdf.paint(g);
		}
		
		
		E.paint(g);
		
		hh.paint(g);//overlay, should always be printed last
		
		if (ammo == true) {
			am.paint(g);
		}
		
		if (powerUp.isColliding(h) && powerUp.getType() <= 1 && powerUp.getLane() == h.getLane()) {
			powerUp.reset();
			if (hh.getHamHealth() < 3) {
				hh.hamHeal();
			}
		} else if (powerUp.isColliding(h) && powerUp.getType() == 2 && powerUp.getLane() == h.getLane()){
			powerUp.reset();
			shield = true;
		} else if (powerUp.isColliding(h) && powerUp.getType() >= 3 && powerUp.getLane() == h.getLane()) {
			powerUp.reset();
			ammo = true;
		}
		
		if (hh.getHamHealth() == 0) {
			gameLose = true;
		}
		
		for (Obstacles a: cars) {
			if (a.isColliding(h) && a.getLane() == h.getLane()) {
				a.reset();
				//car crash sound
				if (shield) {
					shield = false;
				} else if (hh.getHamHealth() > 0){
					hh.hamDmg();
					h.setX(500);
				}
			}
		}
		
		if (shield == true) {
			
			Graphics2D g2 = (Graphics2D) g;
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f)); // 50% transparency
			g2.setColor(Color.cyan);
			g2.fillOval((int)h.getX() + 50, (int)h.getY(), 100, 100);
		}
		
		if (e.getHealth() == 0) {
			gameWin = true;
			e.setHealth(9);
			//play eagle dying sound
		}
		
		
		
//		System.out.println("End of paint");
	} // paint end
	
	public void shoot() {
		
//		if (ammo) {
//			//play sound here for shotgun sound
//			ammo = false;
//			e.eagDmg();
//		} else {
//			//play missing ammo sound
//		}
		e.eagDmg();
	}


	public static void main(String[] arg) {
		Runner m = new Runner();
	}
	
	public Runner() {
		
		JFrame f = new JFrame("Method Use");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(2000,1100);
		
		powerUp.reset();
		
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
		
		for (int i = 0; i < 4; i++) {
			Obstacles a = new Obstacles(1);
			a.reset();
			a.setX((int)(Math.random()*2000)+2000);
			cars.add(a);
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
	 	else if (gameLose || gameWin) {
	        gameLose = false;
	        gameWin = false;
	        //resets game
	        h = new Hamster(500, 850);  
	    	hh = new HamHealth(10, 950);
	    	E = new Eagle(10,400);
	    	e = new EagHealth(160, -600);
	    	powerUp = new PowerUp(1, 2010, 900); 
	        gameStarted = false;
	        animationTimer.restart();
	        
	        hh.setHamHealth(3); //reseting everything back to normal
	        hh.update();
	        e.setHealth(9);
	        e.update();
	        shield = false;
	        ammo = false;
	        powerUp.reset();
	        
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
        newX = Math.max(500, Math.min(newX, 1500-h.getWidth()));
        newY = Math.max(650, Math.min(newY, 950));
        
        //ham movement
        h.setX(newX);
        h.setY(newY);
        //eagle follow ham
        E.setX(newX- 300);
        E.setY(newY - 300);
        
        if (key == 32) {
        	shoot();
        }
        
        repaint();
        
        System.out.println(key);
		
	}

	public void keyReleased(KeyEvent arg0) { 
		
	}

	public void keyTyped(KeyEvent arg0) {
		
	}
}