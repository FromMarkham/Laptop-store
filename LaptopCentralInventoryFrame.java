//Import packages and classes
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

//Start of Inventory Frame Class
//Implement an ActionListener and MouseListener
//to receive user input
public class LaptopCentralInventoryFrame extends JFrame implements ActionListener, MouseListener{
	
	//Create an Array List - filled with the Laptops the user wants
	//Starts off with all the laptops
	private ArrayList<Laptop> laptopList = new ArrayList<>(Arrays.asList(LaptopCentralApp.laptopArray));
	
	//Initialize Buttons 
	JButton backButton = new JButton("Back");
	JButton submitButton = new JButton("Submit");
	JButton helpButton = new JButton("Help");
	JButton exitButton = new JButton("Exit");
	JButton resetButton = new JButton("Reset Filters");
	
	//Initialize Title Label
	JLabel titleLabel = new JLabel("Laptop Central Inventory");
	JLabel sortLabel = new JLabel("Sort By:");
	JLabel filterLabel = new JLabel("Filter By:");
	
	//Initialize ComboBox for sorting the Laptops
	JComboBox<String> sortLaptopsComboBox = new JComboBox<String>();
	
	//Initialize Panels
	JPanel checkBoxPanel = new JPanel();
	JPanel TextfieldPanel = new JPanel();
	JPanel labelsPanel = new JPanel();
	JPanel inputPanel = new JPanel();
	
	//Initialize Labels for the Filter Textfields
	JLabel brandLabel = new JLabel("Brand:");
	JLabel minPriceLabel = new JLabel("Min Price:");
	JLabel maxPriceLabel = new JLabel("Max Price:");
	JLabel minScreenSizeLabel = new JLabel("Min Screen Size:");
	JLabel maxScreenSizeLabel = new JLabel("Max Screen Size:");
	JLabel minTotalCapacityLabel = new JLabel("Min Capacity:");
	JLabel maxTotalCapacityLabel = new JLabel("Max Capacity:");
	JLabel minRAMLabel = new JLabel("Min RAM:");
	JLabel maxRAMLabel = new JLabel("Max RAM:");
	JLabel minWeightLabel = new JLabel("Min Weight:");
	JLabel maxWeightLabel = new JLabel("Max Weight:");
	JLabel operatingSystemLabel = new JLabel("Operating System:");

	//Initialize Textfields for the Filters
	JTextField brandTextField = new JTextField(10);
	JTextField minPriceTextField = new JTextField(10);
	JTextField maxPriceTextField = new JTextField(10);
	JTextField minScreenSizeTextField = new JTextField(10);
	JTextField maxScreenSizeTextField = new JTextField(10);
	JTextField minTotalCapacityTextField = new JTextField(10);
	JTextField maxTotalCapacityTextField = new JTextField(10);
	JTextField minRAMTextField = new JTextField(10);
	JTextField maxRAMTextField = new JTextField(10);
	JTextField minWeightTextField = new JTextField(10);
	JTextField maxWeightTextField = new JTextField(10);
	JTextField operatingSystemTextField = new JTextField(10);
	
	//Initialize MenuBar and Menu Items
	JMenuBar menuBar = new JMenuBar();
	JMenu laptopInventoryMenu = new JMenu("Laptop Central Inventory Menu");
	JMenu surveyMenu = new JMenu("Survey Menu");
	
	JMenuItem laptopInventoryItem = new JMenuItem("Open New Laptop Inventory Frame");
	JMenuItem surveyMenuItem = new JMenuItem("Open New Survey Frame");
	
	
	//Scroll Pane for the Laptops
	//Scroll past because the laptops take too much space
	JScrollPane scrollPane = new JScrollPane(labelsPanel);
	
	//Logo of our Laptop Store
	ImageIcon logo = new ImageIcon("Images/trimmedLogo.png");
  
	//CheckBoxes for the Filters Options
	JCheckBox brandCheckBox = new JCheckBox("Brand");
	JCheckBox priceCheckBox = new JCheckBox("Price");
	JCheckBox screenSizeCheckBox = new JCheckBox("Screen Size");
	JCheckBox totalCapacityCheckBox = new JCheckBox("Total Capacity");
	JCheckBox ramCheckBox = new JCheckBox("RAM");
	JCheckBox operatingSystemCheckBox = new JCheckBox("Operating System");
	JCheckBox weightCheckBox = new JCheckBox("Weight");
	
	
	//Fonts for Labels
	Font TitleFont = new Font("Poppins", Font.BOLD, 40);
	Font HeaderFont = new Font("Poppins", Font.BOLD, 24);
	Font Label2Font = new Font("Poppins", Font.BOLD, 18);
	Font LabelFont = new Font("Poppins", Font.BOLD, 14);
	
	//Border for the Labels
	Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

	//FillArray Method - Fills the Scroll Pane with Laptops
	private void fillArray() {
		
	    //Clear the panel first to avoid duplicates when reloading
	    labelsPanel.removeAll();
	    
	    
	    //Iterate through each Laptop in the LaptopList
	    for (Laptop laptop : laptopList) {
	       
	   
	    	//Create a Label with the Laptop's attributes
	    	//Uses HTML to break lines,
	    	//Able to align the text within the label itself
	        JLabel laptopLabel = new JLabel(String.format("<html>"
	                + "<div style=\"\"> %s %s %.1f\"<br>"
	                + "%d GB RAM %d GB SSD %d GHz %d Cores<br>"
	                + "%s %s %s %s %s<br><br>"
	                + "<div style=\"text-align: center; font-size: 12px; font-weight: bold\">"
	                + "Quality Rating: %d, Memory Rating: %d, Speed Rating: %d<br><br> </div>"
	                + "<div style=\"text-align: center; font-size: 18px; font-weight: bold; color: red\">"
	                + "Price - $%.2f </div> </div> </html>",
	                laptop.getBrand(),laptop.getModel(),laptop.getDisplaySize(),
	                laptop.getRam(),laptop.getSsd(), laptop.getRam(), laptop.getCpuCores(),
	                laptop.getCpuBrand(),laptop.getCpuModel(),laptop.getGpuBrand(),laptop.getGpuModel(),
	                laptop.getOperatingSystem(), laptop.getQualityRating(), laptop.getMemoryRating(), 
	                laptop.getSpeedRating(), laptop.getPrice()
	                ));
	        
	        //Set the image of the label to the Laptop's Image
	        Image originalImage = ((ImageIcon) laptop.getIcon()).getImage()
                    .getScaledInstance(250, 250, Image.SCALE_SMOOTH);
            ImageIcon labelIcon = new ImageIcon(originalImage);
            laptopLabel.setIcon(labelIcon);  
               
            //Align the Label
            laptopLabel.setHorizontalAlignment(SwingConstants.CENTER);
            laptopLabel.setVerticalAlignment(SwingConstants.CENTER);
            laptopLabel.setVerticalTextPosition(SwingConstants.BOTTOM); // Text below the image
            laptopLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centered horizontally
                    
	        //Set font and Add Mouse Listener for click detection
	        laptopLabel.setFont(LabelFont);
	        laptopLabel.addMouseListener(this);
	        
	        //Add client property to differentiate laptops
	        //Checks difference between labels with the same name
	        laptopLabel.putClientProperty("laptop", laptop);
	        laptopLabel.putClientProperty("url", laptop.getLink());
	        laptopLabel.setBorder(border);
	        
	        //Add the label to the Labels Panel
	        labelsPanel.add(laptopLabel);
	        
	    }

	    //Refresh the panel to display new components
	    labelsPanel.revalidate();
	    labelsPanel.repaint();
	    
	    //Not printed before the loop 
	    //If the user wants it empty
	    if (laptopList.isEmpty() && validateInputFields()) {
	    	
	    	//Prints a message if no laptops fit the filter
	        JOptionPane.showMessageDialog(null, "No Laptops match this filter!");
	        return;  
	    }
	      
		    
	}
	
	//Checks if the input fields are valid
	private boolean validateInputFields() {
	    
		//Check for invalid number input in price, screen size, capacity, RAM, weight
	    try {
	        if (!minPriceTextField.getText().isEmpty() && 
	        		!isNumeric(minPriceTextField.getText())) {
	            throw new NumberFormatException("Invalid price");
	        }
	        if (!maxPriceTextField.getText().isEmpty() && 
	        		!isNumeric(maxPriceTextField.getText())) {
	            throw new NumberFormatException("Invalid price");
	        }
	        if (!minScreenSizeTextField.getText().isEmpty() && 
	        		!isNumeric(minScreenSizeTextField.getText())) {
	            throw new NumberFormatException("Invalid screen size");
	        }
	        if (!maxScreenSizeTextField.getText().isEmpty() && 
	        		!isNumeric(maxScreenSizeTextField.getText())) {
	            throw new NumberFormatException("Invalid screen size");
	        }
	        if (!minTotalCapacityTextField.getText().isEmpty() && 
	        		!isNumeric(minTotalCapacityTextField.getText())) {
	            throw new NumberFormatException("Invalid capacity");
	        }
	        if (!maxTotalCapacityTextField.getText().isEmpty() && 
	        		!isNumeric(maxTotalCapacityTextField.getText())) {
	            throw new NumberFormatException("Invalid capacity");
	        }
	        if (!minRAMTextField.getText().isEmpty() && 
	        		!isNumeric(minRAMTextField.getText())) {
	            throw new NumberFormatException("Invalid RAM size");
	        }
	        if (!maxRAMTextField.getText().isEmpty() && 
	        		!isNumeric(maxRAMTextField.getText())) {
	            throw new NumberFormatException("Invalid RAM size");
	        }
	        if (!minWeightTextField.getText().isEmpty() && 
	        		!isNumeric(minWeightTextField.getText())) {
	            throw new NumberFormatException("Invalid weight");
	        }
	        if (!maxWeightTextField.getText().isEmpty() && 
	        		!isNumeric(maxWeightTextField.getText())) {
	            throw new NumberFormatException("Invalid weight");
	        }
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "Please enter valid numeric values.");
	        return false; //Return false if any input is invalid
	    }
	    return true;  //Return true if all inputs are valid
	}
	
	//Checks if the input is a numerical value
	private boolean isNumeric(String str) {
	    try {
	        Double.parseDouble(str); 
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}

	//Checks the filters that have been clicked on
	private void checkFilters() {
		
		//Remove any laptops that does not meet ALL conditions
	    laptopList.removeIf(laptop -> {
	    	
	    	//Set matches to true
	        boolean matches = true;

	        // Filter based on brand
	        if (brandCheckBox.isSelected()) {
	        	
	        	//Sets empty textfield to empty string - Prevents NullPointerException
	            String brandName = brandTextField.getText().isEmpty() ? "" 
	            		: brandTextField.getText();
	            
	            //If the laptop does not meet the condition
	            if (!laptop.getBrand().toLowerCase().contains(brandName.toLowerCase())) {
	            	
	            	//Set matches to false
	                matches = false;
	            }
	        }

	        //If the checkboxes are clicked but the fields are empty
	        //Set textfield to empty/no value
	        
	        //If the numerical textfields are inordered correct
	        //Ex: Min Price is greater than Max Price
	        //Set field to False
	        
	        // Filter based on price
	        if (priceCheckBox.isSelected()) {
	            double minPrice = minPriceTextField.getText().isEmpty() ? 0 : 
	            	Double.parseDouble(minPriceTextField.getText());
	            double maxPrice = maxPriceTextField.getText().isEmpty() ? Double.MAX_VALUE : 
	            	Double.parseDouble(maxPriceTextField.getText());
	            if (laptop.getPrice() < minPrice || laptop.getPrice() > maxPrice) {
	                matches = false;
	            }
	        }

	        // Filter based on screen size
	        if (screenSizeCheckBox.isSelected()) {
	            double minScreenSize = minScreenSizeTextField.getText().isEmpty() ? 0 : 
	            	Double.parseDouble(minScreenSizeTextField.getText());
	            double maxScreenSize = maxScreenSizeTextField.getText().isEmpty() ? 
	            		Double.MAX_VALUE : Double.parseDouble(maxScreenSizeTextField.getText());
	            
	            if (laptop.getDisplaySize() < minScreenSize || laptop.getDisplaySize() > maxScreenSize) {
	                matches = false;
	            }
	        }

	        // Filter based on total capacity (SSD size)
	        if (totalCapacityCheckBox.isSelected()) {
	            int minTotalCapacity = minTotalCapacityTextField.getText().isEmpty() ? 0 : 
	            	Integer.parseInt(minTotalCapacityTextField.getText());
	            int maxTotalCapacity = maxTotalCapacityTextField.getText().isEmpty() ? Integer.MAX_VALUE : 
	            	Integer.parseInt(maxTotalCapacityTextField.getText());
	            
	            if (laptop.getSsd() < minTotalCapacity || laptop.getSsd() > maxTotalCapacity) {
	                matches = false;
	            }
	        }

	        // Filter based on RAM size
	        if (ramCheckBox.isSelected()) {
	            int minRAMSize = minRAMTextField.getText().isEmpty() ? 0 : 
	            	Integer.parseInt(minRAMTextField.getText());
	            int maxRAMSize = maxRAMTextField.getText().isEmpty() ? Integer.MAX_VALUE : 
	            	Integer.parseInt(maxRAMTextField.getText());
	            
	            if (laptop.getRam() < minRAMSize || laptop.getRam() > maxRAMSize) {
	                matches = false;
	            }
	        }

	        // Filter based on weight
	        if (weightCheckBox.isSelected()) {
	            int minWeight = minWeightTextField.getText().isEmpty() ? 0 : 
	            	Integer.parseInt(minWeightTextField.getText());
	            int maxWeight = maxWeightTextField.getText().isEmpty() ? Integer.MAX_VALUE : 
	            	Integer.parseInt(maxWeightTextField.getText());
	            
	            if (laptop.getWeight() < minWeight || laptop.getWeight() > maxWeight) {
	                matches = false;
	            }
	        }

	        // Filter based on operating system
	        if (operatingSystemCheckBox.isSelected()) {
	            String operatingSystem = operatingSystemTextField.getText().isEmpty() ? "" : 
	            	operatingSystemTextField.getText();
	            
	            if (!laptop.getOperatingSystem().toLowerCase().contains(operatingSystem.toLowerCase())) {
	                matches = false;
	            }
	        }

	        return !matches; // Remove laptops that do not match the filter criteria
	    });
		
	}
	
	//Check the Sorting Method
	private void checkSortingMethod() {
		
		//Reset the ArrayList with all the laptops
		laptopList = new ArrayList<>(Arrays.asList(LaptopCentralApp.laptopArray));

	    //Apply sorting (same as before)
	    String selectedSortMethod = (String) sortLaptopsComboBox.getSelectedItem();
	    
	    //Check which method was selected
	    switch (selectedSortMethod) {
	        
	    	//Sort Method based on Chosen Sorting
	    	case "Default":
	    		//No Sorting - Based on Laptop Index Number
	    		break;
	    	case "Price: Low to High":
	            laptopList.sort(Comparator.comparing(Laptop::getPrice));
	            break;
	        case "Price: High to Low":
	            laptopList.sort(Comparator.comparing(Laptop::getPrice).reversed());
	            break;
	        case "RAM Size: Low to High":
	            laptopList.sort(Comparator.comparing(Laptop::getRam));
	            break;
	        case "RAM Size: High to Low":
	            laptopList.sort(Comparator.comparing(Laptop::getRam).reversed());
	            break;
	        case "SSD Size: Low to High":
	            laptopList.sort(Comparator.comparing(Laptop::getSsd));
	            break;
	        case "SSD Size: High to Low":
	            laptopList.sort(Comparator.comparing(Laptop::getSsd).reversed());
	            break;
	        case "CPU Cores: Low to High":
	            laptopList.sort(Comparator.comparing(Laptop::getCpuCores));
	            break;
	        case "CPU Cores: High to Low":
	            laptopList.sort(Comparator.comparing(Laptop::getCpuCores).reversed());
	            break;
	        case "CPU Speed: Low to High":
	            laptopList.sort(Comparator.comparing(Laptop::getCpuSpeed));
	            break;
	        case "CPU Speed: High to Low":
	            laptopList.sort(Comparator.comparing(Laptop::getCpuSpeed).reversed());
	            break;
	        case "Display Size: Small to Large":
	            laptopList.sort(Comparator.comparing(Laptop::getDisplaySize));
	            break;
	        case "Display Size: Large to Small":
	            laptopList.sort(Comparator.comparing(Laptop::getDisplaySize).reversed());
	            break;
	        case "Quality Rating: Low to High":
	        	laptopList.sort(Comparator.comparing(Laptop::getQualityRating));
	            break;
	        case "Quality Rating: High to Low":
	        	laptopList.sort(Comparator.comparing(Laptop::getQualityRating).reversed());
	            break;
	        case "Memory Rating: Low to High":
	        	laptopList.sort(Comparator.comparing(Laptop::getMemoryRating));
	            break;
	        case "Memory Rating: High to Low":
	        	laptopList.sort(Comparator.comparing(Laptop::getMemoryRating).reversed());
	            break;
	        case "Speed Rating: Low to High":
	        	laptopList.sort(Comparator.comparing(Laptop::getSpeedRating));
	            break;
	        case "Speed Rating: High to Low":
	        	laptopList.sort(Comparator.comparing(Laptop::getSpeedRating).reversed());
	            break;
	        default:
	            break;
	    }
		
	}

	//Start of Constructor Method
	public LaptopCentralInventoryFrame() {
		
		//Set Frame
		setSize(1920, 1080);
		setIconImage(logo.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Laptop Inventory");
		setLayout(null);
		
		//Fill the Scroll Pane with Laptops
		fillArray();
		
		//Set Layout of the Panels
		labelsPanel.setLayout(new GridLayout(10, 3, 10, 10));
		checkBoxPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel.setLayout(new GridLayout(12, 2));
		
		//Add the Checkboxes to the Main Panel
		checkBoxPanel.add(brandCheckBox);
		checkBoxPanel.add(priceCheckBox);
		checkBoxPanel.add(screenSizeCheckBox);
		checkBoxPanel.add(totalCapacityCheckBox);
		checkBoxPanel.add(ramCheckBox);
		checkBoxPanel.add(operatingSystemCheckBox);
		checkBoxPanel.add(weightCheckBox);
		
		//Add options to the Combobox
		sortLaptopsComboBox.addItem("Default");
		sortLaptopsComboBox.addItem("Price: Low to High");
		sortLaptopsComboBox.addItem("Price: High to Low");
		sortLaptopsComboBox.addItem("RAM Size: Low to High");
		sortLaptopsComboBox.addItem("RAM Size: High to Low");
		sortLaptopsComboBox.addItem("SSD Size: Low to High");
		sortLaptopsComboBox.addItem("SSD Size: High to Low");
		sortLaptopsComboBox.addItem("CPU Cores: Low to High");
		sortLaptopsComboBox.addItem("CPU Cores: High to Low");
		sortLaptopsComboBox.addItem("CPU Speed: Low to High");
		sortLaptopsComboBox.addItem("CPU Speed: High to Low");
		sortLaptopsComboBox.addItem("Display Size: Small to Large");
		sortLaptopsComboBox.addItem("Display Size: Large to Small");
		sortLaptopsComboBox.addItem("Quality Rating: Low to High");
		sortLaptopsComboBox.addItem("Quality Rating: High to Low");
		sortLaptopsComboBox.addItem("Memory Rating: Low to High");
		sortLaptopsComboBox.addItem("Memory Rating: High to Low");
		sortLaptopsComboBox.addItem("Speed Rating: Low to High");
		sortLaptopsComboBox.addItem("Speed Rating: High to Low");
		
		//Add Labels and Textfields to the Panel
		inputPanel.add(brandLabel);
		inputPanel.add(brandTextField);
		
		inputPanel.add(minPriceLabel);
		inputPanel.add(minPriceTextField);
		
		inputPanel.add(maxPriceLabel);
		inputPanel.add(maxPriceTextField);
		
		inputPanel.add(minScreenSizeLabel);
		inputPanel.add(minScreenSizeTextField);
		
		inputPanel.add(maxScreenSizeLabel);
		inputPanel.add(maxScreenSizeTextField);
		
		inputPanel.add(minTotalCapacityLabel);
		inputPanel.add(minTotalCapacityTextField);
		
		inputPanel.add(maxTotalCapacityLabel);
		inputPanel.add(maxTotalCapacityTextField);
		
		inputPanel.add(minRAMLabel);
		inputPanel.add(minRAMTextField);
		
		inputPanel.add(maxRAMLabel);
		inputPanel.add(maxRAMTextField);
		
		inputPanel.add(minWeightLabel);
		inputPanel.add(minWeightTextField);
		
		inputPanel.add(maxWeightLabel);
		inputPanel.add(maxWeightTextField);
		
		inputPanel.add(operatingSystemLabel);
		inputPanel.add(operatingSystemTextField);
		
		//Set Bounds, Font, and Colour of the Labels
		titleLabel.setBounds(700, 10, 600, 100);
		titleLabel.setFont(TitleFont);
		titleLabel.setForeground(Color.decode("#1f71de"));
		add(titleLabel);
		
		//Load the image for the Title and Scale it
		Image originalImage = new ImageIcon("Images/trimmedLogo.png").getImage()
		        .getScaledInstance(50, 66, Image.SCALE_SMOOTH);
		ImageIcon labelIcon = new ImageIcon(originalImage);
		titleLabel.setIcon(labelIcon); // Set the scaled icon

		//Set Colour of Labels & Buttons to a Shade of Blue
		//Uses HexCode from Canva's Hex Code 
		
		sortLabel.setBounds(1350, 100, 250, 50);
		sortLabel.setFont(HeaderFont);
		sortLabel.setForeground(Color.decode("#1f71de"));
		add(sortLabel);

		filterLabel.setBounds(1350, 190, 250, 50);
		filterLabel.setFont(HeaderFont);
		filterLabel.setForeground(Color.decode("#1f71de"));
		add(filterLabel);

		//Add Action Listeners to detect action from buttons
		//Add a Light Border to each Button with our theme colour
		
		backButton.setBounds(50, 850, 100, 50);
		backButton.addActionListener(this);
		backButton.setForeground(Color.WHITE);
		backButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		backButton.setBackground(Color.decode("#1f71de"));
		add(backButton);

		helpButton.setBounds(1375, 850, 100, 50);
		helpButton.addActionListener(this);
		helpButton.setForeground(Color.WHITE);
		helpButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		helpButton.setBackground(Color.decode("#1f71de"));	
		add(helpButton);

		submitButton.setBounds(1475, 450, 100, 50);
		submitButton.addActionListener(this);
		submitButton.setForeground(Color.WHITE);
		submitButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		submitButton.setBackground(Color.decode("#1f71de"));	
		add(submitButton);

		exitButton.setBounds(1575, 850, 100, 50);
		exitButton.addActionListener(this);
		exitButton.setForeground(Color.WHITE);
		exitButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		exitButton.setBackground(Color.decode("#1f71de"));	
		add(exitButton);
		
		resetButton.setBounds(1700, 600, 100, 50);
		resetButton.addActionListener(this);
		resetButton.setForeground(Color.WHITE);
		resetButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		resetButton.setBackground(Color.decode("#1f71de"));	
		add(resetButton);
		
		//Add the ComboBox	
		sortLaptopsComboBox.setBounds(1475, 100, 175, 50);
		add(sortLaptopsComboBox);

		//Add the Scroll Pane
		scrollPane.setBounds(100, 100, 1200, 700);
		
		//Increase the Increment of the Scroll Bars 
		//Allows for faster Scrolling
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane.getHorizontalScrollBar().setUnitIncrement(16);
		add(scrollPane);

		//Add the Panels
		checkBoxPanel.setBounds(1475, 200, 150, 400);
		add(checkBoxPanel);

		inputPanel.setBounds(1625, 200, 250, 350);
		add(inputPanel);
		
		//Add the Menu Bar, Menu, and Menu Items
		setJMenuBar(menuBar);
		
		menuBar.add(laptopInventoryMenu);
		menuBar.add(surveyMenu);
		
		laptopInventoryMenu.add(laptopInventoryItem);
		laptopInventoryMenu.setBackground(Color.decode("#1f71de"));
		laptopInventoryMenu.setForeground(Color.WHITE);
		
		surveyMenu.add(surveyMenuItem);
		surveyMenu.setBackground(Color.decode("#1f71de"));
		surveyMenu.setForeground(Color.WHITE);
		
		laptopInventoryItem.addActionListener(this);
		laptopInventoryItem.setBackground(Color.decode("#1f71de"));
		laptopInventoryItem.setForeground(Color.WHITE);
		
		surveyMenuItem.addActionListener(this);
		surveyMenuItem.setBackground(Color.decode("#1f71de"));
		surveyMenuItem.setForeground(Color.WHITE);
		
		menuBar.setBackground(Color.decode("#1f71de"));
		menuBar.setForeground(Color.WHITE);
		
	           
		setVisible(true);
		
	}
	//Detects Action
	public void actionPerformed(ActionEvent event) {
	    
		//Goes back to Title Frame
		if (event.getSource() == backButton) {
	        setVisible(false);
	        new LaptopCentralTitleFrame();
	    } 
		
		//Tells user how to use the program
		else if (event.getSource() == helpButton) {
			
			//Option pane to explain the purpose of my program and how to use it
	        JOptionPane.showMessageDialog(null, "This is the Laptop Inventory Screen, a place where you can " 
	                + "view laptops ranging from $0-$2000.\nOn the right, there is a sorting box, "
	                + "that allows you to sort the laptops to your liking, and a filter box to"  
	                + "filter any laptops you don't want.\nClick the Submit Button to finalize your " 
	                + "sorting methods and/or filters.\nAll laptops are from BestBuy, so if you press "
	                + "the image, it will send you to the BestBuy page where you can buy the laptop and "
	                + "have better details.\nClick the Back Button to return to the Home Screen " 
	                + "and Click the Exit Button to exit the Inventory Frame.");
	    } 
		
		//Exits from program
		else if (event.getSource() == exitButton) {
			
			//Asks user if they want to close this screen
	        int reply = JOptionPane.showConfirmDialog(null, 
	        		"Are you sure you want to close the Laptop Inventory Screen?",
	                "Close?", JOptionPane.YES_NO_OPTION);
	        
	        if (reply == JOptionPane.YES_OPTION) {
	            System.exit(0);
	        }
	    } 
		
		//Handles Sorting and Filters
		else if (event.getSource() == submitButton) {
		    
			// Validate input fields before filtering
		    if (!validateInputFields()) {
		        return;  // Exit early if invalid input is found
		    }
		    
		    //Checks the Sorting Method that was chosen
		    checkSortingMethod();
		   
		    //Checks the filters that were chosen
		    checkFilters();
		  
		    
		    // After filtering and sorting, update the display with the laptops
		    fillArray();
		    
		}
		
		//Resets all Filters/Sorting Method
		else if (event.getSource() == resetButton) {
			
			//Resets the laptop list with all the laptops
			laptopList = new ArrayList<>(Arrays.asList(LaptopCentralApp.laptopArray));
			
			//Checks each component (Only Textfields) in the Input Panel
			for (Component component : inputPanel.getComponents()) {
		        if (component instanceof JTextField) {
		        	
		        	//Emptys the Textfields
		            ((JTextField) component).setText("");
		        }
		    }

			//Checks each component (Only Checkboxes) in the CheckBox Panel
		    for (Component component : checkBoxPanel.getComponents()) {
		        if (component instanceof JCheckBox) {
		        	
		        	//Unselected the checkboxes
		            ((JCheckBox) component).setSelected(false);
		        }
		    }
			
		    //Set Selected Item to Default
			sortLaptopsComboBox.setSelectedItem("Default");
			
			//Re-organize the Laptops
			fillArray();
		}
		
		//If the user clicks on the Laptop Inventory Item
		else if (event.getSource() == laptopInventoryItem) {
			
			setVisible(false);
			
			//Open Inventory Frame
			new LaptopCentralInventoryFrame();
		}
		
		//If the user clicks on the Survey Meny Item
		else if (event.getSource() == surveyMenuItem) {
			setVisible(false);
			
			//Open Survey Frame
			new LaptopCentralSurveyScreen();
		}
	}

	
	   
	//Checks if the label has been clicked
	public void mouseClicked(MouseEvent e) {
		
		//Finds the label that was clicked
	    if (e.getSource() instanceof JLabel) {
	        JLabel clickedLabel = (JLabel) e.getSource();
	        
	        // Retrieve the URL from the client property
	        String laptopUrl = (String) clickedLabel.getClientProperty("url");
	        
	        if (laptopUrl != null && !laptopUrl.isEmpty()) {
	            try {
	                
	            	//Attempt to use Desktop.getDesktop() (default approach)
	                java.awt.Desktop.getDesktop().browse(java.net.URI.create(laptopUrl));
	                
	            } catch (Exception ex) {
	                
	            	//Vishal - I use Linux, this command helps run for Linux
	            	
	            	//Fallback: Try using a system-specific command on Linux to open the URL
	                try {
	                    String[] browsers = {"firefox", "google-chrome", "chromium", "xdg-open"};
	                    for (String browser : browsers) {
	                        try {
	                            Runtime.getRuntime().exec(new String[] {browser, laptopUrl});
	                            break; // Exit loop once a browser is successfully opened
	                        } catch (Exception ignored) {
	                            // Ignore exceptions for failed browser attempts
	                        }
	                    }
	                } catch (Exception fallbackEx) {
	                	
	                	//Send message saying that we're unable to open the browser
	                    fallbackEx.printStackTrace();
	                    JOptionPane.showMessageDialog(this, "Unable to open the browser.");
	                }
	            }
	        } else {
	        	
	        	//Error - No URL
	            JOptionPane.showMessageDialog(this, "No URL available for this laptop.");
	        }
	    }
	}


	//Unused MouseListener Methods
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

