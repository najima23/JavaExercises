package Beispiel;

import java.awt.Color;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import lernhilfe2013ws.graphics.DirtyPainter;
import lernhilfe2013ws.graphics.Drawable;

public class AmpelView implements Drawable, PropertyChangeListener{
	protected AmpelModel ampel;
	protected DirtyPainter dp;
	protected int x;
	protected int y;
	protected String ampelphase;
	
	public AmpelView(DirtyPainter painter,AmpelModel ampels ){
		dp = painter;
		ampel = ampels;
		x = ampels.x;
		y = ampels.y;
		ampelphase = ampels.ampelphase;
	
	}
	
	public void propertyChange(PropertyChangeEvent evt){
		if(evt.getPropertyName().equals(Command.AMPEL_MODEL_UPDATED)){
			x = ampel.x;
			y = ampel.y;
			ampelphase = ampel.ampelphase;
			dp.repaint();
		}
	}
	
	public void draw (Graphics g){
		if(Ampelphase.rot.equals(ampelphase) || Ampelphase.rotGelb.equals(ampelphase)) {
			g.setColor(Color.red);	
		}
		else{
			g.setColor(Color.black);
		}
		g.fillOval(x, y, 20,20);
		if(Ampelphase.gelb.equals(ampelphase) || Ampelphase.rotGelb.equals(ampelphase)) {
			g.setColor(Color.yellow);	
		}
		else{
			g.setColor(Color.black);
		}
		g.fillOval(x, y+25,20,20);
		if(Ampelphase.gruen.equals(ampelphase)){
			g.setColor(Color.green);	
		}
		else{
			g.setColor(Color.black);
		}
		g.fillOval(x, y+50,20,20);
	}
	
}
