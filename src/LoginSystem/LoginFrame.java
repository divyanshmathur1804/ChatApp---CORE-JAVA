package LoginSystem;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.io.IOException;

import javax.swing.JFrame;

import ApplicationDatabase.JDBCConnector;
import ChatApp.Network.Server;
import ChatApp.Network.ServerThread;
import LoginSystem.Panel.LoginPanel;
import LoginSystem.utils.ProjectConstants;

public class LoginFrame extends JFrame implements ProjectConstants{
	private ServerThread serverThread;
	public LoginFrame() throws IOException {
		
		setTitle(TITLE);
		setVisible(true);
		setSize(FHEIGHT,FWIDTH);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //frame gets closed after closing
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		LoginPanel panel = new LoginPanel();
		FrameImage image = new FrameImage();
		JDBCConnector jbConnector = new JDBCConnector();
		serverThread = new ServerThread();
		serverThread.start();
		add(panel);
		add(image);
		repaint();
		
		
		
		}
	public void close() {
		dispose();
	}
	public static void main(String[] args) {
		
			try {
				LoginFrame frame =  new LoginFrame();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

}
