package in3.a03;

import java.io.File;

public class ZweiteVariante {

	 public static void main(String[] args) {
         File[] paths = {
             new File("~"),
             new File("/"),
             new File(".")
         };

         test(paths);
         rekursionprintAll(new File("/Users/najima/Documents/"));
     }

     public static void printAll(File path) {
         System.out.println("Verzeichnis \t\t" + path.getAbsolutePath());
         printFilesOnly(path);
         printDirsOnly(path);
     }

     public static void printAll(String path) {
         printAll(new File(path));
     }

     public static void printFilesOnly(File path) {
         File[] filesList = path.listFiles();
         for(File f : filesList) {
             if (f.isFile())
                 System.out.println("Datei \t\t\t\t\t" + path.getName());
         }
     }

     public static void printDirsOnly(File path) {
         File[] filesList = path.listFiles();
         for(File f : filesList) {
             if(f.isDirectory())
                 System.out.println("Unterverzeichnis \t\t" + path.getName());
         }
     }

     public static void test(File[] paths) {
         for(File f : paths) {
             if(f.isFile() || f.isFile())
                 printAll(f);
         }
     }

     public static void rekursionprintAll(File path) {
         File[] filesList = path.listFiles();

         if (filesList != null) {
             for(File f : filesList) {
                 if (f.isDirectory()) {
                     System.out.println("Verzeichnis \t\t" + f.getName());
                     rekursionprintAll(f);
                 }
                 if (f.isFile())
                     System.out.println("Datei \t\t\t\t" + f.getName());
             }
         }
     }

}
