package in3.a08;

import java.io.File;
import java.io.FileFilter;

public class FileFileFilter implements FileFilter {
	public FileFileFilter(){
		
	}
	
	public boolean accept(File f){
		return f.isFile();
		 
	}

}
