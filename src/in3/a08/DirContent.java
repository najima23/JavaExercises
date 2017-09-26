package in3.a08;
import java.io.File;
import java.io.PrintWriter;


public class DirContent {
	public static void main (String[] ags){
		
		PrintWriter out = new PrintWriter (System.out, true);
		printAll("/Users/najima",out);
		File[] files={
		new File ("/Users/najima"),
		new File ("."),
		new File ("./src")
		};
		test(files,out);
	}
	public static void test(File[] path, PrintWriter out){
		for (int i =0;i<path.length;i++){
			printAll(path[i],out);
		}
	}
	public static void printAll(File path, PrintWriter out){
		
		out.printf("Verzeichnis   %s%n%n", 	path.getAbsolutePath());
		printFilesOnly(path,out);
		printDirsOnly(path,out);
		out.println();
		
	
	}
	
	public static void printAll(String path, PrintWriter out){
		printAll(new File (path),out);
	}
	
	public static void printFilesOnly (File path, PrintWriter out){
		File[] lpath=path.listFiles(new FileFileFilter());
		if(lpath==null){
			return;
		}
			for (int i =0;i<lpath.length;i++){
				out.printf("Datei              %s%n%n",lpath[i].getName());
			}
		}
		
	
	public static void printDirsOnly(File path, PrintWriter out){
		File[] lpath=path.listFiles(new DirFileFilter());
		if(lpath==null){
			return;
		}
		for (int i =0;i<lpath.length;i++){
				out.printf("Unterverzeichnis   %s%n%n",lpath[i].getName());
		}
			
	}
}

