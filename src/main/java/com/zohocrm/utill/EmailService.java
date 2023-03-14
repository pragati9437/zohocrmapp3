package com.zohocrm.utill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
@Component
public class EmailService implements EmailServices_int {
	@Autowired
    private JavaMailSender javamailsender;
	@Override
	public void sendSimpleMail(String to, String sub, String emailBody) {
		SimpleMailMessage mailmessage = new SimpleMailMessage();
		mailmessage.setTo(to);
		mailmessage.setSubject(sub);
		mailmessage.setText(emailBody);
		javamailsender.send(mailmessage);
	
	}
	
}
