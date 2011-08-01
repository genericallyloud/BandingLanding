package com.bandinglanding.restapi;

import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.security.Authenticator;

import com.bandinglanding.UserWhitelist;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class AuthFilter extends Authenticator{

	public AuthFilter(Context context) {
		super(context);
	}

	@Override
	protected boolean authenticate(Request request, Response response) {
		UserService userService = UserServiceFactory.getUserService();
		User currUser = userService.getCurrentUser();
		if(currUser == null){
			return false;
		}else{
			return UserWhitelist.isListed(currUser);
		}
	}

}
