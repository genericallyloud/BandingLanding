package com.bandinglanding.dao;

import com.bandinglanding.model.Deck;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.util.DAOBase;

public class DeckDao extends DAOBase {
	static{
		ObjectifyService.register(Deck.class);
	}
	
	public Deck findDefaultByOwner(User user){
		return ofy().query(Deck.class).filter("deckOwner", user).get();
	}
	
	public Deck findOrCreateDefaultByOwner(User user){
		Deck deck = findDefaultByOwner(user);
    	if(deck == null){
    		//if no deck, make one
    		deck = new Deck();
    		deck.setDeckOwner(user);
    		ofy().put(deck);
    	}
    	return deck;
	}
	
	public Deck findDefaultForCurrentUser(){
    	UserService userService = UserServiceFactory.getUserService();
    	User currUser = userService.getCurrentUser();
		return findDefaultByOwner(currUser);
	}
	
	public Deck findOrCreateDefaultForCurrentUser(){
    	UserService userService = UserServiceFactory.getUserService();
    	User currUser = userService.getCurrentUser();
		return findOrCreateDefaultByOwner(currUser);
	}
	
	public Deck find(long id){
		return ofy().find(Deck.class, id);
	}
	
	public Key<Deck> findDefaultKeyForUser(User user) {
		return ofy().query(Deck.class).filter("deckOwner", user).getKey();
		
	}

	public Key<Deck> findDefaultKeyForCurrentUser() {
    	UserService userService = UserServiceFactory.getUserService();
    	User currUser = userService.getCurrentUser();
		return findDefaultKeyForUser(currUser);
	}
}
