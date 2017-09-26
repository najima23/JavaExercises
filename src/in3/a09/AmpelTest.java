package in3.a09;

import lernhilfe2013ws.graphics.DirtyPainter;
import schimkat.berlin.lernhilfe2017ss.event.Timer;


public class AmpelTest {
	public static void main(String[] ags) {
		DirtyPainter dp1 = new DirtyPainter();

		Ampel a1 = new Ampel(140, 20);
		Ampel a2 = new Ampel(180, 20, "RotGelb");
		Ampel a3 = new Ampel(220, 20, "Gruen");
		Ampel a4 = new Ampel(260, 20, "Gelb");
		AmpelSteuerung steuerrung = new AmpelSteuerung(a1, a2, a3, a4);

		Timer timer = new Timer(1000);
		dp1.add(a1);
		dp1.add(a2);
		dp1.add(a3);
		dp1.add(a4);
		timer.addActionListener(steuerrung);
		timer.start();
		
		dp1.showDrawing();
		while (true) {
			dp1.repaint();
		}

	}

}
