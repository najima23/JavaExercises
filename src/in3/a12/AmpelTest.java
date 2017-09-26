package in3.a12;



import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.io.PrintWriter;

import javax.swing.JFrame;

import in3.a12.gui.ctrl.AmpelSteuerung;
import in3.a12.gui.model.AmpelModel;
import in3.a12.gui.view.AmpelView;
import schimkat.berlin.lernhilfe2017ss.event.Timer;


public class AmpelTest {
	public static void main(String[] ags) {


		JFrame frame = new JFrame("AMPELAUFGABE"); 
		Container container = frame;
		container.setLayout(new BorderLayout());
		Container container2 = new Container();
		container2.setLayout(new GridLayout(0,4));
		container.add(container2, BorderLayout.CENTER);
		AmpelModel ampel1 = new AmpelModel(20,20);
		AmpelModel ampel2 = new AmpelModel(20, 20, Ampelphase.rotGelb);
		AmpelModel ampel3 = new AmpelModel(20, 20, Ampelphase.gruen);
		AmpelModel ampel4 = new AmpelModel(20, 20, Ampelphase.gelb);
		AmpelView ampelView1 = new AmpelView(ampel1);
		AmpelView ampelView2 = new AmpelView(ampel2);
		AmpelView ampelView3 = new AmpelView(ampel3);
		AmpelView ampelView4 = new AmpelView(ampel4);
		ampel1.addPropertyChangeListener(ampelView1);
		ampel2.addPropertyChangeListener(ampelView2);
		ampel3.addPropertyChangeListener(ampelView3);
		ampel4.addPropertyChangeListener(ampelView4);
		
		container2.add(ampelView1);
		container2.add(ampelView2);
		container2.add(ampelView3);
		container2.add(ampelView4);
		
		
		Timer eTimer = new Timer(1000);
		eTimer.setActionCommand(Command.NEXT_PHASE);
		Timer redTimer = new Timer(10000);
		redTimer.setActionCommand(Command.RED_ALL);
		Timer resetTimer = new Timer(15000);
		resetTimer.setActionCommand(Command.RESET_ALL);
		Timer stopTimer = new Timer(19000);
		stopTimer.setActionCommand(Command.STOP_ALL);
		AmpelSteuerung aSteuerung = new AmpelSteuerung(ampel1, ampel2, ampel3, ampel4);
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
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 1000);
		frame.setVisible(true);
		
//		dp1.showDrawing();
//		while (true) {
//			dp1.repaint();
//		}

	}

}
