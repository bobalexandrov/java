package com.cba.hdfs;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class sendMail {

	public static void main(String[] args) {

		final String username = "info@custom-built-apps.com";
		final String password = "yourPassworkd";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtpout.secureserver.net");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {
			String ipAddress=args[0];
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("info@custom-built-apps.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("boris.alexandrov@hotmail.ca"));
			message.setSubject("IP address change");
			message.setText("Dear Mr. Alexandrov,"
				+ "\n\n Please, be advised that your IP address is "
				+ ipAddress
				+ "\n\n Regards,"
				+ "Your IP monitor application");

			Transport.send(message);

			System.out.println("Message sent.");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}

