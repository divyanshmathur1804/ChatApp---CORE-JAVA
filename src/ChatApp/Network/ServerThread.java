package ChatApp.Network;

import java.io.IOException;

public class ServerThread extends Thread {
	Server server;
	public ServerThread() {
		
	}
	@Override
	public void run() {
		try {
			server = new Server();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
