package in3.a09;

import java.awt.Color;
import java.awt.Graphics;

import lernhilfe2013ws.graphics.Drawable;


public class Ampel implements Drawable{
	
	protected int x;
	protected int y;
	protected String ampelphase;
	
	public Ampel(int x, int y){
		this.x=x;
		this.y=y;
				
		this.ampelphase = Ampelphase.red;
	}
		
	public Ampel (int x1, int y1, String phase){
		this(x1, y1);
		
		switch (phase) {
			case Ampelphase.red:
			case Ampelphase.green:
			case Ampelphase.yellow:
			case Ampelphase.redyellow:
				this.ampelphase=phase;
				break;
			default: 
		}
		
	}
	
	public Ampel(Ampel cAmpel) {
		this(cAmpel.x, cAmpel.y, cAmpel.ampelphase);
	}
	
	public String toString(){
		return String.format("Position:(%d,%d) Phase: %s", x, y, ampelphase);
	}
	
	public void toNextPhase() {
		
		switch (this.ampelphase) {
			case Ampelphase.red:
				this.ampelphase=Ampelphase.redyellow;
				break;
			case Ampelphase.green:
				this.ampelphase=Ampelphase.yellow;
				break;
			case Ampelphase.yellow:
				this.ampelphase=Ampelphase.red;
				break;
			case Ampelphase.redyellow:
				ampelphase=Ampelphase.green;
				break;
		default : 
		}
	}

	public void draw (Graphics gDrawableObject){
		String ampelZustand = this.ampelphase;
		
		if(Ampelphase.red.equals(ampelZustand) || Ampelphase.redyellow.equals(ampelZustand)) {
			gDrawableObject.setColor(Color.red);	
		}
		else{
			gDrawableObject.setColor(Color.black);
		}
		gDrawableObject.fillOval(x, y, 20,20);
		if(Ampelphase.yellow.equals(ampelZustand) || Ampelphase.redyellow.equals(ampelZustand)) {
			gDrawableObject.setColor(Color.yellow);	
		}
		else{
			gDrawableObject.setColor(Color.black);
		}
		gDrawableObject.fillOval(x, y+25,20,20);
		if(Ampelphase.green.equals(ampelZustand)){
			gDrawableObject.setColor(Color.green);	
		}
		else{
			gDrawableObject.setColor(Color.black);
		}
		gDrawableObject.fillOval(x, y + 50, 20, 20);
	} 
}
