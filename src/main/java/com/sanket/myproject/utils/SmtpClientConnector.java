//package neu.rohanbharti.connecteddevices.project;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.text.DecimalFormat;
//import java.util.Date;
//import java.util.Properties;
//import java.util.logging.Logger;
//
//import javax.mail.Authenticator;
//import javax.mail.Message;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import javax.naming.ConfigurationException;
//
//import neu.rohanbharti.connecteddevices.common.ActuatorData;
//import neu.rohanbharti.connecteddevices.common.ConfigUtil;
//
///**
// * 
// * SMTP Client Connector class. Sets up the SMTP Server and sends an email as per the information provided
// * by the Configuration file.
// * 
// *
// *
// */
//public class SmtpClientConnector {
//
//	private String smtpServerHost;
//	private int smtpServerPort;
//	private String toAddr;
//	private String fromAddr;
//	private String password;
//	private boolean enableAuth;
//	private boolean isConnected = false;
//	
////	private ConfigUtil configUtil = null;
//	private Session session = null;
//	private Authenticator auth = null;
//	
//	private static DecimalFormat df = new DecimalFormat("0.00");
//	private static Logger logger;
//
//	static {
//		System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT] [%4$s] %5$s %n");
//		logger = Logger.getLogger(SmtpClientConnector.class.getName());
//	}
//	
//	/**
//	 * 
//	 * Checks if the SMTP Server is set up or not. If not, sets up the configuration required for the Email Service.
//	 * Once set up, the email is sent to the recipient.
//	 * 
//	 * @param sensorData
//	 */
//	public void setupEmailSettingsAndSendMail(ActuatorData actuatorData) {	
//		
//		try (InputStream input = new FileInputStream("path/to/config.properties")) {
//
//            Properties prop = new Properties();
//
//            // load a properties file
//            prop.load(input);
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//
//		if(!isConnected) {
//			
//			try {
//				this.configUtil = new ConfigUtil();
//			} catch (ConfigurationException e) {
//				logger.severe("The Configuration file wasn't loaded successfully!");
//			}
//			
//			Properties props = setupSmtpProperties();
//			
//			this.fromAddr = configUtil.getStringValue("smtp.fromAddr");
//			this.toAddr = configUtil.getStringValue("smtp.toAddr");
//			this.password = configUtil.getStringValue("smtp.authToken");
//			
//			this.auth = new Authenticator() {
//				protected PasswordAuthentication getPasswordAuthentication() {
//					return new PasswordAuthentication(fromAddr, password);
//				}
//			};
//			
//			this.session = Session.getDefaultInstance(props, auth);
//			this.isConnected = true;
//		} 
//		
//		String emailText = this.createMessage(actuatorData);
//		
//		this.sendEmail(session, fromAddr, toAddr, "Temperature Update Email", emailText);
//	}
//	
//	/**
//	 * 
//	 * Takes in the respective parameters to send the email as per the requirement.
//	 * 
//	 * @param session
//	 * @param fromEmail
//	 * @param toEmail
//	 * @param subject
//	 * @param body
//	 */
//	private void sendEmail(Session session, String fromEmail, String toEmail, String subject, String body){
//		try {
//	      MimeMessage msg = new MimeMessage(session);
//
//	      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
//	      msg.addHeader("format", "flowed");
//	      msg.addHeader("Content-Transfer-Encoding", "8bit");
//
//	      msg.setFrom(new InternetAddress(fromEmail, "NoReply-RohanBharti"));
//	      msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));
//	      msg.setSubject(subject, "UTF-8");
//	      msg.setText(body, "UTF-8");
//	      msg.setSentDate(new Date());
//	      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
//	      logger.info("Message is ready");
//	      
//    	  Transport.send(msg);  
//	      logger.info("Email Sent Successfully!!");
//	      
//	    }
//	    catch (Exception e) {
//	      logger.severe("The Email wasn't sent successfully: " + e.getMessage());
//	    }
//	}
//	
//	/**
//	 * 
//	 * Creates a Properties object with all the required key-value properties that are 
//	 * required for SMTP connection.
//	 * 
//	 * @return Properties
//	 */
//	private Properties setupSmtpProperties() {
//		
//		this.smtpServerHost = configUtil.getStringValue("smtp.host");
//		this.smtpServerPort = configUtil.getIntegerValue("smtp.port");
//		this.enableAuth = configUtil.getBooleanValue("smtp.enableAuth");
//		String socketFactoryClass = "javax.net.ssl.SSLSocketFactory";
//		
//		Properties properties = new Properties();
//		properties.put("mail.smtp.host", this.smtpServerHost);
//		properties.put("mail.smtp.socketFactory.port", this.smtpServerPort);
//		properties.put("mail.smtp.socketFactory.class", socketFactoryClass); 
//		properties.put("mail.smtp.auth", this.enableAuth); 
//		properties.put("mail.smtp.port", this.smtpServerPort); 
//		
//		return properties;
//	}
//	
//	/**
//	 * 
//	 * Takes the SensorData object and creates a well formed body for the email to be sent.
//	 * 
//	 * @param sensorData
//	 * @return String
//	 */
//	private String createMessage(ActuatorData actuatorData) {
//		StringBuilder sb = new StringBuilder("Temperature: ");
//		sb.append(System.getProperty("line.separator")).append(" Type: ").append(actuatorData.getCommand())
//		.append(System.getProperty("line.separator")).append(" Value: ").append(df.format(actuatorData.getValue()))
//		.append(System.getProperty("line.separator")).append(" Name: ").append(actuatorData.getName());
//		
//		return sb.toString();
//	}
//
//}
