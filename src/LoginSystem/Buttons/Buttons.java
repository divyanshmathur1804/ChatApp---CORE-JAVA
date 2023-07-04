package LoginSystem.Buttons;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Buttons extends JButton  {
	Buttons button;
	public Buttons() {
		setText("Login");
		setBounds(30,340,200,50);
		setFocusable(false);
		setFont(new Font("Comic Sans",Font.BOLD,18));
		setBackground(Color.black);
		setForeground(Color.white);
		setBorder(BorderFactory.createLineBorder(Color.white));
	
	}

	
}
