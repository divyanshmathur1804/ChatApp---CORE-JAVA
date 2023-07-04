package LoginSystem.Label;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

import LoginSystem.utils.ProjectConstants;

public class LoginLabels extends JLabel implements ProjectConstants {
	public LoginLabels() {
		setText("Login!");
		
		setBounds(180, -50, 250,250);
		setForeground(Color.black);
		setFont(new Font("MV Boli",Font.BOLD,50));
		//TextFields textFields = new TextFields();
	    //add(textFields);
	
	}


}
