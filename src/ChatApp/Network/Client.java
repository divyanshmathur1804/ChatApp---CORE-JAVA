package ChatApp.Network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.util.Scanner;

import javax.swing.JTextArea;

import LoginSystem.utils.ConfigReader;

public class Client {
	private Socket socket;
	private OutputStream out;
	private InputStream in;
	
	private JTextArea textArea;
	public Client(JTextArea textArea) throws UnknownHostException, IOException {
		int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
		socket = new Socket(ConfigReader.getValue("SERVER_IP"),PORT);
		out =socket.getOutputStream();
		in= socket.getInputStream();
		this.textArea = textArea;
		readMessages();
		/*System.out.println("Client Comes");
		System.out.println("Enter message to be sent ");
		Scanner scanner = new Scanner(System.in);
		String message = scanner.nextLine();
		OutputStream out = socket.getOutputStream();// used for writing message to be sent
		out.write(message.getBytes());
		out.close();
		socket.close();*/
	}
	public void sendMessage(String message) throws IOException {
		message = message +"\n";
		out.write(message.getBytes());
	}
	public void readMessages() {
		ClientWorker worker = new ClientWorker(in, textArea);
		worker.start();
	}

	

}
