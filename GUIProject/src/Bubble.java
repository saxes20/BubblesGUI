import java.awt.*;

public class Bubble {
	int x; 
	int y; 
	int radius;
	int width;
	int height; 
	Color color; 
	int xSpeed;
	int ySpeed;
	public Bubble (int x, int y) {
		this.x = x;
		this.y = y;
		int max = 255;
		int min = 0;
		color = new Color((int)(Math.random() * ((max - min) + 1)) + min,(int)(Math.random() * ((max - min) + 1)) + min,(int)(Math.random() * ((max - min) + 1)) + min);
		radius = (int)(Math.random() * ((100 - 50) + 1)) + 50;
		xSpeed = (int)(Math.random() * ((20 - 5) + 1)) + 5;
		ySpeed = (int)(Math.random() * ((20 - 5) + 1)) + 5;
	}
}
