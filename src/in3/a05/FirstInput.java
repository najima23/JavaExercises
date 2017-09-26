package in3.a05;

import java.awt.Color;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

import lernhilfe2013ws.graphics.DirtyPainter;
import lernhilfe2013ws.graphics.Point;
import lernhilfe2013ws.io.DirtyFileReader;

public class FirstInput {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		PrintWriter out = new PrintWriter(System.out, true);
		String intNumbers 		= "1 2 3 4 5 b 6 7 8 9";
		String doubleNumbers 	= "0.1 1.1 1.3 0.747 22.7338 0.0 0.6 0.8 1.8";
		String mixedNumbers 	= "2 2.4 2.87 7 8 6.8";

		out.printf("Summe der gelesenen Zahlen (int): 	%d%n", countSumOf(new Scanner(intNumbers)));
		out.printf("Summe der gelesenen Zahlen (double): 	%d%n", countSumOf(new Scanner(doubleNumbers)));
		out.printf("Summe der gelesenen Zahlen (mixed): 	%d%n", countSumOf(new Scanner(mixedNumbers)));
		out.printf("Summe der gelesenen Zahlen (aus Datei): %d%n", countSumOf("./testfiles/double-zahlen.txt"));
		
		paintPointsFrom("./testfiles/double-zahlen.txt");
	}
		
	public static int countSumOf(Scanner in){
		double sum = 0;
		while(in.hasNext()){
			
			if(in.hasNextInt()){
				sum += in.nextInt();
			}
			
			if(in.hasNextDouble()){
				sum += in.nextDouble();
			} else {
				in.next();
			}
		}
		return (int)sum;
	}
	
	public static int countSumOf(String filename){
		DirtyFileReader dfr = new DirtyFileReader(filename);
		Scanner in = new Scanner(dfr);
		int summe = countSumOf(in);
		in.close();
		dfr.close();
		return (int)summe;
	}
	
	public static void paintPointsFrom(Scanner in){
		DirtyPainter dp = new DirtyPainter();
		while(in.hasNext()){
			Point p = new Point(cast(in), cast(in));	
			if (in.hasNextInt()){
				p.setColor(Color.blue);
			} else {
				p.setColor(Color.green);
			}
			dp.add(p);
			dp.showDrawing();
		}
	}
	
	public static void paintPointsFrom(String filename){
		DirtyFileReader writer=new DirtyFileReader(filename);
		Scanner in=new Scanner(writer);
		paintPointsFrom(in);
		in.close();
		writer.close();
	}
	
	public static int cast(Scanner in){
		int x = 0;
		if(in.hasNextInt()){
			x = in.nextInt();
		}
		if(in.hasNextDouble()){
			x =  (int) in.nextDouble();
		}
		return x;
	}
}


