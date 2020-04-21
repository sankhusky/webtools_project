package com.sanket.myproject.utils;

import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:email.properties")
public class EmailUtils {


	
	private static boolean sendSimpleEmail(String recipientMail,String subject, String body) {

		/*
		 * try { InputStream input = new FileInputStream("email.properties");
		 * 
		 * Properties prop = new Properties();
		 * 
		 * // load a properties file prop.load(input);
		 * 
		 * } catch (IOException ex) { ex.printStackTrace(); }
		 */
		        
		        ConfigUtil config = new ConfigUtil();

		        
		        Session session = Session.getInstance(config.getProps(),
		          new javax.mail.Authenticator() {
		            protected PasswordAuthentication getPasswordAuthentication() {
		                return new PasswordAuthentication(ConfigUtil.EMAIL_USER, ConfigUtil.EMAIL_PASSWORD);
		            }
		          });

		        try {

		            Message message = new MimeMessage(session);
		            message.setFrom(new InternetAddress("sanketpimple@gmail.com"));
		            message.setRecipients(Message.RecipientType.TO,
		                InternetAddress.parse(recipientMail));
		            message.setSubject(subject);		           
		            message.setText(body);
		            Transport.send(message);

		            System.out.println("Email sent");
		            return true;
		        } catch (MessagingException e) {		        	
		            throw new RuntimeException(e);
		        }
		    }

	
	public static int sendOTP(String recipientMail) {
		 Random random = new Random();
         String otp = String.format("%04d", random.nextInt(10000));
         String subject = "Projects Repository-- Confirm your email";
         String body = "Hi, your One Time Password for confirmation is : " + otp + ". This password is valid for 30 minutes only.";
         
		if(sendSimpleEmail(recipientMail, subject, body)) {
			
			return Integer.valueOf(otp);
		}else {
			return -1;
		}
	}
	}

