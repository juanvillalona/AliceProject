package Alice;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;

public class aliceJPanel  extends JPanel implements ActionListener {
	
	private JLabel labelOut;
	private JTextField userInput;
	private JButton submitBtn;
	private JButton quitBtn;
	private JButton longestWordBtn;
	private JTextArea endScreen;
	private JScrollPane scrollArea;

	public aliceJPanel() {
		setLayout(new GridLayout(7, 1));
		labelOut = new JLabel("Tell me, what's on your mind today in one sentence");
		userInput = new JTextField("", 10);

		
		add(labelOut);
		JPanel userPanel = new JPanel();
		userPanel.setBorder(new TitledBorder(new EtchedBorder(), "Enter Your Responses Here!")); //found through google 
		userPanel.setLayout(new GridLayout(1, 2));
		userPanel.add(userInput);
		add(userPanel);
		
		submitBtn = new JButton("Submit");
		quitBtn = new JButton ("Quit");
		longestWordBtn = new JButton("Longest Words");
		
		submitBtn.addActionListener(this);
		quitBtn.addActionListener(this);
		longestWordBtn.addActionListener(this);
		
		
		JPanel btnSelect = new JPanel();
		btnSelect.add(submitBtn);
		btnSelect.add(quitBtn);
		btnSelect.add(longestWordBtn);
		add(btnSelect);
		
		
		
		JPanel endPanel = new JPanel();
		endPanel.setLayout(new GridLayout(1,15));

	
		endScreen = new JTextArea();
		endScreen.setEditable(false);
		endScreen.setFont(new Font("Serif", Font.BOLD, 16));
		
		
		endScreen.setSize(0, 0);
		scrollArea = new JScrollPane(endScreen);
	
		add(endPanel);
		endPanel.add(new JScrollPane(endScreen));
		
		

	}
	

	


	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			
		String command = e.getActionCommand();//gets commands from the buttons
		
		String jTextInput = userInput.getText(); //I convert anything the user enters into a String variable because my methods won't be able to
												 //to read the input as is.
		String fileName = "userLog.txt"; //This file has already been created in the main method, so its important to have the file name here
										 //so that i can store the user inputs into the file
		
		switch (command) {
		case "Submit":
			/*
			 * When the user hits the submit button, several calls are made to different methods in the Alice methods class.
			 * First, before i send anything to be checked for a longest word, i want to save the sentence, the way it was inputed, to the file
			 * in order to maintain its integrity.
			 * Then i send the JTextInput to the Alice method class in order to search for the longest word and to have it thrown into the
			 * longest words array.
			 */
			aliceTextFile.storeSentenceToFile(fileName, jTextInput);
			Alice.findLongestWord(jTextInput);
			jTextInput= Alice.outputResponses(jTextInput); 
			labelOut.setText(jTextInput);
			break;
		case "Quit":
			/*
			 * When the user hits the quit button, anything on the JTextArea will be replaced with the end message that
			 * is in the Alice class. 
			 * I sent the fileName to the method as well because that method makes a call to a method in the File class that will read the 
			 * contents of the file and send it back so that it will be included in the End Message
			 */
			endScreen.setBorder(new TitledBorder(new EtchedBorder(), "END LOG"));
			endScreen.setText(Alice.endMessage(fileName));		
			break;
			
		case "Longest Words":
			
			endScreen.setBorder(new TitledBorder(new EtchedBorder(), "LONGEST Words"));
			endScreen.setText("Here's a list of the longest words taken straight out of your sentences:\n" + Alice.readArray());
		}
			
		}
		catch(InvalidSentenceException e1) {
			String err = e1.getMessage();
			labelOut.setText(err);
			
			
		}
	}
}
