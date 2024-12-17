
//Imports 
import java.awt.event.*;
import javax.swing.*;

//This class is used to create a new title screen 
public class LaptopCentralTitleFrame extends JFrame implements ActionListener{

	//Stores the logo of laptop central in an ImageIcon object 
	private ImageIcon laptopCentralLogo=new ImageIcon("/Users/bobwang/Desktop/LaptopCentralLogo.png");
	
	//JLabel storing the the image icon object from line 10 
	private JLabel laptopCentralLogoImage=new JLabel(laptopCentralLogo);
	
	//Button that takes the user to the survey screen
	private JButton SurveyScreenbutton=new JButton("To Survey Screen");
	
	//Button that takes the user to the inventory screen 
	private JButton InventoryScreenbutton=new JButton("To Inventory Screen");

	//Class Constructor 
	public LaptopCentralTitleFrame() {
		
		//Sets the size, icon for the window, title and layout
		setSize(1000,700);
		setIconImage(laptopCentralLogo.getImage());
		setTitle("Laptop Central");
		setLayout(null);
		
		//Places the image displaying the laptop central icon to the screen 
		laptopCentralLogoImage.setBounds(320,110,400,400);
		add(laptopCentralLogoImage);
		
		//Places survey screen button to the screen 
		SurveyScreenbutton.setBounds(315,550,150,100);
		SurveyScreenbutton.addActionListener(this);
		add(SurveyScreenbutton);
		
		//Places the inventory screen button to the screen 
		InventoryScreenbutton.setBounds(570,550,150,100);
		InventoryScreenbutton.addActionListener(this);
		add(InventoryScreenbutton);
		
		//setVisible=true 
		setVisible(true);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//If the survey screen button is clicked, create a new instance of the survey screen class
		//And make this window invisible 
		if (e.getSource()==SurveyScreenbutton) {
			
			setVisible(false);
			new LaptopCentralSurveyScreen();
		}

		
		else if (e.getSource()==InventoryScreenbutton) {
			setVisible(false);
			//new LaptopCentralInventoryFrame();

		}
		
	}

}
