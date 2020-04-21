package com.sanket.myproject.utils;

import java.util.Properties;

public class ConfigUtil {

	public static final String EMAIL_USER= "sanketpimple@gmail.com";
	public static final String EMAIL_PASSWORD= "thisismynewpasswordagain";
	private Properties props = new Properties();
	
	public ConfigUtil() {
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
	}

	public Properties getProps() {
		return props;
	}

}
