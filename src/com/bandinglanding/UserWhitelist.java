package com.bandinglanding;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.users.User;

public class UserWhitelist {
	private static final List<String> WHITELIST = new ArrayList<String>();
	static {
		WHITELIST.add("russell.leggett@gmail.com");
	}
	
	public static boolean isListed(User user){
		String email = user.getEmail().toLowerCase();
		return WHITELIST.contains(email);
	}
}
