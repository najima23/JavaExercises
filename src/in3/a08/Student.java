package in3.a08;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class Student extends Person {
	
	protected String matrikel;
	protected String studiengang;
	
	public Student(String vn, String nachname, int gj,String stG, String mat){
		super(vn,nachname,gj);
		matrikel = mat;
		studiengang = stG;
	}
	
	public String toString(){
		return  String.format("%s %s %s",super.toString(),studiengang,matrikel);
	}
	
	public static Set<Person> createTestPersons(){
	
		Set<Person> pSet = new HashSet<Person>();
		pSet.add(new Person("Hans", "Gerd", 1990));	
		pSet.add(new Person("Benni", "Hosenbund", 1991));	
		pSet.add(new Person("Max", "Mustergerd", 1992));	
		pSet.add(new Person("Tom", "Tommer", 1993));	
		pSet.add(new Person("Fred", "Frodo", 1994));
		
		pSet.add(new Student("Jasper", "Ebbolo", 1995,"TI","s123"));
		pSet.add(new Student("John", "Eclipse", 1996,"Architektur","s234"));
		pSet.add(new Student("Reinhard", "Birke", 1997,"Maschienenbau","s345"));
		pSet.add(new Student("Helmert", "Lunzen", 1998,"BWL","s567"));
		pSet.add(new Student("Henry", "Lenovo", 1999,"Medizin","s456"));
		
		return pSet;
	}
	public static void main (String[] ags){
		PrintWriter out = new PrintWriter(System.out);
		out.printf("%nStudenten und Nichtstudenten:%n");
		Set<Person> pSet = Student.createTestPersons();
		for(Person u: pSet){
			out.printf("%s %n",u);
		}
		out.flush();
	}
}
