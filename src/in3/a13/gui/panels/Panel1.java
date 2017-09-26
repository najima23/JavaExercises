package in3.a13.gui.panels;

import java.awt.GridLayout;

import javax.swing.JPanel;

import in3.a13.ActionPainter;
import in3.a13.gui.ctrl.AmpelSteuerung;
import in3.a13.gui.view.AmpelView;

public class Panel1 extends JPanel {
	  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Panel1(AmpelView av,AmpelSteuerung aSteuerung, ActionPainter aPainter ){
		setLayout(new GridLayout(0,2));
		add (av);
		add (new KnopfPanel(aSteuerung,aPainter));
	}

}
