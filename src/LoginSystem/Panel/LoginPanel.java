package LoginSystem.Panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import ApplicationDatabase.JDBCConnector;
import ChatApp.DashBoard;
import ChatApp.Network.Server;
import LoginSystem.LoginFrame;
import LoginSystem.Buttons.Buttons;
import LoginSystem.Label.LoginLabels;
import LoginSystem.TextFields.TextFields;
import LoginSystem.utils.ProjectConstants;
import PasswordEncryption.Encryption;
import RegisterPage.RegisterationPage;

public class LoginPanel extends JPanel implements ProjectConstants,ActionListener,Encryption {
	private int Hiegth = 480;
	private int Width = 480;
	Buttons buttons = new Buttons();
	Buttons registerButtons = new Buttons();
	TextFields textField1 = new TextFields();
	JPasswordField		passField = new JPasswordField();
	LoginFrame loginFrame;
	JDBCConnector jdbc = new JDBCConnector();
	public LoginPanel() {
		setBackground(Color.white);
		setBounds(PanelX, PanelY, Width, Hiegth);
		setLayout(null);
		setVisible(true);
		LoginLabels labels = new LoginLabels();
		buttons.addActionListener(this);
		registerButtons.addActionListener(this);
	    textField1.setT("Username");
	    passField.setText("Password");
	    passField.setBorder(textField1.getBorder());
	    passField.setBounds(20, 270, 450, 50);
	    passField.setBackground(Color.white);
	    registerButtons.setBounds(250,340 , 200, 50);
	    registerButtons.setText("Register");
		add(labels);
		add(textField1);
		add(passField);
		add(buttons);
		add(registerButtons);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==buttons) {
			String data1 = "'"+textField1.getText()+"'";
			String data2 = "'"+Encryption.encryptpass(new String(passField.getPassword()))+"'";
			
			String q = "Select * from Clientsinfo where cUsername = "+data1+"AND cPassWord = "+data2;
			if (jdbc.getData(q)) {
				JOptionPane.showMessageDialog(buttons, "Login Successfull","Messenger", JOptionPane.INFORMATION_MESSAGE);
				JComponent comp = (JComponent) e.getSource();
				  Window win = SwingUtilities.getWindowAncestor(comp);
				  win.dispose();
				 DashBoard dashBoard = new DashBoard(jdbc.GetName(q));
				 try {
					Server server = new Server();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else {
				JOptionPane.showMessageDialog(buttons, "Wrong Credentials", "Messenger", JOptionPane.ERROR_MESSAGE);
			} 
		}
		if (e.getSource()==registerButtons) {
			
			
			
			//JComponent comp = (JComponent) e.getSource();
			JComponent comp = (JComponent) e.getSource();
			  Window win = SwingUtilities.getWindowAncestor(comp);
			  win.dispose();
			RegisterationPage registerationPage = new RegisterationPage();
			
		
		}
	}
	
		
	}
	


