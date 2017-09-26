package in3.a13;



import java.awt.BorderLayout;
import java.awt.Container;
import java.io.PrintWriter;

import javax.swing.JFrame;

import in3.a13.gui.ctrl.AmpelSteuerung;
import in3.a13.gui.model.AmpelModel;
import in3.a13.gui.view.AmpelView;
import in3.a13.gui.panels.Panel1;
import schimkat.berlin.lernhilfe2017ss.event.Timer;


public class AmpelTest {
	public static void main(String[] ags) {


		JFrame frame = new JFrame("AMPELAUFGABE"); 
		Container container = frame.getContentPane();
		container.setLayout(new BorderLayout());
	
		AmpelModel am1 = new AmpelModel(20,20);
		AmpelModel am2 = new AmpelModel(20, 20, Ampelphase.rotGelb);
		AmpelModel am3 = new AmpelModel(20, 20, Ampelphase.gruen);
		AmpelModel am4 = new AmpelModel(20, 20, Ampelphase.gelb);
		AmpelView aw1 = new AmpelView(am1);
		AmpelView aw2 = new AmpelView(am2);
		AmpelView aw3 = new AmpelView(am3);
		AmpelView aw4 = new AmpelView(am4);
		am1.addPropertyChangeListener(aw1);
		am2.addPropertyChangeListener(aw2);
		am3.addPropertyChangeListener(aw3);
		am4.addPropertyChangeListener(aw4);

		
		
		
		Timer eTimer = new Timer(1000);
		eTimer.setActionCommand(Command.NEXT_PHASE);
		Timer redTimer = new Timer(10000);
		Timer resetTimer = new Timer(15000);
		Timer stopTimer = new Timer(19000);
		
		AmpelSteuerung aSteuerung = new AmpelSteuerung(am1, am2, am3, am4);
		ActionPainter aPainter = new ActionPainter(new PrintWriter(System.out),System.currentTimeMillis());	
		
		eTimer.addActionListener(aSteuerung);
		eTimer.addActionListener(aPainter);
		redTimer.addActionListener(aSteuerung);
		redTimer.addActionListener(aPainter);
		resetTimer.addActionListener(aSteuerung);
		resetTimer.addActionListener(aPainter);
		stopTimer.addActionListener(aSteuerung);
		stopTimer.addActionListener(aPainter);
		eTimer.start();
		redTimer.start();
		resetTimer.start();
		stopTimer.start();
		
		Panel1 P1 = new Panel1(aw1,aSteuerung,aPainter);
		container.add(P1);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 500);
		frame.setVisible(true);
	}

}
