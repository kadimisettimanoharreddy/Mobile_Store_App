package com.mobile.app;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Main {
	 public static void sendconfirmation(String em, String body) {
	        String recipient = em;
	        String sender = "kadimisettimanoharreddy5@gmail.com"; // Replace with your email
	        String password = "bjia bxvm qgjx mpyn";  // Use your Gmail App Password

	        // SMTP server properties
	        Properties props = new Properties(); 
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.ssl.protocols", "TLSv1.2"); 
	        props.put("mail.smtp.ssl.trust", "smtp.gmail.com"); 

	        
	        // Create session with authentication
	        Session session = Session.getInstance(props, new Authenticator() { 
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(sender, password);
	            }
	        });

	        try {
	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(sender));
	            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
	            message.setSubject("Thank You for Registering!");
	            message.setText(body);

	            // ✅ Enable debugging for troubleshooting
	            session.setDebug(true);

	            // Send email
	            Transport.send(message);
	            System.out.println(" Email sent successfully!");

	        } catch (MessagingException e) {
	            e.printStackTrace();
	            System.out.println(" Failed to send email: " + e.getMessage());
	        }
	    }

	 public static void Transactionotp(String em, int otp) {
		    String recipient = em;
		    String sender = "kadimisettimanoharreddy5@gmail.com"; // Replace with your email
		    String password = "bjia bxvm qgjx mpyn";  // Use your Gmail App Password

		    // SMTP server properties
		    Properties props = new Properties();
		    props.put("mail.smtp.host", "smtp.gmail.com");
		    props.put("mail.smtp.port", "587");
		    props.put("mail.smtp.auth", "true");
		    props.put("mail.smtp.starttls.enable", "true");
		    props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		    props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		    // Create session with authentication
		    Session session = Session.getInstance(props, new Authenticator() {
		        protected PasswordAuthentication getPasswordAuthentication() {
		            return new PasswordAuthentication(sender, password);
		        }
		    });
 
		    try {
		        // Create a message
		        Message message = new MimeMessage(session);
		        message.setFrom(new InternetAddress(sender));
		        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
		        message.setSubject("One-Time Password for Payment");
		        message.setText("Your One-Time Password (OTP) for payment is: " + otp);

		        // Send email
		        Transport.send(message);
		        System.out.println("Transaction OTP email sent successfully!");

		    } catch (MessagingException e) {
		        e.printStackTrace();
		        System.out.println("Failed to send Transaction OTP email: " + e.getMessage());
		    }
		}

	public static void main(String[] args)
	{
		String em="dhanushkumar6304030341@gmail.com";
		//(em,"Hiii dhanush");
		//System.out.println("EMail sent sucessfully");
		int otp=987849;
		Transactionotp(em,otp);
	}
}
