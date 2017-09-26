package Beispiel;


import java.io.PrintWriter;

import lernhilfe2013ws.graphics.DirtyPainter;
import schimkat.berlin.lernhilfe2017ss.event.Timer;


public class AmpelTest {
	public static void main(String[] args) {
		DirtyPainter dp1 = new DirtyPainter();


		AmpelModel am1 = new AmpelModel(20 + 120, 20);
		AmpelModel am2 = new AmpelModel(60 + 120, 20, Ampelphase.rotGelb);
		AmpelModel am3 = new AmpelModel(100 + 120, 20, Ampelphase.gruen);
		AmpelModel am4 = new AmpelModel(140 + 120, 20, Ampelphase.gelb);
		AmpelView aw1 = new AmpelView(dp1,am1);
		AmpelView aw2 = new AmpelView(dp1,am2);
		AmpelView aw3 = new AmpelView(dp1,am3);
		AmpelView aw4 = new AmpelView(dp1,am4);
		am1.addPropertyChangeListener(aw1);
		am2.addPropertyChangeListener(aw2);
		am3.addPropertyChangeListener(aw3);
		am4.addPropertyChangeListener(aw4);
		Timer eTimer = new Timer(1000);
		eTimer.setActionCommand(Command.NEXT_PHASE);
		Timer redTimer = new Timer(10000);
		redTimer.setActionCommand(Command.RED_ALL);
		Timer resetTimer = new Timer(15000);
		resetTimer.setActionCommand(Command.RESET_ALL);
		Timer stopTimer = new Timer(19000);
		stopTimer.setActionCommand(Command.STOP_ALL);
		AmpelSteuerung aSteuerung = new AmpelSteuerung(am1, am2, am3, am4);
		ActionPainter aPainter = new ActionPainter(new PrintWriter(System.out),System.currentTimeMillis());	
		
		//bla123
		dp1.add(aw1);
		dp1.add(aw2);
		dp1.add(aw3);
		dp1.add(aw4);
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
		
		dp1.showDrawing();
//		while (true) {
//			dp1.repaint();
//		}

	}

}
