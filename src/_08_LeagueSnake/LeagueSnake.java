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
int dir = UP;
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
        background(25,50,100);
        drawFood();
        drawSnake();
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
    	square(foodX,foodY,15);
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
        if(keyCode== 37 || keyCode == 65) {
        	if(dir !=RIGHT) {
        		dir = LEFT;
        }
    }
    if(keyCode == 38 || keyCode == 87) {
    	if (dir != DOWN) {
			dir = UP;

		}
	}
    if(keyCode == 39 || keyCode == 68) {
    	if(dir !=LEFT) {
    		dir = RIGHT;
    	}
    }
    if(keyCode == 40 || keyCode == 83) {
    	if (dir != UP) {
			dir = DOWN;
    }
    }
    }
    void move() {
        // Change the location of the Snake head based on the direction it is moving.

        
        if (dir == UP) {
            // Move head up
        	hy -= 10;
        } else if (dir== DOWN) {
            // Move head down
        	hy += 10;
        } else if (dir == LEFT) {
        	hx -= 100;
        } else if (dir == RIGHT) {
        	hx += 100;
        }
        
    }

    void checkBoundaries() {
        // If the snake leaves the frame, make it reappear on the other side
        
    }

    void eat() {
        // When the snake eats the food, its tail should grow and more
        // food appear
        
    }

    static public void main(String[] passedArgs) {
        PApplet.main(LeagueSnake.class.getName());
    }
}
