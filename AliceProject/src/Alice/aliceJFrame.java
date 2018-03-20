package Alice;

import javax.swing.JFrame;


public class aliceJFrame extends JFrame{
	
	public aliceJFrame () {
		
		aliceJPanel Alice = new aliceJPanel();
		add(Alice);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 600);
		setVisible(true);
		
		
	}

}
