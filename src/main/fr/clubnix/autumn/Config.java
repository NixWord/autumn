package fr.clubnix.autumn;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

	private String host;
	private int port;
	private String pass;
	private String nick;
	private String user;
	private String name;
	private boolean ssl;
	
	public String getHost() {
		return host;
	}
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public int getPort() {
		return port;
	}
	
	public void setPort(int port) {
		this.port = port;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getNick() {
		return nick;
	}
	
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isSsl() {
		return ssl;
	}
	
	public void setSsl(boolean ssl) {
		this.ssl = ssl;
	}
}
