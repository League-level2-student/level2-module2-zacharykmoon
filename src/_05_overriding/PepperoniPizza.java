package _05_overriding;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * GOAL: Override the show() and receipt() methods from Pizza
 */
public class PepperoniPizza extends Pizza {
	JFrame frame = new JFrame();
	JLabel label = new JLabel();

public void make() {
	frame.setVisible(true);
	frame.add(label);
	frame.setSize(500,500);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
	// 1. Copy the show() method from Pizza, but change it so it shows a Pepperoni Pizza 

@Override 
	public void show() {
		frame.setTitle("Pepperoni Pizza");
		label.setIcon(loadImage("pepperoniPizza.png"));
}
	// 2. Add @Override above the method
	//	  This helps with preventing errors(you can ask your teacher for further explanation)
	
	
	// 3. Copy the receipt() method from Pizza, but change it so a Pepperoni Pizza is $12
@Override 
		public void receipt() {
			System.out.println("You purchased a pepperoni pizza for $12");
		}
		
	// 4. Add the @Override tag
public static ImageIcon loadImage(String fileName) {
	try {
		return new ImageIcon(ImageIO.read(new Pizza().getClass().getResourceAsStream(fileName)));
	} catch (IOException e) {
		e.printStackTrace();
		return null;
	}
	}
}

