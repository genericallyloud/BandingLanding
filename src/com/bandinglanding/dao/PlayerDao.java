package com.bandinglanding.dao;

import java.util.List;

import com.bandinglanding.dto.DeckCardListingDto;
import com.bandinglanding.model.Deck;
import com.bandinglanding.model.Game;
import com.bandinglanding.model.Player;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.util.DAOBase;

public class PlayerDao extends DAOBase {
	static{
		ObjectifyService.register(Player.class);
	}
	
	public Player find(long id){
		return ofy().find(Player.class, id);
	}
	
	public Player find(Key<Game> gameKey, User user){
		return ofy().query(Player.class).filter("game", gameKey).filter("user", user).get();
	}
	
	public Player findOpponent(Player player){
		return ofy().query(Player.class).filter("game", player.getGame()).filter("id !=", player.getId()).get();
	}
	
	public Player create(Key<Game> game, Deck deck){
		Player player = new Player(game, deck);
		Key<Player> playerKey = ofy().put(player);
		//now initialize the GameCards
		new GameCardDao().createGameDeck(playerKey, deck);
		
		return player;
	}

	public Player findForCurrentUser(Key<Game> gameKey) {
    	UserService userService = UserServiceFactory.getUserService();
    	User currUser = userService.getCurrentUser();
		return find(gameKey, currUser);
	}
}
