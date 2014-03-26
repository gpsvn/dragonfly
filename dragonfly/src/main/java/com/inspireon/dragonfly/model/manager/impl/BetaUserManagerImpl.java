package com.inspireon.dragonfly.model.manager.impl;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.stereotype.Service;

import com.inspireon.dragonfly.application.EmailSendingService;
import com.inspireon.dragonfly.infrastructure.DFConfig;
import com.inspireon.dragonfly.model.manager.BetaUserManager;

/**
 * 
 * @author Phuong
 *
 */
@Service
public class BetaUserManagerImpl extends Thread implements BetaUserManager{

	@Override
	public void sendActiveLink(String userId, String toEmail)
			throws AddressException, MessagingException {
		
		String url = 
			    DFConfig.getInstance().getAsString("siteurl") + "user/activate/" + userId;
	    String subject = "Hoàn thành đăng ký mystory.vn";
	    String content = "Bạn đã đăng ký mystory.vn với email này. Hãy hoàn thành bước cuối cùng "
	    		+ "để có thể tham gia chia sẻ trên mystory bằng cách click vào link dưới đây :\n" +
	    		url;
	    
	    EmailSendingService emailSendingService = new EmailSendingService();
	    emailSendingService.setToEmail(toEmail);
	    emailSendingService.setSubject(subject);
	    emailSendingService.setContent(content);
	    
	    emailSendingService.start();
	    
	}

}
