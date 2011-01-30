package fr.clubnix.autumn;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

	static Config load(String filename) {
		Config config = new Config();

		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}

		config.setHost(properties.getProperty("host"));
		config.setPort(Integer.parseInt(properties.getProperty("port")));
		config.setPass(properties.getProperty("pass"));
		config.setNick(properties.getProperty("nick"));
		config.setUser(properties.getProperty("user"));
		config.setName(properties.getProperty("name"));
		config.setSsl(Boolean.parseBoolean(properties.getProperty("ssl")));

		return config;
	}
}
