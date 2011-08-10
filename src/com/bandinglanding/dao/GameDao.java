package com.bandinglanding.dao;

import com.bandinglanding.model.Deck;
import com.bandinglanding.model.Game;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.util.DAOBase;

public class GameDao extends DAOBase {
	static{
		ObjectifyService.register(Game.class);
	}
	
	public Game find(long id){
		return ofy().find(Game.class, id);
	}

	public Game find(Key<Game> game) {
		return ofy().find(game);
	}
	
	/**
	 * A new game can be created based off of a deck - this allows us to get the initiating user
	 * and which deck they have chosen. From there, all of the GameCards can be generated and the player,
	 * etc.
	 * 
	 * @param deck
	 * @return
	 */
	public Game create(Deck deck){
		Game game = new Game();
		Key<Game> gameKey = ofy().put(game);
		new PlayerDao().create(gameKey,deck);
		return game;
	}
}
