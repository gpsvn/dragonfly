package com.inspireon.dragonfly.web.rest.user;


public class UserSettingCommand {
	
	private String slogan;
    
    private String facebook;
    
    private String lang;

    private boolean displayToOthers;
    
    private boolean allowPostingActivities;	
    
	public String getSlogan() {
		return slogan;
	}
	
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public String getFacebook() {
		return facebook;
	}
	
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	
	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public boolean isDisplayToOthers() {
		return displayToOthers;
	}

	public void setDisplayToOthers(boolean displayToOthers) {
		this.displayToOthers = displayToOthers;
	}

	public boolean isAllowPostingActivities() {
		return allowPostingActivities;
	}

	public void setAllowPostingActivities(boolean allowPostingActivities) {
		this.allowPostingActivities = allowPostingActivities;
	}
}
