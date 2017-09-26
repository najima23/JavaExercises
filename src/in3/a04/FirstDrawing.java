package in3.a04;

import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;
import lernhilfe2013ws.graphics.*;
//git test
public class FirstDrawing {
	public static void main(String[] args) {
		DirtyPainter painter = new DirtyPainter();

		// paintSomePoints(25, painter);
		// paintSomePoints(50, painter);
		// paintSomePoints(100, painter);
		// paintSomeLines(50, 50, painter);
		//paintSomeOvals(painter);
		paintSinusCurve(1, 250, 100, 0.1, painter);
		// paintDampedSinusCurve(1, 250, 100, 0.1,0.005, painter);

	}

	public static void paintSomePoints(int basicNumber, DirtyPainter painter) {
		for (int i = 0; i <= 500; i++) {
			for (int j = 0; j <= 500; j++) {
				if (i % basicNumber == 0 && j % basicNumber == 0)
					painter.add(new Point(i, j));
			}
		}
		painter.showDrawing();
	}

	public static void paintSomeLines(int dx, int dy, DirtyPainter painter) {
		for (int i = 0; i <= 500; i++) {
			if (i % dy == 0)
				painter.add(new Line(new Point(0, i), new Point(500, i)));
			if (i % dx == 0)
				painter.add(new Line(new Point(i, 0), new Point(i, 500)));
		}
		painter.showDrawing();
	}

	/*
	 * public static void paintSomeLines2(int dx, int dy) { DirtyPainter painter
	 * = new DirtyPainter();
	 * 
	 * for (int i = 0; i <= 500; i++) { if (i % dy == 0) painter.add(new Line(new
	 * Point(0, i), new Point(500, i))); if (i % dx == 0) painter.add(new
	 * Line(new Point(i, 0), new Point(i, 500))); } painter.showDrawing(); }
	 */

	public static int rndmNumbr(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max);
	}

	public static void paintSomeOvals(DirtyPainter painter) {
		for (int i = 0; i < rndmNumbr(10, 21); i++) {
			Point p = new Point(rndmNumbr(0, 501), rndmNumbr(0, 501));
			Oval ov = new Oval(p, rndmNumbr(0, 50), rndmNumbr(0, 50));
			Color c = new Color(rndmNumbr(0, 255), rndmNumbr(0, 255), rndmNumbr(0, 255));
			ov.setColor(c);
			painter.add(ov);
		}
		painter.showDrawing();
	}

	public static double calcsin(double x, double x0, double y0, double a, double f, boolean dumped, double d) {
		if (dumped)
			return a * Math.exp(-d * x) * Math.sin(f * x + x0) + y0;
		return a * Math.sin(f * x + x0) + y0;
	}

	public static void paintSinusCurve(double x0, double y0, double a, double f, DirtyPainter painter) {
		for (int i = 0; i <= 1000; i += 4) {
				painter.add(new Point(i, (int) calcsin(i, x0, y0, a, f, false, 0)));
		}
		painter.showDrawing();
	}

	public static void paintDampedSinusCurve(double x0, double y0, double a, double f, double d, DirtyPainter painter) {
		for (int i = 0; i <= 1000; i += 4) {
				painter.add(new Point(i, (int) calcsin(i, x0, y0, a, f, true, d)));
		}
		painter.showDrawing();
	}
}
