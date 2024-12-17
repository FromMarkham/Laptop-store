import javax.swing.JCheckBox;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Laptopcentral extends JFrame implements ActionListener {

	private JRadioButton[][] radioButtonArray = new JRadioButton[8][3];

//	private JRadioButton studentLaptopCheckbox=new JRadioButton("Student laptop");
//	private JRadioButton gamingLaptopCheckbox=new JRadioButton("Gaming laptop");
//	private JRadioButton professionalLaptopCheckbox=new JRadioButton("Professional laptop");
//
//	private JRadioButton twoThousandCheckbox=new JRadioButton("$1000-$2000");
//	private JRadioButton oneThousandCheckbox=new JRadioButton("$500-$1000");
//	private JRadioButton fiveHundredCheckbox=new JRadioButton("Below $500");

	private JLabel[] labelArray = new JLabel[8];

//	private JLabel laptopKindLabel =new JLabel("What kind of laptop do you want?");
//	
//	private JLabel budgetLabel=new JLabel("Select your budget");

	private ImageIcon logo = new ImageIcon("/Users/bobwang/Downloads/Laptop%20Central%20Logo.png");

	private JButton backToTitleFrame = new JButton("Back to the title screen!");

	private JButton submitButton = new JButton("Submit!");

	public static String[] surveyResult = new String[10];

	private JPanel panel = new JPanel();


	private Font questionFont = new Font("Calibri", Font.PLAIN, 25);

	private Font choiceFont = new Font("Calibri", Font.PLAIN, 16);

	public Laptopcentral() {

		setSize(1920, 1080);
		setIconImage(logo.getImage());
		setTitle("Survey screen");
		setLayout(null);

//		label1.setBounds(50,300,600,30);
//		label1.setFont(new Font("Calibri",Font.PLAIN, 25));
//		add(label1);
//		
//		StudentLaptop.setBounds(65,340,600,20); //student laptop label
//		StudentLaptop.setFont(new Font("Calibri",Font.PLAIN, 16));
//		add(StudentLaptop);
//		
//		StudentLaptopCheckbox.setBounds(40,340,600,20);
//		add(StudentLaptopCheckbox);
//		
//		GamingLaptop.setBounds(65,360,600,20); //gaming laptop label 
//		GamingLaptop.setFont(new Font("Calibri",Font.PLAIN, 16));
//		add(GamingLaptop); ///ok please make it look exactly like the survey screen blueprint please remember that talk u had wit derek
//		
//		GamingLaptopCheckbox.setBounds(40,360,600,20);
//		add(GamingLaptopCheckbox);
//		
//		ProfessionalLaptop.setBounds(65,380,600,20); //professional laptop label
//		ProfessionalLaptop.setFont(new Font("Calibri",Font.PLAIN, 16));
//		add(ProfessionalLaptop);
//		
//		ProfessionalLaptopCheckbox.setBounds(40,380,600,20);
//		add(ProfessionalLaptopCheckbox);
//		
//		AnyLaptop.setBounds(65,400,600,20); //any laptop label 
//		AnyLaptop.setFont(new Font("Calibri",Font.PLAIN, 16));
//		add(AnyLaptop);
//
//		AnyLaptopCheckbox.setBounds(40,400,600,20);
//		add(AnyLaptopCheckbox);
//		
//		//--
//		//[]
//		//type[320,340,340,360,360,380,380,400,400]
//		//price[175,220,220,240,240,260,260,280,280]
//		
//		BudgetLabel.setBounds(50,175,600,30);
//		BudgetLabel.setFont(new Font("Calibri",Font.PLAIN, 25));
//		add(BudgetLabel);
//		
//		TwoThousand.setBounds(65,220,600,20);
//		TwoThousand.setFont(new Font("Calibri",Font.PLAIN, 16));
//		add(TwoThousand);
//		
//		TwoThousandCheckbox.setBounds(40,220,600,20);
//		TwoThousandCheckbox.setFont(new Font("Calibri",Font.PLAIN, 16));
//		add(TwoThousandCheckbox);
//		
//		OneThousand.setBounds(65,240,600,20);
//		OneThousand.setFont(new Font("Calibri",Font.PLAIN, 16));
//		add(OneThousand);
//		
//		OneThousandCheckbox.setBounds(40,240,600,20);
//		OneThousandCheckbox.setFont(new Font("Calibri",Font.PLAIN, 16));
//		add(OneThousandCheckbox);
//		
//		FiveHundred.setBounds(65,260,600,20);
//		FiveHundred.setFont(new Font("Calibri",Font.PLAIN, 16));
//		add(FiveHundred);
//		
//		
//		FiveHundredCheckbox.setBounds(40,260,600,20);
//		FiveHundredCheckbox.setFont(new Font("Calibri",Font.PLAIN, 16));
//		add(FiveHundredCheckbox);

		// --
		createQuestions();
		createRadioButtons();
		
		panel.setBounds(0,0,1700,600);
		panel.setBackground(Color.BLUE);
		panel.setLayout(null); //and thats why setbounds was aint working lol
		add(panel);


		// --

		backToTitleFrame.setBounds(40, 700, 200, 100);
		backToTitleFrame.addActionListener(this);
		backToTitleFrame.setBackground(Color.BLUE);
		add(backToTitleFrame);

		// --
		submitButton.setBounds(1180, 700, 200, 100);
		submitButton.addActionListener(this);
		submitButton.setBackground(Color.BLUE);
		add(submitButton);

		setVisible(true);

	}

	private void createQuestions() {
		
		labelArray[0] = new JLabel("What is your budget?");
		labelArray[1] = new JLabel("What kind of laptop do you want?");
		
		labelArray[2] = new JLabel("How light do you want your laptop to be?");
		labelArray[3] =new JLabel("How much RAM do you want your laptop have?");
		labelArray[4] = new JLabel("What is your preferred OS?");
		
		labelArray[5] = new JLabel("How much SSD do you want your laptop to have?");
		
		labelArray[6] = new JLabel("How much CPU frequency do you want your laptop to have?");
		labelArray[7] = new JLabel("How many CPU cores do you want your laptop to have?");
	}

	private void createRadioButtons() {
		
		//create and set the text for the radio buttons
		radioButtonArray[0][0] = new JRadioButton("Under $500");
		radioButtonArray[0][1] = new JRadioButton("Between $500-$1000");
		radioButtonArray[0][2] = new JRadioButton("Between $1000-$1500");

		radioButtonArray[1][0] = new JRadioButton("Student");
		radioButtonArray[1][1] = new JRadioButton("Professional");
		radioButtonArray[1][2] = new JRadioButton("Gaming");
		
		radioButtonArray[2][0] = new JRadioButton("Below 6 lbs");
		radioButtonArray[2][1] = new JRadioButton("Below 4 lbs");
		radioButtonArray[2][2] = new JRadioButton("Below 3 lbs");
		
		radioButtonArray[3][0] = new JRadioButton("Windows 11/Windows 11 Home");
		radioButtonArray[3][1] = new JRadioButton("MacOS");
		radioButtonArray[3][2] = new JRadioButton("ChromeOS");
		
		radioButtonArray[4][0] = new JRadioButton("128-256 gb");
		radioButtonArray[4][1] = new JRadioButton("256-512 gb");
		radioButtonArray[4][2] = new JRadioButton("512+gb");
		
		radioButtonArray[5][0] = new JRadioButton("4 gb");
		radioButtonArray[5][1] = new JRadioButton("8 gb");
		radioButtonArray[5][2] = new JRadioButton("16 gb or more");
		
		radioButtonArray[6][0] = new JRadioButton("1-2 ghz");
		radioButtonArray[6][1] = new JRadioButton("2-3 ghz");
		radioButtonArray[6][2] = new JRadioButton("3 or more");
		
		radioButtonArray[7][0] = new JRadioButton("2-4");
		radioButtonArray[7][1] = new JRadioButton("4-6");
		radioButtonArray[7][2] = new JRadioButton("6 or more");
		

		//add radio buttons to the panel (CHANGE ROW TO 8)
		for (int row = 0; row < 2; row++) {
			
			
			labelArray[row].setFont(questionFont);
			labelArray[row].setBounds(500, (row*100), 300, 50);
			panel.add(labelArray[row]);
	
			
			
			for (int column = 0; column < 3; column++) {
				
				radioButtonArray[row][column].setFont(choiceFont);
				radioButtonArray[row][column].addActionListener(this);
				radioButtonArray[row][column].setBounds(500,(row*100), 100, 50);
				panel.add(radioButtonArray[row][column]);
				
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == backToTitleFrame) {

			setVisible(false);
			new LaptopCentralTitleFrame();

		}
		
	}
	

}