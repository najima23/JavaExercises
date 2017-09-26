package klausurZwei;

public class Gewaechshaus extends Basisgewaechshaus {
	protected String pflanzenart;
	protected Dimension groesse;
	
	public Gewaechshaus (int t, int lf, String pflanzenart, Dimension groesse){
		super( t,lf);
		this.pflanzenart=pflanzenart;
		this.groesse=groesse;
	}
	public Gewaechshaus (Gewaechshaus ohter){
		this()
	}
	
	

}
