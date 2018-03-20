package Alice;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class aliceTextArea extends aliceJFrame {
	
	private JTextArea endScreen; //provides the area where the text will appear
	private JLabel endlabel; //label for where we are going to stick our textArea to
	private JScrollPane scrollArea; //the content at the end of the code might get a little too full, so lets add a scroll bar
	
	public aliceTextArea () {
		setLayout(new FlowLayout());
		endScreen = new JTextArea(10,50);
		endScreen.setBorder(new TitledBorder(new EtchedBorder(), "END LOG"));
		
		
		endScreen.setEditable(false);
		
		endlabel = new JLabel();
		add(endlabel);
		
		
		scrollArea = new JScrollPane(endScreen);
		scrollArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollArea.setPreferredSize(new Dimension(15,400));
		
		
		//add(scrollArea);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(endScreen);
		setVisible(true);
	}
	
	public void addText(String i ){
		endScreen.append(i + "\n");
	}

	public void append(String endMessage) {
		
		
	}

}
