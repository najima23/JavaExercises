package in3.a05;

import java.io.PrintWriter;
import java.util.Locale;

import lernhilfe2013ws.io.*;

public class FirstOutput {
	
	public static void main(String[] args){
		Locale.setDefault(Locale.US);
		dirtyFileWriterTesten();
		
	}
	
	public static void dirtyFileWriterTesten(){
		DirtyFileWriter writer = new DirtyFileWriter("./testfiles/ganze-zahlen.txt");
		PrintWriter fout = new PrintWriter(writer);
		
		for(int i = 1; i <= 9; i++){
			fout.printf("%d ", i);
		}
		fout.printf("%n %n");
		for(int i = 1; i <= 999; i++){
			fout.printf("%" + 4 + "d ", i);
		}
		fout.printf("%n %n");
		for(int i = 1; i <= 999; i++){
			fout.printf("%" + 11 + "d ", i);
			if(i%10 == 0){
				fout.printf("%n");
			}
		}
		fout.flush();
		fout.close();
	}

}



