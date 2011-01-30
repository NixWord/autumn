package fr.clubnix.autumn;

import java.io.IOException;

import org.schwering.irc.lib.IRCConnection;

public class Autumn extends Thread {

	public Autumn(Config config) throws IOException {

		IRCConnection conn;

		conn = new IRCConnection(config.getHost(), new int[] { config.getPort() },
				config.getPass(), config.getNick(), config.getUser(), config.getName());

		conn.addIRCEventListener(new Listener(conn));
		conn.setEncoding("UTF-8");
		conn.setPong(true);
		conn.setDaemon(false);
		conn.setColors(false);
		conn.connect();
		setDaemon(true);
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Config config = ConfigLoader.load(args[0]);

		Autumn autumn;
		try {
			autumn = new Autumn(config);
			autumn.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
