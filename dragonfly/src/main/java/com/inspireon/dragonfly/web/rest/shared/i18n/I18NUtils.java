package com.inspireon.dragonfly.web.rest.shared.i18n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.util.StringUtils;

public class I18NUtils {
	private static final String VIETNAMESE = "vi";
	
	public static final String DEFAULT_LANG = VIETNAMESE;
	
	@Autowired
	private MessageSource messageSource;
	
	public String getMessage(String code, String lang) {
		return getMessage(code, null, lang);
	}
	
	public String getMessage(String code, String[] args, String lang) {
		if (lang == null) lang = DEFAULT_LANG;
		return messageSource.getMessage(code, args, StringUtils.parseLocaleString(lang));
	}
	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
}
