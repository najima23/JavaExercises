package in3.a06;

import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

import lernhilfe2013ws.io.DirtyFileReader;
import lernhilfe2013ws.io.DirtyFileWriter;
import lernhilfe2013ws.objectPlay.Factory;
import lernhilfe2013ws.objectPlay.Person;
import lernhilfe2013ws.objectPlay.PersonSet;

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
	
	public static PersonSet testPersonen(){
		PersonSet testPersonen = new PersonSet();
		Person[] personArray = Factory.createTestPersons();
		for (int i = 0; i < personArray.length; i++) {
			testPersonen.add(personArray[i]);
		}
		return testPersonen;
	}
	
	
	public static void printPersons(PersonSet persons, PrintWriter out){
		for(Person person : persons){
			out.println(person);
		}
	}
	
	public static void printPersons(PersonSet persons, String filename){
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
	
	public static PersonSet getPersonFrom(Scanner in){
		PersonSet returnPersons = new PersonSet();
		
		while(in.hasNextLine()){
			returnPersons.add(createPerson(in));
		}
		
        return returnPersons;
	}

	public static PersonSet getPersonsFrom(String filename){
		Scanner in = new Scanner(new DirtyFileReader(filename));
		return getPersonFrom(in);
	}
	
	
	public static void demoMengenOperationen(PersonSet s, PersonSet k, PersonSet t){
		PersonSet sTemp = s;
		PersonSet kTemp = k;
		
		s.retainAll(kTemp);
		printPersons(s, "./listen/SundK.txt");
		k.removeAll(sTemp);
		printPersons(k, "./listen/KaberNichtS.txt");
		t.addAll(kTemp);
		printPersons(t, "./listen/TvereinigtK.txt");
	}
}
