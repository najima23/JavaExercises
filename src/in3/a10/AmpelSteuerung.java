package in3.a10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AmpelSteuerung implements ActionListener {

	Ampel[] ampeln = new Ampel [4];
	String[] startPhasen = new String [4];
	boolean shouldRunNextPhase;
	
	public AmpelSteuerung(Ampel ampel1, Ampel ampel2, Ampel ampel3, Ampel ampel4) {
		ampeln[0] = ampel1;
		ampeln[1] = ampel2;
		ampeln[2] = ampel3;
		ampeln[3] = ampel4;

		for (int i=0;i<ampeln.length;i++){
			startPhasen[i] =ampeln[i].getAmpelphase();
		}
		shouldRunNextPhase=true;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(Command.NEXT_PHASE) && shouldRunNextPhase) {
			for (Ampel a : ampeln) {
				a.toNextPhase();
			}
		} else if (e.getActionCommand().equals(Command.RESET_ALL)) {
			for (int i=0;i<ampeln.length;i++){
				ampeln[i].setAmpelphase(startPhasen[i]);
			}
			shouldRunNextPhase = true;
		} else if (e.getActionCommand().equals(Command.STOP_ALL)) {
			shouldRunNextPhase = false;
			for (Ampel a : ampeln) {
				a.setAmpelphase(Ampelphase.red);
			}
//		}else if (e.getActionCommand().equals(Command.STOP_ALL)){
//			shouldRunNextPhase = false;
		}
		
	}

}







