package in3.a02;

import java.lang.Math;

public class TablePrint {
	
	public static void main(String[] args){
		printTable(0.1, 0.9, 16);
		System.out.printf("\n");
		printTable(1, 9, 20);
		System.out.printf("\n");
		printTable(-9, 0.9, 25);
	}
	
	public static double f(double x){
		return (x-17)*(x+12)/(x*x+0.1);
	}
	
	public static double g(double x){
		return x * Math.sin(x);
	}
	
	public static void printTable(double xMin, double xMax, int width){
		printHeader(width);
		printBody(xMin, xMax, width);
		for(int i = 0; i<(width+1)*3-1;i++){
			System.out.printf("-");
		}
	}
	
	protected static void printHeader(int width){
		System.out.printf("%"+ width +"s %"+ width +"s %"+ width +"s\n", "x","f(x)","g(x)");
		for(int i = 0; i<(width+1)*3-1;i++){
			System.out.printf("-");
		}
		System.out.printf("\n");
	}
	
	protected static void printBody(double xMin, double xMax, int width){
		double Faktor = (xMax - xMin) /8;
		for(int i = 0; i<10; i++){
			printLine(xMin+Faktor*i, width);
		}
	}
	
	protected static void printLine(double x, int width){
		System.out.printf("%"+ width +".02f %"+ width +".7f %"+ width +".7f\n", x,f(x),g(x));
	}
}	
