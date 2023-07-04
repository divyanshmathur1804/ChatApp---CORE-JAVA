package RegisterPage;

import java.awt.Color;

import javax.swing.JFrame;

import LoginSystem.FrameImage;
import LoginSystem.Panel.LoginPanel;
import LoginSystem.utils.ProjectConstants;
import RegisterPage.panel.RegisterPanel;

public class RegisterationPage extends JFrame implements ProjectConstants {
	public RegisterationPage() {
		setTitle("Registration Page");
		setVisible(true);
		setSize(FHEIGHT,FWIDTH);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //frame gets closed after closing
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		RegisterPanel panel = new RegisterPanel();
		FrameImage image = new FrameImage();
		
		add(panel);
		add(image);
		repaint();
	}

}
