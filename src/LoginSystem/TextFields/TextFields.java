package LoginSystem.TextFields;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.security.PublicKey;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class TextFields extends JTextField {
	
	public TextFields() {
		
		setBounds(20, 200, 450, 50);
		setFont(new Font("MV Boli",Font.PLAIN,18));
		setBackground(Color.white);
		Border border = BorderFactory.createLineBorder(Color.black, 1);
		setBorder(border);
		
	
	}
	public void setT(String Text) {
		setText(Text);
	}
	

}
