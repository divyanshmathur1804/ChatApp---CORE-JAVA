package ChatApp.Network;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.PublicKey;
import java.util.ArrayList;

import LoginSystem.utils.ConfigReader;

public class Server {
	ServerSocket serverSocket; // class used for starting server
	ArrayList<ServerWorker> workers = new ArrayList<>();
	public Server() throws IOException {
		int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
	    serverSocket = new ServerSocket(PORT);
	    
	    handleCLientRequest();
	}
	//multiple client handling
	public void handleCLientRequest() throws IOException {
		while (true) {
			Socket Clientsocket = serverSocket.accept();//handshaking between client server
		    ServerWorker worker = new ServerWorker(Clientsocket,this /*this will provide acces of workers to thread*/);
		    workers.add(worker);
		    worker.start();	
		}
		
	}
	// for single client
	/*public Server() throws IOException {
		int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
	    serverSocket = new ServerSocket(PORT);
	    System.out.println("Server started and waiting for client connection");
		Socket socket = serverSocket.accept();//handshaking between client server
		System.out.println("Client joins th server");
		InputStream input = socket.getInputStream();
		byte[] arr = input.readAllBytes();
		String message = new String(arr);
		System.out.println("Message from client "+message);
		input.close(); 
		socket.close();
	}*/

	

}
