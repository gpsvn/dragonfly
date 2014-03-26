package com.inspireon.dragonfly.web.rest.shared.prepare;

import java.io.Serializable;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.inspireon.dragonfly.application.UserService;
import com.inspireon.dragonfly.model.domain.user.UserRepo;
import com.inspireon.dragonfly.web.rest.shared.i18n.I18NUtils;

@Controller("myStoryViewPrepare")
@Scope("session")
public class MyStoryViewPrepare implements ViewPreparer, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5229485822309646866L;

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private I18NUtils i18nUtils;
	
	@Override
	public void execute(Request request, AttributeContext attributeContext) {
		
//		try {
//			
//			Map<String, Object> viewMap = request.getContext("session");
//			
//			MystoryUser myStoryUser = MystoryUserReference.getLoggedInUser();
//			String username = null;
//			
//			if (myStoryUser != null) {
//				//user side bar
//				username = myStoryUser.getUsername();
//				User currentUser = userRepo.findByUsername(username);
//				
//				List<Notification> notifications = notificationService.
//						getNewNotificationForUser(myStoryUser.getUserId());
//				if(notifications!=null && notifications.size()>0){
//					List<NotificationViewAdapter> notificationViewAdapters = new ArrayList<NotificationViewAdapter>();
//					int notificationCount = 0;
//					for(Notification notification : notifications){
//						if(notification.createdDate().after(currentUser.lastViewedNotification())){
//							if(notificationViewAdapters.size() < 30)
//								notificationViewAdapters.add(new NotificationViewAdapter(notification, i18nUtils, false));
//							notificationCount++;
//						}
//						else if(notificationViewAdapters.size() < 30)
//								notificationViewAdapters.add(new NotificationViewAdapter(notification, i18nUtils, true));
//					}
//					
//					viewMap.put("userPanel", new UserPanelViewAdapter(currentUser, notificationViewAdapters, notificationCount));
//				} else {
//					viewMap.put("userPanel", new UserPanelViewAdapter(currentUser, null, 0));
//				}
//			}
//			
//			else{
//				viewMap.put("userPanel", null);
//			}
//			
//			viewMap.put("topTellers", getTopTellers());
//			viewMap.put("menuCategories", getMenuCategories());
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

}
