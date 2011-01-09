package fr.clubnix.autumn;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.schwering.irc.lib.IRCConnection;

public class Autumn extends Thread {

	public Autumn(String host, int port, String pass, String nick, String user,
			String name, boolean ssl) throws IOException {

		IRCConnection conn;

		conn = new IRCConnection(host, new int[] { port }, pass, nick, user,  name);

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
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(args[0]));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String host = properties.getProperty("host");
		int port = Integer.parseInt(properties.getProperty("port"));
		String pass = properties.getProperty("pass");
		String nick = properties.getProperty("nick");
		String user = properties.getProperty("user");
		String name = properties.getProperty("name");
		boolean ssl = Boolean.parseBoolean(properties.getProperty("ssl"));

		Autumn autumn = null;
		try {
			autumn = new Autumn(host, port, pass, nick, user, name, ssl);
			autumn.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
