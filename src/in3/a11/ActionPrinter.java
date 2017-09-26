package in3.a11;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

public class ActionPrinter implements ActionListener{
	protected PrintWriter prw;
	protected long startTime;
	
	public ActionPrinter(PrintWriter prw, long startTime){
		this.prw=prw;
		this.startTime=startTime;
	}
	
	public void actionPerformed(ActionEvent e) {
		prw.printf("%d ms:  ActionEvent mit Command \"%s\"%n",e.getWhen()-startTime,e.getActionCommand());
		prw.flush();
	}

}
