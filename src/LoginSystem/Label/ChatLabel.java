package LoginSystem.Label;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class ChatLabel extends JLabel  {
	public ChatLabel() {
		setText("Messenger");
		setForeground(Color.BLACK);
		setBounds(150,150, 250, 250);
		setFont(new Font("MV Boli",Font.BOLD,50));
	}

}
