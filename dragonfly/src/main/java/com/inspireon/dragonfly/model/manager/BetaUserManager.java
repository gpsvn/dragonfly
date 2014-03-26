package com.inspireon.dragonfly.model.manager;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface BetaUserManager {
	
	void sendActiveLink(String userId, String toEmail) throws AddressException, MessagingException;
}
