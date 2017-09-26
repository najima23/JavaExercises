package in3.a05;

import java.io.PrintWriter;
import java.util.Locale;
import java.util.Random;

import lernhilfe2013ws.io.*;

public class FirstIO {
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		PrintWriter out = new PrintWriter(System.out, true);
		
		writeRandomIntNumbersTo(100, 10, out);
		writeRandomIntNumbersTo(100, 10, "./testfiles/ganze-zahlen.txt");
		writeRandomMixedNumbersTo(100, 10, out);
		writeRandomMixedNumbersTo(100, 10, "./testfiles/double-zahlen.txt");
	}
	
	public static void writeRandomIntNumbersTo(int numberCount, int width, PrintWriter out){
		 for(int i = 1; i <= numberCount ; i++){
			out.printf("%" + width + "d", (int) (Math.random() * 1000));
			if(i%10 == 0){
				out.println();
			}
		}
	}

	public static void writeRandomMixedNumbersTo(int numberCount, int width, PrintWriter out){
		Random rand = new Random();
		for(int i = 1; i <= numberCount; i++ ){
			if(rand.nextInt() % 2 == 0){
				out.printf("%" + 10 + "d", (int)(Math.random() * 1000));
			} else {
				out.printf("%" + 10 + ".2f", (double)(Math.random() * 1000));
			}
			if(i%10 == 0){
				out.println();
			}
		}
	}
	
	public static void writeRandomIntNumbersTo(int numberCount, int width, String filename){
		DirtyFileWriter writer = new DirtyFileWriter(filename);
		PrintWriter fout = new PrintWriter(writer);
		writeRandomIntNumbersTo(numberCount, width, fout);
		fout.flush();
		fout.close();
	}
	
	
	
	public static void writeRandomMixedNumbersTo(int numberCount, int width, String filename){
		DirtyFileWriter writer = new DirtyFileWriter(filename);
		PrintWriter fout = new PrintWriter(writer);
		writeRandomMixedNumbersTo(numberCount, width, fout);
		fout.flush();
		fout.close();
	}
}


