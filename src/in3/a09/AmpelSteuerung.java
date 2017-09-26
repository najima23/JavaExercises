package in3.a09;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AmpelSteuerung implements ActionListener {

	Ampel[] ampeln = new Ampel [4];
	
	
	public AmpelSteuerung(Ampel ampel0, Ampel ampel1, Ampel ampel2, Ampel ampel3){
		this.ampeln[0] = ampel0;
		this.ampeln[1] = ampel1;
		this.ampeln[2] = ampel2;
		this.ampeln[3] = ampel3;
	}
	
	public void actionPerformed(ActionEvent e){
		this.ampeln[0].toNextPhase();
		this.ampeln[1].toNextPhase();
		this.ampeln[2].toNextPhase();
		this.ampeln[3].toNextPhase();
	}
	
}






