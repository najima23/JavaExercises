package in3.a12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

public class ActionPainter implements ActionListener{
	protected PrintWriter pw;
	protected long startTime;
	
	public ActionPainter(PrintWriter pw, long startTime){
		this.pw=pw;
		this.startTime=startTime;
	}
	
	public void actionPerformed(ActionEvent e) {
		pw.printf("%d ms:  ActionEvent mit Command \"%s\"%n",e.getWhen()-startTime,e.getActionCommand());
		pw.flush();
	}

}
