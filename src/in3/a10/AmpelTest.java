package in3.a10;

import java.io.PrintWriter;

import lernhilfe2013ws.graphics.DirtyPainter;
import schimkat.berlin.lernhilfe2017ss.event.Timer;


public class AmpelTest {
	public static void main(String[] args) {
		DirtyPainter dp1 = new DirtyPainter();

		Ampel a1 = new Ampel(20 + 120, 20);
		Ampel a2 = new Ampel(60 + 120, 20, "RotGelb");
		Ampel a3 = new Ampel(100 + 120, 20, "Gruen");
		Ampel a4 = new Ampel(140 + 120, 20, "Gelb");
        
		Timer eTimer = new Timer(1000);
		eTimer.setActionCommand(Command.NEXT_PHASE);
		
//        Timer redTimer = new Timer(10000);
//		redTimer.setActionCommand(Command.RED_ALL);
		//set action command ist der name des events das ausgeführt wird
        Timer resetTimer = new Timer(15000);
		resetTimer.setActionCommand(Command.RESET_ALL);
		
        Timer stopTimer = new Timer(10000);
		stopTimer.setActionCommand(Command.STOP_ALL);
		
        AmpelSteuerung aSteuerung = new AmpelSteuerung(a1, a2, a3, a4);
		ActionPrinter aPainter = new ActionPrinter(new PrintWriter(System.out),System.currentTimeMillis());	
		
        dp1.add(a1);
		dp1.add(a2);
		dp1.add(a3);
        dp1.add(a4);
		//eTimer ist das action event, Listener ist die aSteuerung
        eTimer.addActionListener(aSteuerung);//jeder Listener hat eine methode die actionperformed heißt die ausgeführt wird
		eTimer.addActionListener(aPainter);
		
//        redTimer.addActionListener(aSteuerung);
//		redTimer.addActionListener(aPainter);
		
        resetTimer.addActionListener(aSteuerung);
		resetTimer.addActionListener(aPainter);
		
        stopTimer.addActionListener(aSteuerung);
		stopTimer.addActionListener(aPainter);
		
        eTimer.start();
//		redTimer.start();
		resetTimer.start();
		stopTimer.start();
		
		dp1.showDrawing();
		while (true) {
			dp1.repaint();
		}

	}

}