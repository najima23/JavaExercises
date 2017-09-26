package in3.a13.gui.model;

import java.beans.PropertyChangeSupport;

import in3.a13.Ampelphase;
import in3.a13.Command;
import in3.a13.gui.view.AmpelView;

public class AmpelModel {
	protected int x;
	protected int y;
	protected String ampelphase;
	protected PropertyChangeSupport pcSupport;

	
	public AmpelModel(int x1, int y1){
		x=x1;
		y=y1;
		pcSupport=new PropertyChangeSupport(this);
		ampelphase=Ampelphase.rot;
		
		pcSupport.firePropertyChange(Command.AMPEL_MODEL_UPDATED, 1 , this);	 
	}
	
	public AmpelModel(int x1, int y1, String phase){
		this(x1,y1);
		switch (phase) {
		case Ampelphase.gruen :
		case Ampelphase.gelb :
		case Ampelphase.rotGelb : ampelphase=phase; break;
		default : ampelphase=Ampelphase.rot;				
		}
	}
	
	public AmpelModel(AmpelModel that){
		this(that.x,that.y,that.ampelphase);		
	}
	
	public void setPhase(String phase){
		AmpelModel amalt =  new AmpelModel(this);

		switch (phase) {
			case Ampelphase.gruen :
			case Ampelphase.gelb :
			case Ampelphase.rotGelb : ampelphase=phase; 
				break;
			default : ampelphase=Ampelphase.rot;		
		}
		pcSupport.firePropertyChange(Command.AMPEL_MODEL_UPDATED, amalt, this);
	}
	
	public String getPhase(){
		return ampelphase;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public String toString(){
		return String.format("Position:(%d,%d) Phase: %s", x,y,ampelphase);
	}
	
	public void toNextPhase(){
		AmpelModel amalt =  new AmpelModel(this);
		switch (ampelphase) {
		case Ampelphase.rot :ampelphase=Ampelphase.rotGelb;
			break;
		case Ampelphase.gruen :ampelphase=Ampelphase.gelb; break;
		case Ampelphase.gelb :ampelphase=Ampelphase.rot; break;
		case Ampelphase.rotGelb :ampelphase=Ampelphase.gruen; break;
		default : 
		}
		pcSupport.firePropertyChange(Command.AMPEL_MODEL_UPDATED, amalt, this);
	}
	
	public void addPropertyChangeListener(AmpelView av){
		pcSupport.addPropertyChangeListener(av);
	}

	public void removePropertyChangeListener(AmpelView av){
		pcSupport.removePropertyChangeListener(av);
	}
}
