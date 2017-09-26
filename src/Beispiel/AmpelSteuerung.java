package Beispiel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AmpelSteuerung implements ActionListener {

	protected AmpelModel[] ampeln ;
	protected String[] startPhasen ;
	protected boolean active;
	
	public AmpelSteuerung(AmpelModel ampel1, AmpelModel ampel2, AmpelModel ampel3, AmpelModel ampel4) {
		ampeln = new AmpelModel [4];
		ampeln[0] = ampel1;
		ampeln[1] = ampel2;
		ampeln[2] = ampel3;
		ampeln[3] = ampel4;
		
		startPhasen = new String [4];
		
		for (int i=0;i<ampeln.length;i++){
			startPhasen[i] =ampeln[i].getPhase();
		}
		active=true;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(Command.NEXT_PHASE) && active) {
			for (AmpelModel a : ampeln) {
				a.toNextPhase();
			}
		} else if (e.getActionCommand().equals(Command.RESET_ALL)) {
			for (int i=0;i<ampeln.length;i++){
				ampeln[i].setPhase(startPhasen[i]);
			}
			active = true;
		} else if (e.getActionCommand().equals(Command.RED_ALL)) {
			for (AmpelModel a : ampeln) {
				a.setPhase(Ampelphase.rot);
			}
			active = false;
		}else if (e.getActionCommand().equals(Command.STOP_ALL)){
			active = false;
		}
		
	}

}












