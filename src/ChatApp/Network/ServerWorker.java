package ChatApp.Network;
// Worker == thread
//worker needs a job to perform
//for job you gicve runnable
// once job is create via runnable so write the job logic inside run()
// thread class internally calls run functions and implement runnable interface
// assign the job to worker/thread

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Iterator;

public class ServerWorker extends Thread {
	private Socket clientSocket;
	private InputStream in;
	private OutputStream out;// for thread to read and write message
	private Server server;
	public ServerWorker(Socket clientSocket, Server server) throws IOException {
		this.server = server;
		this.clientSocket = clientSocket;
		in = clientSocket.getInputStream();// read message
		out = clientSocket.getOutputStream();// write message
		System.out.println("New Client Comes");
	
	}
	
	@Override
	public void run() {
		//read data from the client and broadcast to all
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line;
		try {
			while (true) {
				line = br.readLine();
				
				if (line.equalsIgnoreCase("quit")) {// if user writes quit
					break;//chat ends
				}
				//out.write(line.getBytes());// single client send
				// broadcast all
				for(ServerWorker serverWorker : server.workers) {
					line = line+"\n";
					serverWorker.out.write(line.getBytes());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				if (br!=null) {
					br.close();
				}if (in!=null) {
					in.close();
				}if (out!=null) {
					out.close();
				}if (clientSocket!=null) {
					clientSocket.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			
		}
		
	}

}
