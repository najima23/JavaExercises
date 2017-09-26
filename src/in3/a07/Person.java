package in3.a07;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Person {
	String vorname;
	String nachname;
	int geburtsjahr;
	
	public Person(String vorname, String nachname, int geburtsjahr){
		this.vorname=vorname;
		this.nachname=nachname;
		this.geburtsjahr=geburtsjahr;
	}
	public Person(Person that){
		this(that.vorname, that.nachname, that.geburtsjahr);
	}
	
	public Person(lernhilfe2013ws.objectPlay.Person that){
		this(that.getVorname(),that.getNachname(),that.getGeburtsjahr());
	}
	
	public String getVorname(){
		return vorname;
	}

	public String getNachname(){
		return nachname;
	}

	public int getGeburtsjahr(){
		return geburtsjahr;
	}

	public String toString(){
		return String.format("%s %s %d",vorname,nachname,geburtsjahr);
	}
	
//factorymethode waoaw
	public static Person createPerson(Scanner in){
		int jahr=0;
		String vName="",nName="";
		if(in.hasNext()){
			vName=in.next();
		}
		if(in.hasNext()){
			nName=in.next();
		}
		if(in.hasNextInt()){
			jahr=in.nextInt();
		}
		return new Person(vName, nName, jahr);
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + geburtsjahr;
		result = prime * result + ((nachname == null) ? 0 : nachname.hashCode());
		result = prime * result + ((vorname == null) ? 0 : vorname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (geburtsjahr != other.geburtsjahr)
			return false;
		if (nachname == null) {
			if (other.nachname != null)
				return false;
		} else if (!nachname.equals(other.nachname))
			return false;
		if (vorname == null) {
			if (other.vorname != null)
				return false;
		} else if (!vorname.equals(other.vorname))
			return false;
		return true;
	}

}