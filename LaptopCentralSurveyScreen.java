
//Imports 
import javax.swing.JCheckBox;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//This class is used to create the survey screen for the laptop central, which asks the user 
//8 multiple-choice questions about what kind of laptop they want 
public class LaptopCentralSurveyScreen extends JFrame implements ActionListener {

	//2D radio button array to store all the radio buttons 
	private JRadioButton[][] radioButtonArray = new JRadioButton[8][3];
	
	//Array storing all the questions
	private JLabel[] labelArray = new JLabel[8];
	
	//Title of the survey screen 
	private JLabel surveyScreenTitle=new JLabel("Survey Screen!");
	
	//Description of the survey screen
	private JLabel surveyScreenDescription=new JLabel("Answer these questions and we will display the top 3 laptops which meet your requirements");

	//Logo as the image icon
	private ImageIcon logo = new ImageIcon("/Users/bobwang/Downloads/Laptop%20Central%20Logo.png");
	
	//JButton that takes the user back to the title screen 
	private JButton backToTitleFrame = new JButton("Back to the title screen!");
	
	//JButton that submits everything the user entered 
	private JButton submitButton = new JButton("Submit!");

	//String array that stores results of the user's survey 
	public static String[] surveyResult = new String[8];
	
	//2D string array that stores the survey options
	//Its used for the loop which creates the array which stores the user's responses 
	public static String[][] optionArray=new String[8][3];
	
	//Survey responses (2d array)
	public static String[][] surveyResultsthree = new String[8][3];
	
	//The JPanel that will hold one half of the questions 
	private JPanel leftPanel = new JPanel();
	
	//The JPanel that will hold one half of the questions 
	private JPanel rightPanel = new JPanel();

	//Font object for the questions
	private Font questionFont = new Font("Calibri", Font.PLAIN, 25);
	
	//Font object for the option labels 
	private Font choiceFont = new Font("Calibri", Font.PLAIN, 16);

	//Constructor
	public LaptopCentralSurveyScreen() {
		
		//Set the window size to 1920x1080, icon image to the logo, title to survey screen, and layout to null
		setSize(1920, 1080);
		setIconImage(logo.getImage());
		setTitle("Survey screen");
		setLayout(null);
		
		//Set the optionArray 
		setArrayOptions();

		//Create the questions and their corresponding radio button options
		createQuestions();
		createRadioButtons();
		
		//Adds the panel on the left half of the window with 1 half of the questions
		leftPanel.setBounds(50,150,700,500);
		leftPanel.setBackground(Color.BLUE);
		leftPanel.setLayout(null); 
		add(leftPanel);
		
		
		//Adds the right panel with the rest of the questions
		rightPanel.setBounds(800,150,600,500);
		rightPanel.setBackground(Color.BLUE);
		rightPanel.setLayout(null); 
		add(rightPanel);



		//Set the coordinates of the back to title frame button
		backToTitleFrame.setBounds(40, 700, 200, 100);
		
		//Give the backToTitleFrame button an actionlistener 
		backToTitleFrame.addActionListener(this);
		
		//Make the backToTitleFrame button blue 
		backToTitleFrame.setBackground(Color.BLUE);
		
		//Adds the backToTitleFrame button
		add(backToTitleFrame);

		//Set the coordinates, color and actionlistener of the submit button. As well as adds it. 
		submitButton.setBounds(1180, 700, 200, 100);
		submitButton.addActionListener(this);
		submitButton.setBackground(Color.BLUE);
		add(submitButton);
		
		//Adds the title of the survey screen, sets its coordinates, and sets its font 
		surveyScreenTitle.setBounds(630, -70, 300, 200);
		surveyScreenTitle.setFont(new Font("Calibri", Font.PLAIN, 30));
		add(surveyScreenTitle);
		
		//Adds the description of the survey screen, sets its coordinates and sets its font
		surveyScreenDescription.setBounds(200, -40, 1100, 200);
		surveyScreenDescription.setFont(new Font("Calibri", Font.PLAIN, 24));
		add(surveyScreenDescription);
		
		
		setVisible(true);

	}
//Method add the questions in the form of JLabels to the array which holds the question titles
	private void createQuestions() {
		
		labelArray[0] = new JLabel("What is your budget?");
		labelArray[1] = new JLabel("What kind of laptop do you want?");
		
		labelArray[2] = new JLabel("How light do you want your laptop to be?");
		labelArray[3] =new JLabel("How much RAM do you want your laptop have?");
		labelArray[4] = new JLabel("What is your preferred OS?");
		
		labelArray[5] = new JLabel("How much SSD do you want to have?");
		
		labelArray[6] = new JLabel("How much GHZ do you want to have?");
		labelArray[7] = new JLabel("How many CPU cores do you want to have?");
	}
	
//method to set the array elements for the array which stores the options of the survey
	private void setArrayOptions() {
	
		optionArray[0][0] ="Under $500";
		optionArray[0][1] ="Between $500-$1000";
		optionArray[0][2] ="Between $1000-$2000";

		optionArray[1][0] ="Student";
		optionArray[1][1] = "Professional";
		optionArray[1][2] = "Gaming";
		
		optionArray[2][0] = "Below 6 lbs";
		optionArray[2][1] = "Below 4 lbs";
		optionArray[2][2] = "Below 3 lbs";
		
		optionArray[3][0] = "4 gb";
		optionArray[3][1] ="8 gb";
		optionArray[3][2] = "16 gb or more";
		
		optionArray[4][0] = "ChromeOS";
		optionArray[4][1] ="MacOS";
		optionArray[4][2] = "Windows 11";
		
		optionArray[5][0] = "128-256 gb";
		optionArray[5][1] = "256-512 gb";
		optionArray[5][2] ="512+gb";
		
		optionArray[6][0] = "1-2 ghz";
		optionArray[6][1] ="2-3 ghz";
		optionArray[6][2] ="3 ghz or more";
		
		optionArray[7][0] ="2-4";
		optionArray[7][1] = "4-6";
		optionArray[7][2] = "6 or more";	
	
	}
	
	//Method to create the radio buttons, as well as set the labels for the radio buttons 
	//These radio buttons will represent the options for the multiple choice questions 
	private void createRadioButtons() {
		
	
		radioButtonArray[0][0] = new JRadioButton("Under $500");
		radioButtonArray[0][1] = new JRadioButton("From $500-$1000");
		radioButtonArray[0][2] = new JRadioButton("From $1000-$2000");

		radioButtonArray[1][0] = new JRadioButton("Student");
		radioButtonArray[1][1] = new JRadioButton("Professional");
		radioButtonArray[1][2] = new JRadioButton("Gaming");
		
		radioButtonArray[2][0] = new JRadioButton("Below 6 lbs");
		radioButtonArray[2][1] = new JRadioButton("Below 4 lbs");
		radioButtonArray[2][2] = new JRadioButton("Below 3 lbs");
		
		radioButtonArray[3][0] = new JRadioButton("4 gb");
		radioButtonArray[3][1] = new JRadioButton("8 gb");
		radioButtonArray[3][2] = new JRadioButton("16 gb or more");
		
		radioButtonArray[4][0] = new JRadioButton("ChromeOS");
		radioButtonArray[4][1] = new JRadioButton("MacOS");
		radioButtonArray[4][2] = new JRadioButton("Windows 11");
		
		radioButtonArray[5][0] = new JRadioButton("128-256 gb");
		radioButtonArray[5][1] = new JRadioButton("256-512 gb");
		radioButtonArray[5][2] = new JRadioButton("512+gb");
		
		radioButtonArray[6][0] = new JRadioButton("1-2 ghz");
		radioButtonArray[6][1] = new JRadioButton("2-3 ghz");
		radioButtonArray[6][2] = new JRadioButton("3 ghz or more");
		
		radioButtonArray[7][0] = new JRadioButton("2-4");
		radioButtonArray[7][1] = new JRadioButton("4-6");
		radioButtonArray[7][2] = new JRadioButton("6 or more");
		

		//add the questions to both of the panels 
		for (int row = 0; row < 8; row++) {
			
			leftPanel.setLayout(null);
			rightPanel.setLayout(null);
			labelArray[row].setFont(questionFont);
			
		
			if (row>=4) {
				labelArray[row].setBounds(40, (row*100)-330, 3000, 50);
				rightPanel.add(labelArray[row]);
			}
			
			
			else {
				labelArray[row].setBounds(75, (row*100)+70, 3000, 50);
				leftPanel.add(labelArray[row]);
			}
		
			
			
			
		//add the radiobuttons to both of the panels 
			
			for (int column = 0; column < 3; column++) {
				leftPanel.setLayout(null);
				rightPanel.setLayout(null);
				radioButtonArray[row][column].setFont(choiceFont);
				radioButtonArray[row][column].addActionListener(this);
				
				if (row<=3) {
					radioButtonArray[row][column].setBounds((column*200)+75,(row*100)+100, 200, 50);	
					leftPanel.add(radioButtonArray[row][column]);
				}
				
				else {
					radioButtonArray[row][column].setBounds((column*200)+40,(row*100)-300, 200, 50);
					rightPanel.add(radioButtonArray[row][column]);
				}

			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		//if the backToTitleFrame button is clicked, close the current window and create a new instance of
		//The title frame 
		if (e.getSource() == backToTitleFrame) {

			setVisible(false);
			new LaptopCentralTitleFrame();

		}
	
		//If the submit button is clicked, loop through the radio buttons and check to see which ones have
		//Been clicked. If the radio button has been clicked, set the corresponding row and column of the 
		//Survey results array accordingly 
		if (e.getSource() == submitButton) {

			for (int row=0; row<8; row++) {
			
				for (int column=0; column<3; column++) {
					
					if (radioButtonArray[row][column].isSelected()==true) {
						surveyResultsthree[row][column]=optionArray[row][column];
					}

				}
				
			}

	} 

		}
	}

