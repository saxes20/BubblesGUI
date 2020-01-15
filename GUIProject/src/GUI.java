import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.io.*;
import java.awt.Font;

public class GUI {
    private JFrame frame;
    static Bubble b;
    static Queue q; 

    public GUI() {
        frame = new JFrame("Bubbles Program");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(frame.getSize());
        frame.add(new InnerProgram(frame.getSize()));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String... argv) {
        new GUI();
    }

    public static class InnerProgram extends JPanel implements Runnable, MouseListener  {

        ArrayList<String> names = new ArrayList<String>();
        private Thread animator;
        Dimension d;
        String str = "";


        public InnerProgram (Dimension dimension) {
            setSize(dimension);
            setPreferredSize(dimension);
            addMouseListener(this);
            addKeyListener(new TAdapter());
            setFocusable(true);
            d = getSize();

            //for animating the screen - you won't need to edit
            if (animator == null) {
                animator = new Thread(this);
                animator.start();
            }
            setDoubleBuffered(true);
        }

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;

            g2.setColor(Color.black);
            g2.fillRect(0, 0,(int)d.getWidth() , (int)d.getHeight());


            Color co = new Color(255,255,255);
            g2.setColor(co);
            int fontSize = 10;
            g2.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
            g2.drawString("String " + str,20,40);
            
            if (q != null) {
	            for(int x = 0; x<q.size(); x++){
	            		Bubble bub = (Bubble) q.get(x);
	            		if (bub!=null) {
	                		g2.setColor(bub.color);
	                		g2.fillOval(bub.x, bub.y, bub.radius, bub.radius);
	                }
		    			
		    		}
            }
            
            moveBubbles();
            
            
        }
        
        public void moveBubbles() {
        		int max = 255;
			int min = 0;
	        	if (q != null) {
		            for(int x = 0; x<q.size(); x++){
		            		Bubble bub = (Bubble) q.get(x);
		            		if (bub!=null) {
		                		bub.x += bub.xSpeed;
		                		bub.y += bub.ySpeed;
		                }
		            		if (bub.x >= 730 || bub.x <= 0) { 
		            			bub.xSpeed *= -1; 
		            			bub.color = new Color((int)(Math.random() * ((max - min) + 1)) + min,(int)(Math.random() * ((max - min) + 1)) + min,(int)(Math.random() * ((max - min) + 1)) + min);
		            		}
		            		if (bub.y >= 730 || bub.y <= 0) { 
		            			bub.ySpeed *= -1; 
		            			bub.color = new Color((int)(Math.random() * ((max - min) + 1)) + min,(int)(Math.random() * ((max - min) + 1)) + min,(int)(Math.random() * ((max - min) + 1)) + min);
		            		}
			    			
			    		}
	            }
        }

        public int random (int a, int b){    
            int max=a;
            int min=b;
            int random=(int)(Math.random() * (max - min) + min);

            return random;
        }

        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            str = x + " " + y;
            b = new Bubble(x,y);
            if (q == null) {
            		q = new Queue(5);
            }
            q.insert(b);
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mouseClicked(MouseEvent e) {
        }

        private class TAdapter extends KeyAdapter {

            public void keyReleased(KeyEvent e) {
                int keyr = e.getKeyCode();

            }

            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
               // String c = KeyEvent.getKeyText(e.getKeyCode());
              //  c = Character.toString((char) key);

               

               
            }
        }//end of adapter

        public void run() {
            long beforeTime, timeDiff, sleep;
            beforeTime = System.currentTimeMillis();
            int animationDelay = 37;
            long time = System.currentTimeMillis();
            while (true) {// infinite loop
                // spriteManager.update();
                repaint();
                try {
                    time += animationDelay;
                    Thread.sleep(Math.max(0, time - System.currentTimeMillis()));
                } catch (InterruptedException e) {
                    System.out.println(e);
                } // end catch
            } // end while loop
        }// end of run

        
       

    }//end of class
}
