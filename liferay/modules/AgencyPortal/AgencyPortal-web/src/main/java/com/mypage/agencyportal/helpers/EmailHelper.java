package com.mypage.agencyportal.helpers;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class EmailHelper {
	
	public boolean sendEmail(String recipient, String subject, String msg) {
		ActionHelpers helpers = new ActionHelpers();
		LogHelper<Object> logs = new LogHelper<Object>();
		
		String sender = helpers.getConfig("com.mypage.agent.config.smtpEmail");
		String username = helpers.getConfig("com.mypage.agent.config.smtpUsername");
		String password = helpers.getConfig("com.mypage.agent.config.smtpPassword");
		
		Properties props = new Properties();
        props.put("mail.smtp.host", helpers.getConfig("com.mypage.agent.config.smtpHost"));
        props.put("mail.smtp.port", helpers.getConfig("com.mypage.agent.config.smtpPort"));
        props.put("mail.smtp.auth", helpers.getConfig("com.mypage.agent.config.smtpAuth"));

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
		
        try {
        	Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);
            String type = msg.contains("<html>") == true ? "text/html; charset=utf-8" : "text/plain";
            message.setContent(msg, type);

            Transport.send(message);
            
            return true;
        } catch (Exception e) {
            logs.log(e.getStackTrace());
        }
        
        return false;
    }
}
