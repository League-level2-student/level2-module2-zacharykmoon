package _08_LeagueSnake;

import java.util.ArrayList;

import processing.core.PApplet;

public class LeagueSnake extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 800;
    
    /*
     * Game variables
     * 
     * Put all the game variables here.
     */

 Segment head;
int foodX;
int foodY;

int hx = 250;
int hy = 250;
int direction = UP;
int food = 0;
boolean fail = false;
int nowx = 250;
int nowy = 250;
ArrayList<Segment> segments = new ArrayList<Segment>();
ArrayList<Integer> nx = new ArrayList<Integer>();
ArrayList<Integer> ny = new ArrayList<Integer>();
ArrayList<Integer> px = new ArrayList<Integer>();
ArrayList<Integer> py = new ArrayList<Integer>();
    /*
     * Setup methods
     * 
     * These methods are called at the start of the game.
     */
    @Override
    public void settings() {
        size(500,500);
    }

    @Override
    public void setup() {
    	head = new Segment(250, 250, this);
		frameRate(20);
		dropFood();

		px.add(5);
		py.add(5);
		nx.add(5);
	    ny.add(5);
    }

    void dropFood() {
        // Set the food in a new random location
        foodX = ((int)random(50)*10);
        foodY = ((int)random(50)*10);
    }

    /*
     * Draw Methods
     * 
     * These methods are used to draw the snake and its food
     */

    @Override
    public void draw() {
        background(205,100,0);
        drawFood();
        drawSnake();
        eat();
        manageTail();
    }

    void drawFood() {
        // Draw the food
        foodX=10*10;
        fill(160,0,0);
       
    }

    void drawSnake() {
        // Draw the head of the snake followed by its tail
    	stroke(50, 255, 100);    	
    	fill(200,0,100);
    	rect(head.x,head.y,15,10);
    	drawTail();
    }

    void drawTail() {
        // Draw each segment of the tail
    	for (int i = 0; i < segments.size(); i++) {
			segments.get(i).draw();
		}
		System.out.println(segments.size());
		
    }

    /*
     * Tail Management methods
     * 
     * These methods make sure the tail is the correct length.
     */

    void manageTail() {
        // After drawing the tail, add a new segment at the "start" of the tail and
        // remove the one at the "end"
        // This produces the illusion of the snake tail moving.
    	segments.add(new Segment(hx, hy, this));
		segments.remove(0);
		System.out.println(hx + " " + hy);
    }

    void checkTailCollision() {
        // If the snake crosses its own tail, shrink the tail back to one segment
        
    }

    /*
     * Control methods
     * 
     * These methods are used to change what is happening to the snake
     */

    @Override
    public void keyPressed() {
        // Set the direction of the snake according to the arrow keys pressed
    	 
    		// Set the direction of the snake according to the arrow keys pressed
    		if (keyCode == 37 || keyCode == 65) {
    			if (direction != RIGHT) {
    				direction = LEFT;

    			}
    		}
    		if (keyCode == 38 || keyCode == 87) {
    			if (direction != DOWN) {
    				direction = UP;

    			}
    		}
    		if (keyCode == 39 || keyCode == 68) {
    			if (direction != LEFT) {
    				direction = RIGHT;
    			}
    		}

    		if (keyCode == 40 || keyCode == 83) {
    			if (direction  != UP) {
    				direction = DOWN;
    			}

    		}
    	}
    	
    void move() {
        // Change the location of the Snake head based on the direction it is moving.
    	System.out.println("y " + head.y);
		System.out.println("x "+ head.x);
        
        if (direction== UP) {
            // Move head up
        	head.y = head.y - 10;

        } else if (direction == DOWN) {
         	 
            // Move head down
        	head.y = head.y + 10;
        } else if (direction == LEFT) {
         	 
        	head.x = head.x - 10;
        } else if (direction == RIGHT) {
        	head.x = head.x + 10;
   
        }
      	checkBoundaries();
    }

    void checkBoundaries() {
        // If the snake leaves the frame, make it reappear on the other side
    	if (head.x > 500) {
			head.x = 0;
		}
		if (head.y > 500) {
			head.y = 0;
		}
		if (head.y < 0) {
			head.y = 500;
		}
		if (head.x < 0) {
			head.x = 500;
		}
		
	}

    

    void eat() {
        // When the snake eats the food, its tail should grow and more
        // food appearif (head.x == foodX && head.y == foodY) {
    	if (foodX >= head.x && foodX <= head.x) {
    		if(foodY >= head.y && foodY <= head.y) {
food  += 1;
		dropFood();
		drawTail();
    		}
    		for(int i =10; i>0; i--) {
				segments.add(new Segment(hx, hy, this));
}
		
    }
    }
    static public void main(String[] passedArgs) {
        PApplet.main(LeagueSnake.class.getName());
    }
}
