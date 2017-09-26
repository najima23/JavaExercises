package in3.a07.mitSet;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import lernhilfe2013ws.io.DirtyFileReader;
import lernhilfe2013ws.io.DirtyFileWriter;
import lernhilfe2013ws.objectPlay.Factory;
import lernhilfe2013ws.objectPlay.Person;


public class Personen {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		PrintWriter out = new PrintWriter(System.out, true);
		
		printPersons(testPersonen(), out);
		printPersons(testPersonen(), "./listen/Versuch.txt");
		demoMengenOperationen(
				getPersonsFrom("./listen/sportfreunde.txt"), 
				getPersonsFrom("./listen/kommilitonen.txt"), testPersonen());
	}
	
	public static Set<Person> testPersonen(){
		Set<Person> testPersonen = new HashSet<Person>();
		Person[] personArray = Factory.createTestPersons();
		for (int i = 0; i < personArray.length; i++) {
			testPersonen.add(personArray[i]);
		}
		return testPersonen;
	}
	
	
	public static void printPersons(Set<Person> persons, PrintWriter out){
		for(Person person : persons){
			out.println(person);
		}
	}
	
	public static void printPersons(Set<Person> persons, String filename){
		PrintWriter fout = new PrintWriter(new DirtyFileWriter(filename));
		for(Person person : persons){
			fout.println(person);
		}
		fout.flush();
		fout.close();
	}
	
	
	public static Person createPerson(Scanner in){
		String name = in.next();
		String surname = in.next().replace(",", "");
		in.next(); // To ignore 'geb.' 
		int date = in.nextInt();
		
			return new Person(name, surname, date);
	}
	
	public static Set<Person> getPersonFrom(Scanner in){
		Set<Person> returnPersons = new HashSet<Person>();
		
		while(in.hasNextLine()){
			returnPersons.add(createPerson(in));
		}
		
        return returnPersons;
	}

	public static Set<Person> getPersonsFrom(String filename){
		Scanner in = new Scanner(new DirtyFileReader(filename));
		return getPersonFrom(in);
	}
	
	
	public static void demoMengenOperationen(Set<Person> s, Set<Person> k, Set<Person> t){
		Set<Person> sTemp = s;
		Set<Person> kTemp = k;
		
		s.retainAll(kTemp);
		printPersons(s, "./listen/SundK.txt");
		k.removeAll(sTemp);
		printPersons(k, "./listen/KaberNichtS.txt");
		t.addAll(kTemp);
		printPersons(t, "./listen/TvereinigtK.txt");
	}
}
