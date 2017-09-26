package Gui;

import javax.swing.*;

public class EinfachenGui1 {
	public static void main(String[] args)  {
		
		JFrame frame = new JFrame();
		JButton button = new JButton("klick mich");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(button);
		
		frame.setSize(300, 300);
		
		frame.setVisible(true);;
		
	}

}
