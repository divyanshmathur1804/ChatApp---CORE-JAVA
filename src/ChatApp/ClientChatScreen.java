package ChatApp;

import java.awt.EventQueue;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ChatApp.Network.Client;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

public class ClientChatScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtTypeYourMessage;
	 
	private Client client;
	JTextArea textArea;

	/**
	 * Launch the application.
	 */
	
			
		
	
	private void sendIt(String Username) {
		String message = txtTypeYourMessage.getText();
		try {
			client.sendMessage(Username+": "+message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public ClientChatScreen(String Username) throws UnknownHostException, IOException {
		setBackground(new Color(192, 192, 192));
		setTitle("Messanger");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1056, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		textArea= new JTextArea();
		textArea.setBackground(SystemColor.inactiveCaption);
		client = new Client(textArea);
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1007, 335);
		contentPane.add(scrollPane);
		
		textArea.setFont(new Font("Arial", Font.BOLD, 16));
		textArea.setBounds(21, 23, 982, 319);
		scrollPane.setViewportView(textArea);
		
		txtTypeYourMessage = new JTextField();
		txtTypeYourMessage.setText("Type Your Message Here....");
		txtTypeYourMessage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTypeYourMessage.setBounds(10, 372, 803, 49);
		contentPane.add(txtTypeYourMessage);
		txtTypeYourMessage.setColumns(10);
		
		JButton btnNewButton= new JButton("Send");
		btnNewButton.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sendIt(Username);
				
			}
		});
		btnNewButton.setBounds(846, 379, 121, 35);
		contentPane.add(btnNewButton);
		setVisible(true);
	}

	
}
