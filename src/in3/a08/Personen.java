package in3.a08;


import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import lernhilfe2013ws.io.DirtyFileReader;
import lernhilfe2013ws.io.DirtyFileWriter;
import lernhilfe2013ws.objectPlay.Factory;


public class Personen {
	public static void main (String[] ags){
		PrintWriter out = new PrintWriter(System.out);
		
		lernhilfe2013ws.objectPlay.Person[] p = (Factory.createTestPersons());
		Set<Person> pset = new HashSet<Person>();
		for(int i=0; i<p.length; i++){
			if(pset.add(new Person(p[i]))){}
			
		}
		printPersons(pset,out);
		
		Set<Person> komm = createPersonsFrom("./persondata/kommilitonen.txt");
		Set<Person> sFreunde = createPersonsFrom("./persondata/sportfreunde.txt");
		out.println();
		printPersons(komm,out);
		out.println();
		printPersons(sFreunde,out);
		demoMengenOperationen();

		
	}
	
	public static void printPersons (Set<Person> persons, PrintWriter out){
		//out.println(persons);
		for (Person p:persons){
			out.printf("%s,%n",p);
		}
		out.flush();
		
	}
	
	public static void printPersons (Set<Person> persons, String filename){	
		 printPersons(persons,new PrintWriter(new DirtyFileWriter(filename)));
	}
	

	public static Set<Person> createPersonsFrom(Scanner in){
		Set<Person> pset = new HashSet<Person>();
		while (in.hasNext()){
			pset.add(Person.createPerson(in));
		}
		return pset;
	}
	
	public static Set<Person> createPersonsFrom(String filename){
		 DirtyFileReader DFR =new DirtyFileReader(filename);
		 Scanner sdatei= new Scanner(DFR);
		 Set<Person> z = createPersonsFrom(sdatei);
		 sdatei.close();
		return z;
		
	}
	
	public static void demoMengenOperationen(){
		Set<Person> komm = createPersonsFrom("./persondata/kommilitonen.txt");
		Set<Person> sFreunde = createPersonsFrom("./persondata/sportfreunde.txt");

		lernhilfe2013ws.objectPlay.Person[] p = (Factory.createTestPersons());
		Set<Person> test = new HashSet<Person>();
		for(lernhilfe2013ws.objectPlay.Person i: p){
			test.add(new Person(i));		
		} 
		Set<Person> sUndK = new HashSet<Person>(sFreunde);
		Set<Person> kAberNichtS = new HashSet<Person>(komm);
		Set<Person> tVereinigtK = new HashSet<Person>(test);	
	
		sUndK.retainAll(komm);
		kAberNichtS.removeAll(sFreunde);
		tVereinigtK.addAll(sFreunde);
		
		printPersons(sUndK,"./persondata/SundK.txt");
		printPersons(kAberNichtS,"./persondata/KaberNichtS.txt");
		printPersons(tVereinigtK,"./persondata/TvereinigtK.txt");
	}

}
	