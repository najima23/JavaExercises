package in3.a08;

import java.io.File;
import java.io.FileFilter;

public class DirFileFilter implements FileFilter {
	public DirFileFilter(){
		
	}
	
	public boolean accept(File f){
		return f.isDirectory();
		 
	}

}