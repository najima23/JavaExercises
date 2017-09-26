package in3.a13.gui.panels;


import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import in3.a10.Command;
import in3.a13.ActionPainter;
import in3.a13.gui.ctrl.AmpelSteuerung;

public class KnopfPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public KnopfPanel(AmpelSteuerung aSteuerung, ActionPainter aPainter){
		setLayout(new GridLayout(1,0));
		JButton button1 = new JButton("Red & Stop");
		JButton button2 = new JButton("Reset &Go");
		JButton button3 = new JButton("Stop!");
		button1.setActionCommand(Command.RED_ALL);
		button1.addActionListener(aPainter);
		button1.addActionListener(aSteuerung);
		button2.setActionCommand(Command.RESET_ALL);
		button2.addActionListener(aPainter);
		button2.addActionListener(aSteuerung);
		button3.addActionListener(aPainter);
		button3.addActionListener(aSteuerung);
		button3.setActionCommand(Command.STOP_ALL);
		add (button1);
		add (button2);
		add (button3);
		
	}
	
}
