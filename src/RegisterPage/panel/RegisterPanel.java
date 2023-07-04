package RegisterPage.panel;

import java.awt.Color;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;

import ApplicationDatabase.JDBCConnector;
import LoginSystem.LoginFrame;
import LoginSystem.Buttons.Buttons;
import LoginSystem.Label.LoginLabels;
import LoginSystem.TextFields.TextFields;
import LoginSystem.utils.ProjectConstants;
import PasswordEncryption.Encryption;

public class RegisterPanel extends JPanel implements ProjectConstants, ActionListener,Encryption {
	TextFields textField1 = new TextFields();
	TextFields textField2 = new TextFields();
	JPasswordField passField = new JPasswordField();
	Buttons registerButtons = new Buttons();
	JDBCConnector jdbc = new JDBCConnector();
	public RegisterPanel() {
		setBackground(Color.white);
		setBounds(PanelX, PanelY, 480, 480);
		setLayout(null);
		setVisible(true);
		LoginLabels labels = new LoginLabels();
		labels.setText("Register!");
		labels.setBounds(130, -50, 250,250);
		textField1.setT("Full Name");
		textField2.setT("Username");
		passField.setText("Password");
		textField1.setBounds(20, 170, 450, 50);
		textField2.setBounds(20, 240, 450, 50);
		passField.setBounds(20, 310, 450, 50);
		passField.setBorder(textField1.getBorder());
		registerButtons.setBounds(150,400 , 200, 50);
	    registerButtons.setText("Register");
	    registerButtons.addActionListener(this);
		add(labels);
		add(textField1);
		add(textField2);
		add(passField);
		add(registerButtons);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==registerButtons) {
			char[] pass = passField.getPassword();
			String password = new String(pass);
			String encryptedpass = Encryption.encryptpass(password);
			String q = "insert into ClientsInfo(cName,cUserName,cPassword) values(?,?,?)";
			jdbc.InsertData(q, textField1.getText(), textField2.getText(), encryptedpass);
		int res =JOptionPane.showOptionDialog(registerButtons, "Registeration Successfull !!!", "Messenger", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
			if (res == 0 || res == -1) {
				JComponent comp = (JComponent) e.getSource();
				  Window win = SwingUtilities.getWindowAncestor(comp);
				  win.dispose();
				  try {
					LoginFrame frame = new LoginFrame();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

}
