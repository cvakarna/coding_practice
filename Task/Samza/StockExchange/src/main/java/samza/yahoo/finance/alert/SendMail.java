package samza.yahoo.finance.alert;

import java.util.Properties;
import java.util.function.Supplier;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import samza.yahoo.finance.pojo.Fields;
public class SendMail implements Runnable{
	Logger log=Logger.getLogger(SendMail.class);
	String to = "to@gmail.com";
	String from = "from@gmail.com";
	Properties props = null;

	private String key;
	private String message;
	private Fields fields;
	public SendMail(String key, String message, Fields fields) {
		this();
		this.key=key;
		this.message=message;
		this.fields=fields;
	
	}

	public SendMail() {
		props = new Properties();
		props.put("mail.smtp.host" , "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port" , "465");
		props.put("mail.smtp.socketFactory.class" , "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.port", "465");
	}

	public void createAlert(String symbol, String message,Fields fields) {
		log.debug("alert called" + message + fields);
		Session session = Session.getDefaultInstance(props,new SMTPAuthenticator());

		try {
			Message mimemessage = new MimeMessage(session);
			mimemessage.setFrom(new InternetAddress(from));
			
			mimemessage.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			
			mimemessage.setSubject("Update of Stock");

			StringBuffer bf=new StringBuffer();
			bf.append("Dear Subscriber," + "\n\n "+"Your Subscribtion to Stock "+ symbol+message);
			bf.append("\n\nNow Current Price is "+fields.getPrice());
			mimemessage.setText(bf.toString());


			Transport.send(mimemessage);
		
			log.debug("Done");

		}catch(AddressException e){
			e.printStackTrace();
			log.debug("Address Exception occurred.... Please check the mail id whether correct or not "+e.getMessage());			
		}catch(MessagingException e){
			e.printStackTrace();
			log.debug("Message Exception occurred.. "+e.getMessage());
		}
		
	}

	@Override
	public void run() {
		log.debug("run method called");
		createAlert(this.key, this.message, this.fields);
	}

	
	class SMTPAuthenticator extends Authenticator{
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(
				from, "password");
	}
}
}
