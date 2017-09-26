                       package in3.a13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

public class ActionPainter implements ActionListener{
	protected PrintWriter pw;
	protected long startZeit;
	
	public ActionPainter(PrintWriter pw, long startZeit){
		this.pw=pw;
		this.startZeit=startZeit;
	}
	
	public void actionPerformed(ActionEvent e) {
		pw.printf("%d ms:  ActionEvent mit Command \"%s\"%n",e.getWhen()-startZeit,e.getActionCommand());
		pw.flush();
	}

}
