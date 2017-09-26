package in3.a02.tabelle;

import java.io.PrintWriter;


public class TablePrint {
	public static void main2 (String[] ags){
		printTable(10,8123,20); //mindestens 12 oder so
		printTable(0.1,0.9,14);
		printTable(-30,202,16);
	}
	public static void printTable(double xMin, double xMax, int width){
		printHeader(width);
		strich(width);
		printBody(xMin,xMax,width);
		strich(width);
	}
	protected static void printBody(double xMin, double xMax, int width){
		for(double x = xMin; x<=xMax; x=x+((xMax-xMin)/8)){
			
			printLine(x,width);
			
		}
	}
	protected static void printHeader(int width){
		PrintWriter out = new PrintWriter (System.out, true);
		
		out.printf(" %"+ width +"s %"+ width +"s %"+ width +"s \n","x","f(x)","g(x)");
	}
	protected static void printLine(double x, int width){
		PrintWriter out = new PrintWriter (System.out, true);
	
		out.printf(" %"+ width +".2f %"+ width +".7f %"+ width +".7f\n",x,f(x),g(x) );
		
	}
	protected static double f(double x){
		return((x-17)*(x+12)/(x*x+0.1));	
	}
	protected static double g(double x){
		return(x*Math.sin(x));
	}
	protected static void strich(int width){
		PrintWriter out = new PrintWriter (System.out, true);
		for(int x=width*3+3;x>0;x--){
			out.printf("-");			
		}
		out.printf("\n");
	}
	
}
