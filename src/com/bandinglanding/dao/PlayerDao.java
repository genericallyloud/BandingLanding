package com.bandinglanding.dao;

import com.bandinglanding.model.Deck;
import com.bandinglanding.model.Game;
import com.bandinglanding.model.Player;
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
	
	public Player findOpponent(Player player){
		return ofy().query(Player.class).filter("game", player.getGame()).filter("id !=", player.getId()).get();
	}
	
	public Player create(Key<Game> game, Deck deck){
		Player player = new Player(game, deck);
		ofy().put(player);
		//now initialize the GameCards
		
		return player;
	}
}
