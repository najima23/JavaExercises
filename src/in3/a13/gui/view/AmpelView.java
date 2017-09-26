package in3.a13.gui.view;

import java.awt.Color;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import in3.a13.Ampelphase;
import in3.a13.Command;
import in3.a13.gui.model.AmpelModel;

public class AmpelView extends JPanel implements  PropertyChangeListener {
	static final long serialVersionUID =1;//??
	protected AmpelModel ampel;
	protected int x;
	protected int y;
	protected String ampelphase;
	 
	
	public AmpelView(AmpelModel ampels ){
	
		ampel = ampels;
		x = ampels.getX();
		y = ampels.getY();
		ampelphase = ampels.getPhase();
		setSize(50,100);
		setBorder(new TitledBorder ("Ampel"));
	}
	
	public void propertyChange(PropertyChangeEvent evt){
		if(evt.getPropertyName().equals(Command.AMPEL_MODEL_UPDATED)){
			x = ampel.getX();
			y = ampel.getY();
			ampelphase = ampel.getPhase();
			repaint();
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(Ampelphase.rot.equals(ampelphase) || Ampelphase.rotGelb.equals(ampelphase)) {
			g.setColor(Color.red);	
		} else{
			g.setColor(Color.black);
		}
		g.fillOval(x, y, 100,100);
		if(Ampelphase.gelb.equals(ampelphase) || Ampelphase.rotGelb.equals(ampelphase)) {
			g.setColor(Color.yellow);	
		}
		else{
			g.setColor(Color.black);
		}
		g.fillOval(x, y+110,100,100);
		if(Ampelphase.gruen.equals(ampelphase)){
			g.setColor(Color.green);	
		}
		else{
			g.setColor(Color.black);
		}
		g.fillOval(x, y+220,100,100);
	}
	
}
